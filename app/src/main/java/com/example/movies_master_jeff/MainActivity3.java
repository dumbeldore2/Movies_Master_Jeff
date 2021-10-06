package com.example.movies_master_jeff;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;

public class MainActivity3 extends AppCompatActivity {

    //animatie initen
    Animation animation;
    AnimationDrawable animationDrawable;

    //constraint layout initen voor background
    ConstraintLayout constraintLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.color1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.color2));

        //constraint layout connecteren
        constraintLayout = findViewById(R.id.constraintLayout3);

        //funties
        background_ani();
    }

    public void background_ani(){
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
    }
}