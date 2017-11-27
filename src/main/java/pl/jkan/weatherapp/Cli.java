package pl.jkan.weatherapp;

import pl.jkan.http.SimpleBrowser;
import pl.jkan.openweatherapi.ApiClient;
import pl.jkan.openweatherapi.TempParser;

import pl.jkan.weatherstation.WeatherStation;
import pl.jkan.weatherstation.sensors.ApiTempSensor;
import pl.jkan.weatherstation.TempSensor;

public class Cli {
    public static void main(String[] args) {
        String city = "";
        try {
            city = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            city = "Krakow";
        }

        TempSensor tempSensor = new ApiTempSensor(
            new ApiClient(
                new SimpleBrowser(),
                new TempParser(),
                city,
                System.getenv("OPEN_WEATHER_API_KEY")
            )
        );

        WeatherStation station = new WeatherStation(tempSensor);
        Double temp = station.temperature();

        System.out.printf("Weather in %s| Temp: %s\n", city, temp);
    }
}

