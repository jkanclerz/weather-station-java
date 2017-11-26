package pl.jkan.openweatherapi;

import org.junit.Test;
import org.junit.Assert;

public class TempParserTest {
    private final static String response1 = "{\"coord\":{\"lon\":19.92,\"lat\":50.08},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":14.59,\"pressure\":1017,\"humidity\":86,\"temp_min\":4,\"temp_max\":4},\"visibility\":10000,\"wind\":{\"speed\":2.1,\"deg\":280},\"clouds\":{\"all\":75},\"dt\":1511683200,\"sys\":{\"type\":1,\"id\":5352,\"message\":0.0429,\"country\":\"PL\",\"sunrise\":1511676657,\"sunset\":1511707450},\"id\":3094802,\"name\":\"Krakow\",\"cod\":200}";
    private final static String expectedTemp1 = "14.59";

    private final static String response2 = "{\"coord\":{\"lon\":19.92,\"lat\":50.08},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":-3.20,\"pressure\":1017,\"humidity\":86,\"temp_min\":4,\"temp_max\":4},\"visibility\":10000,\"wind\":{\"speed\":2.1,\"deg\":280},\"clouds\":{\"all\":75},\"dt\":1511683200,\"sys\":{\"type\":1,\"id\":5352,\"message\":0.0429,\"country\":\"PL\",\"sunrise\":1511676657,\"sunset\":1511707450},\"id\":3094802,\"name\":\"Krakow\",\"cod\":200}";
    private final static String expectedTemp2 = "-3.20";

    private final static String response3 = "{\"coord\":{\"lon\":19.92,\"lat\":50.08},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":18,\"pressure\":1017,\"humidity\":86,\"temp_min\":4,\"temp_max\":4},\"visibility\":10000,\"wind\":{\"speed\":2.1,\"deg\":280},\"clouds\":{\"all\":75},\"dt\":1511683200,\"sys\":{\"type\":1,\"id\":5352,\"message\":0.0429,\"country\":\"PL\",\"sunrise\":1511676657,\"sunset\":1511707450},\"id\":3094802,\"name\":\"Krakow\",\"cod\":200}";
    private final static String expectedTemp3 = "18";

    @Test
    public void itRecogniseTempFromResponse() {
        TempParser parser = new TempParser();
        String temp = parser.parse(response1);

        Assert.assertEquals(temp, expectedTemp1);
    }

    @Test
    public void itRecogniseTempWithMinus() {
        TempParser parser = new TempParser();
        String temp = parser.parse(response2);

        Assert.assertEquals(temp, expectedTemp2);
    }

    @Test
    public void itRecogniseIntTemperature() {
        TempParser parser = new TempParser();
        String temp = parser.parse(response3);

        Assert.assertEquals(temp, expectedTemp3);
    }
}
