package PlaceholderAPI;

import SpoutSDK.CraftPlayer;
import SpoutSDK.CraftServer;
import SpoutSDK.ModBase;
import SpoutSDK.ModInfo;
import SpoutSDK.SpoutHelper;

public class Main extends ModBase {
	public static String modName = "PlaceholderAPI";
	public static String version = "1.0.0";
	
	
	public void onStartup(CraftServer argServer) {
		System.out.println("[PlaceholderAPI/INFO]: PlaceholderAPI version " + version + " starting up...");
	}
	
	public static String replacePlaceholders(String string, CraftPlayer plr) {
		String str = string;
		// Player variables
		str = str.replace("%player%", plr.getName());
		str = str.replace("%player_name%", plr.getName());
		str = str.replace("%player_displayname%", plr.getCustomName());
		str = str.replace("%player_uuid%", plr.getUUID().toString());
		str = str.replace("%player_world%", plr.getWorld().getName());
		str = str.replace("%player_flying%", getStringFromBoolean(plr.isFlying()));
		str = str.replace("%player_health%", String.valueOf(plr.getHealth()));
		str = str.replace("%player_max_health%", String.valueOf(plr.getMaxHealth()));
		str = str.replace("%player_food%", String.valueOf(plr.getFoodLevel()));
		str = str.replace("%player_gamemode%", String.valueOf(plr.getGameMode()));
		str = str.replace("%player_x%", String.valueOf(plr.getLocation().x));
		str = str.replace("%player_y%", String.valueOf(plr.getLocation().y));
		str = str.replace("%player_z%", String.valueOf(plr.getLocation().z));
		str = str.replace("%player_exp%", String.valueOf(plr.getExp()));
		str = str.replace("%player_exp_total%", String.valueOf(plr.getTotalExperience()));
		str = str.replace("%player_fly_speed%", String.valueOf(plr.getFlySpeed()));
		str = str.replace("%player_walk_speed%", String.valueOf(plr.getWalkSpeed()));
		str = str.replace("%player_balance%", String.valueOf(plr.getEconomyBalance()));
		// Server variables
		str = str.replace("%server_online%", String.valueOf(SpoutHelper.getServer().getPlayers().size()));
		str = str.replace("%server_max_players%", String.valueOf(SpoutHelper.getServer().getMaxPlayerCount()));
		str = str.replace("%server_motd%", SpoutHelper.getServer().getServerMOTD());
		str = str.replace("%server_minecraft_version%", SpoutHelper.getServer().getMinecraftVersion());
		// Return the string
		return str;
	}
	
	public static String getStringFromBoolean(Boolean foo) {
		if(foo) {
			return "true";
		}
		return "false";
	}
	
    public ModInfo getModInfo() {
		ModInfo info = new ModInfo();
		info.description = "A standardized placeholder API for mod developers (" + version + ")";
		info.name = modName;
		info.version = version;
		info.eventSortOrder = -9999.00;
		return info;
    }

}
