package service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import model.Visit;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
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

    public Map<String, Integer> getVisits() {
        Map<String, Integer> map = new HashMap();

        String dateString;
        for(Iterator var2 = this.getAllVisits().iterator(); var2.hasNext(); map.put(dateString, (Integer)map.get(dateString) + 1)) {
            Visit visit = (Visit)var2.next();
            Date date = visit.getDate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(1);
            int month = cal.get(2) + 1;
            int day = cal.get(5);
            dateString = year + "-" + month + "-" + day;
            if (!map.containsKey(dateString)) {
                map.put(dateString, 0);
            }
        }

        return map;
    }
}
