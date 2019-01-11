package com.example.aeroz.quizzapp.notActivities;

import java.util.List;

public class Util {
    public static Quiz getQuizById(int id,List<Quiz> quizes){
        for(Quiz q:quizes)
            if(q.getId()==id)
                return q;
        return null;
    }
}
