package com.example.weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class WeatherService {

    private static final String API_KEY = "466e7759dbdba6980a7ae11a20f63ae1"; 
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";

    public WeatherModel fetchWeather(String city) {
        try {
            String url = String.format(BASE_URL, city, API_KEY);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(response.body());

            WeatherModel model = new WeatherModel();
            model.setLastCity(city);
            model.setLastTemperature(json.getJSONObject("main").getDouble("temp"));
            model.setLastDescription(json.getJSONArray("weather")
                    .getJSONObject(0)
                    .getString("description"));

            return model;

        } catch (IOException | InterruptedException e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
            return null;
        }
    }
}
