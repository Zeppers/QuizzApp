package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.Answer;
import com.example.aeroz.quizzapp.notActivities.HttpRequestMaker;
import com.example.aeroz.quizzapp.notActivities.Question;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.QuizDB;
import com.example.aeroz.quizzapp.notActivities.Teacher;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PCreateQuizTwo extends AppCompatActivity {

    private Switch privat;
    private Switch active;
    private TextView textViewCode;
    private EditText editTextTime;
    private ImageView imageView;

    private Quiz quiz;
    private Teacher teacher;
    private QuizDB lastQuiz;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcreate_quiz_two);

        privat = findViewById(R.id.switch_pcreatequiztwo_private);
        active = findViewById(R.id.switch_pcreatequiztwo_active);
        textViewCode = findViewById(R.id.txtView_pcreatequiztwo_code);
        editTextTime = findViewById(R.id.edtTxt_pcreatequiztwo_time);
        imageView = findViewById(R.id.imgView_pcreatequiztwo_ic_back);

        quiz = (Quiz)getIntent().getExtras().getSerializable("quiz");
        teacher = (Teacher)getIntent().getExtras().getSerializable("teacher");
        index = getIntent().getIntExtra("index",-1);


            new HttpRequestMaker(){
                @Override
                public void onPostExecute(String s){
                    lastQuiz = new Gson().fromJson(s,QuizDB.class);
                    textViewCode.setText(""+(lastQuiz.getCode()+1));

                }

            }.execute("GET","http://188.25.199.62:8000/lastQuiz");

        findViewById(R.id.btn_pcreatequiztwo_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int time = Integer.parseInt(editTextTime.getText().toString());
                    quiz.setTime(time);
                    quiz.setActive(active.isChecked());
                    quiz.setPrivat(privat.isChecked());
                    quiz.setCode(lastQuiz.getCode()+1);

                        new HttpRequestMaker(){
                            @Override
                            public void onPostExecute(String s){
                                new HttpRequestMaker(){
                                    @Override
                                    public void onPostExecute(String s){
                                        quiz = new Gson().fromJson(s,Quiz[].class)[0];
                                        teacher.getQuizes().add(quiz);
                                        startActivity(new Intent(PCreateQuizTwo.this,PProfileActivity.class).putExtra("teacher",teacher));
                                    }
                                }.execute("GET","http://188.25.199.62:8000/quizes/?code="+quiz.getCode());
                            }
                        }.execute("POST","http://188.25.199.62:8000/quizes",convertQuizToJson(quiz,teacher.getId()).toString());
                }
                catch(Exception e){
                    Toast.makeText(PCreateQuizTwo.this,"enter a valid time!",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public JSONObject convertQuizToJson(Quiz quiz,int id){
        JSONObject jsonQuiz = new JSONObject();
        JSONArray jsonQuestions = new JSONArray();
        JSONArray jsonAnswers = new JSONArray();
        JSONObject jsonQuestion = new JSONObject();
        JSONObject jsonAnswer = new JSONObject();
        try {
            jsonQuiz.put("id",quiz.getId());
            jsonQuiz.put("name",quiz.getName());
            jsonQuiz.put("description",quiz.getDescription());
            jsonQuiz.put("time",quiz.getTime());
            jsonQuiz.put("active",quiz.isActive());
            jsonQuiz.put("privat",quiz.isPrivat());
            jsonQuiz.put("code",quiz.getCode());
            for(Question question:quiz.getQuestions()){
                for(Answer answer:question.getAnswers()){
                    jsonAnswer.put("id",answer.getId());
                    jsonAnswer.put("text", answer.getText());
                    jsonAnswer.put("isCorrect",answer.getIsCorect());
                    jsonAnswers.put(jsonAnswer);
                }
                jsonQuestion.put("answers",jsonAnswers);
                jsonQuestion.put("id",question.getId());
                jsonQuestion.put("text",question.getText());
                jsonQuestions.put(jsonQuestion);
            }
            jsonQuiz.put("questions",jsonQuestions);
            jsonQuiz.put("teacherId",id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonQuiz;
    }
}
