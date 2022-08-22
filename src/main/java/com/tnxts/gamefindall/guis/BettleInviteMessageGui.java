package com.tnxts.gamefindall.guis;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BettleInviteMessageGui{

    public static void InvitePlayerMessage(String playerUUID){
        try{
            Player player = Bukkit.getPlayer(UUID.fromString(playerUUID));
            TextComponent textComponent = new TextComponent();
            textComponent.setText(player.getName()+ChatColor.GREEN+"邀请你加入");
            textComponent.setBold(true);
            TextComponent textComponentRoom = new TextComponent();
            textComponentRoom.setText("ta的房间");
            textComponentRoom.setUnderlined(true);
            textComponentRoom.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new Text("点击进入房间")));
            textComponentRoom.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND,"/EnterRoom "+player.getUniqueId().toString()));
            textComponent.addExtra(textComponentRoom);
            Bukkit.spigot().broadcast(textComponent);
        }
        catch (NullPointerException nullPointerException)
        {}
    }
}

