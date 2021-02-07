package com.example.mthwapp.database;

//public class TAppDatabase {
//}
//

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {WeatherDBItem.class}, version  = 1, exportSchema = false)
public abstract class TAppDatabase extends RoomDatabase {

    public abstract WeatherDBItemDao weatherDBItemDao();

    private static TAppDatabase INSTANCE;

    public static TAppDatabase getDbInstance(Context context) {

        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TAppDatabase.class, "MTH_DB")
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }
}