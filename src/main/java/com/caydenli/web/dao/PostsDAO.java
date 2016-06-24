package com.caydenli.web.dao;


import com.caydenli.web.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;


@Component("postsDao")
public class PostsDAO {

    private NamedParameterJdbcTemplate jdbc;

    public PostsDAO() {
    }

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }


    @Transactional
    public boolean createPost(Post post) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(post);
        return jdbc.update("insert into posts (subject, content, email, postdate, userId, posttype)" +
                "values (:subject, :content, :email, :postdate, :userId, :posttype)",params) == 1;
    }
}
