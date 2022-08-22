package com.tnxts.gamefindall;

import com.convallyria.languagy.api.language.Language;
import com.convallyria.languagy.api.language.Translator;
import com.tnxts.gamefindall.commands.EnterRoom;
import com.tnxts.gamefindall.events.*;
import com.tnxts.gamefindall.games.thingscollection.actions.ClickRequiredItem;
import com.tnxts.gamefindall.utils.Translations;
import org.bukkit.plugin.java.JavaPlugin;

public final class GameFindAll extends JavaPlugin {

    private static GameFindAll plugin;
    private static Translator translator;


    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("收集物品小游戏插件加载成功");
        plugin = this;
        translator = Translator.of(this,Language.CHINESE_SIMPLIFIED);

        Translations.generateLang(plugin);
        getServer().getPluginManager().registerEvents(new GiveItemOnPlayerJoinServer(),this);
        getServer().getPluginManager().registerEvents(new OpenMenu(),this);
        getServer().getPluginManager().registerEvents(new CancelClickItem(),this);
        getServer().getPluginManager().registerEvents(new ClickItem(),this);
        getServer().getPluginManager().registerEvents(new PlayerExitServer(),this);
        //thingscollection
        getServer().getPluginManager().registerEvents(new ClickRequiredItem(),this);

        getCommand("EnterRoom").setExecutor(new EnterRoom());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("收集物品小游戏插件停止");
        translator.close(); // IMPORTANT! See below.

    }

    public static Translator getTranslator() {
        return translator;
    }

    public static GameFindAll getPlugin() {
        return plugin;
    }



}
