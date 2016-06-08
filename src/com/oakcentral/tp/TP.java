package com.oakcentral.tp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TP extends JavaPlugin implements Listener {
	
	public final String name = "OakCentralHub";
	
	FileConfiguration config = getConfig();
	
	public void onEnable() {
		Bukkit.getServer().getLogger().info(name + " has been enabled!");
		Bukkit.getPluginManager().registerEvents(this, this);
		
		config.addDefault("TeleportMessage", "Message goes here!");
	    config.options().copyDefaults(true);
	    saveConfig();
	}

	public void onDisable() {
		Bukkit.getServer().getLogger().info(name + " has been disabled!");
	}
	
	@EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
            if (e.getMessage().startsWith("/tp")) {
                    e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("TeleportMessage")));
            }
    }

}
