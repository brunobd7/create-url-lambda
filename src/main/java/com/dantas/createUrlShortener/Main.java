package com.dantas.createUrlShortener;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.UUID;

public class Main implements RequestHandler<Map<String, Object>, Map<String, String>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, String> handleRequest(Map<String, Object> inputMapObject, Context context) {
        String body = (String) inputMapObject.get("body");

        Map<String, String> bodyMap;

        try {
            bodyMap = objectMapper.readValue(body, Map.class);

        } catch (Exception exception) {
             throw new RuntimeException("Error parsing request body! ", exception);
        }

        String originalUrl = bodyMap.get("originalUrl");
        String expirationTime = bodyMap.get("expirationTime");

        String shortUrlCode = UUID.randomUUID().toString().substring(0, 8);

        Map<String, String> responseMap = Map.of("code", shortUrlCode);

        return responseMap;
    }
}