package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.aeroz.quizzapp.notActivities.Question;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.QuizAdapter;
import com.example.aeroz.quizzapp.notActivities.Teacher;

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
    private List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcreatequiz);

        teacher = (Teacher)getIntent().getExtras().getSerializable("teacher");
        editText1 = findViewById(R.id.edtText_pcreatequiz_quizname);
        editText2 = findViewById(R.id.edtText_pcreatequiz_description);
        listView = findViewById(R.id.listview_pcreatequiz_question);
        button = findViewById(R.id.btn_pcreatequiz_addquestion);
        imageView = findViewById(R.id.imgView_pcreatequiz_ic_back);
        button2 = findViewById(R.id.btn_pcreatequiz_nextstep);
        quiz = new Quiz();
        questions = new ArrayList<>();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,questions);
        listView.setAdapter(arrayAdapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PCreateQuiz.this,PProfileActivity.class).putExtra("teacher",teacher));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PCreateQuiz.this,PAddQuestion.class)
                        .putExtra("quiz",quiz).putExtra("teacher",teacher));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PCreateQuiz.this,PCreateQuizTwo.class).putExtra("quiz",quiz));
            }
        });
    }
}
