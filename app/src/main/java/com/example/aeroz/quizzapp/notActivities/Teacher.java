package com.example.aeroz.quizzapp.notActivities;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String name;
    private String email;
    private List<Quiz> quizes = new ArrayList<>();

    public Teacher(String name, String email, List<Quiz> quizes){
        this.name = name;
        this.email = email;
        this.quizes = quizes;
    }

    public String getName(){return this.name;}      public void setName(String value){this.name = value;}
    public String getEmail(){return this.email;}        public void setEmail(String value){this.email = value;}
    public List<Quiz> getQuizes(){return  this.quizes;}     public void setQuizes(List<Quiz> value){this.quizes = value;}


}
