package org.mypluginsff.cheatitems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.mypluginsff.cheatitems.recipe.CustomRecipe;
import org.mypluginsff.cheatitems.utils.CodeUtils;

public final class CheatItems extends JavaPlugin implements Listener {

    public void onEnable() {
        CustomRecipe.registerRecipe();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onLaunch(ProjectileLaunchEvent evt) {

        if (evt.getEntityType() == EntityType.ENDER_PEARL && evt.getEntity().getShooter() != null && evt.getEntity().getShooter() instanceof Player) {
            //getServer().broadcastMessage(evt.getEntity().getName().);

           if(evt.getEntity().getName().equals("SuperPearl") ){
               evt.setCancelled(true);
           }
        }


    }



    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent evt) {
        Player player = evt.getPlayer();
        Action action = evt.getAction();

        if(player.getItemInHand().getType().equals(Material.ENDER_PEARL)) {
            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {

                EnderPearl pearl = player.launchProjectile(EnderPearl.class);

                if(pearl.getPassenger() ==  null) {



                    pearl.setVelocity(player.getLocation().getDirection());
                    pearl.setPassenger(player);
                    evt.getPlayer().sendMessage("Ender Pearl Rider by Shinsu for " + evt.getPlayer().getName());

                }
                else {
                    //Something
                }
            }
        }
        if(player.getItemInHand().getType().equals(Material.SNOW_BALL)) {
            String name = ChatColor.BLUE + "Bridge";
            if (player.getItemInHand().getItemMeta().getDisplayName().equals(name)){
                evt.getPlayer().sendMessage(player.getItemInHand().getItemMeta().getDisplayName());

            }





        }
    }
    @EventHandler
    public void onExit(VehicleExitEvent evt) {
        if (evt.getVehicle().getType() == EntityType.ENDER_PEARL && evt.getExited() instanceof Player) {
           // Player p = (Player)evt.getExited();
            evt.getVehicle().eject();
            evt.getVehicle().remove();
        }

    }

    @EventHandler
    public void onHit(ProjectileHitEvent evt) {
        if (evt.getEntityType() == EntityType.ENDER_PEARL && evt.getEntity().getShooter() != null && evt.getEntity().getShooter() instanceof Player) {
            Player p = (Player)evt.getEntity().getShooter();
            evt.getEntity().eject();
            evt.getEntity().remove();
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent evt) {
        Player p = evt.getPlayer();
        if (p.getVehicle() != null) {
            p.getVehicle().setPassenger(null);
        }

        if (p.getVehicle().getPassenger() != null) {
            p.getVehicle().eject();
        }

    }
    @EventHandler
    public void  onTeleportPearl(PlayerTeleportEvent evt){
        if(evt.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL){
            evt.setCancelled(true);
        }
    }

}
