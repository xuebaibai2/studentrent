package com.caydenli.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class HomeController {

    @RequestMapping("/home")
    public String showHome(Model model){
        model.addAttribute("name","<pre>yanfeng li will success</pre>");
        return "home";
    }

    @RequestMapping("/jndi")
    public String showJNDI(Model model){
        return "jndi";
    }

}
