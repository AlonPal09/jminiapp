package com.jminiapp.examples.weather;

import com.jminiapp.core.api.JMiniApp;
import com.jminiapp.core.api.JMiniAppConfig;
import com.jminiapp.core.engine.JMiniAppRunner;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WeatherApp extends JMiniApp {

    private Scanner scanner;
    private WeatherData weatherData;
    private WeatherService weatherService;

    public WeatherApp(JMiniAppConfig config) {
        super(config);
        this.scanner = new Scanner(System.in);
        this.weatherService = new WeatherService();
    }

    @Override
    protected void initialize() {
        System.out.println("Weather app initialized.");

        List<WeatherData> data = context.getData();
        if (!data.isEmpty()) {
            weatherData = data.get(0);
            System.out.println("Last searched city: " + weatherData.getCityName());
            displayWeatherInfo(weatherData);
        } else {
            weatherData = new WeatherData();
        }
    }

    @Override
    protected void run() {
        boolean running = true;
        while (running) {
            System.out.println("Menu");
            System.out.println("1. Search weather by city");
            System.out.println("2. View last search");
            System.out.println("3. Export to JSON file");
            System.out.println("4. Import from JSON file");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    searchWeather();
                    break;
                case "2":
                    viewLastSearch();
                    break;
                case "3":
                    exportToFile();
                    break;
                case "4":
                    importFromFile();
                    break;
                case "5":
                    running = false;
                    System.out.println("\nExiting Weather App...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    @Override
    protected void shutdown() {
        if (weatherData != null && weatherData.getCityName() != null) {
            context.setData(List.of(weatherData));
            System.out.println("\nWeather data auto-saved successfully.");
        }
        scanner.close();
        System.out.println("Weather app closed");
    }

    private void searchWeather() {
        System.out.print("\nEnter city name: ");
        String cityName = scanner.nextLine().trim();

        if (cityName.isEmpty()) {
            System.out.println("Error: City name cannot be empty.");
            return;
        }

        System.out.println("\nFetching weather data for " + cityName);
        WeatherData newData = weatherService.fetchWeather(cityName);

        if (newData != null) {
            this.weatherData = newData;
            displayWeatherInfo(this.weatherData);
        } else {
            System.out.println("Could not fetch weather data. Please try again.");
        }
    }

    private void exportToFile() {
        try {
            if (weatherData != null) {
                context.setData(List.of(weatherData));
            }

            context.exportData("json");
            System.out.println("Weather data exported successfully!");
        } catch (IOException e) {
            System.out.println("Error exporting file: " + e.getMessage());
        }
    }

    private void importFromFile() {
        try {
            context.importData("json");

            List<WeatherData> data = context.getData();
            if (data != null && !data.isEmpty()) {
                weatherData = data.get(0);
                System.out.println("Weather data imported successfully!");
                displayWeatherInfo(weatherData);
            } else {
                System.out.println("Error: No data found in file.");
            }
        } catch (IOException e) {
            System.out.println("Error importing file: " + e.getMessage());
        }
    }

    private void viewLastSearch() {
        if (weatherData == null || weatherData.getCityName() == null) {
            System.out.println("\nNo previous searches found.");
            return;
        }
        System.out.println("\nLast search: ");
        displayWeatherInfo(weatherData);
    }

    private void displayWeatherInfo(WeatherData data) {
        if (data == null || data.getCityName() == null) {
            System.out.println("No weather data available.");
            return;
        }
        System.out.println("\nLocation: " + data.getCityName() + ", " + data.getCountry());
        System.out.println("Description: " + data.getDescription());
        System.out.println("Temperature: " + String.format("%.1f°C", data.getTemperature()));
        System.out.println("Humidity: " + data.getHumidity() + "%");
    }

    public static void main(String[] args) {
        JMiniAppRunner
                .forApp(WeatherApp.class)
                .withState(WeatherData.class)
                .withAdapters(new WeatherJSONAdapter())
                .named("Weather")
                .withResourcesPath("src/main/resources/")
                .run(args);
    }
}