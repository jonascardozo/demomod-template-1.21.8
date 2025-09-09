package com.demomod.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.junit.jupiter.api.Assertions;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigReader {
    private final Path vein_mine_config_path = Paths.get("vein_mine_config.json");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private ConfigData config = new ConfigData();

    private static ConfigReader instance;

    public static ConfigReader getInstance(){
        if(instance == null){
            instance = new ConfigReader();
        }
        return instance;
    }

//    public ConfigReader(){
//        try{
//            Assertions.assertTrue(Files.exists(vein_mine_config_path));
//
//
//        }
//        catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void loadConfig(){


    }

    public void writeToConfig(){


    }




}