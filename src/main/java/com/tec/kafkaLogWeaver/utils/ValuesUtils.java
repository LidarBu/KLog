package com.tec.kafkaLogWeaver.utils;

import java.util.Locale;
import java.util.Properties;

public class ValuesUtils {


    public static Properties klogValuesToProducerProperties(String[] values) {
        Properties properties = new Properties();

        for (String value : values) {
            String[] temp = value.split(";"); //the key value should be in key;value form
            if (temp.length != 2)
                continue;
            temp[0] = temp[0].toUpperCase(Locale.ROOT);
            properties.put(temp[0], temp[1]);
        }
        return properties;
    }


}
