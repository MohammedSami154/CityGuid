package com.example.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.cityguide.HelperClasses.OnBoardingAdapter;
import com.example.cityguide.HelperClasses.OnBoardingItems;
import com.example.cityguide.R;
import com.example.cityguide.Users.Dashboard;

import java.util.ArrayList;
import java.util.List;


public class OnBoarding extends AppCompatActivity {
    ViewPager2 viewPager;
    LinearLayout layoutOnBoardingIndicators;
    Button letsStarted;
    private OnBoardingAdapter onBoardingAdapter;
    Animation letsStart;
    int positionOfPage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        viewPager = (ViewPager2) findViewById(R.id.viewPager2);
        layoutOnBoardingIndicators = (LinearLayout) findViewById(R.id.dots);
        letsStarted = (Button)findViewById(R.id.lets_get_started);
        letsStart = AnimationUtils.loadAnimation(this , R.anim.anim_lets_start);
        letsStarted.setVisibility(View.INVISIBLE);
        setUpOnBoardingItems();
        viewPager.setAdapter(onBoardingAdapter);
        setLayoutOnBoardingIndicators();

        setCurrentOnBoardingIndicator(0);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicator(position);
                positionOfPage = position;
                buttonAnimation(position);
            }
        });
    }

    private void buttonAnimation(int position) {
        if(position == 3){
            letsStarted.setAnimation(letsStart);
            letsStarted.setVisibility(View.VISIBLE);

        }else{
            letsStarted.setVisibility(View.INVISIBLE);
        }
    }

    private void setUpOnBoardingItems() {
        List<OnBoardingItems> onBoardingItems = new ArrayList<>();

        OnBoardingItems search = new OnBoardingItems();
        search.setImages(R.drawable.search_your_location);
        search.setTitle("Search for a location");
        search.setDocs("Here you can search for the locations of many agencies that are registered on our app!, register now with us");

        OnBoardingItems addNew = new OnBoardingItems();
        addNew.setImages(R.drawable.add_a_location);
        addNew.setTitle("Add a new location");
        addNew.setDocs("Here you can add the locations of many agencies that are registered on our app!, register now with us");

        OnBoardingItems makeCall = new OnBoardingItems();
        makeCall.setImages(R.drawable.make_call);
        makeCall.setTitle("Make a call!");
        makeCall.setDocs("Here you can search for the locations of many agencies that are registered on our app!, register now with us");

        OnBoardingItems setBack = new OnBoardingItems();
        setBack.setImages(R.drawable.set_back);
        setBack.setTitle("Set back and relax!");
        setBack.setDocs("Here you can search for the locations of many agencies that are registered on our app!, register now with us");

        onBoardingItems.add(addNew);
        onBoardingItems.add(makeCall);
        onBoardingItems.add(setBack);
        onBoardingItems.add(search);

        onBoardingAdapter = new OnBoardingAdapter(onBoardingItems);
    }

    private void setLayoutOnBoardingIndicators() {
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnBoardingIndicators.addView(indicators[i]);

        }
    }

    private void setCurrentOnBoardingIndicator(int index){
        int child = layoutOnBoardingIndicators.getChildCount();
        for (int i=0; i<child; i++){
            ImageView imageView = (ImageView)layoutOnBoardingIndicators.getChildAt(i);
            if(i == index){
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getApplicationContext(),
                        R.drawable.active));
            }else{
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getApplicationContext(),
                        R.drawable.inactive));
            }
        }
    }

    public void skip(View view) {
        Intent intent = new Intent(OnBoarding.this, Dashboard.class);
        startActivity(intent);
        finish();
    }
    public void letsGetStarted(View view) {
        startActivity(new Intent(this, Dashboard.class));
        finish();
    }
    public void next(View view){
        viewPager.setCurrentItem(positionOfPage+1);
    }

}