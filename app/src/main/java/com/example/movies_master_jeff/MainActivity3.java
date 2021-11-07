package com.example.movies_master_jeff;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

    //output stream ininten
    OutputStream outputStream;

    //string initen
    String path;

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

        //string default value geven
        path = "null";

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
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                if (!getNaam().equals(null)){
                    database.addToTabel1(getNaam(),nummer,path);
                }
               //dees moet miss niet meer
                /*
                if (ActivityCompat.checkSelfPermission(MainActivity3.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    System.out.println("true");
                    {
                        database.addToTabel1(getNaam(),nummer);
                        createFolder();
                        startActivity(intent);
                    }
                }else {
                    ActivityCompat.requestPermissions(MainActivity3.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);

                }
                 */
                startActivity(intent);
            }
        });
    }

    //proberen om dit niet meer te gebruiken , want dit werkt totaal niet
    /*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //check statement
        if(requestCode == 100 && (grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
            //dit is als er permision is
            createFolder();
        } else {
            //wanneer er geen permision is
            Toast.makeText(getApplicationContext(),"permision denied",Toast.LENGTH_LONG).show();
        }
    }

    public void  createFolder(){
        //init file
        File file = new File(Environment.getExternalStorageDirectory().getPath()+ "/lol");
        System.out.println(Environment.getExternalStorageDirectory().getAbsolutePath());
        System.out.println(Environment.getExternalStorageDirectory().getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        //check condition
        if (file.exists()){
            //dit is als de directory al bestaat
            //display toast
            Toast.makeText(getApplicationContext(),"het bestaat al",Toast.LENGTH_LONG).show();
        } else {
            //dit is als de directory nog niet bestaat
            System.out.println("lllllllllllllllllllllllllllllllol");
            if (file.mkdirs()){
                //lol tis goed gegaan
                System.out.println("wojoooo");
            } else {
                System.out.println("cmon man");
            }
            file.mkdir();
            //check conditie
            if (file.isDirectory()){
                //als de directory is gemaakt
                Toast.makeText(getApplicationContext(),"het is gemaakt",Toast.LENGTH_LONG).show();
            } else {
                //als de directory niet gemaakt is
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                String smessage = "mesage : failed to create directory" + "\npath : " +Environment.getExternalStorageState() + "\nmkdirs : " + file.mkdirs();
                builder.setMessage(smessage);
                builder.show();
            }
        }
    }
     */

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
        if (resultCode == RESULT_OK) {

            Uri selectedImageUri = data.getData();
            String s = getRealPathFromURI(selectedImageUri);
            System.out.println(s);
        }
    }
    public String getRealPathFromURI(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        @SuppressWarnings("deprecation")
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}