package com.jminiapp.examples.weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;


public class WeatherService {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric";
    private static final String API_KEY = "466e7759dbdba6980a7ae11a20f63ae1";

    public WeatherData fetchWeather(String city) {
        try {
            String url = String.format(BASE_URL, city, API_KEY);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 401) {
                System.out.println("Error: Invalid API key");
                return null;
            } else if (response.statusCode() == 404) {
                System.out.println("Error: City not found");
                return null;
            } else if (response.statusCode() != 200) {
                System.out.println("Error: API request failed with status code " + response.statusCode());
                return null;
            }

            JSONObject json = new JSONObject(response.body());

            WeatherData model = new WeatherData();

            // Basic information
            model.setLastCity(city);
            model.setCityName(json.getString("name"));
            model.setCountry(json.getJSONObject("sys").getString("country"));

            // Temperature data
            JSONObject main = json.getJSONObject("main");
            model.setLastTemperature(main.getDouble("temp"));
            model.setTemperature(main.getDouble("temp"));
            model.setFeelsLike(main.getDouble("feels_like"));
            model.setHumidity(main.getInt("humidity"));

            // Weather description
            String description = json.getJSONArray("weather")
                    .getJSONObject(0)
                    .getString("description");
            model.setLastDescription(description);
            model.setDescription(description);

            // Weather icon
            String icon = json.getJSONArray("weather")
                    .getJSONObject(0)
                    .getString("icon");
            model.setIcon(icon);

            // Wind data
            if (json.has("wind")) {
                JSONObject wind = json.getJSONObject("wind");
                model.setWindSpeed(wind.getDouble("speed"));
            }

            // Set timestamp
            model.setTimestamp(System.currentTimeMillis());

            return model;

        } catch (IOException | InterruptedException e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error parsing weather data: " + e.getMessage());
            return null;
        }
    }
}