package filenio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;


public class Configuration {
    private String name;
    private String ipAddress;
    private int port;
    private static Configuration instance;
    
    public static Configuration getInstance() throws ConfigException{
        if (instance == null) instance = new Configuration();
        return instance;
    }
    
    private Configuration() throws ConfigException{
        BufferedReader input = null;
        try{
            input= new BufferedReader(new FileReader("config.dat"));
            name= input.readLine();
            ipAddress= input.readLine();
            port = Integer.valueOf(input.readLine());
        } catch (IOException ex){
            throw new ConfigException(ex);
        }
    }
    
    public String getName() {
        return name;
    }
    
    public String getIpAddress() {
        return ipAddress;
    }
    
    public int getPort() {
        return port;
    }
}
