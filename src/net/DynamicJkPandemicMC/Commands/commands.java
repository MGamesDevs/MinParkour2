package net.DynamicJkPandemicMC.Commands;

import net.DynamicJkPandemicMC.Main.Main;
import net.DynamicJkPandemicMC.Main.SettingsManager;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class commands
  implements Listener, CommandExecutor
{
  Main plugin;
  SettingsManager settings = SettingsManager.getInstance();

  public void commands2(Main instance)
  {
    this.plugin = instance;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player p;
    if (cmd.getName().equalsIgnoreCase("parkour")) {
      p = (Player)sender;
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage("§c§lMin§f§lParkour§6§l> §a   < MinParkour >");
      p.sendMessage("§c§lMin§f§lParkour§6§l> §c/madmin §eAbrir el menu de ayuda de admins");
      p.sendMessage("§c§lMin§f§lParkour§6§l> §cEste plugin esta hecho por §elacacatua1992 &");
      p.sendMessage("§c§lMin§f§lParkour§6§l> §elacacatua §ctesteo este plugin");
    }

    if (cmd.getName().equalsIgnoreCase("madmin")) {
      p = (Player)sender;
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §a   < MinParkour Admin >");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/msetup §eBegin the setup proccess");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/msetjmsg §eSet Join click message");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/msetjhead §eSet Join NPCS Name");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/msetcp1msg §eSet p1 click message");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/msetcp2msg §eSet p2 click message");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/msetcp3msg §eSet p3 click message");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/msetcommsg §eSet CompletePk click message");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/msetcp1head §eSet CP1 NPCS Name");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/msetcp2head §eSet CP2 NPCS Name");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/msetcp3head §eSet CP3 NPCS Name");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/msetcomhead §eSet CompletePk NPCS Name");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §aSet Money in Config");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/mcomsetup §cFinish the setup");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c/mforceloadnpcs §eForce load NPCS");
    }
    if (cmd.getName().equalsIgnoreCase("msetup")) {
      p = (Player)sender;
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage(" ");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §a   < DynamicParkour SetUp >");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §cSetup proccess begun set the Npc SpawnPoints ");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §c(Right Click the Items in inventory in order) ");
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §cWhen done right click the save item");
      p.getInventory().clear();
      this.settings.getConfig().set("location.world", p.getLocation().getWorld().getName());
      this.settings.saveConfig();
      ItemStack Join = new ItemStack(Material.APPLE, 1);
      ItemMeta JoinMeta = Join.getItemMeta();
      JoinMeta.setDisplayName("§7§l>> §a§lSet Join NPC Spawn");
      Join.setItemMeta(JoinMeta);
      p.getInventory().setItem(0, new ItemStack(Join));

      ItemStack Cp1 = new ItemStack(Material.ARROW, 1);
      ItemMeta Cp1Meta = Cp1.getItemMeta();
      Cp1Meta.setDisplayName("§7§l>> §6§lSet Checkpoint 1 NPC Spawn");
      Cp1.setItemMeta(Cp1Meta);
      p.getInventory().setItem(1, new ItemStack(Cp1));

      ItemStack Cp2 = new ItemStack(Material.BONE, 1);
      ItemMeta Cp2Meta = Cp2.getItemMeta();
      Cp2Meta.setDisplayName("§7§l>> §e§lSet Checkpoint 2 NPC Spawn");
      Cp2.setItemMeta(Cp2Meta);
      p.getInventory().setItem(2, new ItemStack(Cp2));

      ItemStack Cp3 = new ItemStack(Material.BOOK, 1);
      ItemMeta Cp3Meta = Cp3.getItemMeta();
      Cp3Meta.setDisplayName("§7§l>> §9§lSet Checkpoint 3 NPC Spawn");
      Cp3.setItemMeta(Cp3Meta);
      p.getInventory().setItem(3, new ItemStack(Cp3));

      ItemStack Cp4 = new ItemStack(Material.DIAMOND, 1);
      ItemMeta Cp4Meta = Cp4.getItemMeta();
      Cp4Meta.setDisplayName("§7§l>> §f§lSet Complete NPC Spawn");
      Cp4.setItemMeta(Cp4Meta);
      p.getInventory().setItem(4, new ItemStack(Cp4));

      ItemStack Finish = new ItemStack(Material.EMERALD, 1);
      ItemMeta FinishMeta = Finish.getItemMeta();
      FinishMeta.setDisplayName("§7§l>> §c§lSave Npcs");
      Finish.setItemMeta(FinishMeta);
      p.getInventory().setItem(8, new ItemStack(Finish));
    }

    if (cmd.getName().equalsIgnoreCase("pksetleave")) {
      p = (Player)sender;
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §cLeave spawnpoint set!");
      p.playSound(p.getLocation(), Sound.NOTE_PLING, 10.0F, 10.0F);
      this.settings.getData().set("spawn.world", p.getLocation().getWorld().getName());
      this.settings.getData().set("spawn.x", Double.valueOf(p.getLocation().getX()));
      this.settings.getData().set("spawn.y", Double.valueOf(p.getLocation().getY()));
      this.settings.getData().set("spawn.z", Double.valueOf(p.getLocation().getZ()));
      this.settings.saveData();
    }

    if (cmd.getName().equalsIgnoreCase("msetcpitem")) {
      p = (Player)sender;
      p.sendMessage("§c§lDynamic§f§lParkour§6§l> §cId Set");
      p.playSound(p.getLocation(), Sound.NOTE_PLING, 10.0F, 10.0F);
      this.settings.getData().set("checkpoint.item", args[0]);
      this.settings.saveData();
    }
    StringBuilder str;
    int i;
    String JoinMsg;
    if (cmd.getName().equalsIgnoreCase("msetjmsg")) {
      if (!(sender.hasPermission("pkset.set"))) {
        sender.sendMessage(ChatColor.RED + "§c§lDynamic§f§lParkour§6§l> §c§lYou are not permitted to do this!");
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(ChatColor.RED + "§c§lDynamic§f§lParkour§6§l> §c§lUsage /pksetjmsg <join parkour message> <- set a custom message");
        return true;
      }
      str = new StringBuilder();
      for (i = 0; i < args.length; ++i) {
        str.append(args[i] + " ");
      }
      String joinmsg = str.toString();
      this.settings.getConfig().set("pk.jmsg", joinmsg);
      this.settings.saveConfig();
      JoinMsg = this.settings.getConfig().getString("pk.jmsg");
      joinmsg = joinmsg.replaceAll("&", "§");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(ChatColor.YELLOW + "§c§lDynamic§f§lParkour§6§l> §c§lNPC Join Message set to " + JoinMsg);
      return true;
    }

    if (cmd.getName().equalsIgnoreCase("msetcp1msg")) {
      if (!(sender.hasPermission("pkset.set"))) {
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(ChatColor.RED + "§c§lDynamic§f§lParkour§6§l> §c§lYou are not permitted to do this!");
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(ChatColor.RED + "§c§lDynamic§f§lParkour§6§l> §c§lUsage /pksetcp1msg <Click message> <- set a custom message");
        return true;
      }
      str = new StringBuilder();
      for (i = 0; i < args.length; ++i) {
        str.append(args[i] + " ");
      }
      String cp1msg = str.toString();
      this.settings.getConfig().set("pk.cp1msg", cp1msg);
      this.settings.saveConfig();
      JoinMsg = this.settings.getConfig().getString("pk.cp1msg");
      cp1msg = cp1msg.replaceAll("&", "§");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(ChatColor.YELLOW + "§c§lDynamic§f§lParkour§6§l> §c§lNPC Checkpoint1 Message set to " + JoinMsg);
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("msetcp2msg")) {
      if (!(sender.hasPermission("pkset.set"))) {
        sender.sendMessage(ChatColor.RED + "§c§lDynamic§f§lParkour§6§l> §c§lYou are not permitted to do this!");
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(ChatColor.RED + "§c§lDynamic§f§lParkour§6§l> §c§lUsage /pksetcp2msg <Click message> <- set a custom message");
        return true;
      }
      str = new StringBuilder();
      for (i = 0; i < args.length; ++i) {
        str.append(args[i] + " ");
      }
      String cp2msg = str.toString();
      this.settings.getConfig().set("pk.cp2msg", cp2msg);
      this.settings.saveConfig();
      JoinMsg = this.settings.getConfig().getString("pk.cp2msg");
      cp2msg = cp2msg.replaceAll("&", "§");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(ChatColor.YELLOW + "§c§lDynamic§f§lParkour§6§l> §c§lNPC Checkpoint2 Message set to " + JoinMsg);
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("msetcp3msg")) {
      if (!(sender.hasPermission("pkset.set"))) {
        sender.sendMessage(ChatColor.RED + "§c§lDynamic§f§lParkour§6§l> §c§lYou are not permitted to do this!");
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(ChatColor.RED + "§c§lDynamic§f§lParkour§6§l> §c§lUsage /pksetcp3msg <Click message> <- set a custom message");
        return true;
      }
      str = new StringBuilder();
      for (i = 0; i < args.length; ++i) {
        str.append(args[i] + " ");
      }
      String cp3msg = str.toString();
      this.settings.getConfig().set("pk.cp3msg", cp3msg);
      this.settings.saveConfig();
      JoinMsg = this.settings.getConfig().getString("pk.cp3msg");
      cp3msg = cp3msg.replaceAll("&", "§");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(ChatColor.YELLOW + "§c§lDynamic§f§lParkour§6§l> §c§lNPC Checkpoint3 Message set to " + JoinMsg);
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("msetcommsg")) {
      if (!(sender.hasPermission("pkset.set"))) {
        sender.sendMessage(ChatColor.RED + "§c§lDynamic§f§lParkour§6§l> §c§lYou are not permitted to do this!");
        return true;
      }
      if (args.length == 0) {
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(" ");
        sender.sendMessage(ChatColor.RED + "§c§lMin§f§lParkour§6§l> §c§lUsa /msetcommsg <Click message> <- Colocar un mensaje aleatorio");
        return true;
      }
      str = new StringBuilder();
      for (i = 0; i < args.length; ++i) {
        str.append(args[i] + " ");
      }
      String cp4msg = str.toString();
      this.settings.getConfig().set("pk.cp4msg", cp4msg);
      this.settings.saveConfig();
      JoinMsg = this.settings.getConfig().getString("pk.cp4msg");
      cp4msg = cp4msg.replaceAll("&", "§");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(" ");
      sender.sendMessage(ChatColor.YELLOW + "§c§lMin§f§lParkour§6§l> §c§lNPC Completo conjunto de mensajes a " + JoinMsg);
      return true;
    }
    return false;
  }
}
