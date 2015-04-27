package hw8.taxi.controller;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.domain.Taxist;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.OrderService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vlad on 12.04.2015.
 */
@Controller
@SessionAttributes("employee")
public class OrderServlet {


    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/registerOrder", method = RequestMethod.POST)
    private String createOrder(@RequestParam("clientName") String clientName,
                               @RequestParam("orderPrice") String orderPrice,
                               @RequestParam("addressFrom") String addressFrom,
                               @RequestParam("addressTo") String addressTo,
                               Model model) {
        Client client = clientService.readByName(clientName);
        if (client == null) {
            client = new Client(clientName);
        }
        orderService.createOrder(client, orderPrice, addressFrom, addressTo);
        return "dashboard";
    }

    @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
    private String editOrder(@RequestParam("orderIdedit") String orderId,
                             @RequestParam("clientNameedit") String clientName,
                             @RequestParam("orderPriceedit") String orderPrice,
                             @RequestParam("addressFromedit") String addressFrom,
                             @RequestParam("addressToedit") String addressTo,
                             Model model) {
        if (orderId != null && !orderId.equals("")) {
            Long longId = Long.parseLong(orderId);
            Order order = orderService.read(longId);
            if (order == null) {
                model.addAttribute("msg", "Error id");
            } else {
                Client client = clientService.readByName(clientName);
                try {
                    if (client != null) {
                        orderService.editOrder(longId, client, orderPrice, addressFrom, addressTo);
                    } else {
                        orderService.editOrder(longId, new Client(clientName), orderPrice, addressFrom, addressTo);
                    }
                } catch (OrderException e) {
                    e.printStackTrace();
                }
            }
        }
        return "dashboard";
    }


//    @RequestMapping(value = "/showallorders", method = RequestMethod.GET)
//    private String showAllOrders(Model model) {
//        List<Order> listorder = orderService.showOrdersByPortion();
//        model.addAttribute("listorder", listorder);
//        return "dashboard";
//    }

    @RequestMapping(value = "/showallorders", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Order> listorder(Model model) {

        List<Order> listorder = orderService.showAllOrders();//велисопедик =)
        List<Order> rezList = new LinkedList<>();
        for (Order order : listorder) {
            order.setClient(new Client(order.getClientName()));
            order.setTaxist(null);
            rezList.add(order);
        }

        return rezList;
    }

    @RequestMapping(value = "/showneworders", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Order> listNewOrders(Model model) {

        List<Order> listorder = orderService.listNewOrders();
        List<Order> rezList = new LinkedList<>();
        for (Order order : listorder) {
            order.setClient(new Client(order.getClientName()));
            rezList.add(order);
        }
        return rezList;
    }

    @RequestMapping(value = "/shownewfreeorders", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Order> listNewFreeOrders(Model model) {

        List<Order> listorder = orderService.listNewFreeOrders();
        List<Order> rezList = new LinkedList<>();
        for (Order order : listorder) {
            order.setClient(new Client(order.getClientName()));
            rezList.add(order);
        }
        System.out.println("___________" + rezList);
        return rezList;
    }

    @RequestMapping(value = "/shownewtakenorders", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Order> listNewTakenOrders(Model model) {

        List<Order> listorder = orderService.listNewTakenOrders();
        List<Order> rezList = new LinkedList<>();
        for (Order order : listorder) {
            order.setClient(new Client(order.getClientName()));
            order.setTaxist(new Taxist(order.getTaxist().getFirstName(), order.getTaxist().getPhone()));
            rezList.add(order);
        }

        return rezList;
    }

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    public
    @ResponseBody
    String stringOrders(Model model) {
        System.out.println(orderService.showStringForTaxist());
        return orderService.showStringForTaxist();
    }


    @RequestMapping(value = "/fromto", method = RequestMethod.GET)
    public String clientsMoreThen(@RequestParam("from") String from, @RequestParam("to") String to, Model model) {
        if (from != null && !from.equals("") && to != null && !to.equals("")) {
            Long fromLong = Long.parseLong(from);
            Long toLong = Long.parseLong(to);
            List<Order> listorder = null;
            try {
                listorder = orderService.showOrders(fromLong, toLong);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
            model.addAttribute("listorder", listorder);
        }
        return "dashboard";
    }
}
