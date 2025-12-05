package com.example.weather;

import com.jminiapp.Application;
import com.jminiapp.persistence.DataRepository;
import com.jminiapp.persistence.JsonDataRepository;

import java.util.Scanner;

public class WeatherApp extends Application {

    private DataRepository<WeatherData> repository;
    private WeatherService service;

    @Override
    public void init() {
        this.service = new WeatherService();
        this.repository = new JsonDataRepository<>(
                "Weather.json",
                WeatherData.class
        );

        System.out.println("Weather App initialized.");
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWeather Application: ");

        System.out.print("Enter a city name: ");
        String city = scanner.nextLine();

        System.out.println("Fetching weather data...");

        WeatherData data = service.fetchWeather(city);

        if (data != null) {
            repository.save(data);

            System.out.println("\nWeather Information:");
            System.out.println("City: " + data.getLastCity());
            System.out.println("Temperature: " + data.getLastTemperature() + " °C");
            System.out.println("Description: " + data.getLastDescription());
        } else {
            System.out.println("Failed to retrieve weather data.");
        }
    }

    @Override
    public void stop() {
        System.out.println("Weather App stopped.");
    }
}
