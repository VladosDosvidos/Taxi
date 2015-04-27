package hw8.taxi.dao;

import hw8.taxi.domain.Order;
import hw8.taxi.domain.Taxist;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.beans.Expression;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Vlad on 12.04.2015.
 */

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public void createOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order readOrder(Long id) {
        return (Order) sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public void deleteOrder(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

    @Override
    public void updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public List showOrders(Long from, Long to) {

        return sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.between("orderSum", from.intValue(), to.intValue())).list();
    }

    @Override
    public List showOrdersByPortion() {
        return sessionFactory.getCurrentSession().createCriteria(Order.class).setMaxResults(5).list();
    }

    @Override
    public List showAllOrders() {
        return sessionFactory.getCurrentSession().createCriteria(Order.class).list();
    }

    @Override
    public String showStringForTaxist() {
        String rezultOrderString = "";
        List<Order> orderList = showAllOrders();
        for (Order order : orderList) {
            rezultOrderString += order.getOrderId() + "|" + order.getAddressFrom() + "|" + order.getAddressTo() + "|" + order.getOrderSum() + "&";
        }
        return rezultOrderString;
    }

    @Override
    public List listNewOrders() {
//        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Taxist.class);
//        criteria.addOrder(org.hibernate.criterion.Order.asc("orderDate"));
//        return criteria.list();
//        return  sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.conjunction()).addOrder(org.hibernate.criterion.Order.asc("orderDate")).list();

        Calendar current = Calendar.getInstance();
        return sessionFactory.getCurrentSession().createCriteria(Order.class)
                .add(Restrictions.gt("orderDate", new GregorianCalendar(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH))))
                .addOrder(org.hibernate.criterion.Order.desc("orderDate")).list();
    }

    @Override
    public List listNewFreeOrders() {
        Calendar current = Calendar.getInstance();
        return sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.isNull("taxist")).add(Restrictions.gt("orderDate", new GregorianCalendar(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH))))
                .addOrder(org.hibernate.criterion.Order.desc("orderDate")).list();
    }

    @Override
    public List listNewTakenOrders() {
        Calendar current = Calendar.getInstance();
        return sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.isNotNull("taxist")).add(Restrictions.gt("orderDate", new GregorianCalendar(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH))))
                .addOrder(org.hibernate.criterion.Order.desc("orderDate")).list();
    }
}
