package com.github.steeldev.betternetherite;

import com.github.steeldev.betternetherite.commands.admin.BetterNetheriteReload;
import com.github.steeldev.betternetherite.config.BetterConfig;
import com.github.steeldev.betternetherite.config.Lang;
import com.github.steeldev.betternetherite.listeners.blocks.AncientDebris;
import com.github.steeldev.betternetherite.listeners.blocks.SmithingTable;
import com.github.steeldev.betternetherite.listeners.items.ReinforcedItem;
import com.github.steeldev.betternetherite.listeners.shrines.CrimsonShrine;
import com.github.steeldev.betternetherite.listeners.shrines.WarpedShrine;
import com.github.steeldev.betternetherite.managers.RecipeManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BetterNetherite extends JavaPlugin {
    private static final Pattern HEX_PATTERN = Pattern.compile("<#([A-Fa-f0-9]){6}>");
    public static BetterNetherite instance;
    public BetterConfig config = null;
    public Lang lang = null;
    public Random rand = new Random();

    public static BetterNetherite getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        loadCustomConfigs();
        registerCommands();
        registerBlockListeners();
        registerItemListeners();
        RecipeManager.RegisterRecipes();

        getLogger().info(colorize(Lang.ENABLED_MSG.replace("VERSION", getDescription().getVersion())));
    }

    @Override
    public void onDisable() {
        getLogger().info(colorize(Lang.DISABLED_MSG.replace("VERSION", getDescription().getVersion())));
    }

    public void loadCustomConfigs() {
        this.lang = new Lang(this);
        this.config = new BetterConfig(this);
    }

    public void registerCommands() {
        this.getCommand("betternetheritereload").setExecutor(new BetterNetheriteReload());
    }

    public void registerBlockListeners() {
        getServer().getPluginManager().registerEvents(new SmithingTable(), this);
        getServer().getPluginManager().registerEvents(new AncientDebris(), this);

        if(BetterConfig.CRIMSON_NETHERITE_SHRINE_ENABLED)
            getServer().getPluginManager().registerEvents(new CrimsonShrine(), this);
        if(BetterConfig.WARPED_NETHERITE_SHRINE_ENABLED)
            getServer().getPluginManager().registerEvents(new WarpedShrine(), this);
    }

    public void registerItemListeners(){
        if(BetterConfig.CRIMSON_NETHERITE_SHRINE_ENABLED)
            getServer().getPluginManager().registerEvents(new ReinforcedItem(), this);
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

    public String formalizedString(String string){
        String[] itemSplit = string.toLowerCase().split("_");
        StringBuilder finalIt = new StringBuilder();
        for (int i = 0; i < itemSplit.length; i++) {
            finalIt.append(itemSplit[i].substring(0, 1).toUpperCase() + itemSplit[i].substring(1));
            if (i < itemSplit.length - 1)
                finalIt.append(" ");
        }
        return finalIt.toString();
    }
}
