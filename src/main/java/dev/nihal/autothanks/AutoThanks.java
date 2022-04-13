package dev.nihal.autothanks;

import dev.nihal.autothanks.command.Command;
import dev.nihal.autothanks.config.Configs;

import static dev.nihal.autothanks.config.Configs.tyMessages;
import static dev.nihal.autothanks.config.Configs.getRandomTYmessage;

import gg.essential.api.EssentialAPI;
import gg.essential.api.utils.Multithreading;
import gg.essential.vigilance.Vigilant;
import net.minecraft.client.Minecraft;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Mod(modid = AutoThanks.ID, name = AutoThanks.NAME, version = AutoThanks.VER)

public class AutoThanks {

        // Registering

    @Mod.Instance("autothanks")
    public static AutoThanks instance;

    public static final String NAME = "@NAME@", VER = "@VERSION@", ID = "@ID@";

    public static Vigilant config;

    @Mod.EventHandler
    public void init (FMLInitializationEvent event){
        config = new Configs();
        config.initialize();
        MinecraftForge.EVENT_BUS.register(this);
        new Command().register();
    }
        // All the good luck messages.
        // Thanks to Lan for helping me with this part.
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

        // Here is what happens when any of the above message is detected.

    @SubscribeEvent
    public void onMessageReceieved(ClientChatReceivedEvent event) {
        String msg = event.message.getFormattedText();

        if (EssentialAPI.getMinecraftUtil().isHypixel()) {

            if (Configs.autoTYEnabled){
            }

            if (msg.contains(Minecraft.getMinecraft().getSession().getUsername())) {
                return;
            }

            String[] splitMessage = StringUtils.stripControlCodes(msg).split("\\b");
            for (String currentWord : splitMessage) {
                if (keyWords.contains(currentWord)) {

                    // This is to check if the mod is turned onn and if random messages is onn
                    // It alsp does the message sending!

                    Multithreading.schedule(() -> Minecraft.getMinecraft().thePlayer.sendChatMessage(Configs.randomMessage ? getRandomTYmessage() : Configs.getTYmessage()), Configs.tyDelay, TimeUnit.SECONDS);
                }
            }
        }
    }

    private static String gettyMessages() {
        return tyMessages[Configs.tyMessage];
    }
}