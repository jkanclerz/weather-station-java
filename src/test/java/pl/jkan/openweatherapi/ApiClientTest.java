package pl.jkan.openweatherapi;

import java.io.IOException;
import org.junit.Test;
import org.junit.Assert;
import pl.jkan.http.Browser;

public class ApiClientTest {

    @Test
    public void itIsConstructedWithCityAndApiKey() {
        ApiClient api = new ApiClient(new MockBrowser(), new TempParser(), "Krakow", System.getenv("OPEN_WEATHER_API_KEY"));

        Assert.assertNotNull(api);
    }

    @Test
    public void itAllowReadWeatherInformation() {
        ApiClient api = new ApiClient(new MockBrowser(), new TempParser(),"Krakow", System.getenv("OPEN_WEATHER_API_KEY"));

        try {
            String info = api.readWeatherInformation();
            Assert.assertTrue(info.contains("\"coord\":{\"lon\":19.92,\"lat\":50.08}"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void itAllowReadTemperature() {
        ApiClient api = new ApiClient(new MockBrowser(), new TempParser(),"Krakow", System.getenv("OPEN_WEATHER_API_KEY"));

        Double temp = api.getTemperature();

        Assert.assertTrue(14.59 == temp);
    }

    private class MockBrowser implements Browser {
        private final static String response = "{\"coord\":{\"lon\":19.92,\"lat\":50.08},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":14.59,\"pressure\":1017,\"humidity\":86,\"temp_min\":4,\"temp_max\":4},\"visibility\":10000,\"wind\":{\"speed\":2.1,\"deg\":280},\"clouds\":{\"all\":75},\"dt\":1511683200,\"sys\":{\"type\":1,\"id\":5352,\"message\":0.0429,\"country\":\"PL\",\"sunrise\":1511676657,\"sunset\":1511707450},\"id\":3094802,\"name\":\"Krakow\",\"cod\":200}";

        @Override
        public String get(String url) throws IOException {
            return response;
        }
    }
}

