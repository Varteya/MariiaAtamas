package hw9.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class GetProperties {

    private static Properties properties;

    public static String getUrl(){
        if (properties == null){
            downloadProperties();
        }
        return properties.getProperty("url");
    }


    private static void downloadProperties (){
        properties = new Properties();
        try(InputStream inputStream = GetProperties.class.getClassLoader().getResourceAsStream("hw9/test.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
