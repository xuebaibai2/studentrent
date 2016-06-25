package com.caydenli.web.dao;


import com.caydenli.web.model.Account;
import com.caydenli.web.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.object.MappingSqlQueryWithParameters;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


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

    public List<Post> getAllPost() {

        return jdbc.query("select * from userpost", getPostListMapper());
    }

    public List<Post> getAllPost(String id) {
        return jdbc.query("select * from userpost where postId = :postId ",
                new MapSqlParameterSource("postId", id),
                getPostListMapper());
    }

    public List<Post> getAllMyPost(String name) {
        return jdbc.query("select * from userpost where username = :username",
                new MapSqlParameterSource("username", name),
                getPostListMapper());
    }

    public List<Post> getPostByID(String id) {
        return jdbc.query("select * from userpost where postId = :postId ",
                new MapSqlParameterSource("postId", id),
                getPostListMapper());
    }

    private RowMapper<Post> getPostListMapper(){
        return  new RowMapper<Post>() {
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Post(
                        new Account(rs.getString("username")),
                        rs.getString("posttype"),
                        rs.getString("subject"),
                        rs.getString("content"),
                        rs.getString("email"),
                        rs.getTimestamp("postdate"),
                        rs.getBoolean("issticky"),
                        rs.getInt("postId")
                );
            }
        };
    }

    public List<Post> getPostByIdandUserName(String id, String username) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("postId", id);
        params.addValue("username", username);
        return jdbc.query("select * from userpost where postId = :postId and username = :username",
                params,
                getPostListMapper());
    }

    @Transactional
    public boolean updatePost(Post post) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("subject", post.getSubject());
        params.addValue("content", post.getContent());
        params.addValue("email", post.getEmail());
        params.addValue("posttype", post.getPosttype());
        params.addValue("postdate", post.getPostdate());
        params.addValue("issticky", post.issticky());
        params.addValue("postId", post.getId());

        return jdbc.update("update userpost " +
                "set subject = :subject, content = :content, email = :email, posttype = :posttype, " +
                "postdate = :postdate, issticky = :issticky " +
                "where postId = :postId",params) == 1;

    }
}
