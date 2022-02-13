package com.hit.client;

import java.util.Map;

public class Request {

    private Map<String, String> headers;
    private String body;

    public Request(Map<String, String> headers, String body) {
        this.headers = headers;
        this.body = body;
    }

    public Request() {

    }


    public String getBody() {
        return body;
    }


    public void setBody(String body) {
        this.body = body;
    }


    public Map<String, String> getHeaders() {
        return headers;
    }


    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }


    @Override
    public String toString() {
        return "{'headers':'" + headers + "', 'body':'" + body + "'}";
    }
}
