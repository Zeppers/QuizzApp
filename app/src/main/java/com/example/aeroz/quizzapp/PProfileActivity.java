package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.QuizAdapter;
import com.example.aeroz.quizzapp.notActivities.Teacher;

import java.util.ArrayList;
import java.util.List;

public class PProfileActivity extends AppCompatActivity {
    private Teacher teacher;
    private ImageView close;
    private TextView textView1;
    private TextView textView2;
    private ListView listView;
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pprofile);

        teacher = (Teacher)getIntent().getExtras().getSerializable("teacher");
        textView1 = findViewById(R.id.txtView_pprofile_text2);
        textView2 = findViewById(R.id.txtView_pprofile_text3);
        button1 = findViewById(R.id.btn_pprofile_logout);
        button2 = findViewById(R.id.btn_pprofile_createquiz);
        listView = findViewById(R.id.list_pprofile_drafts);
        close = findViewById(R.id.imgView_pprofile_ic_close);

        textView1.setText(""+getPublic().size()+" public quizzes");
        textView2.setText(""+getPrivate().size()+" private quizzes");

        QuizAdapter quizAdapter = new QuizAdapter(PProfileActivity.this,android.R.layout.simple_list_item_2,getInactive());
        listView.setAdapter(quizAdapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PProfileActivity.this,SigninActivity.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PProfileActivity.this,PCreateQuiz.class)
                .putExtra("teacher",teacher));
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PProfileActivity.this.finish();
            }
        });
    }

    public List<Quiz> getPublic(){
        List<Quiz> publics = new ArrayList<>();
        for(Quiz q:teacher.getQuizes())
            if(!q.isPrivat()&&q.isActive())
                publics.add(q);
        return publics;
    }
    public List<Quiz> getPrivate(){
        List<Quiz> privates = new ArrayList<>();
        for(Quiz q:teacher.getQuizes())
            if(q.isPrivat()&&q.isActive())
                privates.add(q);
        return privates;
    }
    public List<Quiz> getInactive(){
        List<Quiz> inactives = new ArrayList<>();
        for(Quiz q:teacher.getQuizes())
            if(!q.isActive())
                inactives.add(q);
        return inactives;
    }
}
