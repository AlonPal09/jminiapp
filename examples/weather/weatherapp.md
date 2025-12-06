
# Weather App

A simple console-based weather application built with the JMiniApp framework that allows users to check current weather conditions for any city in the world using the OpenWeatherMap API.

## Features

- Real-time temperature display in Celsius
- Current weather conditions and description
- Wind speed information
- Humidity percentage
- Easy city search functionality
- Saves last searched city for quick access
- Comprehensive error handling

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- JMiniApp framework (included in parent project)
- OpenWeatherMap API key (free)

## How to run

Using IntelliJ IDEA
- Open the project in IntelliJ IDEA.
- Navigate to examples/weather/src/main/java/com/jminiapp/examples/weather/WeatherApp.java.
- Right-click on the WeatherApp class and select "Run 'WeatherApp.main()'".
- Ensure the Run Configuration is using the classpath of the "weather-app" module.

## Usage
- Follow the on-screen menu to interact with the application:
- Search weather by city: Enter a city name (e.g., London, Tokyo).
- View last search: Displays the weather data from the previous session.
- Export to JSON file: Saves the current weather data to src/main/resources/Weather.json.
- Import from JSON file: Loads weather data from src/main/resources/Weather.json.
- Exit: Closes the application.

## Configuration
- The application uses a default OpenWeatherMap API key for demonstration purposes. To use your own key, update the API_KEY constant in the WeatherService class.

## Author
Rodrigo Alonzo

## Resources

- OpenWeatherMap 
- API Documentation
- JMiniApp Framework
- Java HTTP Client Guide