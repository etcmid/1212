
package com.example.mthwapp.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentWeather {

    @SerializedName("request")
    @Expose
    private WsRequest wsRequest;
    @SerializedName("location")
    @Expose
    private WsLocation wsLocation;
    @SerializedName("current")
    @Expose
    private WsCurrent wsCurrent;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("error")
    @Expose
    private Error error;

    public WsRequest getWsRequest() {
        return wsRequest;
    }

    public void setWsRequest(WsRequest wsRequest) {
        this.wsRequest = wsRequest;
    }

    public WsLocation getWsLocation() {
        return wsLocation;
    }

    public void setWsLocation(WsLocation wsLocation) {
        this.wsLocation = wsLocation;
    }

    public WsCurrent getWsCurrent() {
        return wsCurrent;
    }

    public void setWsCurrent(WsCurrent wsCurrent) {
        this.wsCurrent = wsCurrent;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

}
