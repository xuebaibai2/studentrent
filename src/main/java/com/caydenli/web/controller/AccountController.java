package com.caydenli.web.controller;

import com.caydenli.web.model.Account;
import com.caydenli.web.service.AccountsService;
import com.caydenli.web.utility.AUTHORITY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Cayden on 16/6/20.
 */
@Controller
public class AccountController {

    private AccountsService accountsService;

    @Autowired
    public void setAccountsService(AccountsService accountsService) {
        this.accountsService = accountsService;
    }


    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }

    @RequestMapping(value = "/account/createaccount", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("account", new Account());
        return "/account/createaccount";
    }

    @RequestMapping(value = "/account/createaccount",method = RequestMethod.POST)
    public String register(@Valid Account account, BindingResult result){
        if (result.hasErrors()){
            return "/account/createaccount";
        }
        account.setEnabled(true);
        account.setAuthority(AUTHORITY.user.toString());

        if(accountsService.userExist(account.getUsername())){
            result.rejectValue("username","DuplicateKey.user.username");
            return "/account/createaccount";
        }
        if (accountsService.emailExist(account.getEmail())){
            result.rejectValue("Email","DuplicateKey.user.Email");
            return "/account/createaccount";
        }

        if(accountsService.create(account)){
            return "welcome";
        }else {
            return "/account/createaccount";
        }

    }

    @RequestMapping(value = "/account/user/{username}", method = RequestMethod.GET)
    public String viewUser(@PathVariable("username") String username, Model model, Principal principal){
        Account account = accountsService.getUserByUsername(username);
        List<String> loginUserAuth = accountsService.getUserAuthorityByName(principal.getName());
        List<String> requestUserAuth = accountsService.getUserAuthorityByName(username);
        if (!loginUserAuth.contains(AUTHORITY.admin.toString())){
            if (requestUserAuth.contains(AUTHORITY.admin.toString())){
                return "redirect:/home";
            }
        }
        if (principal.getName().equals(username)){
            model.addAttribute("isAuthor", true);
        }else {
            model.addAttribute("isAuthor", false);
        }
        model.addAttribute("user", account);
        return "/account/user";
    }

    @RequestMapping(value = "/account/update/{username}", method = RequestMethod.GET)
    public String update(@PathVariable("username") String username, Model model,Principal principal){
        List<String> loginUserAuth = accountsService.getUserAuthorityByName(principal.getName());
        if (!principal.getName().equals(username)) {
            if (!loginUserAuth.contains(AUTHORITY.admin.toString())) {
                return "redirect:/home";
            }
        }
        Account account = accountsService.getUserByUsername(username);
        model.addAttribute("user", account);
        model.addAttribute("gender", new ArrayList<String>(){
            {add("male");add("female");add("null");}
        });
        return "/account/update";
    }

    @RequestMapping(value = "/account/update/{username}", method = RequestMethod.POST)
    public String update(@PathVariable("username") String username, Account account){
        if (accountsService.updateUser(account)){
            return "redirect:/account/user/"+username;
        }else{
            return "redirect:/account/update/"+username;
        }
    }

    @RequestMapping("/welcome")
    public String register_welcome(){
        return "welcome";
    }

}
