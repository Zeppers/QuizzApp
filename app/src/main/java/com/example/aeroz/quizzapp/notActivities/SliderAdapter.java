package com.example.aeroz.quizzapp.notActivities;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.aeroz.quizzapp.OnboardingActivity;
import com.example.aeroz.quizzapp.R;
import com.example.aeroz.quizzapp.SplashscreenActivity;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public String[] slideHeadings = {
            "heading1",
            "heading2",
            "heading3"
    };
    public String[] slideDescriptions = {
            "desc1",
            "desc2",
            "desc3"
    };

    public int[] slideIcons = {
            R.drawable.onboarding_ill1,
            R.drawable.onboarding_ill2,
            R.drawable.onboarding_ill3
    };

    @Override
    public int getCount() {
        return slideHeadings.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_onboarding_slides,container,false);

        ImageView slideImageView = view.findViewById(R.id.img_onboarding_slide1);
        TextView slideHeading = view.findViewById(R.id.txtView_onboarding_slide1_title);
        TextView slideDescription = view.findViewById(R.id.txtView_onboarding_slide1_paragraph);

        slideImageView.setImageResource(slideIcons[position]);
        slideHeading.setText(slideHeadings[position]);
        slideDescription.setText(slideDescriptions[position]);

        container.addView(view);

        return view;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((ConstraintLayout)object);
    }
}
