package com.example.aeroz.quizzapp.notActivities;

public class QuizDB {
    private String name;
    private String description;
    private int time;
    private boolean active;
    private boolean privat;
    private int code;
    private int teacherId;

    public QuizDB( String name, String description, int time, boolean active, boolean privat, int code,int teacherId){
        this.name = name;
        this.description = description;
        this.time = time;
        this.active = active;
        this.privat = privat;
        this.code = code;
        this.teacherId = teacherId;
    }
    public QuizDB( Quiz quiz,int teacherId){
        this.name = quiz.getName();
        this.description = quiz.getDescription();
        this.time = quiz.getTime();
        this.active = quiz.isActive();
        this.privat = quiz.isPrivat();
        this.code = quiz.getCode();
        this.teacherId = teacherId;
    }
    public int getCode(){ return this.code;}
}
