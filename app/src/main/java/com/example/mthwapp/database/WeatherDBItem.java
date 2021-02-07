package com.example.mthwapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WeatherDBItem {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "imageResource")
    public String imageResource;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "temperature")
    public String temperature;

    @ColumnInfo(name = "detail")
    public String detail;
}
