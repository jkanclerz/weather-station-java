package pl.jkan.http;

import java.io.IOException;
import org.junit.Test;
import org.junit.Assert;

public class SimpleBrowserTest {

    @Test
    public void itAllowGetContentFromURL() {
        Browser browser = new SimpleBrowser();

        try {
            String content = browser.get("http://google.pl");
            Assert.assertTrue(content.contains("<!doctype html>"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
