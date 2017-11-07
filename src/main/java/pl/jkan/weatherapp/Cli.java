package pl.jkan.weatherapp;

public class Cli {
    public static void main(String[] args) {
        String city = "Krakow";
        Double temp = 13.50;

        System.out.printf("Weather in %s: Temp: %s\n", city, temp);
    }
}
