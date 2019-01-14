package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aeroz.quizzapp.notActivities.QuizAdapter;
import com.example.aeroz.quizzapp.notActivities.Teacher;

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

        textView1.setText(""+teacher.getPublicQuizes().size()+" public quizzes");
        textView2.setText(""+teacher.getPrivateQuizes().size()+" private quizzes");

        QuizAdapter quizAdapter = new QuizAdapter(PProfileActivity.this,android.R.layout.simple_list_item_2,teacher.getInactiveQuizes());
        listView.setAdapter(quizAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(PProfileActivity.this,PCreateQuizTwo.class)
                .putExtra("teacher",teacher)
                .putExtra("quiz",teacher.getInactiveQuizes().get(position))
                .putExtra("index",position));
            }
        });

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
                startActivity(new Intent(PProfileActivity.this,PHomeActivity.class).putExtra("teacher",teacher));
            }
        });
    }

}
