package com.github.steeldev.betternetherite.managers;

import com.github.steeldev.betternetherite.BetterNetherite;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

import java.util.Iterator;

public class RecipeManager {

    final static BetterNetherite main = BetterNetherite.getInstance();

    public static void RegisterRecipes(){
        if (main.config.getBoolean("EnableNetheriteCrafting") && !main.config.getBoolean("ImprovedUpgrading"))
            registerNetheriteItems();
        if (main.config.getBoolean("AncientDebris.BetterSmelting.Enabled"))
            registerBetterNetheriteScrapSmelting();
    }

    static  void registerNetheriteItems(){
        //
        //NETHERITE SWORD
        //
        removeRecipe("minecraft:netherite_sword");
        ItemStack netheriteSword = new ItemStack(Material.NETHERITE_SWORD);
        NamespacedKey netheriteSwordKey = new NamespacedKey(main, "netherite_sword");
        ShapedRecipe netheriteSwordRec = new ShapedRecipe(netheriteSwordKey, netheriteSword);
        netheriteSwordRec.shape(" N ", " N ", " S ");
        netheriteSwordRec.setIngredient('S', Material.STICK);
        netheriteSwordRec.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(netheriteSwordRec);
        //
        //NETHERITE AXE
        //
        removeRecipe("minecraft:netherite_axe");
        ItemStack netheriteAxe = new ItemStack(Material.NETHERITE_AXE);
        NamespacedKey netheriteAxeKey = new NamespacedKey(main, "netherite_axe");
        ShapedRecipe netheriteAxeRec = new ShapedRecipe(netheriteAxeKey, netheriteAxe);
        netheriteAxeRec.shape("NN ", "NS ", " S ");
        netheriteAxeRec.setIngredient('S', Material.STICK);
        netheriteAxeRec.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(netheriteAxeRec);
        //
        //NETHERITE SHOVEL
        //
        removeRecipe("minecraft:netherite_shovel");
        ItemStack netheriteShovel = new ItemStack(Material.NETHERITE_SHOVEL);
        NamespacedKey netheriteShovelKey = new NamespacedKey(main, "netherite_shovel");
        ShapedRecipe netheriteShovelRec = new ShapedRecipe(netheriteShovelKey, netheriteShovel);
        netheriteShovelRec.shape(" N ", " S ", " S ");
        netheriteShovelRec.setIngredient('S', Material.STICK);
        netheriteShovelRec.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(netheriteShovelRec);
        //
        //NETHERITE PICKAXE
        //
        removeRecipe("minecraft:netherite_pickaxe");
        ItemStack netheritePickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
        NamespacedKey netheritePickaxeKey = new NamespacedKey(main, "netherite_pickaxe");
        ShapedRecipe netheritePickaxeRec = new ShapedRecipe(netheritePickaxeKey, netheritePickaxe);
        netheritePickaxeRec.shape("NNN", " S ", " S ");
        netheritePickaxeRec.setIngredient('S', Material.STICK);
        netheritePickaxeRec.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(netheritePickaxeRec);
        //
        //NETHERITE SICKLE (HOE)
        //
        removeRecipe("minecraft:netherite_hoe");
        ItemStack netheriteHoe = new ItemStack(Material.NETHERITE_HOE);
        NamespacedKey netheriteHoeKey = new NamespacedKey(main, "netherite_sickle");
        ShapedRecipe netheriteHoeRec = new ShapedRecipe(netheriteHoeKey, netheriteHoe);
        netheriteHoeRec.shape("NN ", " S ", " S ");
        netheriteHoeRec.setIngredient('S', Material.STICK);
        netheriteHoeRec.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(netheriteHoeRec);
        //
        //NETHERITE HELMET
        //
        removeRecipe("minecraft:netherite_helmet");
        ItemStack netheriteHelmet = new ItemStack(Material.NETHERITE_HELMET);
        NamespacedKey netheriteHelmetKey = new NamespacedKey(main, "netherite_helmet");
        ShapedRecipe netheriteHelmetRec = new ShapedRecipe(netheriteHelmetKey, netheriteHelmet);
        netheriteHelmetRec.shape("NNN", "N N", "   ");
        netheriteHelmetRec.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(netheriteHelmetRec);
        //
        //NETHERITE CHESTPLATE
        //
        removeRecipe("minecraft:netherite_chestplate");
        ItemStack netheriteChestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
        NamespacedKey netheriteChestplateKey = new NamespacedKey(main, "netherite_chestplate");
        ShapedRecipe netheriteChestplateRec = new ShapedRecipe(netheriteChestplateKey, netheriteChestplate);
        netheriteChestplateRec.shape("N N", "NNN", "NNN");
        netheriteChestplateRec.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(netheriteChestplateRec);
        //
        //NETHERITE LEGGINGS
        //
        removeRecipe("minecraft:netherite_leggings");
        ItemStack netheriteLeggings = new ItemStack(Material.NETHERITE_LEGGINGS);
        NamespacedKey netheriteLeggingsKey = new NamespacedKey(main, "netherite_leggings");
        ShapedRecipe netheriteLeggingsRec = new ShapedRecipe(netheriteLeggingsKey, netheriteLeggings);
        netheriteLeggingsRec.shape("NNN", "N N", "N N");
        netheriteLeggingsRec.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(netheriteLeggingsRec);
        //
        //NETHERITE BOOTS
        //
        removeRecipe("minecraft:netherite_boots");
        ItemStack netheriteBoots = new ItemStack(Material.NETHERITE_BOOTS);
        NamespacedKey netheriteBootsKey = new NamespacedKey(main, "netherite_boots");
        ShapedRecipe netheriteBootsRec = new ShapedRecipe(netheriteBootsKey, netheriteBoots);
        netheriteBootsRec.shape("   ", "N N", "N N");
        netheriteBootsRec.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(netheriteBootsRec);
    }

