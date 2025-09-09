package com.demomod.config;

import net.minecraft.text.BlockNbtDataSource;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Set;

public class ConfigData implements Serializable {

    private static volatile ConfigData instance;


    public int dfs_limit = 100;
    public String keybind = "undefined";
    public String version = "1.0.0";


    public Set<String> tools = Set.of(
            "minecraft.diamond_pickaxe",
            "minecraft.diamond_sword",
            "minecraft.diamond_axe",
            "minecraft.diamond_shovel",
            "minecraft.diamond_hoe",

            "minecraft.iron_pickaxe",
            "minecraft.iron_sword",
            "minecraft.iron_axe",
            "minecraft.iron_shovel",
            "minecraft.iron_hoe",

            "minecraft.golden_pickaxe",
            "minecraft.golden_sword",
            "minecraft.golden_axe",
            "minecraft.golden_shovel",
            "minecraft.golden_hoe",

            "minecraft.stone_pickaxe",
            "minecraft.stone_sword",
            "minecraft.stone_axe",
            "minecraft.stone_shovel",
            "minecraft.stone_hoe",

            "minecraft.wooden_pickaxe",
            "minecraft.wooden_sword",
            "minecraft.wooden_axe",
            "minecraft.wooden_shovel",
            "minecraft.wooden_hoe",

            "minecraft.shears"

    );

    public static ConfigData getInstance(){
        ConfigData result = instance;
        if(result == null){
            synchronized (ConfigData.class){
                result = instance;
                if(result == null){
                    instance = result = new ConfigData();
                }
            }
        }
        return result;
    }








}

