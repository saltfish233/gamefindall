package com.tnxts.gamefindall.events;

import com.tnxts.gamefindall.GameFindAll;
import com.tnxts.gamefindall.guis.GuiHub;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataType;


public class OpenMenu implements Listener {
    @EventHandler
    public void onClickMenu(PlayerInteractEvent event){
        try {
//            if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6小游戏"))
            if(event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(GameFindAll.getPlugin(),"tag"), PersistentDataType.STRING).equalsIgnoreCase("littlegamelauncher"))
            {
                if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
                {
                    GuiHub.openGameMenuGui(event.getPlayer().getUniqueId().toString());
                }
            }
            }
        catch (NullPointerException exception)
        {

        }
    }
}
