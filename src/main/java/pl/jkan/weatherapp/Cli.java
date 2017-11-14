package pl.jkan.weatherapp;

import pl.jkan.weatherstation.WeatherStation;
import pl.jkan.weatherstation.FakeTempSensor;
import pl.jkan.weatherstation.TempSensor;
import pl.jkan.openweatherapi.ApiTempSensor;


public class Cli {
    public static void main(String[] args) {
        String city = "Krakow";
        
        TempSensor tempSensor = new FakeTempSensor();
        WeatherStation station = new WeatherStation(tempSensor);

        Double temp = station.temperature();

        System.out.printf("Weather in %s| Temp: %s\n", city, temp);
	try{
	System.out.println(ApiTempSensor.readURL());
	} catch (Exception e)
		{
			System.out.println("sth went wrong");
		}
    }
}

