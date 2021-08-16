package gg.discord.gzPpN5yc44.FailSafe;


import java.util.TimerTask;

import gg.discord.gzPpN5yc44.Starter;
import net.minecraft.client.Minecraft;

public class Saver extends TimerTask {
    public void run() {
        if(Starter.Status == true) {
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/sethome");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/skyblock");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Minecraft.getMinecraft().thePlayer.sendChatMessage("/is");
        }
    }

}
