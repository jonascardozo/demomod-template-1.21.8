package com.demomod.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;


public class ConfigReader {
    private final Path vein_mine_config_path = Paths.get("config/vein_mine_config.json");
    private final Gson jsonLoader = new GsonBuilder().setPrettyPrinting().create();
    private ConfigData configData;
    public static final Logger LOGGER =  LogManager.getLogger("demomod");




    public ConfigReader(){
        try {
            Files.createDirectories(vein_mine_config_path.getParent());

            if (!Files.exists(vein_mine_config_path)) {
               writeToConfig();
            }
            loadConfig();
        }
        catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void loadConfig(){
        try(Reader read = Files.newBufferedReader(vein_mine_config_path)){
            ConfigData config = jsonLoader.fromJson(read, ConfigData.class);

            if(config != null){
                this.configData = config;
                System.out.println("wip");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void writeToConfig(){
        try(Writer writer = Files.newBufferedWriter(vein_mine_config_path)){
            jsonLoader.toJson(configData, writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public ConfigData getConfigData(){
        return configData;
    }




}