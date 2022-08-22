package com.tnxts.gamefindall.guis;

import com.tnxts.gamefindall.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class GameMenuGui{
    public GameMenuGui(){}
    public static void mainGui(String playerUUID){
        Player player = Bukkit.getPlayer(UUID.fromString(playerUUID));
        Inventory gui = Bukkit.createInventory(player,4*9,"小游戏菜单");

        ItemStack gameCollectionThings =  new Items().getItem("物品收集竞速",player);
        ItemStack btnExitRoom = new Items().getItem("退出房间",player);
        ItemStack btnInvitePlayer = new Items().getItem("邀请玩家",player);

        gui.setItem(13,gameCollectionThings);
        gui.setItem(34,btnInvitePlayer);
        gui.setItem(35,btnExitRoom);

        player.openInventory(gui);
    }
}
