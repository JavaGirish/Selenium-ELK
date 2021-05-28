package com.fw.utils;

import com.fw.constants.Constants;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyFileReader {

    private PropertyFileReader() { }

    private static Properties properties = new Properties();
    private static Map<String,String> configMap = new HashMap<>();

    /* Static block to read values from config file and add it in hashmap
    */
    static {
        try (FileInputStream fis = new FileInputStream(Constants.CONFIG_PATH)) {
            properties.load(fis);

            for(Object key : properties.keySet()){
                configMap.put(String.valueOf(key) , properties.getProperty((String) key).trim());
            }

        }

        catch (IOException e) {
            e.printStackTrace();
        }


    }

    /* Read values from config properties file
       @param: Key
    * */
    public static String getValue(String key) {
        if (Objects.isNull(key) || Objects.isNull(configMap.get(key))) {
            try {
                throw new Exception("Key or Value is Null, please check!!");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        else
            return configMap.get(key);

    }

}




