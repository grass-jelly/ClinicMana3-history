package service;

import java.sql.Date;
import java.util.List;
import javax.transaction.Transactional;
import model.Patient;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PatientService {
    @Autowired
    private SessionFactory sessionFactory;

    public PatientService() {
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addPatient(Patient patient) {
        this.sessionFactory.getCurrentSession().save(patient);
        return patient.getId();
    }

    public List<Patient> getAllPatients() {
        return this.sessionFactory.getCurrentSession().createQuery("from Patient").list();
    }

    public Patient getPatient(int id) {
        return (Patient)this.sessionFactory.getCurrentSession().get(Patient.class, id);
    }

    public void deletePatient(int id) {
        Patient patient = this.getPatient(id);
        this.sessionFactory.getCurrentSession().delete(patient);
    }

    public void updatePatient(Patient patient) {
        this.sessionFactory.getCurrentSession().update(patient);
    }

    public List<Patient> getPatients(String name) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from Patient where name = :name");
        query.setString("name", name);
        return query.list();
    }

    public List<Patient> getPatients(Date date) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from Patient where dateOfBirth = :date");
        query.setParameter("date", date);
        return query.list();
    }
}