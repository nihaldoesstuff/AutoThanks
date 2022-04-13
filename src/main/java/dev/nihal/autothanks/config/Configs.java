package dev.nihal.autothanks.config;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;

import java.io.File;


public class Configs extends Vigilant {

    @Property(
            type = PropertyType.SWITCH, name = "Auto Thanks",
            description = "Replies to good luck messages.",
            category = "General", subcategory = "AutoThanks"
    )

    public static boolean autoTYEnabled = true;

    @Property(
            type = PropertyType.SELECTOR, name = "Auto Thanks Phrase",
            description = "Choose what message is said.",
            category = "General", subcategory = "AutoThanks",
            options = {"Thank You", "Good luck to you too!", "Yay! Good luck", "<3", ":)", "You too :D", "ty", "gl to u too", "thanks"}
    )
    public static int tyPhrase = 0;

    @Property(
            type = PropertyType.SLIDER, name = "Delay",
            description = "Delay to say the message.\n§eMeasured in seconds.",
            category = "General", subcategory = "AutoThanks",
            max = 5
    )
    public static int tyDelay = 1;


    public Configs() {
        super(new File("autothanks.toml"), "AutoThanks");
    }
}