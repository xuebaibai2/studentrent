package com.caydenli.web.controller;

import com.caydenli.web.model.Offer;
import com.caydenli.web.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {

    private OffersService offersService;

    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }

    @RequestMapping("/home")
    public String showHome(Model model){
        model.addAttribute("name","<pre>yanfeng li will success</pre>");
        return "home";
    }

    @RequestMapping("/jndi")
    public String showJNDI(Model model){
        return "jndi";
    }

    @RequestMapping("/dao")
    public String showDAO(Model model){
        List<Offer> offers =  offersService.getCurrent();
        model.addAttribute("offers",offers);
        return "dao";
    }

}
