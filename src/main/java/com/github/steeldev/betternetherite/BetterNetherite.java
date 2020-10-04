package com.github.steeldev.betternetherite;

import com.github.steeldev.betternetherite.commands.admin.BetterNetheriteReload;
import com.github.steeldev.betternetherite.listeners.blocks.AncientDebris;
import com.github.steeldev.betternetherite.listeners.blocks.SmithingTable;
import com.github.steeldev.betternetherite.managers.RecipeManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BetterNetherite extends JavaPlugin {
    public static BetterNetherite instance;

    private static final Pattern HEX_PATTERN = Pattern.compile("<#([A-Fa-f0-9]){6}>");

    public FileConfiguration config = null;
    public Random rand = new Random();
    String configPath = getDataFolder() + "/Config.yml";
    public final File configFile = new File(configPath);

    public static BetterNetherite getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        loadCustomConfigs();
        registerCommands();
        registerBlockListeners();
        RecipeManager.RegisterRecipes();

        getLogger().info(colorize("&6Better Netherite &5v" + getDescription().getVersion() + " &2Enabled!"));
    }

    @Override
    public void onDisable() {
        getLogger().info(colorize("&6Better Netherite &5v" + getDescription().getVersion() + " &cDisabled!"));
    }

    public void loadCustomConfigs() {
        if (!configFile.exists())
            saveResource("Config.yml", false);
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void registerCommands() {
        this.getCommand("betternetheritereload").setExecutor(new BetterNetheriteReload());
    }

    public void registerBlockListeners() {
        getServer().getPluginManager().registerEvents(new SmithingTable(), this);
        getServer().getPluginManager().registerEvents(new AncientDebris(), this);
    }

    public String colorize(String string) {
        Matcher matcher = HEX_PATTERN.matcher(string);
        while (matcher.find()) {
            final net.md_5.bungee.api.ChatColor hexColor = net.md_5.bungee.api.ChatColor.of(matcher.group().substring(1, matcher.group().length() - 1));
            final String before = string.substring(0, matcher.start());
            final String after = string.substring(matcher.end());
            string = before + hexColor + after;
            matcher = HEX_PATTERN.matcher(string);
        }
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public boolean chanceOf(int chance) {
        return rand.nextInt(100) < chance;
    }
}
