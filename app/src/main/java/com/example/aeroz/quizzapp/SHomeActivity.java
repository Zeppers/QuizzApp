package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Student;
import com.example.aeroz.quizzapp.notActivities.TakenQuiz;
import com.example.aeroz.quizzapp.notActivities.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;

public class SHomeActivity extends AppCompatActivity {
    private ListView listView;
    private EditText editText;
    private Quiz quiz=null;
    private Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shome);
        //initialize views, fields
        ImageView imageView = findViewById(R.id.ic_shome_profile);
        Button button = findViewById(R.id.btn_shome_continue);
        student = (Student)getIntent().getExtras().getSerializable("student");
        listView = findViewById(R.id.list_shome_publicquizzes);
        editText = findViewById(R.id.edtText_shome_code);

        //fill the listView
        final List<String> publicQuizes = new ArrayList<>();
        for(Quiz q:SplashscreenActivity.quizes){
            if(!q.isPrivat()&&q.isActive())
                publicQuizes.add("ID:"+q.getId()+" "+q.getQuizName());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,publicQuizes);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int quizId = Integer.parseInt(publicQuizes.get(position).split(" ")[0].split(":")[1]);
                quiz = Util.getQuizById(quizId);
                TakenQuiz tq = Util.getTakenQuizById(quiz.getId(),student);
                if(tq==null||tq.getRemainingTries()!=0){
                    startActivity(new Intent(SHomeActivity.this,SQuizPreviewActivity.class).putExtra("quiz",quiz).putExtra("student",student));
                }
                else Toast.makeText(SHomeActivity.this,R.string.shometries,Toast.LENGTH_LONG).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int code = Integer.parseInt(editText.getText().toString());
                    quiz = Util.getQuizByCode(code);
                }
                catch(Exception ex){
                    Toast.makeText(SHomeActivity.this,R.string.shomeincorrectcode,Toast.LENGTH_LONG).show();
                }
                if(quiz!=null){
                    TakenQuiz tq = Util.getTakenQuizById(quiz.getId(),student);
                    if(tq.getRemainingTries()!=0)
                        startActivity(new Intent(SHomeActivity.this,SQuizPreviewActivity.class).putExtra("quiz",quiz).putExtra("student",student));
                    else Toast.makeText(SHomeActivity.this,R.string.shometries,Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(SHomeActivity.this,R.string.shome_code,Toast.LENGTH_LONG).show();
            }
        });
    }

}