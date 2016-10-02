package tk.roccodev.supertags.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.md_5.bungee.api.ChatColor;

public class ScoreboardUtils {

	
	public static void setPrefix(Player p, String prefix){
		
		Scoreboard board = p.getScoreboard();
		Team pTeam = board.getTeam(p.getName());
		if(pTeam == null){
			pTeam = board.registerNewTeam(p.getName());
		}
		if(prefix.length() >= 15){
			// Prevent kicking all players
			return;
		}
		if((prefix.length() == 2 && prefix.charAt(0) == '&' ) || prefix.length() == 0){
			pTeam.setPrefix(ChatColor.translateAlternateColorCodes('&', prefix));
		}else{
			
		
		pTeam.setPrefix(ChatColor.translateAlternateColorCodes('&', prefix) + " ");
		}
		pTeam.addPlayer(p);
		
	}
	
	public static void removePrefix(Player p){
		setPrefix(p, "");
	}
	
	
}
