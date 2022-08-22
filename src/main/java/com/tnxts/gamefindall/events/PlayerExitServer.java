package com.tnxts.gamefindall.events;

import com.tnxts.gamefindall.managers.RoomManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerExitServer implements Listener {
    @EventHandler
    public void ExitServer(PlayerQuitEvent event){
        Player player = event.getPlayer();
        RoomManager.exitRoom(player.getUniqueId().toString());
    }

}
