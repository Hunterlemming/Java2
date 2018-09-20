package filenio;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FileNIO {
    
    public static void main(String[] args) {
        try {
            Configuration conf = Configuration.getInstance();
            System.out.println("name: " + conf.getName());
            System.out.println("IP address: " + conf.getIpAddress());
            System.out.println("port: " + conf.getPort());
        } catch (ConfigException ex) {
            Logger.getLogger(FileNIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
