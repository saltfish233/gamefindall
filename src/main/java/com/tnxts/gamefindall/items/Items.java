package com.tnxts.gamefindall.items;

import com.tnxts.gamefindall.GameFindAll;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class Items {
    public ItemStack getItem(String itemName,Player player) {
        try {
            if (itemName.equalsIgnoreCase("小游戏")) {
                ItemStack gameMenu = new ItemStack(Material.BOOK, 1);
                ItemMeta gameMenuMeta = gameMenu.getItemMeta();
                PersistentDataContainer gameData = gameMenuMeta.getPersistentDataContainer();
                if (!gameData.has(new NamespacedKey(GameFindAll.getPlugin(), "tag"), PersistentDataType.STRING)) {
                    gameData.set(new NamespacedKey(GameFindAll.getPlugin(), "tag"), PersistentDataType.STRING, "littlegamelauncher");
                }
                gameMenuMeta.setDisplayName("§6小游戏");
                ArrayList<String> lore = new ArrayList<>();
                lore.add("OPEN THE GAME MENU");
                gameMenuMeta.setLore(lore);
                gameMenu.setItemMeta(gameMenuMeta);
                return gameMenu;
            } else if (itemName.equalsIgnoreCase("物品收集竞速")) {
                ItemStack gameCollectionThings = new ItemStack(Material.RED_SHULKER_BOX);
                ItemMeta gameCollectionThingsMeta = gameCollectionThings.getItemMeta();
                PersistentDataContainer gameData = gameCollectionThingsMeta.getPersistentDataContainer();
                if (!gameData.has(new NamespacedKey(GameFindAll.getPlugin(), "tag"), PersistentDataType.STRING)) {
                    gameData.set(new NamespacedKey(GameFindAll.getPlugin(), "tag"), PersistentDataType.STRING, "gamethingcollectionlauncher");
                    gameData.set(new NamespacedKey(GameFindAll.getPlugin(), "gameID"), PersistentDataType.STRING, "0");
                }
                gameCollectionThingsMeta.setDisplayName("§a物品收集竞速");
                ArrayList<String> lore = new ArrayList<>();
                lore.add("最先收集完所有物品的人将获得胜利");
                gameCollectionThingsMeta.setLore(lore);
                gameCollectionThings.setItemMeta(gameCollectionThingsMeta);
                return gameCollectionThings;
            } else if (itemName.equalsIgnoreCase("退出房间")) {
                ItemStack btnExitRoom = new ItemStack(Material.BARRIER);
                ItemMeta btnExitRoomMeta = btnExitRoom.getItemMeta();
                PersistentDataContainer btnData = btnExitRoomMeta.getPersistentDataContainer();
                if (!btnData.has(new NamespacedKey(GameFindAll.getPlugin(), "tag"), PersistentDataType.STRING)) {
                    btnData.set(new NamespacedKey(GameFindAll.getPlugin(), "tag"), PersistentDataType.STRING, "btnexitroomlauncher");
                }
                btnExitRoomMeta.setDisplayName(ChatColor.RED + "退出房间");
                ArrayList<String> lore = new ArrayList<>();
                lore.add("点击退出所有房间");
                btnExitRoomMeta.setLore(lore);
                btnExitRoom.setItemMeta(btnExitRoomMeta);
                return btnExitRoom;
            } else if (itemName.equalsIgnoreCase("邀请玩家")) {
                ItemStack btnInvitePlayer = new ItemStack(Material.ACACIA_BOAT);
                ItemMeta btnInvitePlayerMeta = btnInvitePlayer.getItemMeta();
                PersistentDataContainer btnData = btnInvitePlayerMeta.getPersistentDataContainer();
                if (!btnData.has(new NamespacedKey(GameFindAll.getPlugin(), "tag"), PersistentDataType.STRING)) {
                    btnData.set(new NamespacedKey(GameFindAll.getPlugin(), "tag"), PersistentDataType.STRING, "btninviteplayerlauncher");
                }
                btnInvitePlayerMeta.setDisplayName(ChatColor.RED + "邀请玩家");
                ArrayList<String> lore = new ArrayList<>();
                lore.add("点击邀请全体玩家");
                btnInvitePlayerMeta.setLore(lore);
                btnInvitePlayer.setItemMeta(btnInvitePlayerMeta);
                return btnInvitePlayer;
            }
        }
        catch (NullPointerException nullPointerException)
        {}
        return null;
    }
}
