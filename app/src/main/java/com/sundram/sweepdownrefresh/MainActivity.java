package com.sundram.sweepdownrefresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList list_data = new ArrayList();
    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting id of the swipe refresh layout and the color
        swipeRefreshLayout = findViewById(R.id.swipe_refersh);
        swipeRefreshLayout.setColorScheme(R.color.colorPrimary);
        listView = findViewById(R.id.list_data);
        list_data.add("America");
        list_data.add("Japan");
        list_data.add("Australia");
        list_data.add("India");
        list_data.add("New York");
        list_data.add("Tokiyo");
        list_data.add("China");
        list_data.add("Las Vagos");
        list_data.add("UK");
        list_data.add("America");
        list_data.add("Japan");
        list_data.add("Australia");
        list_data.add("India");
        list_data.add("New York");
        list_data.add("Tokiyo");
        list_data.add("China");
        list_data.add("Las Vagos");
        list_data.add("UK");

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list_data);
        listView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                randomData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    public void randomData(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Collections.shuffle(list_data, new Random(System.currentTimeMillis()));
            }
        },2000);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list_data);
        listView.setAdapter(adapter);
    }
}
