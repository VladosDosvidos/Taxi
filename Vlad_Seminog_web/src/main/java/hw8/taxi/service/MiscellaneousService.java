package hw8.taxi.service;

import hw8.taxi.domain.Address;
import hw8.taxi.domain.Cab;
import hw8.taxi.domain.District;

import javax.xml.ws.Dispatch;
import java.util.List;

/**
 * Created by Роберт on 27.04.2015.
 */
public interface MiscellaneousService {
    public Address getAddress(String stringAddress);
    public List listAddress();
    public List listAddress(District district);

    public Address createAddress(String streetTitle, District district);
    public District createDistrict(String districtTitle);
    public List listDistrict();
    public Long createCab(Cab cab);



}
