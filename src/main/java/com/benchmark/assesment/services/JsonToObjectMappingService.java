package com.benchmark.assesment.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


/**
 * A generic JSON to object mapper. This can be reused as needed.
 */
public class JsonToObjectMappingService {

    ObjectMapper objectResolver;

    public JsonToObjectMappingService(){
        objectResolver = new ObjectMapper();
    }

    public <T> T getPayload(String jsonPayload, Class<T> className) throws IOException {
        return objectResolver.readValue(jsonPayload, className);
    }

}
