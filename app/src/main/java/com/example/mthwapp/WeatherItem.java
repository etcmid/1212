package com.example.mthwapp;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherItem implements Parcelable {
    private String imageResource;
    private String city;
    private String temperature;
    private String detail;

    protected WeatherItem(Parcel in) {
        imageResource = in.readString();
        city = in.readString();
        temperature = in.readString();
        detail = in.readString();
    }

    public static final Creator<WeatherItem> CREATOR = new Creator<WeatherItem>() {
        @Override
        public WeatherItem createFromParcel(Parcel in) {
            return new WeatherItem(in);
        }

        @Override
        public WeatherItem[] newArray(int size) {
            return new WeatherItem[size];
        }
    };

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public WeatherItem(String imageResource, String city, String temperature, String detail) {
        this.imageResource = imageResource;
        this.city = city;
        this.temperature = temperature;
        this.detail = detail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageResource);
        dest.writeString(city);
        dest.writeString(temperature);
        dest.writeString(detail);
    }
}
