package service;

import model.Disease;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ICDService {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Disease> getICDs() {
        return this.sessionFactory.getCurrentSession().createQuery("from Disease").list();
    }

}
