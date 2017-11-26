package pl.jkan.openweatherapi;

import pl.jkan.http.Browser;

import java.io.IOException;

public class ApiClient {

    private Browser http;
    private TempParser parser;
    private String apiKey;
    private String city;
    private final String endpoint = "http://api.openweathermap.org/data/2.5/weather";

    public ApiClient(Browser http, TempParser parser, String city, String apiKey) {
        this.http = http;
        this.parser = parser;
        this.apiKey = apiKey;
        this.city = city;
    }

    public String readWeatherInformation() throws IOException {
        String url = String.format("%s?q=%s&APPID=%s&units=metric", endpoint, city, apiKey);
        return http.get(url);
    }

    public double getTemperature()
    {
        try {
            return Double.parseDouble(parser.parse(readWeatherInformation()));
        } catch (IOException e) {
            return -99.99;
        }
    }
}
