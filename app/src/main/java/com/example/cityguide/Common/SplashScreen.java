package com.example.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguide.R;
import com.example.cityguide.Users.Dashboard;

public class SplashScreen extends AppCompatActivity {

    ImageView splashScreen;
    TextView powerBy;
    public static int splashScreenDuration = 5000;
    Animation sideAnim , bottomAnim;
    SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        splashScreen = (ImageView) findViewById(R.id.splash_screen);
        powerBy = (TextView) findViewById(R.id.powered_by);
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.anim_left_to_right);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        splashScreen.setAnimation(sideAnim);
        powerBy.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen = getSharedPreferences("onBoardingScreen" , MODE_PRIVATE);
                boolean isFirst = onBoardingScreen.getBoolean("isFirst" , true);
                if(isFirst){
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("isFirst" , false);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext() , OnBoarding.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, splashScreenDuration);
    }

}