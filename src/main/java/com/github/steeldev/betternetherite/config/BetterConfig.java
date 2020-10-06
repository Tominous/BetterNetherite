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

    private final BetterNetherite plugin;
    private FileConfiguration config;
    private File configFile;

    // Config stuff
    public static String PREFIX;
    public static boolean ENABLE_NETHERITE_CRAFTING;
    public static String NETHERITE_UPGRADING_DISABLE_MSG;
    public static boolean IMPROVED_UPGRADING;
    public static String NOT_ENOUGH_INGOTS_MSG;
    public static String UPGRADE_SUCCESS_MSG;
    // Upgrade Recipes
    public static Map<String, Integer> UPGRADE_RECIPES;
    // Ancient Debris Better Smelting
    public static boolean ANCIENT_DEBRIS_BETTER_SMELTING_ENABLED;
    public static int ANCIENT_DEBRIS_BETTER_SMELTING_AMOUNT;
    public static int ANCIENT_DEBRIS_BETTER_SMELTING_BLAST_FURNACE_EXP;
    public static int ANCIENT_DEBRIS_BETTER_SMELTING_BLAST_FURNACE_TIME;
    public static int ANCIENT_DEBRIS_BETTER_SMELTING_FURNACE_EXP;
    public static int ANCIENT_DEBRIS_BETTER_SMELTING_FURNACE_TIME;
    public static boolean ANCIENT_DEBRIS_BETTER_SCRAP_DROP_ENABLED;
    public static int ANCIENT_DEBRIS_BETTER_SCRAP_DROP_MAX;
    public static int ANCIENT_DEBRIS_BETTER_SCRAP_DROP_CHANCE;

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
        PREFIX = config.getString("Prefix");
        ENABLE_NETHERITE_CRAFTING = config.getBoolean("EnableNetheriteCrafting");
        NETHERITE_UPGRADING_DISABLE_MSG = config.getString("NetheriteUpgradingDisabledMsg");
        IMPROVED_UPGRADING = config.getBoolean("ImprovedUpgrading");
        NOT_ENOUGH_INGOTS_MSG = config.getString("NotEnoughIngotsMsg");
        UPGRADE_SUCCESS_MSG = config.getString("UpgradeSuccessMsg");

        ANCIENT_DEBRIS_BETTER_SMELTING_ENABLED = config.getBoolean("AncientDebris.BetterSmelting.Enabled");
        ANCIENT_DEBRIS_BETTER_SMELTING_AMOUNT = config.getInt("AncientDebris.BetterSmelting.Amount");
        ANCIENT_DEBRIS_BETTER_SMELTING_BLAST_FURNACE_EXP = config.getInt("AncientDebris.BetterSmelting.BlastFurnace.EXP");
        ANCIENT_DEBRIS_BETTER_SMELTING_BLAST_FURNACE_TIME = config.getInt("AncientDebris.BetterSmelting.BlastFurnace.Time");
        ANCIENT_DEBRIS_BETTER_SMELTING_FURNACE_EXP = config.getInt("AncientDebris.BetterSmelting.Furnace.EXP");
        ANCIENT_DEBRIS_BETTER_SMELTING_FURNACE_TIME = config.getInt("AncientDebris.BetterSmelting.Furnace.Time");
        ANCIENT_DEBRIS_BETTER_SCRAP_DROP_ENABLED = config.getBoolean("AncientDebris.ScrapDrop.Enabled");
        ANCIENT_DEBRIS_BETTER_SCRAP_DROP_MAX = config.getInt("AncientDebris.ScrapDrop.Maximum");
        ANCIENT_DEBRIS_BETTER_SCRAP_DROP_CHANCE = config.getInt("AncientDebris.ScrapDrop.Chance");

        UPGRADE_RECIPES = new HashMap<>();
        ConfigurationSection section = config.getConfigurationSection("UpgradeRecipes");
        if (section == null) return;
        for (String key : section.getKeys(false)) {
            UPGRADE_RECIPES.put(key, section.getInt(key));
        }
    }

}
