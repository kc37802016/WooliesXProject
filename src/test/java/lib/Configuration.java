package test.java.lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private Properties config;
    private String basepath = "\\src\\test\\resources\\config\\";
    private String sysPath = basepath + "profiles\\";

    public Configuration() {
        initConfig();
        loadRunConfig();
    }

    public void loadRunConfig(){
        try{
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + sysPath + "default.properties");
        Properties config = new Properties();
        config.load(fs);
        this.config = config;
        }catch (IOException e) {
        }

    }

    private void initConfig() {
        loadRunConfig();
    }

    public String getProperty(String propertyName) {
        return config.getProperty(propertyName);
    }
}
