package com.numberwords;

import com.numberwords.controller.ConvertController;
import com.numberwords.service.ConversionHandler;
import com.numberwords.service.StaticFileHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Create your handler instance
        ConversionHandler handler = new ConversionHandler();

        // Bind handler to a context path
        server.createContext("/", new StaticFileHandler("src/main/resources/static"));
        server.createContext("/convert", handler);

        // Optional: set executor (null means default)
        server.setExecutor(null);

        // Start the server
        server.start();

        System.out.println("Server started at http://localhost:" + port);
    }

}
