package me.tomjw64.HungerBarGames.Managers;

import java.io.File;
import java.io.IOException;

import me.tomjw64.HungerBarGames.HungerBarGames;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;

public class ConfigManager {
	/*
	 * ConfigManager creates a config file for the plugin.
	 * Plugin preferences and options are set in this file.
	 * This file will be edited by the user in almost all cases.
	 */
	private static File configFile;
	private static FileConfiguration config;
	
	//Call onEnable for initialization
	public static void loadConfig(HungerBarGames pl)
	{
		PluginDescriptionFile pdf=pl.getDescription();
		//Naming the file
		configFile=new File(pl.getDataFolder(),"config.yml");
		//Create if it doesn't exist
		if(!configFile.exists())
		{
			configFile.getParentFile().mkdirs();
			try {
				configFile.createNewFile();
				HungerBarGames.logger.info("["+pdf.getName()+"] Generating config!");
			} catch (IOException wtf){
				wtf.printStackTrace();
			}
		}
		//Actually loading the file
		config=new YamlConfiguration();
		try {
			config.load(configFile);
			HungerBarGames.logger.info("["+pdf.getName()+"] Loading config!");
		} catch (Exception wtf) {
			wtf.printStackTrace();
		}
	}
	//Get the config
	public static FileConfiguration getConfig()
	{
		return config;
	}
	//Save config
	public static void saveConfig()
	{
		try {
			config.save(configFile);
		} catch (IOException wtf) {
			wtf.printStackTrace();
		}
	}
}
