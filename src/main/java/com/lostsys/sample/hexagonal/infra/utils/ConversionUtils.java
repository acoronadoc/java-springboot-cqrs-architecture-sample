package com.lostsys.sample.hexagonal.infra.utils;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversionUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private ConversionUtils() {}

    public static String map2Jsonstring( Map<String, Object> map ) {
        if ( map == null ) return "{}";

        try {
            return objectMapper.writeValueAsString( map );
        } catch (JsonProcessingException e) {
           e.printStackTrace();
        }

        return "{}";
    }
    
    public static Map<String, Object> jsonstring2Map( String json ) {
        if ( json == null ) return new HashMap<String, Object>();

        try {
            return objectMapper.readValue( json, Map.class);
        } catch (JsonProcessingException e) {
           e.printStackTrace();
        }

        return new HashMap<String, Object>();
    }

}
