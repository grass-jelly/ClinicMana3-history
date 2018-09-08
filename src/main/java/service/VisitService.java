package service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import model.*;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VisitService {
    @Autowired
    private SessionFactory sessionFactory;

    public VisitService() {
    }

    public int addVisit(Visit visit) {
        this.sessionFactory.getCurrentSession().save(visit);
        return visit.getId();
    }

    public List<Visit> getAllVisits() {
        return this.sessionFactory.getCurrentSession().createQuery("from Visit").list();
    }

    public Visit getVisit(int id) {
        return (Visit)this.sessionFactory.getCurrentSession().get(Visit.class, id);
    }

    public void deleteVisit(int id) {
        Visit visit = this.getVisit(id);
        this.sessionFactory.getCurrentSession().delete(visit);
    }

    public void updateVisit(Visit visit) {
        this.sessionFactory.getCurrentSession().update(visit);
    }

    public List<Visit> getVisits(Date date) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from Visit where date = :date");
        query.setParameter("date", date);
        return query.list();
    }

    public List<Visit> getVisits(int patientId) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from Visit where patient_id = :patientId");
        query.setInteger("patientId", patientId);
        return query.list();
    }

    public List<VisitCountsDatestringDTO> getVisitCounts()
    {
        List<VisitCountsDTO> results = sessionFactory.getCurrentSession().createCriteria(Visit.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("date"), "date")
                        .add(Projections.rowCount(), "count"))
                .setResultTransformer(Transformers.aliasToBean(VisitCountsDTO.class))
                .list();

        List<VisitCountsDatestringDTO> res = new ArrayList<>();
        for (VisitCountsDTO dto : results) {
            Date date = dto.getDate();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String text = df.format(date);
            res.add(new VisitCountsDatestringDTO(text, dto.getCount()));
        }
        return res;
    }
}
