package com.jminiapp.examples.weather;

public class WeatherData {
    private String cityName;
    private String lastCity;
    private String country;
    private double temperature;
    private double lastTemperature;
    private double feelsLike;
    private int humidity;
    private double windSpeed;
    private String description;
    private String lastDescription;
    private String icon;
    private long timestamp;


    public WeatherData() {
    }


    public WeatherData(String cityName, String country, double temperature,
                       double feelsLike, int humidity, double windSpeed,
                       String description, String icon) {
        this.cityName = cityName;
        this.lastCity = cityName;
        this.country = country;
        this.temperature = temperature;
        this.lastTemperature = temperature;
        this.feelsLike = feelsLike;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.description = description;
        this.lastDescription = description;
        this.icon = icon;
        this.timestamp = System.currentTimeMillis();
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
        this.lastCity = cityName;
    }

    public String getLastCity() {
        return lastCity;
    }

    public void setLastCity(String lastCity) {
        this.lastCity = lastCity;
        this.cityName = lastCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        this.lastTemperature = temperature;
    }

    public double getLastTemperature() {
        return lastTemperature;
    }

    public void setLastTemperature(double lastTemperature) {
        this.lastTemperature = lastTemperature;
        this.temperature = lastTemperature;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.lastDescription = description;
    }

    public String getLastDescription() {
        return lastDescription;
    }

    public void setLastDescription(String lastDescription) {
        this.lastDescription = lastDescription;
        this.description = lastDescription;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "cityName='" + cityName + '\'' +
                ", lastCity='" + lastCity + '\'' +
                ", country='" + country + '\'' +
                ", temperature=" + temperature +
                ", lastTemperature=" + lastTemperature +
                ", feelsLike=" + feelsLike +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", description='" + description + '\'' +
                ", lastDescription='" + lastDescription + '\'' +
                ", icon='" + icon + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}