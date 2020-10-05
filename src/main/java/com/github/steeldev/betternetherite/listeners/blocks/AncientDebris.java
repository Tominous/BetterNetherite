package com.github.steeldev.betternetherite.listeners.blocks;

import com.github.steeldev.betternetherite.BetterNetherite;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class AncientDebris  implements Listener {
    BetterNetherite main = BetterNetherite.getInstance();

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Block block = e.getBlock();
        if(e.isCancelled() ||
                !block.getType().equals(Material.ANCIENT_DEBRIS) ||
                !main.config.getBoolean("AncientDebris.ScrapDrop.Enabled") ||
                block.hasMetadata("PlacedByPlayer"))
            return;
        ItemStack netheriteScrap = new ItemStack(Material.NETHERITE_SCRAP);

        int chance = main.config.getInt("AncientDebris.ScrapDrop.Chance");

        int maxNumber = main.config.getInt("AncientDebris.ScrapDrop.Maximum");
        int randAmount = main.rand.nextInt(maxNumber);
        int amount = (randAmount == 0) ? 1 : randAmount;
        if(amount > 64) amount = 64;

        netheriteScrap.setAmount(amount);
        if (main.chanceOf(chance)) {
            block.getWorld().dropItem(block.getLocation(), netheriteScrap);
            block.getWorld().spawnParticle(Particle.CRIMSON_SPORE, block.getLocation(), 3);
            block.getWorld().playSound(block.getLocation(), Sound.BLOCK_ANCIENT_DEBRIS_FALL, 1, 0.5f);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Block block = e.getBlock();
        //We only want to add this metadata value if the placed block is ancient debris
        //So we dont put metedata on EVERY placed block.
        //This is so people cant farm the extra scrap drops by placing and
        //mining debris over and now, aka abuse the system
        //this value will of course wont persist through a server restart
        //but the players dont have control over restarts
        if(e.isCancelled() ||
                !block.getType().equals(Material.ANCIENT_DEBRIS))
            return;

        block.setMetadata("PlacedByPlayer", new FixedMetadataValue(main, true));
    }
}
