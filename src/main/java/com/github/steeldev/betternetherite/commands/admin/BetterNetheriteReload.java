package com.github.steeldev.betternetherite.commands.admin;

import com.github.steeldev.betternetherite.BetterNetherite;
import com.github.steeldev.betternetherite.config.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BetterNetheriteReload implements CommandExecutor {
    final BetterNetherite main = BetterNetherite.getInstance();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        main.loadCustomConfigs();
        commandSender.sendMessage(main.colorize(String.format("%s%s", Lang.PREFIX, Lang.RELOAD_MSG)));
        return true;
    }
}
