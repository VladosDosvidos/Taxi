package hw8.taxi.controller;

import hw8.taxi.domain.Taxist;
import hw8.taxi.service.TaxistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vlad on 25.04.2015.
 */

@Controller
@SessionAttributes("employee")
public class TaxistController {

    @Autowired
    private TaxistService taxistService;


    @RequestMapping(value = "/registerTaxist", method = RequestMethod.POST)
    private String registerNewTaxist(@RequestParam("taxistName") String name,
                                     @RequestParam("taxistSurName") String surName,
                                     @RequestParam("taxistPhone") String phone,
                                     @RequestParam("taxistPassword") String pass,
                                     Model model) {
        taxistService.Create(phone, name, surName, pass);
        return "dashboard";
    }

    @RequestMapping(value = "/showAllTaxists", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Taxist> listAllTaxists(Model model) {
        List<Taxist> tempList = taxistService.getAllTaxists();//велисопедик =)
        List<Taxist> rezList = new LinkedList<>();
        for (Taxist taxist : tempList) {
            taxist.setCurrentOrder(null);
            taxist.setTaxiOrders(null);
            rezList.add(taxist);
        }
        return rezList;
    }

    @RequestMapping(value = "/showOnlineTaxists", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Taxist> listOnlineTaxists(Model model) {
        List<Taxist> tempList = taxistService.getOnlineTaxists();//велисопедик =)
        List<Taxist> rezList = new LinkedList<>();
        for (Taxist taxist : tempList) {
            taxist.setCurrentOrder(null);
            taxist.setTaxiOrders(null);
            rezList.add(taxist);
        }

        return rezList;
    }

}