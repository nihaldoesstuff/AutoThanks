package dev.nihal.autothanks.config;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;


public class Configs extends Vigilant {

    // All the thank you messages.
    public static final String[] tyMessages = {"Thank You", "Good luck to you too!", "Yay! Good luck", "<3", ":)", "You too :D", "ty", "gl to u too", "thanks"};

    // Here is what happens when the command /autothanks is ran.

    @Property(
            type = PropertyType.SWITCH, name = "Auto Thanks",
            description = "Replies to good luck messages.",
            category = "General", subcategory = "AutoThanks"
    )

    public static boolean autoTYEnabled = true;

    @Property(
            type = PropertyType.SELECTOR, name = "Auto Thanks Phrase",
            description = "Choose what message is said.",
            category = "General", subcategory = "Configurations",
            options = {"Thank You", "Good luck to you too!", "Yay! Good luck", "<3", ":)", "You too :D", "ty", "gl to u too", "thanks"}
    )
    public static int tyMessage = 0;

    @Property(
            type = PropertyType.SWITCH, name = "Random Messagge",
            description = "Sends a random GG phrase",
            category = "General", subcategory = "Configurations"
    )

    public static boolean randomMessage = false;

    @Property(
            type = PropertyType.SLIDER, name = "Delay",
            description = "Delay to say the message.\n§eMeasured in seconds.",
            category = "General", subcategory = "Configurations",
            max = 5
    )
    public static int tyDelay = 1;

        // This selects a random thank you message from the given list above

    public static String getRandomTYmessage() {
        return tyMessages[ThreadLocalRandom.current().nextInt(tyMessages.length)];
    }

    public static String getTYmessage() {
        return tyMessages [tyMessage];
    }

    public Configs() {
        super(new File("autothanks.toml"), "AutoThanks");
    }
}