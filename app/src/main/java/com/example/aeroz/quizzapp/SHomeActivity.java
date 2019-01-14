package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.Creator;
import com.example.aeroz.quizzapp.notActivities.HttpRequestMaker;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.QuizAdapter;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SHomeActivity extends AppCompatActivity {
    private ListView listView;
    private ImageView ic_home;
    private EditText editText;
    private TextView whyNeedCode;
    private Button button;
    private Student student;
    private List<Quiz> publicQuizes;
    private int code;
    private Quiz quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shome);
        //INITIALIZE FIELDS
        listView = findViewById(R.id.list_shome_publicq);
        editText = findViewById(R.id.edtText_shome_code);
        whyNeedCode = findViewById(R.id.txtView_shome_why);
        ic_home=findViewById(R.id.ic_shome_profile);
        button = findViewById(R.id.btn_shome_continue);
        publicQuizes = new ArrayList<>();
        student = (Student)getIntent().getExtras().getSerializable("student");
        ////////////////////
        HttpRequestMaker httpRequestMaker = new HttpRequestMaker() {
            @Override
            public void onPostExecute(String s){
                publicQuizes = Arrays.asList(new Gson().fromJson(s,Quiz[].class));

                QuizAdapter quizAdapter = new QuizAdapter(SHomeActivity.this,android.R.layout.simple_list_item_2,publicQuizes);
                listView.setAdapter(quizAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        TextView tv = view.findViewById(android.R.id.text2);
//                        int ID = Integer.parseInt(tv.getText().toString());
//                        Quiz quiz= Util.getQuizById(ID,publicQuizes);
                        quiz = publicQuizes.get(position);
                        new HttpRequestMaker(){
                            @Override
                            public void onPostExecute(String s){
                                Creator creator = new Gson().fromJson(s,Creator.class);
                                startActivity(new Intent(SHomeActivity.this,SQuizPreviewActivity.class)
                                        .putExtra("quiz",quiz).putExtra("student",student).putExtra("creator",creator));
                            }
                        }
                                .execute("POST","http://188.25.199.62:8000/teacherName",new Gson().toJson(quiz));

                    }
                });

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            code=Integer.parseInt(editText.getText().toString());
                            new HttpRequestMaker(){
                                public void onPostExecute(String s){
                                    try{
                                        quiz = new Gson().fromJson(s,Quiz[].class)[0];
                                        new HttpRequestMaker(){
                                            @Override
                                            public void onPostExecute(String s){
                                                Creator creator = new Gson().fromJson(s,Creator.class);
                                                startActivity(new Intent(SHomeActivity.this,SQuizPreviewActivity.class)
                                                        .putExtra("student",student).putExtra("quiz",quiz).putExtra("creator",creator));
                                            }
                                        }.execute("POST","http://188.25.199.62:8000/teacherName",new Gson().toJson(quiz));

                                    }
                                    catch(Exception e){
                                        Toast.makeText(SHomeActivity.this,R.string.shomeincorrectcode,Toast.LENGTH_LONG).show();
                                    }
                                }
                            }.execute("GET","http://188.25.199.62:8000/quizes/?code="+code);
                        }
                        catch(Exception e){
                            Toast.makeText(SHomeActivity.this, "the code is not valid :(", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        };
        httpRequestMaker.execute("GET","http://188.25.199.62:8000/quizes/?privat=0");


        whyNeedCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SHomeActivity.this,DemoQuizActivity.class).putExtra("student",student));
            }
        });

        ic_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SHomeActivity.this,SProfileActivity.class).putExtra("student",student));
            }
        });
    }

}