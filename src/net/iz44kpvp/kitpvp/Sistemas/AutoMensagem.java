package net.iz44kpvp.kitpvp.Sistemas;

import java.util.Random;

import org.bukkit.Bukkit;

import com.github.caaarlowsz.flamemc.kitpvp.FlamePvP;

public class AutoMensagem {
	public static void start() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(FlamePvP.plugin, new Runnable() {
			String[] msg = { String.valueOf(String.valueOf(API.preffix)) + API.AutoM1,
					String.valueOf(String.valueOf(API.preffix)) + API.AutoM2,
					String.valueOf(String.valueOf(API.preffix)) + API.AutoM3,
					String.valueOf(String.valueOf(API.preffix)) + API.AutoM4,
					String.valueOf(String.valueOf(API.preffix)) + API.AutoM5 };

			@Override
			public void run() {
				Bukkit.getServer().broadcastMessage(this.msg[new Random().nextInt(this.msg.length)]);
			}
		}, 0L, 420L);
	}
}
