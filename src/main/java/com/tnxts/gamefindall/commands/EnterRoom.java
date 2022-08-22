package com.tnxts.gamefindall.commands;

import com.tnxts.gamefindall.customs.QueueRoom;
import com.tnxts.gamefindall.managers.RoomManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class EnterRoom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try{

            if(sender instanceof Player)
            {
                Player player = (Player) sender;
                if(args.length <= 0)
                {
                    sender.sendMessage(ChatColor.RED + "请输入正确的房间ID");
                    return false;
                }
                HashMap<String,QueueRoom> roomManager = RoomManager.getRoomManager();
                for(QueueRoom room:roomManager.values())
                {
                    if(room.getRoomUUID().equalsIgnoreCase(args[0]))
                    {
                        if(RoomManager.isPlayerInOtherRoom(player.getUniqueId().toString(),room.getRoomUUID()))
                        {
                            player.sendMessage(ChatColor.RED +  "请先退出其它房间");
                            return false;
                        }
                        room.addPlayer(player.getUniqueId().toString());
                        for(String aPlayer:room.getPlayers())
                        {
                            sender.sendMessage(Bukkit.getPlayer(UUID.fromString(aPlayer)).getName());
                        }
                        break;
                    }
                }
            }
        }
        catch (NullPointerException nullPointerException)
        {
        }
        return false;
    }
}
