package com.example.aeroz.quizzapp.notActivities;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String email;
    private List<TakenQuiz> takenQuizes = new ArrayList<>();

    public Student(String name, String email, List<TakenQuiz> takenQuizes){
        this.name = name;
        this.email = email;
        this.takenQuizes = takenQuizes;
    }

    public String getName(){return this.name;}      public void setName(String value){this.name = value;}
    public String getEmail(){return  this.email;}       public void setEmail(String value){this.email = value;}
    public List<TakenQuiz> getTakenQuizes(){return  this.takenQuizes;}      public void setTakenQuizes(List<TakenQuiz> value){this.takenQuizes = value;}


}
