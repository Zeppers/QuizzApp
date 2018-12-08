package com.example.aeroz.quizzapp.notActivities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private String name;
    private String email;
    private String password;
    private List<TakenQuiz> takenQuizes = new ArrayList<>();

    public Student(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Student(String name, String email,String password, List<TakenQuiz> takenQuizes){
        this.name = name;
        this.email = email;
        this.password = password;
        this.takenQuizes = takenQuizes;
    }

    public String getName(){return this.name;}      public void setName(String value){this.name = value;}
    public String getEmail(){return  this.email;}       public void setEmail(String value){this.email = value;}
    public List<TakenQuiz> getTakenQuizes(){return  this.takenQuizes;}      public void setTakenQuizes(List<TakenQuiz> value){this.takenQuizes = value;}
    public String getPassword(){return this.password;}      public void setPassword(String value){this.password = value;}

}
