package pl.jkan.http;

import java.io.IOException;

public interface Browser {
    public String get(String url) throws IOException;
}
