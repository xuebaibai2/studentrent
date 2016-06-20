package com.caydenli.web.model;



import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


public class Account {
    private int id;
    @NotBlank
    @Size(min = 4, max = 20)
    @Pattern(regexp = "^\\w{4,}$")
    private String username;

    @NotBlank
    @Size(min = 3)
    @Pattern(regexp = "^\\S+$")
    private String password;
    private String firstName;
    private String lastName;

    @NotBlank
    @Email
    private String Email;
    private String phonenumber;
    @Pattern(regexp = "\\b(male|female)\\b")
    private String gender;
    private String authority;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    private boolean enabled = false;

    public Account() {
    }

    //    private GROUP groupname;
    private List<Post> posts = new ArrayList<Post>();

    public Account(String username, String password, String firstName, String lastName, String email, String phonenumber, String gender) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.phonenumber = phonenumber;
        this.gender = gender;
//        this.groupname = groupname;
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

//    public GROUP getGroupname() {
//        return groupname;
//    }
//
//    public void setGroupname(GROUP groupname) {
//        this.groupname = groupname;
//    }

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private List<Subscription> subscription = new ArrayList<Subscription>();
}
