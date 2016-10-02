package tk.roccodev.supertags;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import tk.roccodev.supertags.utils.ScoreboardUtils;

public class SuperTags extends JavaPlugin{

	@Override
	public void onEnable(){
		
		
		
		
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
		if(label.equalsIgnoreCase("tag")){
			if(args.length == 2){
				Player target = Bukkit.getPlayer(args[1]);
				if(target == null){
					sender.sendMessage("Player not found.");
					return true;
				}
				if(args[0].equalsIgnoreCase("remove")){
				ScoreboardUtils.removePrefix(target);
				sender.sendMessage(ChatColor.GOLD + "Succesfully removed " + target.getName() + "'s prefix.");
				target.sendMessage(ChatColor.GOLD + "Your prefix has been removed.");
				}
				
				
				
			}
			else if(args.length < 3){
				
				sender.sendMessage("Usage: " + cmd.getUsage());
				return true;
			}	
			else{
				String mode = args[0];
				String pName = args[1];
				if(mode.equalsIgnoreCase("set")){
					if(!(args.length == 3)){
						sender.sendMessage("Usage: " + cmd.getUsage() );
						return true;
					}
					String prefix = args[2];
					Player target = Bukkit.getPlayer(pName);
					if(target == null){
						sender.sendMessage("Player not found.");
						return true;
					}
					ScoreboardUtils.setPrefix(target, prefix);
					sender.sendMessage(ChatColor.GOLD + "Succesfully set " + target.getName() + "'s prefix.");
					target.sendMessage(ChatColor.GOLD + "Your prefix is now " + ChatColor.translateAlternateColorCodes('&', prefix));
				}
			}
			
			
		}
		
		return true;
		
	}
	
}
