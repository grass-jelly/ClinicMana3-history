package service;

import java.util.List;
import javax.transaction.Transactional;
import model.Drug;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DrugService {
    @Autowired
    private SessionFactory sessionFactory;

    public DrugService() {
    }

    public int addDrug(Drug drug) {
        this.sessionFactory.getCurrentSession().save(drug);
        return drug.getId();
    }

    public List<Drug> getAllDrugs() {
        return this.sessionFactory.getCurrentSession().createQuery("from Drug").list();
    }

    public Drug getDrug(int id) {
        return (Drug)this.sessionFactory.getCurrentSession().get(Drug.class, id);
    }

    public void updateDrug(Drug drug) {
        this.sessionFactory.getCurrentSession().update(drug);
    }

    public void deleteDrug(int id) {
        Drug drug = this.getDrug(id);
        this.sessionFactory.getCurrentSession().delete(drug);
    }
}
