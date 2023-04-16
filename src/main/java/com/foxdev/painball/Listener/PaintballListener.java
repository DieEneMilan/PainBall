package com.foxdev.painball.Listener;

import com.foxdev.painball.Manager.GameManager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PaintballListener implements Listener {

    private GameManager gameManager;

    public PaintballListener(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player && event.getDamager() instanceof Snowball){
            Player hitPlayer = (Player) event.getEntity();
            if(gameManager.isPlayerInGame(hitPlayer)){
                event.setDamage(5);
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if(gameManager.isPlayerInGame(player)){
            gameManager.removePlayer(player);
        }
    }
}
