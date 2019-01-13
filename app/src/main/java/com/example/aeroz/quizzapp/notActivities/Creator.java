package com.example.aeroz.quizzapp.notActivities;

import java.io.Serializable;

public class Creator implements Serializable {
    private String creator;
    public Creator(){};
    public Creator(String creator){
        this.creator = creator;
    }
    public String getCreator(){return this.creator;}
}
