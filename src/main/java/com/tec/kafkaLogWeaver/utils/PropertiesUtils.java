package com.tec.kafkaLogWeaver.utils;

import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {

    public static Properties getAndValidateProducerProperties(String[] values) {

        Properties properties = ValuesUtils.klogValuesToProducerProperties(values);
        Properties validProperties = new Properties();

        //copy only the required properties into the new properties object
        for (String property : ProducerKeys.propertiesKeys) {
            if (properties.getProperty(property) != null)
                validProperties.put(property, properties.getProperty(property));
        }

        //the properties most contains bootstrap server
        if (properties.getProperty(ProducerKeys.BOOTSTRAP_SERVERS) == null)
            throw new RuntimeException("Values Most Contains BootStrapServers");

        //in case the properties doesn't contains value for required attribute. its complete the property with the default value (in case the default value exists)
        for (Map.Entry<String, String> entry : DefaultProducerValues.defaultValues.entrySet()) {
            if (properties.getProperty(entry.getKey()) == null)
                properties.put(entry.getKey(), entry.getValue());
        }


        return validProperties;

    }


}
