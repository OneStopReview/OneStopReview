package com.parse.internal.signpost.basic;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import com.parse.internal.signpost.http.HttpResponse;


@SuppressWarnings("all")
public class HttpURLConnectionResponseAdapter implements HttpResponse {

    private HttpURLConnection connection;

    public HttpURLConnectionResponseAdapter(HttpURLConnection connection) {
        this.connection = connection;
    }

    public InputStream getContent() throws IOException {
        return connection.getInputStream();
    }

    public int getStatusCode() throws IOException {
        return connection.getResponseCode();
    }

    public String getReasonPhrase() throws Exception {
        return connection.getResponseMessage();
    }

    public Object unwrap() {
        return connection;
    }
}
