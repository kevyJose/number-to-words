package com.numberwords.service;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StaticFileHandler implements HttpHandler {
    private final String basePath;

    public StaticFileHandler(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        if (path.equals("/")) path = "/index.html";

        File file = new File(basePath + URLDecoder.decode(path, StandardCharsets.UTF_8));
        if (!file.exists() || file.isDirectory()) {
            String notFound = "404 Not Found";
            exchange.sendResponseHeaders(404, notFound.length());
            OutputStream os = exchange.getResponseBody();
            os.write(notFound.getBytes(StandardCharsets.UTF_8));
            os.close();
            return;
        }

        String mimeType = Files.probeContentType(Paths.get(file.getAbsolutePath()));
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        exchange.getResponseHeaders().add("Content-Type", mimeType);
        exchange.sendResponseHeaders(200, fileBytes.length);
        OutputStream os = exchange.getResponseBody();
        os.write(fileBytes);
        os.close();
    }
}
