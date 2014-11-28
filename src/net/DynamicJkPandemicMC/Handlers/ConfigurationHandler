package net.DynamicJkPandemicMC.Handlers;

import net.DynamicJkPandemicMC.Main.SettingsManager;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigurationHandler
{
  static SettingsManager settings = SettingsManager.getInstance();

  public static void Check() {
    if (settings.getConfig().getConfigurationSection("Shop.Skipperz") == null)
      settings.getConfig().addDefault("Shop.Skipperz", Boolean.valueOf(true));
    settings.getConfig().addDefault("Shop.Skipper.amount", Integer.valueOf(20));
    settings.saveConfig();
    settings.reloadConfig();
    settings.saveConfig();
  }
}
