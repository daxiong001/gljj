package comments;

import com.google.common.collect.Maps;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class Env {

    public static Map<String,String> getEnv(){
        Map<String,String> env = Maps.newHashMap();
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("params.properties");
        try {
            properties.load(inputStream);
            for (Object key:properties.keySet()
                 ) {
                env.put((String) key,properties.getProperty((String) key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return env;
    }

    public static void main(String[] args) {
        System.out.println(getEnv());
    }
}
