package me.matr0nic.fly.fly.commands;

import me.matr0nic.fly.Fly;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class FlyCommand implements CommandExecutor {

    private final Fly plugin;

    public FlyCommand(Fly plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NonNull String[] args) {
        if (sender instanceof Player player) {
            if (!player.hasPermission("fly.fly")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to fly.");
                return true;
            }
            player.setAllowFlight(!player.getAllowFlight());
            if (player.getAllowFlight()) {
                player.sendMessage(ChatColor.GREEN + "Fly has been enabled.");
            } else {
                player.sendMessage(ChatColor.RED + "Fly has been disabled.");
            }
        } else {
            plugin.getLogger().severe("You must be a player to fly.");
        }

        return true;
    }

}