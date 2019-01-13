package com.example.aeroz.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aeroz.quizzapp.notActivities.Answer;
import com.example.aeroz.quizzapp.notActivities.Question;
import com.example.aeroz.quizzapp.notActivities.Quiz;
import com.example.aeroz.quizzapp.notActivities.Teacher;

import java.util.Arrays;

public class PAddQuestion extends AppCompatActivity {

    private EditText editTextQuestion;
    private EditText[] editTextAnswers;
    private CheckBox[] checkBoxes;
    private Question question;
    private Answer[] answers;
    private Button button;

    private Teacher teacher;
    private Quiz quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padd_question);

        //INITIALIZE FIELDS
        editTextQuestion = findViewById(R.id.edtText_paddquestion_question);
        editTextAnswers = new EditText[4];
        checkBoxes = new CheckBox[4];
        answers = new Answer[4];
        editTextAnswers[0] = findViewById(R.id.edtText_paddquestion_answer1);
        editTextAnswers[1] = findViewById(R.id.edtText_paddquestion_answer2);
        editTextAnswers[2] = findViewById(R.id.edtText_paddquestion_answer3);
        editTextAnswers[3] = findViewById(R.id.edtText_paddquestion_answer4);
        checkBoxes[0] = findViewById(R.id.checkbox_paddquestion_answer1);
        checkBoxes[1] = findViewById(R.id.checkbox_paddquestion_answer2);
        checkBoxes[2] = findViewById(R.id.checkbox_paddquestion_answer3);
        checkBoxes[3] = findViewById(R.id.checkbox_paddquestion_answer4);
        ///////////////////
        teacher = (Teacher)getIntent().getExtras().getSerializable("teacher");
        quiz = (Quiz)getIntent().getExtras().getSerializable("quiz");
        button = findViewById(R.id.btn_paddquestion_add);
        if(getIntent().getExtras().getSerializable("question")!=null){
            question = (Question)getIntent().getExtras().getSerializable("question");
            for(int i = 0;i<4;i++){
                editTextAnswers[i].setText(question.getAnswers().get(i).getText());
                checkBoxes[i].setChecked(question.getAnswers().get(i).getIsCorect());
            }
            editTextQuestion.setText(question.getText());
            button.setText("MODIFY QUESTION");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextQuestion.getText().toString().trim().length()>0){
                    if(allAnswersFilled()&&oneAnswerIsCorrect()){
                        for(int i = 0;i<4;i++)
                            answers[i] = new Answer(0,editTextAnswers[i].getText().toString(),checkBoxes[i].isChecked());
                        Question q = new Question(0,editTextQuestion.getText().toString(),Arrays.asList(answers));
                        int index = getIntent().getIntExtra("index",-1);
                        if(index!=-1)
                            quiz.getQuestions().set(index,q);
                        else
                            quiz.getQuestions().add(q);
                        startActivity(new Intent(PAddQuestion.this,PCreateQuiz.class)
                                .putExtra("teacher",getIntent().getExtras().getSerializable("teacher"))
                                .putExtra("quiz",quiz));
                    }
                    else
                        Toast.makeText(PAddQuestion.this,"You must fill all the answers and at least one answer should be true!",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(PAddQuestion.this,"Give question a text!",Toast.LENGTH_LONG).show();
            }
        });
        ////////////////////
        findViewById(R.id.imgView_paddquestion_ic_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PAddQuestion.this,PCreateQuiz.class)
                        .putExtra("teacher",getIntent().getExtras().getSerializable("teacher"))
                        .putExtra("quiz",quiz));
            }
        });
    }
    private boolean allAnswersFilled(){
        for(int i = 0;i<4;i++)
            if(editTextAnswers[i].getText().toString().trim().length()==0)
                return false;
        return true;
    }
    private boolean oneAnswerIsCorrect(){
        for(int i = 0;i<4;i++)
            if(checkBoxes[i].isChecked())
                return true;
        return false;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {

        }

        return super.onKeyDown(keyCode, event);
    }

}
