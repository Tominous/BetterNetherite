package com.github.steeldev.betternetherite.managers;

import com.github.steeldev.betternetherite.BetterNetherite;
import com.github.steeldev.betternetherite.config.BetterConfig;
import com.github.steeldev.betternetherite.config.Lang;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

import java.util.Iterator;

public class RecipeManager {

    final static BetterNetherite main = BetterNetherite.getInstance();

    public static void RegisterRecipes() {
        if (BetterConfig.ENABLE_NETHERITE_CRAFTING &&
                !BetterConfig.IMPROVED_UPGRADING)
            registerNetheriteItems();
        if(BetterConfig.IMPROVED_UPGRADING &&
                !BetterConfig.ENABLE_NETHERITE_CRAFTING)
            registerImprovedUpgradingSmithingTableItems();
        if (BetterConfig.ANCIENT_DEBRIS_BETTER_SMELTING_ENABLED)
            registerBetterNetheriteScrapSmelting();
    }

    static void registerImprovedUpgradingSmithingTableItems(){
        // Wood to Stone
        addSmithingRecipe("wood_to_stone_sword_smithing",
                new ItemStack(Material.STONE_SWORD),
                Material.WOODEN_SWORD,
                new ItemStack(Material.COBBLESTONE));
        addSmithingRecipe("wood_to_stone_axe_smithing",
                new ItemStack(Material.STONE_AXE),
                Material.WOODEN_AXE,
                new ItemStack(Material.COBBLESTONE));
        addSmithingRecipe("wood_to_stone_shovel_smithing",
                new ItemStack(Material.STONE_SHOVEL),
                Material.WOODEN_SHOVEL,
                new ItemStack(Material.COBBLESTONE));
        addSmithingRecipe("wood_to_stone_hoe_smithing",
                new ItemStack(Material.STONE_HOE),
                Material.WOODEN_HOE,
                new ItemStack(Material.COBBLESTONE));
        addSmithingRecipe("wood_to_stone_pickaxe_smithing",
                new ItemStack(Material.STONE_PICKAXE),
                Material.WOODEN_PICKAXE,
                new ItemStack(Material.COBBLESTONE));
        
        // Stone to Iron
        addSmithingRecipe("stone_to_iron_sword_smithing",
                new ItemStack(Material.IRON_SWORD),
                Material.STONE_SWORD,
                new ItemStack(Material.IRON_INGOT));
        addSmithingRecipe("stone_to_iron_axe_smithing",
                new ItemStack(Material.IRON_AXE),
                Material.STONE_AXE,
                new ItemStack(Material.IRON_INGOT));
        addSmithingRecipe("stone_to_iron_shovel_smithing",
                new ItemStack(Material.IRON_SHOVEL),
                Material.STONE_SHOVEL,
                new ItemStack(Material.IRON_INGOT));
        addSmithingRecipe("stone_to_iron_hoe_smithing",
                new ItemStack(Material.IRON_HOE),
                Material.STONE_HOE,
                new ItemStack(Material.IRON_INGOT));
        addSmithingRecipe("stone_to_iron_pickaxe_smithing",
                new ItemStack(Material.IRON_PICKAXE),
                Material.STONE_PICKAXE,
                new ItemStack(Material.IRON_INGOT));
        
        // Iron to Gold
        addSmithingRecipe("iron_to_gold_sword_smithing",
                new ItemStack(Material.GOLDEN_SWORD),
                Material.IRON_SWORD,
                new ItemStack(Material.GOLD_INGOT));
        addSmithingRecipe("iron_to_gold_axe_smithing",
                new ItemStack(Material.GOLDEN_AXE),
                Material.IRON_AXE,
                new ItemStack(Material.GOLD_INGOT));
        addSmithingRecipe("iron_to_gold_shovel_smithing",
                new ItemStack(Material.GOLDEN_SHOVEL),
                Material.IRON_SHOVEL,
                new ItemStack(Material.GOLD_INGOT));
        addSmithingRecipe("iron_to_gold_hoe_smithing",
                new ItemStack(Material.GOLDEN_HOE),
                Material.IRON_HOE,
                new ItemStack(Material.GOLD_INGOT));
        addSmithingRecipe("iron_to_gold_pickaxe_smithing",
                new ItemStack(Material.GOLDEN_PICKAXE),
                Material.IRON_PICKAXE,
                new ItemStack(Material.GOLD_INGOT));
        addSmithingRecipe("iron_to_gold_helmet_smithing",
                new ItemStack(Material.GOLDEN_HELMET),
                Material.IRON_HELMET,
                new ItemStack(Material.GOLD_INGOT));
        addSmithingRecipe("iron_to_gold_chestplate_smithing",
                new ItemStack(Material.GOLDEN_CHESTPLATE),
                Material.IRON_CHESTPLATE,
                new ItemStack(Material.GOLD_INGOT));
        addSmithingRecipe("iron_to_gold_leggings_smithing",
                new ItemStack(Material.GOLDEN_LEGGINGS),
                Material.IRON_LEGGINGS,
                new ItemStack(Material.GOLD_INGOT));
        addSmithingRecipe("iron_to_gold_boots_smithing",
                new ItemStack(Material.GOLDEN_BOOTS),
                Material.IRON_BOOTS,
                new ItemStack(Material.GOLD_INGOT));

        // Iron to Diamond
        addSmithingRecipe("iron_to_diamond_sword_smithing",
                new ItemStack(Material.DIAMOND_SWORD),
                Material.IRON_SWORD,
                new ItemStack(Material.DIAMOND));
        addSmithingRecipe("iron_to_diamond_axe_smithing",
                new ItemStack(Material.DIAMOND_AXE),
                Material.IRON_AXE,
                new ItemStack(Material.DIAMOND));
        addSmithingRecipe("iron_to_diamond_shovel_smithing",
                new ItemStack(Material.DIAMOND_SHOVEL),
                Material.IRON_SHOVEL,
                new ItemStack(Material.DIAMOND));
        addSmithingRecipe("iron_to_diamond_hoe_smithing",
                new ItemStack(Material.DIAMOND_HOE),
                Material.IRON_HOE,
                new ItemStack(Material.DIAMOND));
        addSmithingRecipe("iron_to_diamond_pickaxe_smithing",
                new ItemStack(Material.DIAMOND_PICKAXE),
                Material.IRON_PICKAXE,
                new ItemStack(Material.DIAMOND));
        addSmithingRecipe("iron_to_diamond_helmet_smithing",
                new ItemStack(Material.DIAMOND_HELMET),
                Material.IRON_HELMET,
                new ItemStack(Material.DIAMOND));
        addSmithingRecipe("iron_to_diamond_chestplate_smithing",
                new ItemStack(Material.DIAMOND_CHESTPLATE),
                Material.IRON_CHESTPLATE,
                new ItemStack(Material.DIAMOND));
        addSmithingRecipe("iron_to_diamond_leggings_smithing",
                new ItemStack(Material.DIAMOND_LEGGINGS),
                Material.IRON_LEGGINGS,
                new ItemStack(Material.DIAMOND));
        addSmithingRecipe("iron_to_diamond_boots_smithing",
                new ItemStack(Material.DIAMOND_BOOTS),
                Material.IRON_BOOTS,
                new ItemStack(Material.DIAMOND));
    }

