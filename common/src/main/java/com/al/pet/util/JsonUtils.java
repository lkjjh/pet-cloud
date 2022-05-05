package com.al.pet.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author al
 * @version 1.0
 */
@Component
public class JsonUtils {
    @Autowired
    private ObjectMapper objectMapper;

    public <T> T get(Object obj, Class<T> c) {
        String s = null;
        try {
            s = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            return objectMapper.readValue(s, c);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String get(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public <T> T get(String str, Class<T> c) {
        try {
            return objectMapper.readValue(str, c);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
