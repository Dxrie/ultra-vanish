package ultravanish.ultravanish.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

public class UltraVanish implements CommandExecutor {

    ultravanish.ultravanish.UltraVanish plugin;

    public UltraVanish(ultravanish.ultravanish.UltraVanish plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (ultravanish.ultravanish.UltraVanish.invisiblePlayers.contains(player)) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        if (player.isOp()) {
                            players.showPlayer(plugin, player);
                            players.sendMessage("§c[/] " + sender.getName() + " has disabled vanish mode.");
                            players.sendMessage("§e" + player.getName() + " joined the game");
                        } else {
                            player.showPlayer(plugin, players);
                            players.sendMessage("§e" + player.getName() + " joined the game");
                        }
                    }
                    ultravanish.ultravanish.UltraVanish.invisiblePlayers.remove(player);
                    sender.sendMessage("§c[/] You are now unvanished and everybody on the server are able to see you.");
                } else {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        if (players.isOp()) {
                            players.sendMessage("§c[/] " + sender.getName() + " are now vanished.");
                        } else {
                            players.hidePlayer(plugin, player);
                        }
                        players.sendMessage("§e" + player.getName() + " left the game");
                    }

                    ultravanish.ultravanish.UltraVanish.invisiblePlayers.add(player);
                    sender.sendMessage("§c[/] You are now vanished and nobody on the server are able to see you except for operators.");
                }
            } else {
                sender.sendMessage("§4[!] Online players are allowed to vanish themself, console are unable to do that !");
            }
        } else {
            sender.sendMessage("§4[!] No argument are allowed on this command. | Usage : /vanish");
        }

        return true;
    }
}
