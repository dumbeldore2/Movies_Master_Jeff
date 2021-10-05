package com.example.movies_master_jeff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MainActivity2_lijst extends ArrayAdapter<String> {
    Context context;
    String string[];
    int anInt[];

    public MainActivity2_lijst(@NonNull Context c,String s[]) {
        super(c, R.layout.activity_main2_lijst , R.id.list_view_1 , s);
        this.context = c;
        this.string = s;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.activity_main2_lijst,parent,false);
        ImageView images = row.findViewById(R.id.image_listview);
        TextView names = row.findViewById(R.id.text_listview);

        images.setImageResource(R.drawable.rec_1);
        names.setText(string[position]);

        return row;
    }
}
