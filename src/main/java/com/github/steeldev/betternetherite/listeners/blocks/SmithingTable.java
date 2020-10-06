package com.github.steeldev.betternetherite.listeners.blocks;

import com.github.steeldev.betternetherite.BetterNetherite;
import com.github.steeldev.betternetherite.config.BetterConfig;
import com.github.steeldev.betternetherite.config.Lang;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class SmithingTable implements Listener {
    BetterNetherite main = BetterNetherite.getInstance();

    @EventHandler
    public void useSmithingTable(PlayerInteractEvent e) {
        if (!BetterConfig.ENABLE_NETHERITE_CRAFTING) return;
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        Block b = e.getClickedBlock();
        if (b == null) return;
        Player p = e.getPlayer();
        if (b.getType().equals(Material.SMITHING_TABLE)) {
            e.setCancelled(true);
            p.sendMessage(main.colorize(String.format("%s%s", Lang.PREFIX, Lang.NETHERITE_UPGRADING_DISABLE_MSG)));
        }
    }

    @EventHandler
    public void smithingTableClick(InventoryClickEvent e) {
        //definitely in need of improvements, i cant be fucked right now, so, deal with it :p
        if (!BetterConfig.IMPROVED_UPGRADING) return;

        Player p = (Player) e.getWhoClicked();
        if (p.getOpenInventory().getTitle().contains(main.colorize("Upgrade Gear"))) {
            ItemStack slot0Item = p.getOpenInventory().getItem(0);
            ItemStack slot1Item = p.getOpenInventory().getItem(1);
            ItemStack slot2Item = p.getOpenInventory().getItem(2);
            Map<String, Integer> upgradeRecipes = BetterConfig.UPGRADE_RECIPES;

            if (e.getSlot() != 2 ||
                    slot0Item == null ||
                    slot1Item == null ||
                    slot2Item == null ||
                    slot0Item.getType() == Material.AIR ||
                    slot2Item.getType() == Material.AIR ||
                    slot1Item.getType() != Material.NETHERITE_INGOT ||
                    upgradeRecipes == null ||
                    !upgradeRecipes.containsKey(String.valueOf(slot0Item.getType())))
                return;

            int ingotAmount = upgradeRecipes.get(String.valueOf(slot0Item.getType()));

            String[] itemSplit = slot0Item.getType().toString().toLowerCase().split("_");
            StringBuilder finalIt = new StringBuilder();
            for (int i = 0; i < itemSplit.length; i++) {
                finalIt.append(itemSplit[i].substring(0, 1).toUpperCase() + itemSplit[i].substring(1));
                if (i < itemSplit.length - 1)
                    finalIt.append(" ");
            }
            String notEnoughIngotsMsg = Lang.NOT_ENOUGH_INGOTS_MSG.replaceAll("AMOUNT", String.valueOf(ingotAmount)).replaceAll("ITEM", finalIt.toString());
            String upgradeSuccessMsg = Lang.UPGRADE_SUCCESS_MSG.replaceAll("AMOUNT", String.valueOf(ingotAmount)).replaceAll("ITEM", finalIt.toString());

            if (slot1Item.getAmount() < ingotAmount) {
                e.setCancelled(true);
                p.sendMessage(main.colorize(String.format("%s%s", Lang.PREFIX, notEnoughIngotsMsg)));
            } else {
                slot1Item.setAmount(slot1Item.getAmount() - (ingotAmount - 1));
                p.sendMessage(main.colorize(String.format("%s%s", Lang.PREFIX, upgradeSuccessMsg)));
            }
        }
    }
}
