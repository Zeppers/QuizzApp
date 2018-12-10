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
import com.example.aeroz.quizzapp.notActivities.Reader;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.TakenQuiz;
import com.example.aeroz.quizzapp.notActivities.Teacher;
import com.example.aeroz.quizzapp.notActivities.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SplashscreenActivity extends AppCompatActivity {

    public static List<Student> students = new ArrayList<>();
    public static List<Teacher> teachers = new ArrayList<>();
    public static List<Quiz> quizes = new ArrayList<>();
    public static List<Quiz> demoQuizes = new ArrayList<>();

    public String JSONContent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        List<Question> questions1 = new ArrayList<>();
        List<Question> questions2 = new ArrayList<>();
        List<Question> questions3=new ArrayList<>();

        Question q1 = new Question("Who was the first american in space?",new String[]{"Alan Shepard","Donald Trump","Marizio Tutti","Mariah Carey"},new int[]{0,1,2});
        Question q2 = new Question("Which planet is nearest the sun",new String[]{"the Moon","Jupiter","Venus","Mercur"},new int[]{0,2});
        Question q3 = new Question("Which device was invented by Henry Mill", new String[]{"metal thing","toothbrush","pen","typewriter"},new int[]{2});
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

        Question q9 = new Question("What is the most basic language Microsoft made?",new String[]{"Visual Basic","DirectX","Batch","C++"},new int[]{0});
        Question q10 = new Question(
                "Using the declaration below, what will be the final element of the array? int [ ] grades = new int[35]?",new String[]{"Grades[34]","Grades[0]","Grades[35]","Impossible to tell"},new int[]{1});
        Question q11 = new Question(
                "It is the command used to compile Java program in the command prompt.",new String[]{"javac","java","jav","javacompile"},new int[]{0});
        Question q12 = new Question(
                "It is the length of the data type short.",new String[]{"8 bits","32 bits","16 bites","1 bite"},new int[]{2});
        questions3.add(q9);
        questions3.add(q10);
        questions3.add(q11);
        questions3.add(q12);


        Quiz quiz3=new Quiz("Java Programming","Quiz for basic knowledge of Java Programming",questions3,240,true,true,"Zamfiroiu Alin");

        Log.d("pandarer",""+quiz3.getCode());
        Quiz quiz1 = new Quiz("Science","description1",questions1,240,true,false,"Zamfiroiu Alin");
        Quiz quiz2 = new Quiz("Literature and arts","description2",questions2,240,true,false,"Craciun Marian");

        quizes.add(quiz1);quizes.add(quiz2); quizes.add(quiz3);

        students.add(new Student("Petre Cosmin","petrecosmin16@stud.ase.ro","password1"));
        students.add(new Student("Niculae Andreea","niculaeandreea16@stud.ase.ro","password2"));
        students.add(new Student("Paun Diana","paundiana16@stud.ase.ro","password3"));

        teachers.add(new Teacher("Boja Catalin","bojacatalin@ie.ase.ro","password1"));
        teachers.add(new Teacher("Toma Andrei","tomaandrei@ie.ase.ro","password2"));
        teachers.add(new Teacher("Testescu Testulici","test@ie.ase.ro","password3",quizes));





        Reader reader = new Reader(){
            @Override
            protected void onPostExecute(String s){
                try {
                    JSONArray JSONquizesArray = new JSONObject(s).getJSONArray("Quizes");
                    for(int i = 0;i<JSONquizesArray.length();i++){
                        List<Question> questions = new ArrayList<>();
                        int id = ((JSONObject)JSONquizesArray.get(i)).getInt("id");
                        String quizName = ((JSONObject)JSONquizesArray.get(i)).getString("quizName");
                        String description = ((JSONObject)JSONquizesArray.get(i)).getString("description");
                        int time = ((JSONObject)JSONquizesArray.get(i)).getInt("time");
                        boolean active = ((JSONObject)JSONquizesArray.get(i)).getBoolean("active");
                        boolean privat = ((JSONObject)JSONquizesArray.get(i)).getBoolean("privat");
                        int code = ((JSONObject)JSONquizesArray.get(i)).getInt("code");
                        String creator = ((JSONObject)JSONquizesArray.get(i)).getString("creator");


                        JSONArray JSONQuestions = ((JSONObject) JSONquizesArray.get(i)).getJSONArray("questions");
                        for(int j = 0;j<JSONQuestions.length();j++){
                            String questionText = ((JSONObject)JSONQuestions.get(j)).getString("questionText");
                            JSONArray JSONAnswers = ((JSONObject) JSONQuestions.get(j)).getJSONArray("answers");
                            JSONArray JSONCorrectAnswers = ((JSONObject) JSONQuestions.get(j)).getJSONArray("correctAnswers");
                            String[] answers = new String[JSONAnswers.length()];
                            int[] correctAnswers = new int[JSONCorrectAnswers.length()];
                            for(int k = 0;k<answers.length;k++)
                                answers[k] = (String)JSONAnswers.get(k);
                            for(int l = 0;l<correctAnswers.length;l++)
                                correctAnswers[l] = (int)JSONCorrectAnswers.get(l);
                            questions.add(new Question(questionText,answers,correctAnswers));
                        }
                        Quiz quiz = new Quiz(quizName,description,questions,time,active,privat,creator);
                        quiz.setId(id);
                        quiz.setCode(code);
                        demoQuizes.add(quiz);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        reader.execute("https://api.myjson.com/bins/1f1hna");
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
