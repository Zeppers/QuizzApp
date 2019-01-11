package com.example.aeroz.quizzapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aeroz.quizzapp.notActivities.Teacher;

import java.lang.reflect.Type;

public class PHomeActivity extends AppCompatActivity {

    private Teacher teacher;
    private ListView listView1;
    private ListView listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phome);
        //INITIALIZE FIELDS
        listView1 = findViewById(R.id.list_shome_publicquizzes);
        listView2 = findViewById(R.id.list_phome_privateq);
        teacher = (Teacher)getIntent().getExtras().getSerializable("teacher");
        ///////////////////
        //FILL LISTVIEWS
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_2,android.R.id.text1,teacher.getQuizes()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position,convertView,parent);
                TextView text1 = (TextView)view.findViewById(android.R.id.text1);
                TextView text2 = (TextView)view.findViewById(android.R.id.text2);

                text1.setText(teacher.getQuizes().get(position).getName());
                text2.setText(String.valueOf(teacher.getQuizes().get(position).getId()));
                return view;
            }
        };
        listView1.setAdapter(arrayAdapter);




    }
}
