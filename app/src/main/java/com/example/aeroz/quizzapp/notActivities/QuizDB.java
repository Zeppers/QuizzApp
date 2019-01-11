package com.example.aeroz.quizzapp.notActivities;

public class QuizDB {
    private int id;
    private String name;
    private String description;
    private int time;
    private boolean active;
    private boolean privat;
    private int code;
    private int teacherId;
    public QuizDB(int id, String name, String description, int time, boolean active, boolean privat, int code,int teacherId){
        this.id = id;
        this.name = name;
        this.description = description;
        this.time = time;
        this.active = active;
        this.privat = privat;
        this.code = code;
        this.teacherId = teacherId;
    }
}
