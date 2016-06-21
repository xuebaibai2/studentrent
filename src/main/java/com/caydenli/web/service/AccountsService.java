package com.caydenli.web.service;

import com.caydenli.web.dao.AccountsDAO;
import com.caydenli.web.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cayden on 16/6/20.
 */
@Service("accountsService")
public class AccountsService {
    private AccountsDAO accountsDAO;

    @Autowired
    public void setAccountsDAO(AccountsDAO accountsDAO){
        this.accountsDAO = accountsDAO;
    }

    public boolean create(Account account){
        return accountsDAO.register(account);
    }

    public boolean userExist(String username) {
        return accountsDAO.usernameExist(username);
    }

    public boolean emailExist(String email) {
        return  accountsDAO.userEmailExist(email);
    }

    public List<Account> getAllAccounts() {
        return accountsDAO.getAllUsers();
    }
}
