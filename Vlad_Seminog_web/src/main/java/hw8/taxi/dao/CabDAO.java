package hw8.taxi.dao;

import hw8.taxi.domain.Cab;

import java.util.List;

/**
 * Created by admssa on 27.04.2015.
 */
public interface CabDAO {
    public Long createCab(Cab cab);

    public Cab readCab(Long id);


    public void deleteCab(Cab cab);

    public void updateCab(Cab cab);


    public List<Cab> findAll();

    
}
