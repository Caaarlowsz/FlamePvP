package net.iz44kpvp.kitpvp.Comandos;

import net.iz44kpvp.kitpvp.Sistemas.API;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Aplicar implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("aplicar")) {
            p.sendMessage(API.MSGAplicar1);
        }
        return false;
    }
}
