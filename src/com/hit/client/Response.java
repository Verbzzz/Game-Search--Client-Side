package com.hit.client;

import java.util.List;

public class Response {
    public String json;
    public List<Game> game;

    public Response(){}
    public Response(List<Game> games){ this.game = games;}


    public Response(String string){
        json = string;
    }

    public String toString() {
        return  "{'Games':" + game + "', 'json':'" + json + "'}";
    }

}
