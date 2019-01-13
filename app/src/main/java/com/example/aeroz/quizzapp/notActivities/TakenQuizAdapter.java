package com.example.aeroz.quizzapp.notActivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

    public class TakenQuizAdapter extends ArrayAdapter<TakenQuiz> {
        private Context mContext;
        int mResource;

        public TakenQuizAdapter( Context context, int resource, List<TakenQuiz> objects) {
            super(context, resource, objects);
            mContext = context;
            mResource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            String score = String.valueOf(getItem(position).getScore());
            String name = getItem(position).getQuiz().getName();

            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            TextView tv1 = (TextView)convertView.findViewById(android.R.id.text1);
            TextView tv2 = (TextView)convertView.findViewById(android.R.id.text2);

            tv1.setText(name);
            tv2.setText(String.valueOf(score));
            return convertView;

}
    }
