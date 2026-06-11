package me.matr0nic.fly.commands;

import me.matr0nic.fly.FlyToggle;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

/**
 * Enables the player to fly through a command.
 * @author matr0nic
 * @version 2026-06-11
 */
public class FlyCommand implements CommandExecutor {

    private final FlyToggle plugin;

    /**
     * Initializes the fly command.
     * @param plugin the plugin
     */
    public FlyCommand(FlyToggle plugin) {
        this.plugin = plugin;
    }

    /**
     * If the command executor is a player, the command gets executed for the player.
     * The command toggles flight being on or off, by fetching the current flying state.
     *
     * @param sender Source of the command
     * @param command Command which was executed
     * @param label Alias of the command which was used
     * @param args Passed command arguments
     * @return always true, to prevent output
     */
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