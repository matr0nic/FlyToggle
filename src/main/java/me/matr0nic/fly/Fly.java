package me.matr0nic.fly;

import me.matr0nic.fly.fly.commands.FlyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Fly extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("fly").setExecutor(new FlyCommand(this));
    }

}
