package com.demomod.config;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigReader {
    static final Gson GSON = new Gson();
    public static void of(Path path) {

        Path file_path = Paths.get("config/vein_mine_config.json");
        JsonReader reader;
        {
            try {
                reader = new JsonReader(new FileReader(file_path.toString()));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void loadConfig(JsonReader reader){
        GSON.fromJson(reader, ConfigData.class);
    }








}