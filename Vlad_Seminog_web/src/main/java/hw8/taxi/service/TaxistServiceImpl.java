package hw8.taxi.service;

import hw8.taxi.dao.OrderDAO;
import hw8.taxi.dao.TaxistDAO;
import hw8.taxi.domain.Order;
import hw8.taxi.domain.Taxist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vlad on 23.04.2015.
 */

@Service
@Transactional
public class TaxistServiceImpl implements TaxistService{

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private TaxistDAO taxistDAO;


    @Override
    public void Create(String phone, String name, String secondName, String password) {
        taxistDAO.createTaxist(new Taxist(name,secondName,phone,password));
    }

    @Override
    public Long Auth(String phone, String password) {
        Taxist taxist = taxistDAO.readByPhone(phone);
        if (taxist == null) {
            return -1l;
        }
        if (taxist.getPassword().equals(password)) {
            taxist.setOnline(true);
            taxistDAO.updateTaxist(taxist);
            return taxist.getId();
        }
        return -1l;
    }



    @Override
    public void setOnline(Long id, boolean b) {

    }

    @Override
    public List getAllTaxists() {
        return taxistDAO.getAllTaxists();
    }

    @Override
    public List getOnlineTaxists() {
        return taxistDAO.getOnlineTaxists();
    }

    @Override
    public void logOut(Long id) {
        Taxist taxist = taxistDAO.readTaxist(id);
        taxist.setOnline(false);
        taxistDAO.updateTaxist(taxist);
    }

    @Override
    public void setOrderForTaxist(Long taxistId, Long orderId) {

        Order order = orderDAO.readOrder(orderId);
        Taxist taxist = taxistDAO.readTaxist(taxistId);

        if (order != null && taxist != null){
            taxist.addOrder(order);
            order.setTaxist(taxist);
            orderDAO.updateOrder(order);
            taxistDAO.updateTaxist(taxist);
        }

    }

    @Override
    public Taxist getTaxist(Long taxistId) {
        return taxistDAO.readTaxist(taxistId);
    }
}
