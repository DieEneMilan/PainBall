package com.foxdev.painball;

import com.foxdev.painball.Commands.PaintballCommands;
import com.foxdev.painball.Listener.PaintballListener;
import com.foxdev.painball.Manager.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PainBall extends JavaPlugin {

    private GameManager gameManager;

    @Override
    public void onEnable() {
        gameManager = new GameManager();
        getCommand("paintball").setExecutor(new PaintballCommands(gameManager));
        getServer().getPluginManager().registerEvents(new PaintballListener(gameManager), this);

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
