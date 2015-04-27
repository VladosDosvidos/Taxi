package hw8.taxi.dao;

import hw8.taxi.domain.District;

import java.util.List;

/**
 * Created by Evgenchik on 27.04.2015.
 */
public interface DistrictDao {
    public Long createDistrict(District district);

    public District readDistrict(Long id);
    public District readDistrict(String districtTitle);

    public void deleteDistrict(District district);

    public void updateDistrict(District district);

    public List<District> lisOfAddress();




}
