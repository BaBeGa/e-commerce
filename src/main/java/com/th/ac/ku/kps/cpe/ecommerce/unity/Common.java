package com.th.ac.ku.kps.cpe.ecommerce.unity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class Common {
    private static final Logger LOGGER = Logger.getLogger(Common.class.getName());

    public static String ConvertToJson(Object object) {
        ObjectMapper obj = new ObjectMapper();
        try {
            return obj.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void LoggerInfo(String str) {
        LOGGER.info(str);
    }

    public static void LoggerInfo(Object object) {
        ObjectMapper obj = new ObjectMapper();
        String str = "";
        try {
            str = obj.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        LOGGER.info(str);
    }
}
