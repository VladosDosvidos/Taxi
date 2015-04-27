package hw8.taxi.dao;

import hw8.taxi.domain.Address;
import hw8.taxi.domain.District;

import java.util.List;

/**
 * Created by admssa on 27.04.2015.
 */

public interface AddressDAO {


    public void createAddress(Address address);
    public Address createAddress(String address,District district);

    public Address readAddress(Long id);
    public Address readAddress(String addressTitle);


    public void deleteAddress(Address address);

    public void updateAddress(Address address);


      public List<Address> findAll();

      public List<Address> findByDistrict(District district);

}
