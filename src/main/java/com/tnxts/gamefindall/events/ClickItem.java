package com.tnxts.gamefindall.events;

import com.tnxts.gamefindall.GameFindAll;
import com.tnxts.gamefindall.managers.InviteMessageManager;
import com.tnxts.gamefindall.actions.MatchPlayer;
import com.tnxts.gamefindall.managers.RoomManager;
import com.tnxts.gamefindall.customs.QueueRoom;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import org.bukkit.persistence.PersistentDataType;

public class ClickItem implements Listener {
    @EventHandler
    public void onClickItem(InventoryClickEvent event){
        try{
            String playerUUID = event.getWhoClicked().getUniqueId().toString();
            if(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(GameFindAll.getPlugin(),"tag"), PersistentDataType.STRING).equalsIgnoreCase("gamethingcollectionlauncher"))
            {
                if(RoomManager.isPlayerInOneRoom(playerUUID))
                {
                    event.getWhoClicked().sendMessage(ChatColor.RED + "请先退出当前所在房间");
                    return;
                }
                QueueRoom room = new QueueRoom(playerUUID,event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(GameFindAll.getPlugin(),"gameID"), PersistentDataType.STRING));
                RoomManager.exitRoom(playerUUID);
                RoomManager.addRoom(playerUUID,room);
                room.addPlayer(playerUUID);
                MatchPlayer matchPlayer = new MatchPlayer(playerUUID,room);
                InviteMessageManager.addInviteMessage(matchPlayer);
                InviteMessageManager.startInviteMessage(matchPlayer,0,5,playerUUID);
            }
            else if(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(GameFindAll.getPlugin(),"tag"), PersistentDataType.STRING).equalsIgnoreCase("btnexitroomlauncher")){
                RoomManager.exitRoom(playerUUID);
            }
            else if(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(GameFindAll.getPlugin(),"tag"), PersistentDataType.STRING).equalsIgnoreCase("btninviteplayerlauncher")){
               if(InviteMessageManager.hasInviteMessage(playerUUID))
               {
                   InviteMessageManager.removeInviteMessage(InviteMessageManager.getInviteMessage(playerUUID));
                   MatchPlayer matchPlayer = new MatchPlayer(playerUUID,RoomManager.getRoomByPlayerUUID(playerUUID));
                   InviteMessageManager.addInviteMessage(matchPlayer);
                   InviteMessageManager.startInviteMessage(InviteMessageManager.getInviteMessage(playerUUID),0,5,playerUUID);
               }
               else
               {
                   if(InviteMessageManager.getInviteMessage(playerUUID) != null)
                   {
                       event.getWhoClicked().sendMessage(ChatColor.RED + "只有房主能够邀请玩家");
                   }
                   else
                   {
                       event.getWhoClicked().sendMessage(ChatColor.RED + "请先创建一个房间");
                   }

               }
            }
        }
        catch (NullPointerException nullPointerException)
        {}
    }
}
