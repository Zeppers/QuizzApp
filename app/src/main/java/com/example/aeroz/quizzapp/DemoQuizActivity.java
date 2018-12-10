package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.TakenQuiz;
import com.example.aeroz.quizzapp.notActivities.Util;

import java.util.ArrayList;
import java.util.List;

public class DemoQuizActivity extends AppCompatActivity {
    private Student student;
    private ListView listView;
    private ImageView imageView;
    private Quiz quiz;
    private List<String> demoQuizes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_quiz);
        //INITIALIZE FIELDS///////////////////////////////////////////////////////
        student = (Student)getIntent().getExtras().getSerializable("student");
        listView = findViewById(R.id.listView_demoquiz_dynamic);
        imageView = findViewById(R.id.imgView_demoquiz_ic_back);



        /////////////////////////////////////////////////////////////////////////

        for(Quiz q:SplashscreenActivity.demoQuizes)
            demoQuizes.add("ID:"+q.getId()+" "+q.getQuizName());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,demoQuizes);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int quizId = Integer.parseInt(demoQuizes.get(position).split(" ")[0].split(":")[1]);
                quiz = Util.getDemoQuizById(quizId);
                TakenQuiz tq = Util.getTakenQuizById(quiz.getId(),student);
                if(tq==null||tq.getRemainingTries()!=0){
                    startActivity(new Intent(DemoQuizActivity.this,SQuizPreviewActivity.class).putExtra("quiz",quiz).putExtra("student",student));
                }
                else Toast.makeText(DemoQuizActivity.this,R.string.shometries,Toast.LENGTH_LONG).show();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DemoQuizActivity.this,SHomeActivity.class).putExtra("student",student));
            }
        });
    }
}
