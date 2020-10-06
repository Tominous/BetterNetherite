package com.github.steeldev.betternetherite.commands.admin;

import com.github.steeldev.betternetherite.BetterNetherite;
import com.github.steeldev.betternetherite.config.BetterConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BetterNetheriteReload implements CommandExecutor {
    final BetterNetherite main = BetterNetherite.getInstance();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        main.loadCustomConfigs();
        commandSender.sendMessage(main.colorize(String.format("%s&aSuccessfully reloaded configurations!", BetterConfig.PREFIX)));
        commandSender.sendMessage(main.colorize("&7&oPlease note, most features require a server restart to fully apply! (Mainly crafting/smelting related features)"));
        return true;
    }
}
