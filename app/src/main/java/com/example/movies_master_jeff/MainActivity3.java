package com.example.movies_master_jeff;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {

    //animatie initen
    Animation animation;
    AnimationDrawable animationDrawable;

    //constraint layout initen voor background
    ConstraintLayout constraintLayout;

    //database initen
    Database database;

    // editext initen
    EditText editText;

    //textview initen
    TextView textView1,textView2_exta,textView4;

    //intent initen
    Intent intent;

    //nummer ininten
    int nummer;

    //foto ininten
    ImageView imageView;

    //for fotos to get
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSON_CODE = 1001;
    private static final int SELECT_FOTO = 100;

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

        //database conecteren
        database = new Database(this);

        //edittext connecten
        editText = findViewById(R.id.editText_1);

        //Textview connecten
        textView1 = findViewById(R.id.text_1);
        textView2_exta = findViewById(R.id.text_2_extra);
        textView4 = findViewById(R.id.text_4);

        //intent connecten
        intent = getIntent();

        //nummer connecten
        nummer = intent.getIntExtra("nummer",0);

        //imageview connnecten
        imageView = findViewById(R.id.image_1);

        //funties
        background_ani();
        fun_text();
        click_text_4();
        fun_back();
        fun_image_click();
    }

    public void background_ani(){
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(10);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
    }

    public String getNaam(){
        String uit = "";
        if(!editText.getText().toString().trim().isEmpty()){
            uit = editText.getText().toString();
        }
        return uit;
    }

    public void click_text_4(){
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                database.addToTabel1(getNaam(),1);
                startActivity(intent);
            }
        });
    }

    public void fun_text(){
        if (nummer == 1){
            textView2_exta.setText("Add series");
        }
    }

    public void fun_back(){
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }
 //dit is waarschgijnlijk niet de juiste mannier
    public void fun_image_click(){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Image(s)"), IMAGE_PICK_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode , @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == IMAGE_PICK_CODE){
            if (resultCode == Activity.RESULT_OK){
                Uri imageUri = data.getData();
                imageView.setImageURI(imageUri);
            }
        }
    }
}