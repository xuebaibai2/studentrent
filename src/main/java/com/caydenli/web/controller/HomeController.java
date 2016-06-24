package com.caydenli.web.controller;

import com.caydenli.web.model.Offer;
import com.caydenli.web.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {

    private OffersService offersService;

    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }


    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }


    @RequestMapping(value = "/accessdenied")
    public String accessDenied(){
        return "accessdenied";
    }
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String showTest(Model model, @RequestParam("id") String id){
//        System.out.println("Id is : " + id);
//        return "test";
//    }

//    @RequestMapping(value = "/create", method = RequestMethod.GET)
//    public String showCreate(Model model){
//        model.addAttribute("offer",new Offer());
//        return "create";
//    }

    //Following method shows when there are a validation error occurs
//    @RequestMapping(value = "/createsuccess", method = RequestMethod.POST)
//    public String doValidate(Model model, @Valid Offer offer, BindingResult result){
//        if (result.hasErrors()){
//            return "create";
//        }
//            return "createsuccess";
//    }
//
//    @RequestMapping(value = "/createsuccess", method = RequestMethod.GET)
//    public String doValidate(){
//        return "redirect:home";
//    }

//    @RequestMapping("/home")
//    public String showHome(Model model){
//        model.addAttribute("name","<pre>yanfeng li will success</pre>");
//        return "home";
//    }

    @RequestMapping("/jndi")
    public String showJNDI(Model model){
        return "jndi";
    }

//    @RequestMapping("/dao")
//    public String showDAO(Model model){
//        List<Offer> offers =  offersService.getCurrent();
//        model.addAttribute("offers",offers);
//        return "dao";
//    }

}
