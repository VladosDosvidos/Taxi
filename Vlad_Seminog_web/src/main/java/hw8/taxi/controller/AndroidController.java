package hw8.taxi.controller;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.domain.Taxist;
import hw8.taxi.service.OrderService;
import hw8.taxi.service.TaxistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vlad on 25.04.2015.
 */
@Controller
public class AndroidController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private TaxistService taxistService;

    @RequestMapping(value = "/taxistAuth", method = RequestMethod.POST)
    public @ResponseBody
    Long taxistAuth (@RequestParam("phone") String phone,
                       @RequestParam("pass") String password,
                       Model model){
        return taxistService.Auth(phone,password);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public @ResponseBody
    String taxistLogout (@RequestParam("id") String id, Model model){
        Long idLong = 0l;
        try {
            idLong = Long.parseLong(id);
            taxistService.logOut(idLong);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return "error";
        }
        return "log out";
    }

    @RequestMapping(value = "/getOrdersJS", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Order> listAllOrders(Model model) {
        List<Order> listorder = orderService.listNewFreeOrders();//велисопедик =)
        List<Order> rezList = new LinkedList<>();
        for (Order order : listorder) {
            order.getClientObj().setClientTotalOrders(null);
            order.getClientObj().setClientOrderDate(null);
            order.setOrderDate(null);
            rezList.add(order);
        }
        return rezList;
    }

    @RequestMapping(value = "/getTaxist", method = RequestMethod.GET)
    public
    @ResponseBody
    Taxist getTaxistForAndroid(@RequestParam("id") String taxistId,Model model) {

        Long id = 0l;
        Taxist taxist = null;
        try {
            id = Long.parseLong(taxistId);
            taxist = taxistService.getTaxist(id);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        return taxist;
    }





    @RequestMapping(value = "/setOrder", method = RequestMethod.POST)
    public @ResponseBody
    String setOrderForTaxist (@RequestParam("taxistId") String stringTaxistId,
                     @RequestParam("orderId") String stringOrderId,
                     Model model){
        Long taxiId = 0l;
        Long orderId = 0l;
        try{
            taxiId = Long.parseLong(stringTaxistId);
            orderId = Long.parseLong(stringOrderId);
            taxistService.setOrderForTaxist(taxiId,orderId);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return "false";
        }
        return "ok";
    }

}
