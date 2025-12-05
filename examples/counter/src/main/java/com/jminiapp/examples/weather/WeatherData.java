package com.jminiapp.examples.weather;

public class WeatherData {

    private String lastCity;
    private double lastTemperature;
    private String lastDescription;

    public String getLastCity() {
        return lastCity;
    }

    public void setLastCity(String lastCity) {
        this.lastCity = lastCity;
    }

    public double getLastTemperature() {
        return lastTemperature;
    }

    public void setLastTemperature(double lastTemperature) {
        this.lastTemperature = lastTemperature;
    }

    public String getLastDescription() {
        return lastDescription;
    }

    public void setLastDescription(String lastDescription) {
        this.lastDescription = lastDescription;
    }
}
