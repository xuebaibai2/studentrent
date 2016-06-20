package com.caydenli.web.model;

import com.caydenli.web.utility.GROUP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cayden on 16/6/20.
 */
public class Account {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String Email;
    private String phonenumber;
    private String gender;
    private GROUP groupname;
    private List<Post> posts = new ArrayList<Post>();

    public Account(String username, String password, String firstName, String lastName, String email, String phonenumber, String gender, GROUP groupname) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.groupname = groupname;
    }

    public List<Subscription> getSubscription() {
        return subscription;
    }

    public void setSubscription(List<Subscription> subscription) {
        this.subscription = subscription;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public GROUP getGroupname() {
        return groupname;
    }

    public void setGroupname(GROUP groupname) {
        this.groupname = groupname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private List<Subscription> subscription = new ArrayList<Subscription>();
}
