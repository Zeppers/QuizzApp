package com.example.aeroz.quizzapp.notActivities;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.example.aeroz.quizzapp.SplashscreenActivity;

import java.util.List;

public class Util extends AppCompatActivity {
    public static boolean arraysEqual(int[] array1, int[] array2){
        if(array1.length!=array2.length)
            return false;
        for(int i = 0;i<array1.length;i++)
            if(array1[i]!=array2[i])
                return false;
        return true;
    }

    public static boolean codeExists(long code,List<Quiz> list){
        for(Quiz q:list)
            if(code==q.getCode())
                return true;
        return false;
    }
    public static boolean IDExists(int id, List<Quiz> list){
        for(Quiz q:list)
            if(q.getId()==id)
                return true;
        return false;
    }

    public static Student getStudentByEmail(String email){
        for(Student s:SplashscreenActivity.students)
            if(s.getEmail().equals(email))
                return s;
        Log.d("panda", "getStudentByEmail: student doesnt exist!");
        return null;
    }
    public static Teacher getTeacherByEmail(String email){
        for(Teacher t:SplashscreenActivity.teachers)
            if(t.getEmail().equals(email))
                return t;
        Log.d("panda", "getTeacherByEmail: teacher doesnt exist!");
        return null;
    }
    public static Quiz getQuizById(int id){
        for(Quiz q:SplashscreenActivity.quizes)
            if(q.getId()==id)
                return q;
        Log.d("panda", "getQuizById: quiz doesnt exist!");
        return null;
    }

    public static TakenQuiz getTakenQuizById(int id,Student s){
        for(TakenQuiz tq:s.getTakenQuizes())
            if(tq.getId()==id)
                return tq;
        Log.d("panda", "getTakenQuizByID: takenQuiz doesnt exist!");
        return null;
    }
    public static Quiz getQuizByCode(int code){
        for(Quiz q:SplashscreenActivity.quizes)
            if(q.getCode()==code)
                return q;
        Log.d("panda", "getQuizByCode: quiz doesnt exist!");
        return null;
    }
}
