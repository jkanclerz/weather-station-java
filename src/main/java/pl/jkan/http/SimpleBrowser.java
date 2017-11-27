package pl.jkan.http;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class SimpleBrowser implements Browser {

    public String get(String url) throws IOException {
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
