package hw8.taxi.dao;

import hw8.taxi.domain.District;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Evgenchik on 27.04.2015.
 */
@Repository
public class DistrictDaoImpl implements DistrictDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public DistrictDaoImpl() {
    }

    @Override
    public Long createDistrict(District district) {
        factory.getCurrentSession().save(district);
        return district.getId();
    }


    @Override
    public District readDistrict(Long id) {
        return (District)factory.getCurrentSession().get(District.class,id);
    }

    @Override
    public District readDistrict(String districtTitle) {
        return (District)factory.getCurrentSession().createCriteria(District.class).add(Restrictions.eq("title",districtTitle));
    }

    @Override
    public void deleteDistrict(District district) {
        factory.getCurrentSession().delete(district);
    }

    @Override
    public void updateDistrict(District district) {
        factory.getCurrentSession().update(district);
    }

    @Override
    public List<District> lisOfAddress() {
        return factory.getCurrentSession().createCriteria(District.class).list();
    }
}
