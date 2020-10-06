package com.github.steeldev.betternetherite.config;

import com.github.steeldev.betternetherite.BetterNetherite;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BetterConfig {

    // Config stuff
    public static boolean DEBUG;
    public static boolean ENABLE_NETHERITE_CRAFTING;
    public static boolean IMPROVED_UPGRADING;
    // Upgrade Recipes
    public static Map<String, Integer> UPGRADE_RECIPES;
    // Ancient Debris Better Smelting
    public static boolean ANCIENT_DEBRIS_BETTER_SMELTING_ENABLED;
    public static int ANCIENT_DEBRIS_BETTER_SMELTING_AMOUNT;
    public static int ANCIENT_DEBRIS_BETTER_SMELTING_BLAST_FURNACE_EXP;
    public static int ANCIENT_DEBRIS_BETTER_SMELTING_BLAST_FURNACE_TIME;
    public static int ANCIENT_DEBRIS_BETTER_SMELTING_FURNACE_EXP;
    public static int ANCIENT_DEBRIS_BETTER_SMELTING_FURNACE_TIME;
    // Ancient Debris Scrap Drop
    public static boolean ANCIENT_DEBRIS_SCRAP_DROP_ENABLED;
    public static int ANCIENT_DEBRIS_SCRAP_DROP_MAX;
    public static int ANCIENT_DEBRIS_SCRAP_DROP_CHANCE;
    // Ancient Debris Ingot Drop
    public static boolean ANCIENT_DEBRIS_INGOT_DROP_ENABLED;
    public static int ANCIENT_DEBRIS_INGOT_DROP_CHANCE;
    private final BetterNetherite plugin;
    private FileConfiguration config;
    private File configFile;

    public BetterConfig(BetterNetherite plugin) {
        this.plugin = plugin;
        loadConfigFile();
    }

    private void loadConfigFile() {
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), "Config.yml");
        }
        if (!configFile.exists()) {
            plugin.saveResource("Config.yml", false);
        }
        config = YamlConfiguration.loadConfiguration(configFile);
        matchConfig();
        loadConfigs();
    }

    // Used to update config
    @SuppressWarnings("ConstantConditions")
    private void matchConfig() {
        try {
            boolean hasUpdated = false;
            InputStream stream = plugin.getResource(configFile.getName());
            assert stream != null;
            InputStreamReader is = new InputStreamReader(stream);
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(is);
            for (String key : defConfig.getConfigurationSection("").getKeys(true)) {
                if (!config.contains(key)) {
                    config.set(key, defConfig.get(key));
                    hasUpdated = true;
                }
            }
            for (String key : config.getConfigurationSection("").getKeys(true)) {
                if (!defConfig.contains(key)) {
                    config.set(key, null);
                    hasUpdated = true;
                }
            }
            if (hasUpdated)
                config.save(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadConfigs() {
        DEBUG = config.getBoolean("Debug");
        ENABLE_NETHERITE_CRAFTING = config.getBoolean("EnableNetheriteCrafting");
        IMPROVED_UPGRADING = config.getBoolean("ImprovedUpgrading");
        ANCIENT_DEBRIS_BETTER_SMELTING_ENABLED = config.getBoolean("AncientDebris.BetterSmelting.Enabled");
        ANCIENT_DEBRIS_BETTER_SMELTING_AMOUNT = config.getInt("AncientDebris.BetterSmelting.Amount");
        ANCIENT_DEBRIS_BETTER_SMELTING_BLAST_FURNACE_EXP = config.getInt("AncientDebris.BetterSmelting.BlastFurnace.EXP");
        ANCIENT_DEBRIS_BETTER_SMELTING_BLAST_FURNACE_TIME = config.getInt("AncientDebris.BetterSmelting.BlastFurnace.Time");
        ANCIENT_DEBRIS_BETTER_SMELTING_FURNACE_EXP = config.getInt("AncientDebris.BetterSmelting.Furnace.EXP");
        ANCIENT_DEBRIS_BETTER_SMELTING_FURNACE_TIME = config.getInt("AncientDebris.BetterSmelting.Furnace.Time");
        ANCIENT_DEBRIS_SCRAP_DROP_ENABLED = config.getBoolean("AncientDebris.ScrapDrop.Enabled");
        ANCIENT_DEBRIS_SCRAP_DROP_MAX = config.getInt("AncientDebris.ScrapDrop.Maximum");
        ANCIENT_DEBRIS_SCRAP_DROP_CHANCE = config.getInt("AncientDebris.ScrapDrop.Chance");
        ANCIENT_DEBRIS_INGOT_DROP_ENABLED = config.getBoolean("AncientDebris.IngotDrop.Enabled");
        ANCIENT_DEBRIS_INGOT_DROP_CHANCE = config.getInt("AncientDebris.IngotDrop.Chance");
        UPGRADE_RECIPES = new HashMap<>();
        ConfigurationSection section = config.getConfigurationSection("UpgradeRecipes");
        if (section == null) return;
        for (String key : section.getKeys(false)) {
            UPGRADE_RECIPES.put(key, section.getInt(key));
        }
    }
}
