package com.example.aeroz.quizzapp.notActivities;

import java.util.List;

public class Util {
    public static Quiz getQuizById(int id,List<Quiz> quizes){
        for(Quiz q:quizes)
            if(q.getId()==id)
                return q;
        return null;
    }
    public static Question getQuestionByName(String name, List<Question> questions){
        for(Question q:questions)
            if(q.getText().equals(name))
                return q;
        return null;
    }
    public static int getIndexOfQuestion(Question question, List<Question> questions){
        for(int i = 0;i<questions.size();i++)
            if(question.getText().equals(questions.get(i).getText()))
                return i;
        return -1;
    }


}
