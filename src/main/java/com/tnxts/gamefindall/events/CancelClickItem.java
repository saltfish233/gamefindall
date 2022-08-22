package com.tnxts.gamefindall.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CancelClickItem implements Listener {
    @EventHandler
    public void onClickMenu(InventoryClickEvent event) {
            if (event.getView().getTitle().equalsIgnoreCase("小游戏菜单")) {
                event.setCancelled(true);
            }
    }
}