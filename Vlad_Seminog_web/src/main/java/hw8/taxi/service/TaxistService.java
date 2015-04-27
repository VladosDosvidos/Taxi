package hw8.taxi.service;

import hw8.taxi.domain.Taxist;

import java.util.List;

/**
 * Created by Vlad on 23.04.2015.
 */
public interface TaxistService {

    public void Create(String phone, String name, String secondName,String password );

    public Long Auth(String phone, String password);

    public void setOnline(Long id, boolean b);

    public List getAllTaxists();

    public List getOnlineTaxists();

    public void logOut(Long id);

    public void setOrderForTaxist(Long taxistId, Long orderId);

    public Taxist getTaxist(Long taxistId);




}
