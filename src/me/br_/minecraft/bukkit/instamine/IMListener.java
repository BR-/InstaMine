package me.br_.minecraft.bukkit.instamine;

import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockListener;

public class IMListener extends BlockListener {
	IMMain main;

	public IMListener(IMMain main) {
		this.main = main;
	}
	
	public void onBlockDamage(BlockDamageEvent event) {
		if (main.instamining.contains(event.getPlayer())) {
			event.setInstaBreak(true);
		}
	}
}
