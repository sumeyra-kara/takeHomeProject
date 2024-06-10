package com.myideasoft.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static {

        try {
            String path="configuration.properties";
            FileInputStream fis = new FileInputStream(path); //configration.properties e ulasmak icin yazilir
            properties = new Properties();
            properties.load(fis); // conf.properties'ten alinan bilgileri properties objesine yüklemek(load)
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String get (String keyName){ //(biz ona key verecegiz)
        return properties.getProperty(keyName); // o da bize key'e ait bilgiyi verecek
    }


}
