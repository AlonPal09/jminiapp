package examples.weatherapp;

import dev.jminiapp.core.JMiniAppRunner;

public class WeatherMain {
    public static void main(String[] args) {
        JMiniAppRunner
            .forApp(WeatherApp.class)
            .withState(WeatherModel.class)
            .run(args);
    }
}
