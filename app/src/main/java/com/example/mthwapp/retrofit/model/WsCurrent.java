
package com.example.mthwapp.retrofit.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WsCurrent {

    @SerializedName("observation_time")
    @Expose
    private String observationTime;
    @SerializedName("temperature")
    @Expose
    private Float temperature;
    @SerializedName("weather_code")
    @Expose
    private Float weatherCode;
    @SerializedName("weather_icons")
    @Expose
    private List<String> weatherIcons = null;
    @SerializedName("weather_descriptions")
    @Expose
    private List<String> weatherDescriptions = null;
    @SerializedName("wind_speed")
    @Expose
    private Float windSpeed;
    @SerializedName("wind_degree")
    @Expose
    private Float windDegree;
    @SerializedName("wind_dir")
    @Expose
    private String windDir;
    @SerializedName("pressure")
    @Expose
    private Float pressure;
    @SerializedName("precip")
    @Expose
    private Float precip;
    @SerializedName("humidity")
    @Expose
    private Float humidity;
    @SerializedName("cloudcover")
    @Expose
    private Float cloudcover;
    @SerializedName("feelslike")
    @Expose
    private Float feelslike;
    @SerializedName("uv_index")
    @Expose
    private Float uvIndex;
    @SerializedName("visibility")
    @Expose
    private Float visibility;
    @SerializedName("is_day")
    @Expose
    private String isDay;

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(Float weatherCode) {
        this.weatherCode = weatherCode;
    }

    public List<String> getWeatherIcons() {
        return weatherIcons;
    }

    public void setWeatherIcons(List<String> weatherIcons) {
        this.weatherIcons = weatherIcons;
    }

    public List<String> getWeatherDescriptions() {
        return weatherDescriptions;
    }

    public void setWeatherDescriptions(List<String> weatherDescriptions) {
        this.weatherDescriptions = weatherDescriptions;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Float getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(Float windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Float getPrecip() {
        return precip;
    }

    public void setPrecip(Float precip) {
        this.precip = precip;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(Float cloudcover) {
        this.cloudcover = cloudcover;
    }

    public Float getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(Float feelslike) {
        this.feelslike = feelslike;
    }

    public Float getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(Float uvIndex) {
        this.uvIndex = uvIndex;
    }

    public Float getVisibility() {
        return visibility;
    }

    public void setVisibility(Float visibility) {
        this.visibility = visibility;
    }

    public String getIsDay() {
        return isDay;
    }

    public void setIsDay(String isDay) {
        this.isDay = isDay;
    }

}