    static void addSmithingRecipe(String key, ItemStack result, Material baseMat, ItemStack itemNeeded){
        NamespacedKey smithingRecKey = new NamespacedKey(main, key);
        SmithingRecipe smithingRec = new SmithingRecipe(smithingRecKey,result,new RecipeChoice.MaterialChoice(baseMat), new RecipeChoice.ExactChoice(itemNeeded));
        addRecipe(smithingRec);
    }

    static void registerNetheriteItems() {
        //
        //NETHERITE SWORD
        //
        ItemStack netheriteSword = new ItemStack(Material.NETHERITE_SWORD);
        NamespacedKey netheriteSwordKey = new NamespacedKey(main, "netherite_sword");
        ShapedRecipe netheriteSwordRec = new ShapedRecipe(netheriteSwordKey, netheriteSword);
        netheriteSwordRec.shape(" N ", " N ", " S ");
        netheriteSwordRec.setIngredient('S', Material.STICK);
        netheriteSwordRec.setIngredient('N', Material.NETHERITE_INGOT);
        addRecipe(netheriteSwordRec);
        //
        //NETHERITE AXE
        //
        ItemStack netheriteAxe = new ItemStack(Material.NETHERITE_AXE);
        NamespacedKey netheriteAxeKey = new NamespacedKey(main, "netherite_axe");
        ShapedRecipe netheriteAxeRec = new ShapedRecipe(netheriteAxeKey, netheriteAxe);
        netheriteAxeRec.shape("NN ", "NS ", " S ");
        netheriteAxeRec.setIngredient('S', Material.STICK);
        netheriteAxeRec.setIngredient('N', Material.NETHERITE_INGOT);
        addRecipe(netheriteAxeRec);
        //
        //NETHERITE SHOVEL
        //
        ItemStack netheriteShovel = new ItemStack(Material.NETHERITE_SHOVEL);
        NamespacedKey netheriteShovelKey = new NamespacedKey(main, "netherite_shovel");
        ShapedRecipe netheriteShovelRec = new ShapedRecipe(netheriteShovelKey, netheriteShovel);
        netheriteShovelRec.shape(" N ", " S ", " S ");
        netheriteShovelRec.setIngredient('S', Material.STICK);
        netheriteShovelRec.setIngredient('N', Material.NETHERITE_INGOT);
        addRecipe(netheriteShovelRec);
        //
        //NETHERITE PICKAXE
        //
        ItemStack netheritePickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
        NamespacedKey netheritePickaxeKey = new NamespacedKey(main, "netherite_pickaxe");
        ShapedRecipe netheritePickaxeRec = new ShapedRecipe(netheritePickaxeKey, netheritePickaxe);
        netheritePickaxeRec.shape("NNN", " S ", " S ");
        netheritePickaxeRec.setIngredient('S', Material.STICK);
        netheritePickaxeRec.setIngredient('N', Material.NETHERITE_INGOT);
        addRecipe(netheritePickaxeRec);
        //
        //NETHERITE SICKLE (HOE)
        //
        ItemStack netheriteHoe = new ItemStack(Material.NETHERITE_HOE);
        NamespacedKey netheriteHoeKey = new NamespacedKey(main, "netherite_sickle");
        ShapedRecipe netheriteHoeRec = new ShapedRecipe(netheriteHoeKey, netheriteHoe);
        netheriteHoeRec.shape("NN ", " S ", " S ");
        netheriteHoeRec.setIngredient('S', Material.STICK);
        netheriteHoeRec.setIngredient('N', Material.NETHERITE_INGOT);
        addRecipe(netheriteHoeRec);
        //
        //NETHERITE HELMET
        //
        ItemStack netheriteHelmet = new ItemStack(Material.NETHERITE_HELMET);
        NamespacedKey netheriteHelmetKey = new NamespacedKey(main, "netherite_helmet");
        ShapedRecipe netheriteHelmetRec = new ShapedRecipe(netheriteHelmetKey, netheriteHelmet);
        netheriteHelmetRec.shape("NNN", "N N", "   ");
        netheriteHelmetRec.setIngredient('N', Material.NETHERITE_INGOT);
        addRecipe(netheriteHelmetRec);
        //
        //NETHERITE CHESTPLATE
        //
        ItemStack netheriteChestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
        NamespacedKey netheriteChestplateKey = new NamespacedKey(main, "netherite_chestplate");
        ShapedRecipe netheriteChestplateRec = new ShapedRecipe(netheriteChestplateKey, netheriteChestplate);
        netheriteChestplateRec.shape("N N", "NNN", "NNN");
        netheriteChestplateRec.setIngredient('N', Material.NETHERITE_INGOT);
        addRecipe(netheriteChestplateRec);
        //
        //NETHERITE LEGGINGS
        //
        ItemStack netheriteLeggings = new ItemStack(Material.NETHERITE_LEGGINGS);
        NamespacedKey netheriteLeggingsKey = new NamespacedKey(main, "netherite_leggings");
        ShapedRecipe netheriteLeggingsRec = new ShapedRecipe(netheriteLeggingsKey, netheriteLeggings);
        netheriteLeggingsRec.shape("NNN", "N N", "N N");
        netheriteLeggingsRec.setIngredient('N', Material.NETHERITE_INGOT);
        addRecipe(netheriteLeggingsRec);
        //
        //NETHERITE BOOTS
        //
        ItemStack netheriteBoots = new ItemStack(Material.NETHERITE_BOOTS);
        NamespacedKey netheriteBootsKey = new NamespacedKey(main, "netherite_boots");
        ShapedRecipe netheriteBootsRec = new ShapedRecipe(netheriteBootsKey, netheriteBoots);
        netheriteBootsRec.shape("   ", "N N", "N N");
        netheriteBootsRec.setIngredient('N', Material.NETHERITE_INGOT);
        addRecipe(netheriteBootsRec);
    }

