package hw8.taxi.dao;

import hw8.taxi.domain.Taxist;

import java.util.List;

/**
 * Created by Vlad on 23.04.2015.
 */
public interface TaxistDAO {

    public void createTaxist(Taxist taxist);

    public Taxist readTaxist(Long id);

    public Taxist readByName(String name);

    public Taxist readByPhone(String phone);

    public void deleteTaxist(Taxist taxist);

    public void updateTaxist(Taxist taxist);

    public List<Taxist> getAllTaxists();

    public List<Taxist> getOnlineTaxists();

}
