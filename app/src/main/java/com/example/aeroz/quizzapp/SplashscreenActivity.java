package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.aeroz.quizzapp.notActivities.ChosenAnswer;
import com.example.aeroz.quizzapp.notActivities.Question;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.TakenQuiz;
import com.example.aeroz.quizzapp.notActivities.Teacher;
import com.example.aeroz.quizzapp.notActivities.Util;

import java.util.ArrayList;
import java.util.List;

public class SplashscreenActivity extends AppCompatActivity {

    public static List<Student> students = new ArrayList<>();
    public static List<Teacher> teachers = new ArrayList<>();
    public static List<Quiz> quizes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        List<Question> questions1 = new ArrayList<>();
        List<Question> questions2 = new ArrayList<>();

        Question q1 = new Question("Who was the first american in space?",new String[]{"Alan Shepard","Donald Trump","Marizio Tutti","Mariah Carey"},new int[]{0,1,2});
        Question q2 = new Question("Which planet is nearest the sun",new String[]{"the Moon","Jupiter","Venus","Mercur"},new int[]{0,2});
        Question q3 = new Question("Which device was invented by Henry Mill", new String[]{"metal dildo","toothbrush","pen","typewriter"},new int[]{2});
        Question q4 = new Question("Which unit indicate the light intensity?",new String[]{"bar","ohm","amper","candela"},new int[]{1,3});
        questions1.add(q1);
        questions1.add(q2);
        questions1.add(q3);
        questions1.add(q4);
        Question q5 = new Question("How was Sumitra's nature?",new String[]{"Calm","Nature","Fierce","Clever"},new int[]{0,3});
        Question q6 = new Question("Who is the author of Lord of the Flies?",new String[]{"William Golding","Aldous Huxley","Sir Arthur Conan Doyle","Dana Marijuana"},new int[]{1,2});
        Question q7 = new Question("Who is the author of Life on the Mississippi?",new String[]{"James Joyce","Graham Greene","Mark Twain","Petre Ispirescu"},new int[]{0});
        Question q8 = new Question("Which of the following is a not a play?",new String[]{"Pygmalion","A Doll’s House","Jane Austen","The Tempest"},new int[]{1});
        questions2.add(q5);
        questions2.add(q6);
        questions2.add(q7);
        questions2.add(q8);

        Quiz quiz1 = new Quiz("Science","description1",questions1,240,true,false,"Alin");
        Quiz quiz2 = new Quiz("Literature and arts","description2",questions2,240,true,false,"Marian");
        quizes.add(quiz1);quizes.add(quiz2);

        students.add(new Student("Petre Cosmin","petrecosmin16@stud.ase.ro","password1"));
        students.add(new Student("Niculae Andreea","niculaeandreea16@stud.ase.ro","password2"));
        students.add(new Student("Paun Diana","paundiana16@stud.ase.ro","password3"));

        teachers.add(new Teacher("Boja Catalin","bojacatalin@ie.ase.ro","password1"));
        teachers.add(new Teacher("Toma Andrei","tomaandrei@ie.ase.ro","password2"));
        teachers.add(new Teacher("Testescu Testulici","test@ie.ase.ro","password3",quizes));


        Thread thread = new Thread(){
            @Override

            public void run() {
                try{
                    sleep(1500);
                    Intent i = new Intent(getApplicationContext(),OnboardingActivity.class);
                    startActivity(i);
                    }
                    catch(Exception e){}
                    }
                };

        thread.start();
    }


}
