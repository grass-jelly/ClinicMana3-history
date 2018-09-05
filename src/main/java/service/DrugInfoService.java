package service;

import model.DrugInfo;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DrugInfoService {
    @Autowired
    private SessionFactory sessionFactory;

    public int addDrugInfo(DrugInfo drugInfo) {
        this.sessionFactory.getCurrentSession().save(drugInfo);
        return drugInfo.getId();
    }

    public List<DrugInfo> getDrugInfos(int prescriptionId) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from DrugInfo where prescription_id = :prescriptionId");
        query.setInteger("prescriptionId", prescriptionId);
        return query.list();
    }
}
