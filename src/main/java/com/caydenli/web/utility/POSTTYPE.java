package com.caydenli.web.utility;

/**
 * Created by Cayden on 16/6/20.
 */
public enum POSTTYPE {
    LookForRoom("Looking for room"),
    LookForFlatmate("Looking for flatmate"),
    RoomAvailable("Room for renting");

    private String label;
    private POSTTYPE(String label){
        this.label = label;
    }
    public String getLabel(){
        return this.label;
    }
}
