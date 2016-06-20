package com.caydenli.web.utility;

/**
 * Created by Cayden on 16/6/20.
 */
public enum POSTTYPE {
    RENTIN("Looking for room"),
    RENTOUT("Looking for flatmate");

    private String label;
    private POSTTYPE(String label){
        this.label = label;
    }
    public String getLabel(){
        return this.label;
    }
}
