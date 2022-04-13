package dev.nihal.autothanks.command;

import dev.nihal.autothanks.AutoThanks;

import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.DefaultHandler;

    // This is to add the mod command i.e /autothanks

public class Command extends gg.essential.api.commands.Command {
    public Command() {
        super("autothanks", true);
    }

    @DefaultHandler
    public void handle() {
        EssentialAPI.getGuiUtil().openScreen(AutoThanks.config.gui());
    }
}