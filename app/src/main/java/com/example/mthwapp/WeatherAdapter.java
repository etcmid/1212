package com.example.mthwapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private ArrayList<WeatherItem> weatherItems;
    private OnWeatherListener mOnWeatherListener;

//    public WeatherAdapter(ArrayList<WeatherDayItem> weatherDayItems) {
//        this.weatherItems = weatherDayItems;
//        this.mOnWeatherListener =
//    }


    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)  {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);
        WeatherViewHolder wvh = new WeatherViewHolder(v, mOnWeatherListener);
        return wvh;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherItem currentItem = weatherItems.get(position);
        Picasso.get().load(currentItem.getImageResource()).into(holder.imageView);
        holder.textView1.setText(currentItem.getCity());
        holder.textView2.setText(currentItem.getTemperature());
        holder.textView3.setText(currentItem.getDetail());
    }

    @Override
    public int getItemCount() {
        return weatherItems.size();
    }

    public  static  class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        OnWeatherListener onWeatherListener;

        public WeatherViewHolder(View itemView, OnWeatherListener onWeatherListener) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView1 = itemView.findViewById(R.id.textView2);
            this.textView2 = itemView.findViewById(R.id.textView3);
            this.textView3 = itemView.findViewById(R.id.textView6);
            this.onWeatherListener = onWeatherListener;
            this.itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onWeatherListener.onWeatherClick(getAdapterPosition());

        }
    }

    public interface OnWeatherListener{
        void onWeatherClick(int position);
    }

    public WeatherAdapter(ArrayList<WeatherItem> weatherItems, OnWeatherListener onWeatherListener) {
        this.weatherItems = weatherItems;
        this.mOnWeatherListener = onWeatherListener;
    }
}
