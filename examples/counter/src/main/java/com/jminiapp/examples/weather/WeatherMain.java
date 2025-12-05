package com.jminiapp.examples.weather;

import com.jminiapp.core.JMiniAppRunner;

public class WeatherMain {
    public static void main(String[] args) {
        JMiniAppRunner
            .forApp(WeatherApp.class)
            .withState(WeatherData.class)
            .run(args);
    }
}
