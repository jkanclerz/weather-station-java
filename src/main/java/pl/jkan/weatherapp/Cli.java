package pl.jkan.weatherapp;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cli {

    private String apiKey;
    private String city;

    public static final String endpoint = "http://api.openweathermap.org/data/2.5/weather";
    private static final Pattern p = Pattern.compile("\"temp\":(?<temperature>[+-]?\\d+(\\.\\d+)?)");


    public static void main(String[] args) {
        String city = "";
        try {
            city = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            city = "Krakow";
        }

        String url = String.format("%s?q=%s&APPID=%s&units=metric", Cli.endpoint, city, System.getenv("OPEN_WEATHER_API_KEY"));

        try {
            String data = Cli.get(url);

            try {
                Matcher m = p.matcher(data);
                m.find();

                Double temp = Double.parseDouble(m.group("temperature"));

                System.out.printf("Weather in %s| Temp: %s\n", city, temp);
            } catch (Exception e) {
                System.out.printf("Weather in %s| Temp: %s\n", city, -99.99);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String get(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            return readAll(rd);

        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[4*1024];
        int len;
        while((len = rd.read(chars))>=0) {
            sb.append(chars, 0, len);
        }

        return sb.toString();
    }
}

