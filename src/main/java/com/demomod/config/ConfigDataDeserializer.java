package com.demomod.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ConfigDataDeserializer implements JsonDeserializer<ConfigData> {


    @Override
    public ConfigData deserialize(@NotNull JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject vein_mine_config_json = json.getAsJsonObject();
        ConfigData.dfs_limit = vein_mine_config_json.get("dfs_limit").getAsInt();
        ConfigData.keybind = vein_mine_config_json.get("keybind").getAsString();
        ConfigData.version = vein_mine_config_json.get("version").getAsInt();

        for(JsonElement tool: vein_mine_config_json.getAsJsonArray("tools")) {
            ConfigData.tools.add(tool.getAsString());
            System.out.println("tool: " + tool.getAsString());
        }
        return null;
    }

}

