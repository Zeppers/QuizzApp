package com.example.aeroz.quizzapp.notActivities;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int id;

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

    public List<Quiz> getQuizes() {
        return quizes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setQuizes(List<Quiz> quizes) {
        this.quizes = quizes;
    }

    private String name;
    private String email;
    private String password;
    private List<Quiz> quizes = new ArrayList<>();

    public Teacher(int id, String name, String email, String password,List<Quiz> quizes){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.quizes = quizes;
    }
    public Teacher(int id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
