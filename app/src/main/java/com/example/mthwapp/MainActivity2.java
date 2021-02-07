package com.example.mthwapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mthwapp.database.TAppDatabase;
import com.example.mthwapp.database.WeatherDBItem;
import com.example.mthwapp.retrofit.model.CurrentWeather;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity implements WeatherAdapter.OnWeatherListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    final ArrayList<WeatherItem> weatherItemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TAppDatabase db = TAppDatabase.getDbInstance(this.getApplicationContext());
        List<WeatherDBItem> weatherDBItems = db.weatherDBItemDao().getAllWeatherDBItems();
        for (WeatherDBItem item : weatherDBItems) {
            weatherItemArrayList.add(new WeatherItem(item.imageResource, item.city, item.temperature, item.detail));
        }


//        weatherItemArrayList.add(new WeatherItem(R.drawable.ic_android,"Tokyo", "31C","Sunny"));
//        weatherItemArrayList.add(new WeatherItem(R.drawable.ic_android,"London", "31C","Rainy"));
//        weatherItemArrayList.add(new WeatherItem(R.drawable.ic_android,"Vancouver", "31C","Thunder"));
//        weatherItemArrayList.add(new WeatherItem(R.drawable.ic_android,"Dhaka", "31C","Sunny"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new WeatherAdapter(weatherItemArrayList, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        final EditText editText = findViewById(R.id.ediText);
        final ImageButton imgButton = findViewById(R.id.imageButton);
        imgButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                TApi.createService(TService.class).getCurrentWeather("17c07b21543ef254313a8fec9eb35227", editText.getText().toString()).enqueue(new Callback<CurrentWeather>() {
                    @Override
                    public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                        if (response.body().getWsCurrent()!=null){
                            Log.e("mango", response.body().getWsCurrent().getObservationTime());
                            saveWeatherItem(response.body());
                            weatherItemArrayList.add(0,new WeatherItem(response.body().getWsCurrent().getWeatherIcons().get(0), response.body().getWsLocation().getName(), response.body().getWsCurrent().getTemperature() + "°C", response.body().getWsCurrent().getWeatherDescriptions().get(0)));
                            adapter.notifyItemInserted(0);
                            recyclerView.scrollToPosition(0);
                            editText.getText().clear();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),response.body().getError().getInfo(),Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<CurrentWeather> call, Throwable t) {
                        Log.e("mango", "eee");

                    }
                });
            }
        });



    }

    private void saveWeatherItem(CurrentWeather currentWeather) {
        TAppDatabase db = TAppDatabase.getDbInstance(this.getApplicationContext());

        try {
            WeatherDBItem item = db.weatherDBItemDao().getWeatherDBItemsByCityName(currentWeather.getWsLocation().getName());
            db.weatherDBItemDao().delete(item);
        } catch (Exception e) {
            Log.e("mango", e.getMessage());
        }
        WeatherDBItem weatherDBItem = new WeatherDBItem();
        weatherDBItem.city = currentWeather.getWsLocation().getName();
        weatherDBItem.detail = currentWeather.getWsCurrent().getWeatherDescriptions().get(0);
        weatherDBItem.temperature = currentWeather.getWsCurrent().getTemperature() + "°C";
        weatherDBItem.imageResource = currentWeather.getWsCurrent().getWeatherIcons().get(0);
        db.weatherDBItemDao().insertWeatherDBItem(weatherDBItem);

    }

    @Override
    public void onWeatherClick(int position) {
        Log.e("mango", String.valueOf(position*100));
        Log.e("mango", weatherItemArrayList.get(position).getCity());
        ArrayList<WeatherDayItem> weatherDayItems = new ArrayList<>();
        weatherDayItems.add(new WeatherDayItem("Wednesday","31°C",weatherItemArrayList.get(position).getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Thursday","31°C",weatherItemArrayList.get(position).getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Friday","31°C",weatherItemArrayList.get(position).getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Saturday","31°C",weatherItemArrayList.get(position).getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Sunday","31°C",weatherItemArrayList.get(position).getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Monday","31°C",weatherItemArrayList.get(position).getImageResource()));
        weatherDayItems.add(new WeatherDayItem("Tuesday","31°C",weatherItemArrayList.get(position).getImageResource()));

        Intent intent = new Intent(MainActivity2.this, DetailActivity.class);//.putExtra("weatherDayItems",weatherDayItems);
        Bundle bundle = new Bundle();
        bundle.putParcelable("weatherItem", weatherItemArrayList.get(position));
        intent.putExtras(bundle);
        startActivity(intent);


    }

//    @Override
//    public void onWeatherClick(int position) {
//
//    }
}