    static void registerBetterNetheriteScrapSmelting(){
        //
        //NETHERITE SCRAP BLASTING
        //
        removeRecipe("minecraft:netherite_scrap");
        removeRecipe("minecraft:netherite_scrap_from_blasting");
        int amount = main.config.getInt("AncientDebris.BetterSmelting.Amount");
        if(amount > 64) amount = 64;
        if(amount < 1) amount = 1;

        int blastEXP = main.config.getInt("AncientDebris.BetterSmelting.BlastFurnace.EXP");
        int blastTime = main.config.getInt("AncientDebris.BetterSmelting.BlastFurnace.Time");

        int normEXP = main.config.getInt("AncientDebris.BetterSmelting.Furnace.EXP");
        int normTime = main.config.getInt("AncientDebris.BetterSmelting.Furnace.Time");

        ItemStack netheriteScrap = new ItemStack(Material.NETHERITE_SCRAP, amount);

        NamespacedKey netheriteScrapBlastKey = new NamespacedKey(main, "netherite_scrap_from_blasting");
        BlastingRecipe netheriteScrapBlastRec = new BlastingRecipe(netheriteScrapBlastKey, netheriteScrap, Material.ANCIENT_DEBRIS, blastEXP, blastTime);
        Bukkit.addRecipe(netheriteScrapBlastRec);

        NamespacedKey netheriteScrapSmeltKey = new NamespacedKey(main, "netherite_scrap");
        FurnaceRecipe netheriteScrapSmeltRec = new FurnaceRecipe(netheriteScrapSmeltKey, netheriteScrap, Material.ANCIENT_DEBRIS, normEXP, normTime);
        Bukkit.addRecipe(netheriteScrapSmeltRec);
    }

    public static void removeRecipe(String key) {
        Iterator<Recipe> it = Bukkit.recipeIterator();
        while (it.hasNext()) {
            Recipe rec = it.next();
            if (rec != null) {
                if (((Keyed) rec).getKey().toString().equals(key)) {
                    main.getLogger().info(main.colorize("&aRecipe for &e" + key + " &ahas been &cremoved!"));
                    it.remove();
                }
            }
        }
    }
}
