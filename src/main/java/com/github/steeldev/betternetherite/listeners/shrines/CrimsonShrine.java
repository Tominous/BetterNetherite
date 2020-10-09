package com.github.steeldev.betternetherite.listeners.shrines;

import com.github.steeldev.betternetherite.BetterNetherite;
import com.github.steeldev.betternetherite.config.BetterConfig;
import com.github.steeldev.betternetherite.config.Lang;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrimsonShrine implements Listener {

    BetterNetherite main = BetterNetherite.getInstance();

    @EventHandler
    public void onCrimsonShrineClick(PlayerInteractEvent e) {
        // Could REALLY use improvements, but I feel like ass as I'm writing this, so deal with it.
        Player p = e.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        Block clickedBlock = e.getClickedBlock();
        boolean correct = false;
        if (!BetterConfig.CRIMSON_NETHERITE_SHRINE_ENABLED ||
                e.getAction() != Action.RIGHT_CLICK_BLOCK ||
                clickedBlock == null ||
                item.getType() == Material.AIR ||
                e.getHand() != EquipmentSlot.HAND ||
                e.isCancelled())
            return;
        
        if (clickedBlock.getType().equals(Material.CRIMSON_STEM)) {
            Block crimsonFence = clickedBlock.getRelative(0, -1, 0);
            if (crimsonFence.getType().equals(Material.CRIMSON_FENCE)) {
                Block cryingObsidian = crimsonFence.getRelative(0, -1, 0);
                if (cryingObsidian.getType().equals(Material.CRYING_OBSIDIAN)) {
                    e.setCancelled(true);
                    Block polishedBlackstone1 = cryingObsidian.getRelative(0, 0, 1);
                    Block polishedBlackstone2 = cryingObsidian.getRelative(0, 0, -1);
                    Block polishedBlackstone3 = cryingObsidian.getRelative(-1, 0, 0);
                    Block polishedBlackstone4 = cryingObsidian.getRelative(1, 0, 0);
                    if (polishedBlackstone1.getType().equals(Material.POLISHED_BLACKSTONE) &&
                            polishedBlackstone2.getType().equals(Material.POLISHED_BLACKSTONE) &&
                            polishedBlackstone3.getType().equals(Material.POLISHED_BLACKSTONE) &&
                            polishedBlackstone4.getType().equals(Material.POLISHED_BLACKSTONE)) {
                        Block magmaBlock1 = polishedBlackstone4.getRelative(0, 0, 1);
                        Block magmaBlock2 = polishedBlackstone4.getRelative(0, 0, -1);
                        Block magmaBlock3 = polishedBlackstone3.getRelative(0, 0, 1);
                        Block magmaBlock4 = polishedBlackstone3.getRelative(0, 0, -1);
                        if (magmaBlock1.getType().equals(Material.MAGMA_BLOCK) &&
                                magmaBlock2.getType().equals(Material.MAGMA_BLOCK) &&
                                magmaBlock3.getType().equals(Material.MAGMA_BLOCK) &&
                                magmaBlock4.getType().equals(Material.MAGMA_BLOCK)) {
                            Block netheriteBlock1 = magmaBlock1.getRelative(0, 0, 1);
                            Block netheriteBlock2 = magmaBlock1.getRelative(1, 0, 0);
                            Block netheriteBlock3 = magmaBlock2.getRelative(0, 0, -1);
                            Block netheriteBlock4 = magmaBlock2.getRelative(1, 0, 0);
                            Block netheriteBlock5 = magmaBlock3.getRelative(0, 0, 1);
                            Block netheriteBlock6 = magmaBlock3.getRelative(-1, 0, 0);
                            Block netheriteBlock7 = magmaBlock4.getRelative(0, 0, -1);
                            Block netheriteBlock8 = magmaBlock4.getRelative(-1, 0, 0);
                            if (netheriteBlock1.getType().equals(Material.NETHERITE_BLOCK) &&
                                    netheriteBlock2.getType().equals(Material.NETHERITE_BLOCK) &&
                                    netheriteBlock3.getType().equals(Material.NETHERITE_BLOCK) &&
                                    netheriteBlock4.getType().equals(Material.NETHERITE_BLOCK) &&
                                    netheriteBlock5.getType().equals(Material.NETHERITE_BLOCK) &&
                                    netheriteBlock6.getType().equals(Material.NETHERITE_BLOCK) &&
                                    netheriteBlock7.getType().equals(Material.NETHERITE_BLOCK) &&
                                    netheriteBlock8.getType().equals(Material.NETHERITE_BLOCK)) {
                                Block blackstone1 = netheriteBlock1.getRelative(-1, 0, 0);
                                Block blackstone2 = netheriteBlock5.getRelative(-1, 0, 0);
                                Block blackstone3 = netheriteBlock6.getRelative(0, 0, -1);
                                Block blackstone4 = netheriteBlock8.getRelative(0, 0, -1);
                                Block blackstone5 = netheriteBlock7.getRelative(1, 0, 0);
                                Block blackstone6 = netheriteBlock3.getRelative(1, 0, 0);
                                Block blackstone7 = netheriteBlock4.getRelative(0, 0, 1);
                                Block blackstone8 = netheriteBlock2.getRelative(0, 0, 1);
                                if (blackstone1.getType().equals(Material.BLACKSTONE) &&
                                        blackstone2.getType().equals(Material.BLACKSTONE) &&
                                        blackstone3.getType().equals(Material.BLACKSTONE) &&
                                        blackstone4.getType().equals(Material.BLACKSTONE) &&
                                        blackstone5.getType().equals(Material.BLACKSTONE) &&
                                        blackstone6.getType().equals(Material.BLACKSTONE) &&
                                        blackstone7.getType().equals(Material.BLACKSTONE) &&
                                        blackstone8.getType().equals(Material.BLACKSTONE)) {
                                    Block chain1 = netheriteBlock1.getRelative(0, 1, 0);
                                    Block chain2 = netheriteBlock2.getRelative(0, 1, 0);
                                    Block chain3 = netheriteBlock3.getRelative(0, 1, 0);
                                    Block chain4 = netheriteBlock4.getRelative(0, 1, 0);
                                    Block chain5 = netheriteBlock5.getRelative(0, 1, 0);
                                    Block chain6 = netheriteBlock6.getRelative(0, 1, 0);
                                    Block chain7 = netheriteBlock7.getRelative(0, 1, 0);
                                    Block chain8 = netheriteBlock8.getRelative(0, 1, 0);
                                    if (chain1.getType().equals(Material.CHAIN) &&
                                            chain2.getType().equals(Material.CHAIN) &&
                                            chain3.getType().equals(Material.CHAIN) &&
                                            chain4.getType().equals(Material.CHAIN) &&
                                            chain5.getType().equals(Material.CHAIN) &&
                                            chain6.getType().equals(Material.CHAIN) &&
                                            chain7.getType().equals(Material.CHAIN) &&
                                            chain8.getType().equals(Material.CHAIN)) {
                                        Block chargeMat1 = chain1.getRelative(0, 1, 0);
                                        Block chargeMat2 = chain2.getRelative(0, 1, 0);
                                        Block chargeMat3 = chain3.getRelative(0, 1, 0);
                                        Block chargeMat4 = chain4.getRelative(0, 1, 0);
                                        Block chargeMat5 = chain5.getRelative(0, 1, 0);
                                        Block chargeMat6 = chain6.getRelative(0, 1, 0);
                                        Block chargeMat7 = chain7.getRelative(0, 1, 0);
                                        Block chargeMat8 = chain8.getRelative(0, 1, 0);

                                        List<Block> charges = new ArrayList<>(Arrays.asList(
                                                chargeMat6,
                                                chargeMat5,
                                                chargeMat1,
                                                chargeMat2,
                                                chargeMat4,
                                                chargeMat3,
                                                chargeMat7,
                                                chargeMat8));
                                        correct = true;
                                        int chargesLeft = 0;
                                        for (Block charge : charges) {
                                            if (charge.getType().equals(BetterConfig.CRIMSON_NETHERITE_SHRINE_CHARGE_MAT)) {
                                                chargesLeft++;
                                            }
                                        }
                                        if (chargesLeft > 0) {
                                            if (!BetterConfig.USABLE_SHRINE_ITEMS.containsKey(item.getType().toString())) {
                                                p.sendMessage(main.colorize(Lang.PREFIX + Lang.SHRINE_INVALID_ITEM_MSG.replaceAll("SHRINE", BetterConfig.CRIMSON_NETHERITE_SHRINE_DISPLAY)));
                                                return;
                                            }
                                            NBTItem nbtItem = new NBTItem(item);
                                            if (nbtItem.hasKey("netherite_reinforced")) {
                                                if (nbtItem.getBoolean("netherite_reinforced")) {
                                                    p.sendMessage(main.colorize(Lang.PREFIX + Lang.SHRINE_ITEM_ALREADY_EFFECTED_MSG.replaceAll("EFFECT", BetterConfig.CRIMSON_NETHERITE_SHRINE_EFFECT_DISPLAY)));
                                                    return;
                                                }
                                            }
                                            nbtItem.addCompound("netherite_reinforced");
                                            nbtItem.setBoolean("netherite_reinforced", true);
                                            item = nbtItem.getItem();
                                            ItemMeta meta = (item.getItemMeta() == null) ? Bukkit.getItemFactory().getItemMeta(item.getType()) : item.getItemMeta();
                                            List<String> curLore = (meta.getLore() == null) ? new ArrayList<>() : meta.getLore();
                                            curLore.add(main.colorize("&b&lREINFORCED"));
                                            meta.setLore(curLore);
                                            item.setItemMeta(meta);
                                            p.getInventory().setItemInMainHand(item);

                                            chargesLeft--;
                                            charges.get(chargesLeft).setType(Material.AIR);
                                            p.getWorld().strikeLightning(clickedBlock.getLocation());
                                            p.getWorld().spawnParticle(Particle.FLAME, charges.get(chargesLeft).getLocation(), 5);
                                            p.getWorld().playSound(charges.get(chargesLeft).getLocation(), Sound.BLOCK_REDSTONE_TORCH_BURNOUT, 1.5f, 1.5f);
                                            p.getWorld().playSound(clickedBlock.getLocation(), Sound.BLOCK_ANVIL_USE, 1.6f, 1.6f);
                                            if (chargesLeft < 3) {
                                                String chargeMat = main.formalizedString(BetterConfig.CRIMSON_NETHERITE_SHRINE_CHARGE_MAT.toString());
                                                p.sendMessage(main.colorize(Lang.PREFIX + Lang.SHRINE_CHARGES_LOW_MSG.replaceAll("CHARGEMAT", chargeMat)));
                                            } else {
                                                p.sendMessage(main.colorize(Lang.PREFIX + Lang.SHRINE_CHARGES_MSG.replaceAll("CHARGESAVAILABLE", String.valueOf(chargesLeft))));
                                            }

                                            if (chargesLeft < 1) {
                                                if (main.chanceOf(BetterConfig.CRIMSON_NETHERITE_SHRINE_EXPLODE_CHANCE)) {
                                                    p.getWorld().playSound(clickedBlock.getLocation(), Sound.BLOCK_ANVIL_BREAK, 1.6f, 1.6f);
                                                    p.getWorld().strikeLightning(clickedBlock.getLocation());
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            p.getWorld().strikeLightning(clickedBlock.getLocation());
                                                        }
                                                    }, 10);
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            p.getWorld().strikeLightning(clickedBlock.getLocation());
                                                            p.getWorld().createExplosion(clickedBlock.getLocation(), 8, true);
                                                        }
                                                    }, 5);
                                                } else {
                                                    p.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, clickedBlock.getLocation(), 2);
                                                    p.getWorld().playEffect(clickedBlock.getLocation(), Effect.ZOMBIE_DESTROY_DOOR, 2);
                                                    clickedBlock.setType(Material.AIR);
                                                }
                                            }
                                            p.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, clickedBlock.getLocation(), 2);
                                            p.sendMessage(main.colorize(Lang.PREFIX + Lang.SHRINE_USED_MSG.replaceAll("SHRINE", BetterConfig.CRIMSON_NETHERITE_SHRINE_DISPLAY).replaceAll("EFFECT", BetterConfig.CRIMSON_NETHERITE_SHRINE_EFFECT_DISPLAY)));
                                        } else {
                                            String chargeMat = main.formalizedString(BetterConfig.CRIMSON_NETHERITE_SHRINE_CHARGE_MAT.toString());
                                            p.getWorld().playSound(clickedBlock.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 1.6f, 1.6f);
                                            p.sendMessage(main.colorize(Lang.PREFIX + Lang.SHRINE_NO_CHARGES_MSG.replaceAll("SHRINE", BetterConfig.CRIMSON_NETHERITE_SHRINE_DISPLAY).replaceAll("CHARGEMAT", chargeMat)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!correct) {
                p.sendMessage(main.colorize(Lang.PREFIX + Lang.SHRINE_BUILT_INCORRECT_MSG.replaceAll("SHRINE", BetterConfig.CRIMSON_NETHERITE_SHRINE_DISPLAY)));
            }
        }
    }
}
