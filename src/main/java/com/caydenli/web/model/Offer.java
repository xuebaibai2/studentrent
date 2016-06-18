package com.caydenli.web.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Offer {
    private int id;

    @Size(min = 5,max = 100, message = "Name cannot less than 5 and over 100 character size")
    private String name;
    @NotNull
    private  String email;
    @NotNull
    private String text;

    public Offer(){

    }

    public Offer(String name, String email, String text) {
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public Offer(int id, String name, String email, String text) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Offer name: " + getName() + " email " + getEmail() + " text " + getText();
    }
}
