package com.tnxts.gamefindall.events;

import com.tnxts.gamefindall.items.Items;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GiveItemOnPlayerJoinServer implements Listener {
    private final Items items = new Items();
    @EventHandler
    public void onPlayerJoinServer(PlayerJoinEvent event)
    {
        if(!event.getPlayer().getInventory().contains(items.getItem("小游戏",event.getPlayer())))
        {
            event.getPlayer().getInventory().addItem(items.getItem("小游戏",event.getPlayer()));
        }
    }
}
