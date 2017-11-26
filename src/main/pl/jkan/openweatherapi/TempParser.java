package pl.jkan.openweatherapi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TempParser {
    private static final Pattern p = Pattern.compile("\"temp\":(?<temperature>[+-]?\\d+(\\.\\d+)?)");

    String parse(String data) {
        Matcher m = p.matcher(data);
        m.find();

        return m.group("temperature");
    }
}
