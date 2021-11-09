package com.example.movies_master_jeff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    MainActivity4_lijst listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

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

        // preparing list data
        prepareListData();

        listAdapter = new MainActivity4_lijst(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Seizoen 1");
        listDataHeader.add("Seizoen 2");
        listDataHeader.add("Seizoen 3");

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

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Episode 1");
        nowShowing.add("Episode 2");
        nowShowing.add("Episode 3");
        nowShowing.add("Episode 4");
        nowShowing.add("Episode 5");
        nowShowing.add("Episode 6");
        nowShowing.add("Episode 7");
        nowShowing.add("Episode 8");
        nowShowing.add("Episode 9");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Episode 1");
        comingSoon.add("Episode 2");
        comingSoon.add("Episode 3");
        comingSoon.add("Episode 4");
        comingSoon.add("Episode 5");
        comingSoon.add("Episode 6");
        comingSoon.add("Episode 7");
        comingSoon.add("Episode 8");
        comingSoon.add("Episode 9");
        comingSoon.add("Episode 10");
        comingSoon.add("Episode 1100");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}