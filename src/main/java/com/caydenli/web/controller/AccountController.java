package com.caydenli.web.controller;

import com.caydenli.web.model.Account;
import com.caydenli.web.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
        account.setAuthority("user");

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



    @RequestMapping("/welcome")
    public String register_welcome(){
        return "welcome";
    }

}
