package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.HttpRequestMaker;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.QuizAdapter;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.Util;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SHomeActivity extends AppCompatActivity {
    private ListView listView;
    private EditText editText;
    private TextView whyNeedCode;
    private Button demoButton;
    private Button button;
    private Student student;
    private List<Quiz> publicQuizes;
    private int code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shome);
        //INITIALIZE FIELDS
        listView = findViewById(R.id.list_shome_publicq);
        editText = findViewById(R.id.edtText_shome_code);
        whyNeedCode = findViewById(R.id.txtView_shome_why);
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
                        Quiz quiz = publicQuizes.get(position);
                            startActivity(new Intent(SHomeActivity.this,SQuizPreviewActivity.class)
                                    .putExtra("quiz",quiz).putExtra("student",student));
                    }
                });

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        code=Integer.parseInt(editText.getText().toString());
                        new HttpRequestMaker(){
                            public void onPostExecute(String s){
                                try{
                                    Quiz quiz = new Gson().fromJson(s,Quiz[].class)[0];
                                    startActivity(new Intent(SHomeActivity.this,SQuizPreviewActivity.class)
                                            .putExtra("student",student).putExtra("quiz",quiz));
                                }
                                catch(Exception e){
                                    Toast.makeText(SHomeActivity.this,R.string.shomeincorrectcode,Toast.LENGTH_LONG).show();
                                }
                            }
                        }.execute("GET","http://188.25.199.62:8000/quizes/?code="+code);
                    }
                });
            }
        };
        httpRequestMaker.execute("GET","http://188.25.199.62:8000/quizes/?privat=0");
    }
}