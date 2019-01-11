package com.example.aeroz.quizzapp.notActivities;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    private int id;
    private String name;
    private String email;
    private String password;
    private List<TakenQuiz> takenQuizes;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTakenQuizes(List<TakenQuiz> takenQuizes) {
        this.takenQuizes = takenQuizes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<TakenQuiz> getTakenQuizes() {
        return takenQuizes;
    }


    public Student(int id, String name, String email, String password, List<TakenQuiz> takenQuizes){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.takenQuizes = takenQuizes;
    }
    public String toString(){
        return "id:" + this.id+" name:"+this.name+" email:" + this.email+ " password:" + this.password;
    }

}
