package com.example.movies_master_jeff;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    TextView text_1;
    MainActivity4_lijst listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getWindow().setNavigationBarColor(getResources().getColor(R.color.color1));
        getWindow().setStatusBarColor(getResources().getColor(R.color.color2));

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.expanded_list_view);

        //conecteer de textview
        text_1 = findViewById(R.id.text_1);

        //database conecteren
        database = new Database(this);

        //functies
        click_fun_1();
        list_fun();
    }

    public void list_fun(){
        // preparing list data
        prepareListData();

        listAdapter = new MainActivity4_lijst(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    public void  click_fun_1(){
        text_1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        for (int i = 0; i < database.aantalSeizoenen(); i++){
            listDataHeader.add("Seizoen " + (i += 1));
        }

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Episode 1");
        top250.add("Episode 2");
        top250.add("Episode 3");
        top250.add("Episode 4");
        top250.add("Episode 5");
        top250.add("Episode 6");
        top250.add("Episode 7");
        top250.add("Episode 8");
        top250.add("Episode 9");

        listDataChild.put(listDataHeader.get(0), top250);

    }
}