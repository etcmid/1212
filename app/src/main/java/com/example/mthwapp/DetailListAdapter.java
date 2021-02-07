package com.example.mthwapp;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailListAdapter  extends  RecyclerView.Adapter<DetailListAdapter.DetailListViewHolder>{

    private ArrayList<WeatherDayItem> weatherDayItems;

    public DetailListAdapter(ArrayList<WeatherDayItem> weatherDayItems) {
        this.weatherDayItems = weatherDayItems;
    }

//    @NonNull
//    @Override
//    public DetailListAdapter.DetailListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_item, parent, false);
//        DetailListAdapter.DetailListViewHolder wvh = new DetailListAdapter.DetailListViewHolder(v);
//        return wvh;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull DetailListAdapter.DetailListViewHolder holder, int position) {
//        WeatherDayItem weatherDayItem = weatherDayItems.get(position);
//
//        holder.dayTextview.setText(weatherDayItem.getDay());
//        holder.temptextView.setText(weatherDayItem.getTemp());
//        Picasso.get().load(weatherDayItem.getImage()).into(holder.imageView);
//    }


    @NonNull
    @Override
    public DetailListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_item, parent, false);
        DetailListAdapter.DetailListViewHolder wvh = new DetailListAdapter.DetailListViewHolder(v);
        return wvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailListViewHolder holder, int position) {
        WeatherDayItem weatherDayItem = weatherDayItems.get(position);

        holder.dayTextview.setText(weatherDayItem.getDay());
        holder.temptextView.setText(weatherDayItem.getTemp());
        Picasso.get().load(weatherDayItem.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return weatherDayItems.size();
    }

    public  static  class DetailListViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView dayTextview;
        public TextView temptextView;


        public DetailListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.day_item_image_icon);
            this.dayTextview = itemView.findViewById(R.id.day_item_textview_day);
            this.temptextView = itemView.findViewById(R.id.day_item_textview_temp);
        }
    }
}
