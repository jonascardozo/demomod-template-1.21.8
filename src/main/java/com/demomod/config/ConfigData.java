package com.demomod.config;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;

public class ConfigData implements Serializable {
    public static int dfs_limit;
    public static String keybind;
    public static int version;
    public static ArrayList<String> tools;



    public String getKeybind() {return keybind;}
    public int dfs_limit(){return dfs_limit;}
    public int version(){return version;}
    public ArrayList<String> tools(){return tools;}
}

