package me.br_.minecraft.bukkit.instamine;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

public class IMMain extends JavaPlugin {
	public Set<Player> instamining = new HashSet<Player>();

	@Override
	public void onDisable() {
		System.out.println("[InstaMine] Disabled.");
	}

	@Override
	public void onEnable() {
		this.getServer()
				.getPluginManager()
				.registerEvent(Event.Type.BLOCK_DAMAGE, new IMListener(this),
						Event.Priority.Normal, this);
		System.out.println("[InstaMine] Enabled.");
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (instamining.contains((Player) sender)) {
			sender.sendMessage("You're now slowmining.");
			instamining.remove((Player) sender);
		} else {
			sender.sendMessage("You're now instamining.");
			instamining.add((Player) sender);
		}
		return true;
	}
}
