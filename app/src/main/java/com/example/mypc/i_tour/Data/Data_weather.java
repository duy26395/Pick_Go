package com.example.mypc.i_tour.Data;

/**
 * Created by MyPC on 01/08/2017.
 */

public class Data_weather {
    private String idImage, cityName, weather, temperature;

    public Data_weather(String cityName, String weather, String temperature, String idImage) {
        this.idImage = idImage;
        this.cityName = cityName;
        this.weather = weather;
        this.temperature = temperature;
    }
    public Data_weather() {
        this.idImage = "";
        this.cityName = "";
        this.weather = "";
        this.temperature = "";
    }

    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
