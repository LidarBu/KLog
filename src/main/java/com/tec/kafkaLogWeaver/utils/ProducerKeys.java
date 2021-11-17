package com.tec.kafkaLogWeaver.utils;

import com.tec.kafkaLogWeaver.KLog;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ProducerKeys {


    public static final String BOOTSTRAP_SERVERS = "BOOTSTRAPSERVERS";
    public static final String TOPIC = "TOPIC";
    public static final String JAAS_CONFIG = "JASSCONFIG";
    public static final String PARTITION = "PARTITION";

    public static List<String> propertiesKeys = new ArrayList<>();


    {
        Field[] fields = ProducerKeys.class.getFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                propertiesKeys.add((String) field.get(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }finally {
                field.setAccessible(false);
            }

        }


    }



}
