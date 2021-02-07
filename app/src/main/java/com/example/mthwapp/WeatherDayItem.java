package com.example.mthwapp;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherDayItem implements Parcelable {
    private String day;
    private String temp;
    private String image;

    protected WeatherDayItem(Parcel in) {
        day = in.readString();
        temp = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(day);
        dest.writeString(temp);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WeatherDayItem> CREATOR = new Creator<WeatherDayItem>() {
        @Override
        public WeatherDayItem createFromParcel(Parcel in) {
            return new WeatherDayItem(in);
        }

        @Override
        public WeatherDayItem[] newArray(int size) {
            return new WeatherDayItem[size];
        }
    };

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public WeatherDayItem(String day, String temp, String image) {
        this.day = day;
        this.temp = temp;
        this.image = image;
    }
}
