package hw8.taxi.dao;

import hw8.taxi.domain.Taxist;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by Vlad on 23.04.2015.
 */
@Repository
public class TaxistDAOImpl implements TaxistDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createTaxist(Taxist taxist) {
        sessionFactory.getCurrentSession().save(taxist);
    }

    @Override
    public Taxist readTaxist(Long id) {
        return (Taxist) sessionFactory.getCurrentSession().get(Taxist.class, id);
    }

    @Override
    public Taxist readByName(String name) {
        return (Taxist) sessionFactory.getCurrentSession().createCriteria(Taxist.class).add(Restrictions.eq("firstName",name)).uniqueResult();
    }

    @Override
    public Taxist readByPhone(String phone) {
        return (Taxist) sessionFactory.getCurrentSession().createCriteria(Taxist.class).add(Restrictions.eq("phone",phone)).uniqueResult();

    }


    @Override
    public void deleteTaxist(Taxist taxist) {
        sessionFactory.getCurrentSession().delete(taxist);
    }

    @Override
    public void updateTaxist(Taxist taxist) {
        sessionFactory.getCurrentSession().update(taxist);
    }

    @Override
    public List<Taxist> getAllTaxists() {
        return sessionFactory.getCurrentSession().createCriteria(Taxist.class).list();
    }

    @Override
    public List<Taxist> getOnlineTaxists() {
        return sessionFactory.getCurrentSession().createCriteria(Taxist.class).add(Restrictions.eq("isOnline", true)).list();
    }

}
