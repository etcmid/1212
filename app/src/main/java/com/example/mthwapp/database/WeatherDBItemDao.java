package com.example.mthwapp.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WeatherDBItemDao {

    @Query("SELECT * FROM weatherDBItem ORDER BY id DESC")
    List<WeatherDBItem> getAllWeatherDBItems();

    @Query("SELECT * FROM weatherDBItem WHERE city=:city LIMIT 1")
    WeatherDBItem getWeatherDBItemsByCityName(String city);

    @Update
    public void updateWeatherDBItem(WeatherDBItem weatherDBItem);

    @Insert
    void insertWeatherDBItem(WeatherDBItem weatherDBItem);

    @Delete
    void delete(WeatherDBItem weatherDBItem);
}
