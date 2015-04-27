package hw8.taxi.dao;

import hw8.taxi.domain.Cab;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admssa on 27.04.2015.
 */
@Repository
public class CabDAOImpl implements CabDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long createCab(Cab cab) {
        return (Long) sessionFactory.getCurrentSession().save(cab);

    }

    @Override
    public Cab readCab(Long id) {
        return (Cab) sessionFactory.getCurrentSession().get(Cab.class, id);
    }

    @Override
    public void deleteCab(Cab cab) {
        sessionFactory.getCurrentSession().delete(cab);
    }

    @Override
    public void updateCab(Cab cab) {
        sessionFactory.getCurrentSession().update(cab);
    }

    @Override
    public List<Cab> findAll() {
        return (List<Cab>) sessionFactory.getCurrentSession().createCriteria(Cab.class).list();

    }

}
