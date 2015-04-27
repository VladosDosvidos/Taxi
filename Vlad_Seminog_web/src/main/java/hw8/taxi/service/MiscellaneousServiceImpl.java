package hw8.taxi.service;

import hw8.taxi.dao.AddressDAO;
import hw8.taxi.dao.CabDAO;
import hw8.taxi.dao.DistrictDao;
import hw8.taxi.domain.Address;
import hw8.taxi.domain.Cab;
import hw8.taxi.domain.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Роберт on 27.04.2015.
 */
@Service
public class MiscellaneousServiceImpl implements MiscellaneousService {
    @Autowired(required = true)
    private AddressDAO addressDAO;


    @Autowired(required = true)
    private DistrictDao districtDao;

    @Autowired(required = true)
    private CabDAO cabDAO;


    @Override
    public Address getAddress(String stringAddress) {
        return addressDAO.readAddress(stringAddress);
    }

    @Override
    public List listAddress() {
        return addressDAO.findAll();
    }

    @Override
    public List listAddress(District district) {
        return addressDAO.findByDistrict(district);
    }

    @Override
    public Address createAddress(String streetTitle, District district) {


        return addressDAO.createAddress(streetTitle,district);
    }

    @Override
    public District createDistrict(String districtTitle) {
        District district=districtDao.readDistrict(districtTitle);
        if(district!=null){
            return district;
        }else {
            district=new District(districtTitle);
            districtDao.createDistrict(district);
            return district;
        }

    }

    @Override
    public List listDistrict() {
        return cabDAO.findAll();
    }

    @Override
    public Long createCab(Cab cab) {
        return cabDAO.createCab(cab);
    }
}
