package com.example.aeroz.quizzapp.notActivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aeroz.quizzapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapter extends ArrayAdapter<Quiz> {
    private Context mContext;
    int mResource;

    public QuizAdapter( Context context, int resource, List<Quiz> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String description = getItem(position).getDescription();
        String name = getItem(position).getName();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tv1 = (TextView)convertView.findViewById(android.R.id.text1);
        TextView tv2 = (TextView)convertView.findViewById(android.R.id.text2);

        tv1.setText(name);
        tv2.setText(String.valueOf(description));
        return convertView;
    }
}
