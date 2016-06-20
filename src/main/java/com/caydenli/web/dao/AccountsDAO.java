package com.caydenli.web.dao;

import com.caydenli.web.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cayden on 16/6/20.
 */
@Component("accountDao")
public class AccountsDAO {
    private NamedParameterJdbcTemplate jdbc;

    public AccountsDAO() {
    }

    @Autowired
    public void setDataSource(DataSource jdbc){
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    @Transactional
    public boolean register(Account account){
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(account);
        Map<String,String> param = new HashMap<String, String>();

        jdbc.update("insert into accounts (username, password, email, enabled) " +
                    "VALUES (:username, :password, :email, :enabled)",params);

        Integer userId = jdbc.queryForObject(
                "select id from accounts where username = :username",params,Integer.class);


        param.put("userId",userId.toString());
        param.put("authority",account.getAuthority());


        return jdbc.update("insert into authorities (userId, authority) values (:userId, :authority) ",
                param) == 1;
    }

    public boolean usernameExist(String username) {
        return jdbc.queryForObject("select count(*) from accounts where username = :username",
                new MapSqlParameterSource("username",username),
                Integer.class) > 0;
    }

    public boolean userEmailExist(String email) {
        return jdbc.queryForObject("select count(*) from accounts where email = :email",
                new MapSqlParameterSource("email",email),
                Integer.class) > 0;
    }
}
