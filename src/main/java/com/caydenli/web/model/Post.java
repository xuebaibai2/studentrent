package com.caydenli.web.model;

import com.caydenli.web.utility.POSTTYPE;

import java.util.Date;


public class Post {
    private int id;
    private Account user;
    private String posttype;
    private String subject;
    private String content;
    private String email;
    private Date postdate;
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

    public Post(Account user, String posttype, String subject, String content, String email, Date postdate, boolean issticky) {

        this.user = user;
        this.posttype = posttype;
        this.subject = subject;
        this.content = content;
        this.email = email;
        this.postdate = postdate;
        this.issticky = issticky;
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

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public boolean issticky() {
        return issticky;
    }

    public void setIssticky(boolean issticky) {
        this.issticky = issticky;
    }


}
