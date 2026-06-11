package me.matr0nic.fly;

import me.matr0nic.fly.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Plugin to enable the player to fly.
 * @author matr0nic
 * @version 2026-06-11
 */

public final class FlyToggle extends JavaPlugin {

    /**
     * Registers the fly command on the server..
     */
    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new FlyCommand(this));
    }

}
