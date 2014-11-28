package net.DynamicJkPandemicMC.Listeners;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.DynamicJkPandemicMC.API.TitleAPI;
import net.DynamicJkPandemicMC.Handlers.PrefixHandler;
import net.DynamicJkPandemicMC.Main.CheckpointSaver;
import net.DynamicJkPandemicMC.Main.Main;
import net.DynamicJkPandemicMC.Main.SettingsManager;
import net.DynamicJkPandemicMC.Shop.ShopEvent;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class ClickEvent
  implements Listener
{
  Main plugin;
  public static HashMap<Player, ItemStack[]> inventory = new HashMap();

  SettingsManager settings = SettingsManager.getInstance();

  public void ClickEvent2(Main instance)
  {
    this.plugin = instance;
  }

  @EventHandler
  public void Interact(PlayerInteractEvent event)
    throws SQLException
  {
    Player player = event.getPlayer();
    Action action = event.getAction();
    if ((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK) || (action == Action.LEFT_CLICK_AIR) || (action == Action.LEFT_CLICK_BLOCK)) {
      ItemStack hand = player.getItemInHand();
      if ((hand != null) && (hand.getType() == Material.APPLE) && 
        (hand.getItemMeta().getDisplayName().equalsIgnoreCase("§7§l>> §a§lColocar Iniciador de parkour"))) {
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(PrefixHandler.prefix + " §a§lComando Exitoso");

        player.playSound(player.getLocation(), Sound.NOTE_PLING, 10.0F, 10.0F);
        this.settings.getData().set("join.world", player.getLocation().getWorld().getName());
        this.settings.getData().set("join.x", Double.valueOf(player.getLocation().getX()));
        this.settings.getData().set("join.y", Double.valueOf(player.getLocation().getY()));
        this.settings.getData().set("join.z", Double.valueOf(player.getLocation().getZ()));
        this.settings.saveData();
      }

      if ((hand.getType() == Material.ARROW) && 
        (hand.getItemMeta().getDisplayName().equalsIgnoreCase("§7§l>> §6§lCheckpoint 1 colocado"))) {
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(PrefixHandler.prefix + " §a§lCheckpoint 1 listo para usar");

        player.playSound(player.getLocation(), Sound.NOTE_PLING, 10.0F, 10.0F);
        this.settings.getData().set("cp1.world", player.getLocation().getWorld().getName());
        this.settings.getData().set("cp1.x", Double.valueOf(player.getLocation().getX()));
        this.settings.getData().set("cp1.y", Double.valueOf(player.getLocation().getY()));
        this.settings.getData().set("cp1.z", Double.valueOf(player.getLocation().getZ()));
        this.settings.saveData();
      }

      if ((hand.getType() == Material.BONE) && 
        (hand.getItemMeta().getDisplayName().equalsIgnoreCase("§7§l>> §e§lCheckpoint 2 colocado))) {
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(PrefixHandler.prefix + " §a§lCheckpoint 3 listo para usar);

        player.playSound(player.getLocation(), Sound.NOTE_PLING, 10.0F, 10.0F);
        this.settings.getData().set("cp2.world", player.getLocation().getWorld().getName());
        this.settings.getData().set("cp2.x", Double.valueOf(player.getLocation().getX()));
        this.settings.getData().set("cp2.y", Double.valueOf(player.getLocation().getY()));
        this.settings.getData().set("cp2.z", Double.valueOf(player.getLocation().getZ()));
        this.settings.saveData();
      }

      if ((hand.getType() == Material.BOOK) && 
        (hand.getItemMeta().getDisplayName().equalsIgnoreCase("§7§l>> §9§lCheckpoint 2 colocado"))) {
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(PrefixHandler.prefix + " §a§lCheckpoint 3 listo para usar");

        player.playSound(player.getLocation(), Sound.NOTE_PLING, 10.0F, 10.0F);
        this.settings.getData().set("cp3.world", player.getLocation().getWorld().getName());
        this.settings.getData().set("cp3.x", Double.valueOf(player.getLocation().getX()));
        this.settings.getData().set("cp3.y", Double.valueOf(player.getLocation().getY()));
        this.settings.getData().set("cp3.z", Double.valueOf(player.getLocation().getZ()));
        this.settings.saveData();
      }

      if ((hand.getType() == Material.DIAMOND) && 
        (hand.getItemMeta().getDisplayName().equalsIgnoreCase("§7§l>> §f§lColocado NPC spawn"))) {
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(" ");
        player.sendMessage(PrefixHandler.prefix + " §a§lTerminado NPC spawn");

        player.playSound(player.getLocation(), Sound.NOTE_PLING, 10.0F, 10.0F);
        this.settings.getData().set("cp4.world", player.getLocation().getWorld().getName());
        this.settings.getData().set("cp4.x", Double.valueOf(player.getLocation().getX()));
        this.settings.getData().set("cp4.y", Double.valueOf(player.getLocation().getY()));
        this.settings.getData().set("cp4.z", Double.valueOf(player.getLocation().getZ()));
        this.settings.saveData();
      }

      if (hand.getType() == Material.EMERALD) {
        if (hand.getItemMeta().getDisplayName().equalsIgnoreCase("§7§l>> §c§lGuardando NPCS")) {
          player.sendMessage(" ");
          player.sendMessage(" ");
          player.sendMessage(" ");
          player.sendMessage(" ");
          player.sendMessage(" ");
          player.sendMessage(" ");
          player.sendMessage(" ");
          player.sendMessage(" ");
          player.sendMessage(PrefixHandler.prefix + " §a§lSuccessfully Set NPCS §cnow set the Messages and Head Names.");
          player.sendMessage(PrefixHandler.prefix + " §a§lSuccessfully §cSaved Configs §8- §edata.yml, config.yml");
          this.settings.getData().set("location.world", player.getLocation().getWorld().getName());
          this.settings.getConfig().set("location.world", player.getLocation().getWorld().getName());
          this.settings.saveConfig();

          this.settings.saveData();
          player.getInventory().clear();
          player.updateInventory();
          this.settings.saveConfig();
          this.settings.saveData();
        }

        if ((hand.getType() != Material.ARROW) || 
          (!(hand.getItemMeta().getDisplayName().equalsIgnoreCase("§b§l>> §6§lTienda")))) return;
        player.openInventory(ShopEvent.Shop());
      }
    }
  }

  @EventHandler
  public void OnInteract(PlayerInteractEntityEvent e)
    throws IOException
  {
    if (e.getRightClicked().getType() == EntityType.VILLAGER) {
      Villager v = (Villager)e.getRightClicked();

      String Cp1 = this.settings.getConfig().getString("pk.cp1name");
      Cp1 = Cp1.replaceAll("&", "§");
      if (v.getCustomName().equalsIgnoreCase(Cp1)) {
        Player p = e.getPlayer();
        if (!(CheckpointSaver.Join.contains(p.getName()))) {
          p.sendMessage("§c§lDynamic§f§lParkour§6§l §cMust be in Game");
          e.setCancelled(true);
        }
        if (CheckpointSaver.Checkpoint1.contains(p.getName())) {
          p.sendMessage(PrefixHandler.prefix + " §cCheckpoint usado.");
          e.setCancelled(true);
        }
        if ((CheckpointSaver.Join.contains(p.getName())) && (!(CheckpointSaver.Checkpoint1.contains(p.getName())))) {
          String Cp1Msg = this.settings.getConfig().getString("pk.cp1msg");
          Cp1Msg = Cp1Msg.replaceAll("&", "§");
          p.sendMessage(Cp1Msg);
          CheckpointSaver.Checkpoint1.add(p.getName());
          CheckpointSaver.Checkpoint1.add(p.getName());
          Location loc = v.getLocation();
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.world", loc.getWorld().getName());
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.x", Double.valueOf(loc.getX()));
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.y", Double.valueOf(loc.getY()));
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.z", Double.valueOf(loc.getZ()));
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.d", Float.valueOf(loc.getYaw()));
          this.settings.saveCp();
          this.settings.reloadcp();
          e.setCancelled(true);
          if (this.settings.getConfig().getBoolean("titles.use")) {
            String CT1 = this.settings.getConfig().getString("title-cp1");
            CT1 = CT1.replaceAll("&", "§");
            String CS1 = this.settings.getConfig().getString("title-cp1-sub");
            CS1 = CS1.replaceAll("&", "§");
            TitleAPI title = new TitleAPI(CT1, CS1, 15, 20, 15);
            title.setTimingsToTicks();

            title.send(p);
          }
        }

      }

      String Cp2 = this.settings.getConfig().getString("pk.cp2name");
      Cp2 = Cp2.replaceAll("&", "§");
      if (v.getCustomName().equalsIgnoreCase(Cp2)) {
        Player p = e.getPlayer();
        if (!(CheckpointSaver.Checkpoint1.contains(p.getName()))) {
          p.sendMessage(PrefixHandler.prefix + " §cYou are Missing a Checkpoint!");
          e.setCancelled(true);
        }
        if (CheckpointSaver.Checkpoint2.contains(p.getName())) {
          p.sendMessage(PrefixHandler.prefix + " §cCheckpoint usado.");
          e.setCancelled(true);
        }
        if ((CheckpointSaver.Checkpoint1.contains(p.getName())) && (!(CheckpointSaver.Checkpoint2.contains(p.getName())))) {
          String Cp2Msg = this.settings.getConfig().getString("pk.cp2msg");
          Cp2Msg = Cp2Msg.replaceAll("&", "§");
          p.sendMessage(Cp2Msg);
          CheckpointSaver.Checkpoint2.add(p.getName());
          Location loc = v.getLocation();
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.world", loc.getWorld().getName());
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.x", Double.valueOf(loc.getX()));
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.y", Double.valueOf(loc.getY()));
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.z", Double.valueOf(loc.getZ()));
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.d", Float.valueOf(loc.getYaw()));
          this.settings.saveCp();
          this.settings.reloadcp();
          e.setCancelled(true);
          if (this.settings.getConfig().getBoolean("titles.use")) {
            String CT1 = this.settings.getConfig().getString("title-cp2");
            CT1 = CT1.replaceAll("&", "§");
            String CS1 = this.settings.getConfig().getString("title-cp2-sub");
            CS1 = CS1.replaceAll("&", "§");
            TitleAPI title = new TitleAPI(CT1, CS1, 15, 20, 15);
            title.setTimingsToTicks();

            title.send(p);
          }
        }
      }
      String Cp3 = this.settings.getConfig().getString("pk.cp3name");
      Cp3 = Cp3.replaceAll("&", "§");
      if (v.getCustomName().equalsIgnoreCase(Cp3)) {
        Player p = e.getPlayer();
        if (!(CheckpointSaver.Checkpoint2.contains(p.getName()))) {
          p.sendMessage(PrefixHandler.prefix + " §cNo hay checkpoints!");
          e.setCancelled(true);
        }
        if (CheckpointSaver.Checkpoint3.contains(p.getName())) {
          p.sendMessage(PrefixHandler.prefix + " §cCheckpoint ya colocado.");
          e.setCancelled(true);
        }
        if ((CheckpointSaver.Checkpoint2.contains(p.getName())) && (!(CheckpointSaver.Checkpoint3.contains(p.getName())))) {
          String Cp3Msg = this.settings.getConfig().getString("pk.cp3msg");
          Cp3Msg = Cp3Msg.replaceAll("&", "§");
          p.sendMessage(Cp3Msg);
          CheckpointSaver.Checkpoint3.add(p.getName());
          Location loc = v.getLocation();
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.world", loc.getWorld().getName());
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.x", Double.valueOf(loc.getX()));
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.y", Double.valueOf(loc.getY()));
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.z", Double.valueOf(loc.getZ()));
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.d", Float.valueOf(loc.getYaw()));
          this.settings.saveCp();
          this.settings.reloadcp();
          e.setCancelled(true);
          if (this.settings.getConfig().getBoolean("titles.use")) {
            String CT1 = this.settings.getConfig().getString("title-cp3");
            CT1 = CT1.replaceAll("&", "§");
            String CS1 = this.settings.getConfig().getString("title-cp3-sub");
            CS1 = CS1.replaceAll("&", "§");
            TitleAPI title = new TitleAPI(CT1, CS1, 15, 20, 15);
            title.setTimingsToTicks();

            title.send(p);
          }
        }
      }

      String Cp4 = this.settings.getConfig().getString("pk.cp4name");
      Cp4 = Cp4.replaceAll("&", "§");
      if (!(v.getCustomName().equalsIgnoreCase(Cp4)))
        return;
      Player p = e.getPlayer();
      if (!(CheckpointSaver.Checkpoint3.contains(p.getName()))) {
        p.sendMessage(PrefixHandler.prefix + " §cNo se a encontrado un checkpoint!");
        e.setCancelled(true);
      }
      if (CheckpointSaver.Checkpoint3.contains(p.getName())) {
        e.setCancelled(true);
        String Cp4Msg = this.settings.getConfig().getString("pk.cp4msg");
        Cp4Msg = Cp4Msg.replaceAll("&", "§");
        p.sendMessage(Cp4Msg);
        CheckpointSaver.Join.remove(p.getName());
        CheckpointSaver.Checkpoint1.remove(p.getName());
        CheckpointSaver.Checkpoint2.remove(p.getName());
        CheckpointSaver.Checkpoint3.remove(p.getName());
        int Win = this.settings.getPlayerData().getInt(p.getName() + ".Wins");
        this.settings.getPlayerData().set(p.getName() + ".Wins", Integer.valueOf(Win + 1));
        this.settings.savePlayerData();
        if (this.settings.getConfig().getBoolean("economy.use")) {
          this.settings.savePlayerData();
          CheckpointSaver.Join.remove(p.getName());
          CheckpointSaver.Checkpoint1.remove(p.getName());
          CheckpointSaver.Checkpoint2.remove(p.getName());
          CheckpointSaver.Checkpoint3.remove(p.getName());
          double npcmotdcp3 = this.settings.getConfig().getDouble("economy.money");
          p.setLevel(0);
          EconomyResponse r = Main.econ.depositPlayer(p.getName(), npcmotdcp3);
          if (r.transactionSuccess())
          {
            p.setLevel(0);
            p.sendMessage(PrefixHandler.prefix + " §eHaz ganado " + npcmotdcp3 + " Monedas de oro");
            e.setCancelled(true);
          } else if (!(this.settings.getConfig().getBoolean("economy.use"))) {
            p.setLevel(0);
          }
        }
        if (this.settings.getConfig().getBoolean("Leave-On-Win")) {
          Player player = e.getPlayer();
          this.settings.getcheckpoints().set("users." + p.getName() + ".cp.world", null);
          this.settings.getcheckpoints().set("users." + player.getName() + ".cp.x", null);
          this.settings.getcheckpoints().set("users." + player.getName() + ".cp.y", null);
          this.settings.getcheckpoints().set("users." + player.getName() + ".cp.z", null);
          this.settings.getcheckpoints().set("users." + player.getName() + ".cp.d", null);
          CheckpointSaver.Join.remove(player.getName());
          CheckpointSaver.Checkpoint1.remove(player.getName());
          CheckpointSaver.Checkpoint2.remove(player.getName());
          CheckpointSaver.Checkpoint3.remove(player.getName());
          this.settings.saveCp();
          this.settings.reloadcp();
          World w = Bukkit.getServer().getWorld(this.settings.getData().getString("spawn.world"));
          double x = this.settings.getData().getDouble("spawn.x");
          double y = this.settings.getData().getDouble("spawn.y");
          double z = this.settings.getData().getDouble("spawn.z");
          player.teleport(new Location(w, x, y, z));
          player.setLevel(0);
          if (Main.instance.getConfig().getString(player.getName() + ".true") != null) {
            Main.restore(player);
            player.updateInventory();
            Main.instance.saveConfig();
            Main.instance.reloadConfig();
            Main.instance.saveConfig();
            Main.instance.getConfig().set(player.getName() + ".true", null);
            Main.instance.saveConfig();
          }
          player.updateInventory();
          Main.instance.saveConfig();
          Main.instance.reloadConfig();
          Main.instance.saveConfig();
          CheckpointSaver.Join.remove(player.getName());
          CheckpointSaver.Checkpoint1.remove(player.getName());
          CheckpointSaver.Checkpoint2.remove(player.getName());
          CheckpointSaver.Checkpoint3.remove(player.getName());
        } else if (!(this.settings.getConfig().getBoolean("Leave-On-Win"))) {
          p.sendMessage(PrefixHandler.prefix + " §eYa haz salido");
        }
        CheckpointSaver.Join.remove(p.getName());
        CheckpointSaver.Checkpoint1.remove(p.getName());
        CheckpointSaver.Checkpoint2.remove(p.getName());
        CheckpointSaver.Checkpoint3.remove(p.getName());
        if (this.settings.getConfig().getBoolean("titles.use")) {
          String CT1 = this.settings.getConfig().getString("title-complete");
          CT1 = CT1.replaceAll("&", "§");
          String CS1 = this.settings.getConfig().getString("title-complete-sub");
          CS1 = CS1.replaceAll("&", "§");
          TitleAPI title = new TitleAPI(CT1, CS1, 15, 20, 15);
          title.setTimingsToTicks();

          title.send(p);
        }
      }
    }
  }
}
