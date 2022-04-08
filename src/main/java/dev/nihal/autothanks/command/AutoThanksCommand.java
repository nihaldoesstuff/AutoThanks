package dev.nihal.autothanks.command;

import dev.nihal.autothanks.AutoThanks;

import gg.essential.api.EssentialAPI;
import gg.essential.api.commands.Command;
import gg.essential.api.commands.DefaultHandler;

public class AutoThanksCommand extends Command {
    public AutoThanksCommand() {
        super("autothanks", true);
    }

    @DefaultHandler
    public void handle() {
        EssentialAPI.getGuiUtil().openScreen(AutoThanks.config.gui());
    }
}