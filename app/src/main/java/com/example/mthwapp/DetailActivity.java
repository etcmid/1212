package com.example.mthwapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    final ArrayList<WeatherDayItem> weatherDayItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WeatherItem weatherItem = getIntent().getExtras().getParcelable("weatherItem");
        Log.e("mango", weatherItem.getCity());
        final TextView cityTextview = findViewById(R.id.detail_textview_city);
        cityTextview.setText(weatherItem.getCity());
        final ImageView weatherImageView = findViewById(R.id.detail_imageview_img);
        Picasso.get().load(weatherItem.getImageResource()).into(weatherImageView);
        final TextView tempTextview = findViewById(R.id.detail_textview_temp);
        tempTextview.setText(weatherItem.getTemperature());

        weatherDayItems.add(new WeatherDayItem("Wednesday", "31°C", weatherItem.getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Thursday", "31°C", weatherItem.getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Friday", "31°C", weatherItem.getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Saturday", "31°C", weatherItem.getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Sunday", "31°C", weatherItem.getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Monday", "31°C", weatherItem.getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Tuesday", "31°C", weatherItem.getImageResource()));


        recyclerView = findViewById(R.id.detail_listview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new DetailListAdapter(weatherDayItems);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}