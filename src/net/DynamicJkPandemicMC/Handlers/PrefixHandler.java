package net.DynamicJkPandemicMC.Handlers;

import net.DynamicJkPandemicMC.Main.SettingsManager;
import org.bukkit.configuration.file.FileConfiguration;

public class PrefixHandler
{
  static SettingsManager settings = SettingsManager.getInstance();

  public static String prefix = settings.getConfig().getString("Prefix").replaceAll("&", "§");

  public String getPrefix() { return prefix;
  }

  public static void getPrefix(String prefix) {
    prefix = prefix.replaceAll("&", "§");
    prefix = prefix;
  }
}
