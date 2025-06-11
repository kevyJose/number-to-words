package com.numberwords.service;

import com.numberwords.controller.ConvertController;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class ConversionHandler implements HttpHandler {

    private final ConvertController controller = new ConvertController();

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String query = exchange.getRequestURI().getRawQuery(); // "amount=123.45"
        String amount = null;
        if (query != null && query.startsWith("amount=")) {
            // extract the numerical value
            amount = URLDecoder.decode(query.substring(7), StandardCharsets.UTF_8);
        }

        // Process the amount (call your number-to-words logic)
        assert amount != null;
        String result = controller.convertToWords(amount);

        // Send response
        byte[] responseBytes = result.getBytes(StandardCharsets.UTF_8);

        // 🔥 Add CORS headers
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream os = exchange.getResponseBody();
        os.write(responseBytes);
        os.close();
    }




}
