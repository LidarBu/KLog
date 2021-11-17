package com.tec.kafkaLogWeaver.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DefaultProducerValues {


    //BE AWARE! the field identifier most be identical to the corresponding key in ProducerKeys class
    public static final String TOPIC = "audit";
    public static final String PARTITION = "0";


    public static final Map<String, String> defaultValues = new HashMap<>();


    {
        Field[] fields = DefaultProducerValues.class.getFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                defaultValues.put(field.getName(), (String) field.get(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                field.setAccessible(false);
            }
        }


    }

}
