package net.DynamicJkPandemicMC.API;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TitleAPI
{
  private Class<?> packetTitle;
  private Class<?> packetActions;
  private Class<?> nmsChatSerializer;
  private String title = "";
  private ChatColor titleColor = ChatColor.WHITE;
  private String subtitle = "";
  private ChatColor subtitleColor = ChatColor.WHITE;
  private int fadeInTime = -1;
  private int stayTime = -1;
  private int fadeOutTime = -1;
  private boolean ticks = false;

  private static final Map<Class<?>, Class<?>> CORRESPONDING_TYPES = new HashMap();

  public TitleAPI(String title) {
    this.title = title;
    loadClasses();
  }

  public TitleAPI(String title, String subtitle) {
    this.title = title;
    this.subtitle = subtitle;
    loadClasses();
  }

  public TitleAPI(TitleAPI title) {
    this.title = title.title;
    this.subtitle = title.subtitle;
    this.titleColor = title.titleColor;
    this.subtitleColor = title.subtitleColor;
    this.fadeInTime = title.fadeInTime;
    this.fadeOutTime = title.fadeOutTime;
    this.stayTime = title.stayTime;
    this.ticks = title.ticks;
    loadClasses();
  }

  public TitleAPI(String title, String subtitle, int fadeInTime, int stayTime, int fadeOutTime)
  {
    this.title = title;
    this.subtitle = subtitle;
    this.fadeInTime = fadeInTime;
    this.stayTime = stayTime;
    this.fadeOutTime = fadeOutTime;
    loadClasses();
  }

  private void loadClasses() {
    this.packetTitle = getClass("org.spigotmc.ProtocolInjector$PacketTitle");
    this.packetActions = getClass("org.spigotmc.ProtocolInjector$PacketTitle$Action");
    this.nmsChatSerializer = getNMSClass("ChatSerializer");
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public String getSubtitle() {
    return this.subtitle; }

  public void setTitleColor(ChatColor color) {
    this.titleColor = color; }

  public void setSubtitleColor(ChatColor color) {
    this.subtitleColor = color; }

  public void setFadeInTime(int time) {
    this.fadeInTime = time; }

  public void setFadeOutTime(int time) {
    this.fadeOutTime = time; }

  public void setStayTime(int time) {
    this.stayTime = time; }

  public void setTimingsToTicks() {
    this.ticks = true; }

  public void setTimingsToSeconds() {
    this.ticks = false; }

  public void send(Player player) {
    if ((getProtocolVersion(player) < 47) || (!(isSpigot())) || 
      (this.packetTitle == null)) return;
    resetTitle(player);
    try {
      Object handle = getHandle(player);
      Object connection = getField(handle.getClass(), 
        "playerConnection").get(handle);
      Object[] actions = this.packetActions.getEnumConstants();
      Method sendPacket = getMethod(connection.getClass(), 
        "sendPacket", new Class[0]);
      Object packet = this.packetTitle.getConstructor(new Class[] { this.packetActions, 
        Integer.TYPE, Integer.TYPE, Integer.TYPE }).newInstance(new Object[] { 
        actions[2], Integer.valueOf(this.fadeInTime * ((this.ticks) ? 1 : 20)), 
        Integer.valueOf(this.stayTime * ((this.ticks) ? 1 : 20)), 
        Integer.valueOf(this.fadeOutTime * ((this.ticks) ? 1 : 20)) });
      if ((this.fadeInTime != -1) && (this.fadeOutTime != -1) && (this.stayTime != -1)) {
        sendPacket.invoke(connection, new Object[] { packet });
      }
      Object serialized = getMethod(this.nmsChatSerializer, "a", new Class[] { 
        String.class }).invoke(
        null, new Object[] { 
        "{text:\"" + 
        ChatColor.translateAlternateColorCodes('&', 
        this.title) + 
        "\",color:" + 
        this.titleColor.name().toLowerCase() + "}" });
      packet = this.packetTitle.getConstructor(new Class[] { this.packetActions, 
        getNMSClass("IChatBaseComponent") }).newInstance(new Object[] { 
        actions[0], serialized });
      sendPacket.invoke(connection, new Object[] { packet });
      if (this.subtitle != "") {
        serialized = getMethod(this.nmsChatSerializer, "a", new Class[] { String.class })
          .invoke(null, new Object[] { 
          "{text:\"" + 
          ChatColor.translateAlternateColorCodes(
          '&', this.subtitle) + 
          "\",color:" + 
          this.subtitleColor.name()
          .toLowerCase() + 
          "}" });
        packet = this.packetTitle.getConstructor(new Class[] { this.packetActions, 
          getNMSClass("IChatBaseComponent") }).newInstance(new Object[] { 
          actions[1], serialized });
        sendPacket.invoke(connection, new Object[] { packet });
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void broadcast()
  {
    for (Player p : Bukkit.getOnlinePlayers())
      send(p);
  }

  public void clearTitle(Player player) {
    if ((getProtocolVersion(player) < 47) || (!(isSpigot()))) return;
    try {
      Object handle = getHandle(player);
      Object connection = getField(handle.getClass(), 
        "playerConnection").get(handle);
      Object[] actions = this.packetActions.getEnumConstants();
      Method sendPacket = getMethod(connection.getClass(), 
        "sendPacket", new Class[0]);
      Object packet = this.packetTitle.getConstructor(new Class[] { this.packetActions })
        .newInstance(new Object[] { 
        actions[3] });
      sendPacket.invoke(connection, new Object[] { packet });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void resetTitle(Player player) {
    if ((getProtocolVersion(player) < 47) || (!(isSpigot()))) return;
    try {
      Object handle = getHandle(player);
      Object connection = getField(handle.getClass(), 
        "playerConnection").get(handle);
      Object[] actions = this.packetActions.getEnumConstants();
      Method sendPacket = getMethod(connection.getClass(), 
        "sendPacket", new Class[0]);
      Object packet = this.packetTitle.getConstructor(new Class[] { this.packetActions })
        .newInstance(new Object[] { 
        actions[4] });
      sendPacket.invoke(connection, new Object[] { packet });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private int getProtocolVersion(Player player) {
    int version = 0;
    try {
      Object handle = getHandle(player);
      Object connection = getField(handle.getClass(), "playerConnection")
        .get(handle);
      Object networkManager = getValue("networkManager", connection);
      version = ((Integer)getMethod("getVersion", 
        networkManager.getClass(), new Class[0]).invoke(networkManager, new Object[0])).intValue();

      return version;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return version; }

  private boolean isSpigot() {
    return Bukkit.getVersion().contains("Spigot"); }

  private Class<?> getClass(String namespace) {
    try {
      return Class.forName(namespace);
    }
    catch (Exception localException) {
    }
    return null;
  }

  private Field getField(String name, Class<?> clazz) throws Exception {
    return clazz.getDeclaredField(name);
  }

  private Object getValue(String name, Object obj) throws Exception {
    Field f = getField(name, obj.getClass());
    f.setAccessible(true);
    return f.get(obj);
  }

  private Class<?> getPrimitiveType(Class<?> clazz) {
    return ((CORRESPONDING_TYPES.containsKey(clazz)) ? 
      (Class)CORRESPONDING_TYPES
      .get(clazz) : clazz);
  }

  private Class<?>[] toPrimitiveTypeArray(Class<?>[] classes) {
    int a = (classes != null) ? classes.length : 0;
    Class[] types = new Class[a];
    for (int i = 0; i < a; ++i)
      types[i] = getPrimitiveType(classes[i]);
    return types;
  }

  private static boolean equalsTypeArray(Class<?>[] a, Class<?>[] o) {
    if (a.length != o.length)
      return false;
    for (int i = 0; i < a.length; ++i)
      if ((!(a[i].equals(o[i]))) && (!(a[i].isAssignableFrom(o[i]))))
        return false;
    return true;
  }

  private Object getHandle(Object obj) {
    try {
      return getMethod("getHandle", obj.getClass(), new Class[0]).invoke(obj, new Object[0]);
    } catch (Exception e) {
      e.printStackTrace(); }
    return null;
  }

  private Method getMethod(String name, Class<?> clazz, Class<?>[] paramTypes)
  {
    Class[] t = toPrimitiveTypeArray(paramTypes);
    for (Method m : clazz.getMethods()) {
      Class[] types = toPrimitiveTypeArray(m.getParameterTypes());
      if ((m.getName().equals(name)) && (equalsTypeArray(types, t)))
        return m;
    }
    return null;
  }

  private String getVersion() {
    String name = Bukkit.getServer().getClass().getPackage().getName();
    String version = name.substring(name.lastIndexOf(46) + 1) + ".";
    return version;
  }

  private Class<?> getNMSClass(String className) {
    String fullName = "net.minecraft.server." + getVersion() + className;
    Class clazz = null;
    try {
      clazz = Class.forName(fullName);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return clazz;
  }

  private Field getField(Class<?> clazz, String name) {
    try {
      Field field = clazz.getDeclaredField(name);
      field.setAccessible(true);
      return field;
    } catch (Exception e) {
      e.printStackTrace(); }
    return null;
  }

  private Method getMethod(Class<?> clazz, String name, Class<?>[] args)
  {
    for (Method m : clazz.getMethods()) {
      if ((!(m.getName().equals(name))) || (
        (args.length != 0) && 
        (!(ClassListEqual(args, 
        m.getParameterTypes()))))) continue;
      m.setAccessible(true);
      return m;
    }
    return null;
  }

  private boolean ClassListEqual(Class<?>[] l1, Class<?>[] l2) {
    boolean equal = true;
    if (l1.length != l2.length)
      return false;
    for (int i = 0; i < l1.length; ++i)
      if (l1[i] != l2[i]) {
        equal = false;
        break;
      }
    return equal;
  }
}
