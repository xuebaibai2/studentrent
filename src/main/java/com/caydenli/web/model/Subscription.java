package com.caydenli.web.model;

import java.util.Date;

public class Subscription {
    private int id;
    private Account user;
    private Service service;
    private Date start_date;
    private Date end_date;
    private boolean activated;

    public Subscription(Account user, Service service, Date start_date, Date end_date, boolean activated) {
        this.user = user;
        this.service = service;
        this.start_date = start_date;
        this.end_date = end_date;
        this.activated = activated;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
