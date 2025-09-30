package com.dantas.createUrlShortener;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.util.Map;
import java.util.UUID;

public class Main implements RequestHandler<Map<String, Object>, Map<String, String>> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final S3Client s3Client = S3Client.builder().build();

    private static final String BUCKET_NAME = "dantas-url-shortener-storage-1";

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
        long expirationTimeInSeconds = expirationTime == null ? 0 : Long.parseLong(expirationTime);

        String shortUrlCode = UUID.randomUUID().toString().substring(0, 8);

        UrlData urlData = new UrlData(originalUrl, expirationTimeInSeconds);

        // Handle data serialization and update to S3 bucket
        try {
            String dataAsJson = objectMapper.writeValueAsString(urlData);

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(shortUrlCode.concat(".json"))
                    .build();

            s3Client.putObject(putObjectRequest, RequestBody.fromString(dataAsJson));

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing url data! " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error on saving data to S3 action! " + e.getMessage());
        }

        Map<String, String> responseMap = Map.of("code", shortUrlCode);

        return responseMap;
    }
}