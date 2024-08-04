package org.mypluginsff.cheatitems.recipe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomRecipe {
    public static   void  registerRecipe(){
        //Ender Pearl Craft Recipe
            ItemStack itemForEnderPearl = new ItemStack(Material.ENDER_PEARL);
            ItemMeta superPearlMeta = itemForEnderPearl.getItemMeta();
            superPearlMeta.setDisplayName(ChatColor.GOLD + "SuperPearl");
            superPearlMeta.addEnchant(Enchantment.DAMAGE_ALL, 1 , true);
            superPearlMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemForEnderPearl.setItemMeta(superPearlMeta);
            ShapelessRecipe recipeEnderPearl = new ShapelessRecipe(itemForEnderPearl);
            recipeEnderPearl.addIngredient(4,Material.GOLD_INGOT);
            Bukkit.addRecipe(recipeEnderPearl);

        //
            ItemStack itemForBridge= new ItemStack(Material.SNOW_BALL);
            ItemMeta superBridgeMeta = itemForBridge.getItemMeta();
            superBridgeMeta.setDisplayName(ChatColor.BLUE + "Bridge");
            superBridgeMeta.addEnchant(Enchantment.DAMAGE_ALL, 1 , true);
            superBridgeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemForBridge.setItemMeta(superBridgeMeta);
            ShapelessRecipe recipeForBridge = new ShapelessRecipe(itemForBridge);
            recipeForBridge.addIngredient(2,Material.IRON_INGOT);
            Bukkit.addRecipe(recipeForBridge);



    }
}
