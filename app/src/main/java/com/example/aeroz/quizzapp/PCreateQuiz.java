package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.Question;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Teacher;
import com.example.aeroz.quizzapp.notActivities.Util;

import java.util.ArrayList;
import java.util.List;

public class PCreateQuiz extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private ListView listView;
    private Button button;
    private Button button2;
    private ImageView imageView;

    private Teacher teacher;
    private Quiz quiz;
    private List<String> questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcreatequiz);

        editText1 = findViewById(R.id.edtText_pcreatequiz_quizname);
        editText2 = findViewById(R.id.edtText_pcreatequiz_description);
        listView = findViewById(R.id.listview_pcreatequiz_question);
        button = findViewById(R.id.btn_pcreatequiz_addquestion);
        imageView = findViewById(R.id.imgView_pcreatequiz_ic_back);
        button2 = findViewById(R.id.btn_pcreatequiz_nextstep);

        questions = new ArrayList<>();
        teacher = (Teacher)getIntent().getExtras().getSerializable("teacher");
        quiz = (Quiz)getIntent().getExtras().getSerializable("quiz");


        if(quiz!=null){
            editText1.setText(quiz.getName());
            editText2.setText(quiz.getDescription());
        }
        else
            quiz = new Quiz();

        for(int i = 0;i<quiz.getQuestions().size();i++)
            questions.add(quiz.getQuestions().get(i).getText());

        listView.setAdapter(new ArrayAdapter<>(PCreateQuiz.this,android.R.layout.simple_list_item_1,questions));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                quiz.setName(editText1.getText().toString());
                quiz.setDescription(editText2.getText().toString());
                Question q = Util.getQuestionByName(quiz.getQuestions().get(position).getText(),quiz.getQuestions());
                startActivity(new Intent(PCreateQuiz.this,PAddQuestion.class).putExtra("teacher",teacher)
                        .putExtra("quiz",quiz)
                        .putExtra("question",q)
                .putExtra("index",position));
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PCreateQuiz.this,PProfileActivity.class).putExtra("teacher",teacher));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quiz.setName(editText1.getText().toString());
                quiz.setDescription(editText2.getText().toString());
                startActivity(new Intent(PCreateQuiz.this,PAddQuestion.class)
                .putExtra("teacher",teacher)
                .putExtra("quiz",quiz));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText1.getText().toString().trim().length()>0&&editText2.getText().toString().trim().length()>0){
                    quiz.setName(editText1.getText().toString());
                    quiz.setDescription(editText2.getText().toString());
                    startActivity(new Intent(PCreateQuiz.this,PCreateQuizTwo.class)
                            .putExtra("quiz",quiz)
                            .putExtra("teacher",teacher));
                }
                else
                    Toast.makeText(PCreateQuiz.this,"Give the quiz a name and a description first!",Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {

        }

        return super.onKeyDown(keyCode, event);
    }

}
