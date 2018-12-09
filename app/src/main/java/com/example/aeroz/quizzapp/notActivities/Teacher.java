package com.example.aeroz.quizzapp.notActivities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Teacher implements Serializable {
    private String name;
    private String email;
    private String password;
    private List<Quiz> quizes = new ArrayList<>();

    public Teacher(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Teacher(String name, String email, String password, List<Quiz> quizes){
        this.name = name;
        this.email = email;
        this.password = password;
        this.quizes = quizes;
    }

    public String getName(){return this.name;}      public void setName(String value){this.name = value;}
    public String getEmail(){return this.email;}        public void setEmail(String value){this.email = value;}
    public List<Quiz> getQuizes(){return  this.quizes;}     public void setQuizes(List<Quiz> value){this.quizes = value;}
    public String getPassword(){return this.password;}      public void setPassword(String value){this.password = value;}

    public String toString(){return this.name+ " "+this.email+" "+this.password;}
}
