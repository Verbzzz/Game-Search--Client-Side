package com.hit.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hit.client.Game;
import com.hit.client.Request;
import com.hit.client.Response;

import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.*;

public class MyModel {
    public Gson gson;
    public PrintWriter writer;
    public Response response;
    public Request request;
    public Scanner reader;
    public Socket toServer;
    public int port;


    public MyModel(int port){
        gson = new GsonBuilder().create();
        this.port = port;
    }


    public List<Game> getGame(String searchVal){
        String command = "Get";
        Map<String, String> headers = new HashMap<>();
        headers.put("command", command);
        response = sendRequest(headers, searchVal);
        return response.game;
    }

    public String saveGame(List<String> input){
        String command = "Save";
        Map<String, String> headers = new HashMap<>();

        headers.put("command",command);
        headers.put("GameName",input.get(0));
        headers.put("Genre",input.get(1));
        headers.put("GameCompanyDevelop",input.get(2));
        headers.put("GameStoreName",input.get(3));
        headers.put("AddressStore",input.get(4));
        response = sendRequest(headers,"Save");
        return response.json;
    }

    public String updateGame(List<String> input){
        String command = "Update";
        Map<String, String> headers = new HashMap<>();

        headers.put("command",command);
        headers.put("Name",input.get(0));
        headers.put("toUpdate",input.get(1));
        headers.put("Val",input.get(2));

        response = sendRequest(headers,"Update");
        return response.json;
    }

    public String deleteGame(String gameName) {
        String command = "Delete";
        Map <String, String> headers = new HashMap <>();
        headers.put("command", command);
        response = sendRequest(headers, gameName);
        return response.json;
    }



    public  Response sendRequest(Map <String, String> headers, String body)  {

        try {
            toServer = new Socket("localhost", port);
            writer = new PrintWriter(toServer.getOutputStream());
            reader = new Scanner(toServer.getInputStream());
            request = new Request(headers, body);
            writer.println(gson.toJson(request));
            writer.flush();
            Type type = new TypeToken<Response>() {}.getType();
            response = gson.fromJson(reader.next(), type);
            writer.close();
            reader.close();
            toServer.close();
            return response;
        }
        catch (Exception ex){ ex.printStackTrace();}
        return new Response("Error");

    }















}
