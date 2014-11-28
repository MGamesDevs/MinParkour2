package net.DynamicJkPandemicMC.Join;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.DynamicJkPandemicMC.Handlers.PrefixHandler;
import net.DynamicJkPandemicMC.Listeners.ClickEvent;
import net.DynamicJkPandemicMC.Main.CheckpointSaver;
import net.DynamicJkPandemicMC.Main.Main;
import net.DynamicJkPandemicMC.Main.SettingsManager;
import net.DynamicJkPandemicMC.Managers.View2;
import net.DynamicJkPandemicMC.Shop.ShopEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinMenu
  implements Listener
{
  static SettingsManager settings = SettingsManager.getInstance();

  public static Inventory Join()
  {
    Inventory inv = Bukkit.createInventory(null, 9, "§4§lSeleccionar Opcion§8:");
    ItemStack item = new ItemStack(Material.EMERALD_BLOCK, 1);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName("§aEntrar al parkour §8(Click derecho)");
    List lore6 = new ArrayList();
    lore6.add("§5§oJoins the Parkour");
    meta.setLore(lore6);
    item.setItemMeta(meta);
    inv.setItem(0, item);

    ItemStack item3 = new ItemStack(Material.DIAMOND, 1);
    ItemMeta meta3 = item3.getItemMeta();
    meta3.setDisplayName("§eMirar WINS del parkour §8(Click derecho)");
    List lore9 = new ArrayList();
    lore9.add("§5§oView your parkour Wins");
    meta3.setLore(lore9);
    item3.setItemMeta(meta3);
    inv.setItem(2, item3);

    ItemStack item1 = new ItemStack(Material.REDSTONE_BLOCK, 1);
    ItemMeta meta1 = item1.getItemMeta();
    meta1.setDisplayName("§cMirar parkour §8(Click derecho)");
    List lore7 = new ArrayList();
    lore7.add("§5§o View all of the parkour");
    meta1.setLore(lore7);
    item1.setItemMeta(meta1);
    inv.setItem(6, item1);

    ItemStack item2 = new ItemStack(Material.BEDROCK, 1);
    ItemMeta meta2 = item2.getItemMeta();
    meta2.setDisplayName("§4Salir del menu §8(Click derecho)");
    List lore8 = new ArrayList();
    lore8.add("§5§o Saliendo del menu de parkour");
    meta2.setLore(lore8);
    item2.setItemMeta(meta2);
    inv.setItem(8, item2);

    return inv;
  }

  @EventHandler
  public void Kit(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    Action action = event.getAction();
    if ((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK)) {
      ItemStack hand = player.getItemInHand();
      if ((hand != null) && (hand.getType() == Material.CHEST))
        player.openInventory(ShopEvent.Shop());
    }
  }

  @EventHandler
  public void onClick1(InventoryClickEvent event)
    throws SQLException, IOException
  {
    HumanEntity entity = event.getWhoClicked();
    if (!(entity instanceof Player))
      return;
    Player p = (Player)entity;
    if (!(event.getInventory().getName().equals(Join().getName())))
      return;
    ItemStack clicked = event.getCurrentItem();
    if (clicked == null)
      return;
    List armorList;
    ItemStack checkpointtp;
    ItemMeta checkpointtp2;
    ItemStack Shop;
    if (clicked.getType() == Material.EMERALD_BLOCK)
    {
      p.closeInventory();
      if (View2.InView.contains(p.getName())) {
        p.sendMessage(PrefixHandler.prefix + " §cHaz salido del modo (espectador) modo de juego! ");
      }
      else if (!(CheckpointSaver.Join.contains(p.getName()))) {
        CheckpointSaver.Join.add(p.getName());
        if (CheckpointSaver.Join.contains(p.getName())) {
          ClickEvent.inventory.put(p, p.getInventory().getContents());
          Main.save2(p);
          p.setAllowFlight(false);
          p.getInventory().clear();
          p.getInventory().setBoots(null);
          p.getInventory().setChestplate(null);
          p.getInventory().setLeggings(null);
          p.getInventory().setHelmet(null);

          armorList = (List)settings.getConfig().get("checkpoint.item");
          p.getInventory().clear();
        }
        CheckpointSaver.Checkpoint1.remove(p.getName());
        CheckpointSaver.Checkpoint2.remove(p.getName());
        CheckpointSaver.Checkpoint3.remove(p.getName());
        ItemStack emerald = new ItemStack(Material.PAPER, 1);
        ItemMeta meta2 = emerald.getItemMeta();
        meta2.setDisplayName("§7§l>> §c§lSalir parkoour");
        emerald.setItemMeta(meta2);
        p.getInventory().setItem(6, new ItemStack(emerald));
        ItemStack checkpoint = new ItemStack(Material.FEATHER, 1);
        ItemMeta checkpoint2 = checkpoint.getItemMeta();
        checkpoint2.setDisplayName("§7§l>> §c§lCheckPoint");
        checkpoint.setItemMeta(checkpoint2);
        p.getInventory().setItem(2, new ItemStack(checkpoint));
        checkpointtp = new ItemStack(Material.APPLE, 1);
        checkpointtp2 = checkpointtp.getItemMeta();
        checkpointtp2.setDisplayName("§7§l>> §c§lIr al checkpoint");
        checkpointtp.setItemMeta(checkpointtp2);
        p.getInventory().setItem(3, new ItemStack(checkpointtp));
        Shop = new ItemStack(Material.CHEST, 1);
        ItemMeta ShopMeta = Shop.getItemMeta();
        ShopMeta.setDisplayName("§b§l>> §6§lTienda");
        Shop.setItemMeta(ShopMeta);
        p.getInventory().setItem(4, new ItemStack(Shop));
        p.updateInventory();
        String joinmsg = settings.getConfig().getString("pk.jmsg");
        joinmsg = joinmsg.replaceAll("&", "§");
        p.sendMessage(joinmsg);
        CheckpointSaver.Checkpoint1.remove(p.getName());
        CheckpointSaver.Checkpoint2.remove(p.getName());
        CheckpointSaver.Checkpoint3.remove(p.getName());
      }

    }

    if (clicked.getType() == Material.DIAMOND)
    {
      p.closeInventory();
      int Win = settings.getPlayerData().getInt(p.getName() + ".Wins");
      if (Win == 1)
        p.sendMessage(PrefixHandler.prefix + " §6You have won §a" + Win + " §6time.");
      else {
        p.sendMessage(PrefixHandler.prefix + " §6You have won §a" + Win + " §6times.");
      }

    }

    if (clicked.getType() == Material.REDSTONE_BLOCK)
    {
      p.closeInventory();
      if (settings.getConfig().getBoolean("View.parkour.use")) {
        if (View2.InView.contains(p.getName())) {
          p.sendMessage(PrefixHandler.prefix + " §cYa estas mirando el parkour");
        }
        else if (!(View2.InView.contains(p.getName()))) {
          p.setAllowFlight(true);
          p.setFlySpeed(0.1F);

          p.sendMessage(PrefixHandler.prefix + " §6Haz sido movido para el modo de mira.");
          ClickEvent.inventory.put(p, p.getInventory().getContents());
          Main.save2(p);
          p.getInventory().clear();

          armorList = (List)settings.getConfig().get("checkpoint.item");
          p.getInventory().clear();
          ItemStack checkpointtp = new ItemStack(Material.TORCH, 1);
          ItemMeta checkpointtp2 = checkpointtp.getItemMeta();
          checkpointtp2.setDisplayName("§eExit View Mode §8(Right Click)");
          checkpointtp.setItemMeta(checkpointtp2);
          p.getInventory().setItem(1, new ItemStack(checkpointtp));
          View2.InView.add(p.getName());
          checkpointtp2 = (Shop = Bukkit.getOnlinePlayers()).length; for (checkpointtp = 0; checkpointtp < checkpointtp2; ++checkpointtp) { Player players = Shop[checkpointtp];
            players.hidePlayer(p);
          }
        }
      }
      else if (!(settings.getConfig().getBoolean("View.parkour.use"))) {
        p.sendMessage(PrefixHandler.prefix + " §cOpcion desabilitada");
      }
    }

    if (clicked.getType() != Material.BEDROCK)
      return;
    p.closeInventory();
  }

  @EventHandler
  public void onItemDrop(PlayerDropItemEvent e)
  {
    Player p = e.getPlayer();
    if (View2.InView.contains(p.getName())) {
      p.sendMessage("§4§l§oX §c§oNo puedes realizar esta accion");
      p.playSound(p.getLocation(), Sound.NOTE_BASS, 2.0F, 4.0F);
      e.setCancelled(true);
    }
    if (CheckpointSaver.Join.contains(p.getName())) {
      p.sendMessage("§4§l§oX §c§oNo puedes realizar esta accion");
      p.playSound(p.getLocation(), Sound.NOTE_BASS, 2.0F, 4.0F);
      e.setCancelled(true);
    }
  }

  @EventHandler
  public void PVP(EntityDamageByEntityEvent event)
  {
    Player attacker = (Player)event.getDamager();
    if ((!(event.getEntity() instanceof Player)) || 
      (!(View2.InView.contains(attacker.getName())))) return;
    event.setCancelled(true);
    attacker.sendMessage(PrefixHandler.prefix + " §cSaliste!");
  }

  @EventHandler
  public void Interact(PlayerInteractEvent event)
    throws SQLException
  {
    Player player = event.getPlayer();
    Action action = event.getAction();
    if ((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK) || (action == Action.LEFT_CLICK_AIR) || (action == Action.LEFT_CLICK_BLOCK)) {
      ItemStack hand = player.getItemInHand();
      if ((hand == null) || (hand.getType() != Material.TORCH) || 
        (!(hand.getItemMeta().getDisplayName().equalsIgnoreCase("§eSalir del modo mira §8(Click derecho)")))) return;
      World w = Bukkit.getServer().getWorld(settings.getData().getString("spawn.world"));
      double x = settings.getData().getDouble("spawn.x");
      double y = settings.getData().getDouble("spawn.y");
      double z = settings.getData().getDouble("spawn.z");
      player.teleport(new Location(w, x, y, z));
      player.sendMessage(PrefixHandler.prefix + " §eSaliste satisfactoriamente");
      View2.InView.remove(player.getName());
      player.setAllowFlight(false);
      try {
        Main.restore(player);
      }
      catch (IOException e) {
        e.printStackTrace();
        player.sendMessage(PrefixHandler.prefix + " §cERROR OCURRIDO);
      }
      for (Player players : Bukkit.getOnlinePlayers())
        players.showPlayer(player);
    }
  }

  @EventHandler
  public void onPlayerJoin2(PlayerJoinEvent e)
  {
    Player p2 = e.getPlayer();
    for (Player p : Bukkit.getServer().getOnlinePlayers())
      if (p != e.getPlayer())
        if (View2.InView.contains(p2.getName())) {
          p.hidePlayer(p2.getPlayer());
        }
        else
        {
          p.showPlayer(e.getPlayer());
        }
  }

  @EventHandler
  public void OnInteract(PlayerInteractEntityEvent e)
    throws IOException
  {
    if (e.getRightClicked().getType() == EntityType.VILLAGER) {
      Villager v = (Villager)e.getRightClicked();

      String join = settings.getConfig().getString("pk.jname");
      join = join.replaceAll("&", "§");
      if (v.getCustomName().equalsIgnoreCase(join)) {
        Player p = e.getPlayer();
        if (CheckpointSaver.Join.contains(p.getName())) {
          p.sendMessage(PrefixHandler.prefix + " §cYa estas en parkour!");
          e.setCancelled(true);
        }
        if (!(CheckpointSaver.Join.contains(p.getName()))) {
          p.openInventory(Join());
          Location loc = v.getLocation();
          settings.getcheckpoints().set("users." + p.getName() + ".cp.world", loc.getWorld().getName());
          settings.getcheckpoints().set("users." + p.getName() + ".cp.x", Double.valueOf(loc.getX()));
          settings.getcheckpoints().set("users." + p.getName() + ".cp.y", Double.valueOf(loc.getY()));
          settings.getcheckpoints().set("users." + p.getName() + ".cp.z", Double.valueOf(loc.getZ()));
          settings.getcheckpoints().set("users." + p.getName() + ".cp.d", Float.valueOf(loc.getYaw()));
          settings.saveCp();
          settings.reloadcp();
          e.setCancelled(true);
        }
      }
    }
  }
}
