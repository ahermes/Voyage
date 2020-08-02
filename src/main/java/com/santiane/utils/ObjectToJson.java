package com.santiane.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ObjectToJson {
    public static String getJsonString(Object obj)
    {
        String jsonStr = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            jsonStr = mapper.writeValueAsString(obj);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
