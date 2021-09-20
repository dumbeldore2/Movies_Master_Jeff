package com.example.movies_master_jeff;

import androidx.annotation.ColorLong;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    //String initen
    TextView textview_1,textview_3,textview_4;

    //animatie initen
    Animation animation;
    AnimationDrawable animationDrawable;

    // linear initen
    LinearLayout linearLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.color1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.color2));

        //linear connecten
        linearLayout = findViewById(R.id.linear);

        //texviews connecten
        textview_1 = findViewById(R.id.text_1);
        textview_3 = findViewById(R.id.text_3);
        textview_4 = findViewById(R.id.text_4);

        //funties
        kleur_knop();
        background_ani();
        click_textview3();
        click_textview4();
    }


    //de functie voor de animatie
    public void background_ani(){
        animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
    }

    //de functie om ervoor te zorgen dat de background word veranderd van de twee buttons
    public void kleur_knop(){
        Intent intent = getIntent();
        if (intent.getIntExtra("nummer",-1) == 1){
            textview_4.setBackgroundResource(R.drawable.button_on);
            textview_4.setTextColor(getResources().getColor(R.color.white));
            textview_3.setBackgroundResource(R.drawable.button_off);
            textview_3.setTextColor(getResources().getColor(R.color.color1));
        }
    }

    public void click_textview3(){
        textview_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("nummer",0);
                startActivity(intent);
            }
        });
    }

    public void click_textview4(){
        textview_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("nummer",1);
                startActivity(intent);
            }
        });
    }
}