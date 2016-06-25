package com.caydenli.web.dao;

import com.caydenli.web.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("accountDao")
public class AccountsDAO {
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AccountsDAO() {
    }

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    @Transactional
    public boolean register(Account account) {
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("username", account.getUsername());
        params.addValue("password", passwordEncoder.encode(account.getPassword()));
        params.addValue("email", account.getEmail());
        params.addValue("enabled", account.isEnabled());
        params.addValue("authority", account.getAuthority());

        jdbc.update("insert into accounts (username, password, email, enabled) " +
                "VALUES (:username, :password, :email, :enabled)", params);

        Integer userId = jdbc.queryForObject(
                "select id from accounts where username = :username", params, Integer.class);

        params.addValue("userId", userId.toString());


        return jdbc.update("insert into authorities (userId, authority) values (:userId, :authority) ",
                params) == 1;
    }

    public boolean usernameExist(String username) {
        return jdbc.queryForObject("select count(*) from accounts where username = :username",
                new MapSqlParameterSource("username", username),
                Integer.class) > 0;
    }

    public boolean userEmailExist(String email) {
        return jdbc.queryForObject("select count(*) from accounts where email = :email",
                new MapSqlParameterSource("email", email),
                Integer.class) > 0;
    }

    public List<Account> getAllUsers() {
        return jdbc.query("select * from accounts left join userauth on accounts.username = userauth.username",
                BeanPropertyRowMapper.newInstance(Account.class));
    }

    public Account getUserByUsername(String username) {
        return jdbc.query("select * from accounts where username = :username",
                new MapSqlParameterSource("username", username),
                new ResultSetExtractor<Account>() {
                    public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
                        rs.next();
                        return new Account(
                                rs.getInt("id"),
                                rs.getString("username"),
                                null,
                                rs.getString("firstName"),
                                rs.getString("lastname"),
                                rs.getString("Email"),
                                rs.getString("phonenumber"),
                                rs.getString("gender"),
                                rs.getBoolean("enabled")
                        );
                    }
                }
        );
    }
}