    static void registerBetterNetheriteScrapSmelting() {
        //
        //NETHERITE SCRAP BLASTING
        //
        removeRecipe("minecraft:netherite_scrap");
        removeRecipe("minecraft:netherite_scrap_from_blasting");
        int amount = BetterConfig.ANCIENT_DEBRIS_BETTER_SMELTING_AMOUNT;
        if (amount > 64) amount = 64;
        if (amount < 1) amount = 1;

        int blastEXP = BetterConfig.ANCIENT_DEBRIS_BETTER_SMELTING_BLAST_FURNACE_EXP;
        int blastTime = BetterConfig.ANCIENT_DEBRIS_BETTER_SMELTING_BLAST_FURNACE_TIME;

        int normEXP = BetterConfig.ANCIENT_DEBRIS_BETTER_SMELTING_FURNACE_EXP;
        int normTime = BetterConfig.ANCIENT_DEBRIS_BETTER_SMELTING_FURNACE_TIME;

        ItemStack netheriteScrap = new ItemStack(Material.NETHERITE_SCRAP, amount);

        NamespacedKey netheriteScrapBlastKey = new NamespacedKey(main, "netherite_scrap_from_blasting");
        BlastingRecipe netheriteScrapBlastRec = new BlastingRecipe(netheriteScrapBlastKey, netheriteScrap, Material.ANCIENT_DEBRIS, blastEXP, blastTime);
        addRecipe(netheriteScrapBlastRec);

        NamespacedKey netheriteScrapSmeltKey = new NamespacedKey(main, "netherite_scrap");
        FurnaceRecipe netheriteScrapSmeltRec = new FurnaceRecipe(netheriteScrapSmeltKey, netheriteScrap, Material.ANCIENT_DEBRIS, normEXP, normTime);
        addRecipe(netheriteScrapSmeltRec);
    }

    public static void addRecipe(Recipe recipe){
        Bukkit.addRecipe(recipe);
        if(BetterConfig.DEBUG) {
            main.getLogger().info(main.colorize(Lang.RECIPE_ADDED_MSG.replace("KEY", ((Keyed) recipe).getKey().toString())));
        }
    }

    public static void removeRecipe(String key) {
        Iterator<Recipe> it = Bukkit.recipeIterator();
        while (it.hasNext()) {
            Recipe rec = it.next();
            if (rec != null) {
                if (((Keyed) rec).getKey().toString().equals(key)) {
                    if(BetterConfig.DEBUG) {
                        main.getLogger().info(main.colorize(Lang.RECIPE_REMOVED_MSG.replace("KEY", key)));
                    }
                    it.remove();
                }
            }
        }
    }
}
