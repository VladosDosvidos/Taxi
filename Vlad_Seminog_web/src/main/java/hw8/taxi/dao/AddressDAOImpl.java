package hw8.taxi.dao;

import hw8.taxi.domain.Address;
import hw8.taxi.domain.District;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admssa on 27.04.2015.
 */
@Repository
public class AddressDAOImpl implements AddressDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createAddress(Address address) {
        sessionFactory.getCurrentSession().save(address);
    }

    @Override
    public Address createAddress(String address, District district) {
        Address anAddress=readAddress(address);
        if(anAddress==null){
            anAddress=new Address(address);
            anAddress.setDistrict(district);
            createAddress(anAddress);
        }else {
            if (anAddress.getDistrict() == null  ) {
                anAddress.setDistrict(district);
                createAddress(anAddress);
            }else {
                if(!anAddress.getDistrict().equals(district)){
                    anAddress=new Address(address);
                    anAddress.setDistrict(district);
                }
            }
        }
        return anAddress;
    }


    @Override
    public Address readAddress(Long id) {
        return (Address) sessionFactory.getCurrentSession().get(Address.class, id);
    }

    @Override
    public Address readAddress(String addressTitle) {
        return (Address) sessionFactory.getCurrentSession().createCriteria(Address.class).add(Restrictions.eq("street",addressTitle));
    }

    @Override
    public void deleteAddress(Address address) {
        sessionFactory.getCurrentSession().delete(address);
    }

    @Override
    public void updateAddress(Address address) {
        sessionFactory.getCurrentSession().update(address);
    }

    @Override
    public List<Address> findAll() {
        return (List<Address>) sessionFactory.getCurrentSession().createCriteria(Address.class).list();
    }

    @Override
    public List<Address> findByDistrict(District district) {
        return (List<Address>) sessionFactory.getCurrentSession().createCriteria(Address.class)
                .add(Restrictions.eq("district", district)).list();

    }

}
