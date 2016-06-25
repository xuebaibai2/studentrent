package com.caydenli.web.model;

import com.caydenli.web.utility.POSTTYPE;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Post {
    private int id;
    private Account user;
    private String posttype;
    private String subject;
    private String content;
    private String email;
    private Timestamp postdate;
    private boolean issticky;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Post() {
    }

    public Post(Account user, String posttype, String subject, String content, String email,
                Timestamp postdate, boolean issticky, int id) {

        this.user = user;
        this.posttype = posttype;
        this.subject = subject;
        this.content = content;
        this.email = email;
        this.postdate = postdate;
        this.issticky = issticky;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public String getPosttype() {
        return posttype;
    }

    public void setPosttype(String posttype) {
        this.posttype = posttype;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getPostdate() {
        return postdate;
    }

    public String getPostdate_display(){
        return new SimpleDateFormat("yyyy-MM-dd").format(getPostdate());
    }

    public void setPostdate(Timestamp postdate) {
        this.postdate = postdate;
    }

    public boolean issticky() {
        return issticky;
    }

    public void setIssticky(boolean issticky) {
        this.issticky = issticky;
    }


}
