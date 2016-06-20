package com.caydenli.web.model;

import com.caydenli.web.utility.SERVICETYPE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cayden on 16/6/20.
 */
public class Service {
    private int id;
    private SERVICETYPE name;
    private List<Subscription> subscription = new ArrayList<Subscription>();

    public Service(SERVICETYPE name, List<Subscription> subscription) {
        this.name = name;
        this.subscription = subscription;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SERVICETYPE getName() {
        return name;
    }

    public void setName(SERVICETYPE name) {
        this.name = name;
    }

    public List<Subscription> getSubscription() {
        return subscription;
    }

    public void setSubscription(List<Subscription> subscription) {
        this.subscription = subscription;
    }
}
