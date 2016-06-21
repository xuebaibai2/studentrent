package com.caydenli.web.controller;

import com.caydenli.web.model.Account;
import com.caydenli.web.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    AccountsService accountsService;

    @Autowired
    public void setAccountsService(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @RequestMapping("/adminhome")
    public String adminHome(Model model){
        List<Account> accounts = accountsService.getAllAccounts();

        model.addAttribute("accounts",accounts);

        return "/admin/adminhome";
    }

}
