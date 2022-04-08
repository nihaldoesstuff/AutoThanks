package dev.nihal.autothanks;

import dev.nihal.autothanks.command.AutoThanksCommand;
import dev.nihal.autothanks.config.Configs;
import gg.essential.api.EssentialAPI;
import gg.essential.vigilance.Vigilant;
import net.minecraft.client.Minecraft;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


@Mod(modid = AutoThanks.ID, name = AutoThanks.NAME, version = AutoThanks.VER)

public class AutoThanks {


    @Mod.Instance("autothanks")
    public static AutoThanks instance;

    public static final String NAME = "@NAME@", VER = "@VERSION@", ID = "@ID@";

    public static Vigilant config;

    private static final String[] tymessages = {"Thank You", "Good luck to you too!", "Yay! Good luck", "<3", ":)", "You too :D", "ty", "gl to u too", "thanks"};


    @Mod.EventHandler
    public void init (FMLInitializationEvent event){
        config = new Configs();
        config.initialize();
        MinecraftForge.EVENT_BUS.register(this);
        new AutoThanksCommand().register();

    }

    public void onMessageReceived(@NotNull ClientChatReceivedEvent event) {

    }

    private static ArrayList<String> keyWords = getKeyWords();

    private static ArrayList<String> getKeyWords() {
        ArrayList returnList = new ArrayList<String>();
        returnList.add("glhf");
        returnList.add("GLHF");
        returnList.add("GlHf");
        returnList.add("hf");
        returnList.add("HF");
        returnList.add("gl");
        returnList.add("GL");
        returnList.add("good luck");
        returnList.add("Good luck");
        returnList.add("Good Luck");
        returnList.add("have fun");
        returnList.add("Have fun");
        returnList.add("Have Fun");
        returnList.add("good luck have fun");
        returnList.add("Good luck have fun");
        returnList.add("Good Luck Have Fun");
        return returnList;
    }

    @SubscribeEvent
    public void onMessageReceieved(ClientChatReceivedEvent event) {
        String msg = event.message.getFormattedText();

        if (Configs.autoTYEnabled) {

            if (EssentialAPI.getMinecraftUtil().isHypixel()) {
            }

            if (msg.contains(Minecraft.getMinecraft().getSession().getUsername())) {
                return;
            }
            String[] splitMessage = StringUtils.stripControlCodes(msg).split("\\b");
            for (String currentWord : splitMessage) {
                if (keyWords.contains(currentWord)) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("/ac " + gettyMessages());
                }
            }
        }

    }

    private static String gettyMessages() {
        return tymessages[Configs.tyPhrase];
    }

}


