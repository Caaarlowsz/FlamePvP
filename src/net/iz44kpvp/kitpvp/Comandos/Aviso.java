package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import net.iz44kpvp.kitpvp.Sistemas.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Aviso implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("aviso")) {
            if (sender.hasPermission("kitpvp.staff")) {
                if (args.length == 0) {
                    sender.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�cSintaxe correta: /aviso (msg)");
                    return true;
                }
                String msg = "";
                for (final String msg2 : args) {
                    msg = String.valueOf(String.valueOf(String.valueOf(msg))) + msg2 + " ";
                }
                Bukkit.broadcastMessage(String.valueOf(String.valueOf(API.preffix)) + ChatColor.RESET + msg.replace("&", "�"));
                return true;
            }
            else {
                sender.sendMessage(API.semperm);
            }
        }
        return false;
    }
}
