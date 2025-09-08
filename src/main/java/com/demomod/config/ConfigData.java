package com.demomod.config;

import java.util.ArrayList;

public class ConfigData {
    private static int dfs_limit;
    private static String keybind;
    private static int version;
    private static ArrayList<String> tools;



    public static String getKeybind() {return keybind;}
    public static int dfs_limit(){return dfs_limit;}
    public static int version(){return version;}
    public static ArrayList<String> tools(){return tools;}
}

