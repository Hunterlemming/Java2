package filenio;

import java.io.IOException;

public class ConfigException extends Exception {

    public ConfigException(IOException ex) {
        super(ex);
    }
    
}
