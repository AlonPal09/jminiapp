package com.jminiapp.examples.weather;

import com.jminiapp.core.adapters.JSONAdapter;

public class WeatherJSONAdapter implements JSONAdapter<WeatherData> {
    @Override
    public Class<WeatherData> getstateClass() {
        return WeatherData.class;
    }
}