package gg.discord.gzPpN5yc44.Movement;

import java.util.TimerTask;

import gg.discord.gzPpN5yc44.Starter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class Forward extends TimerTask {


    @Override
    public void run() {
        int left = Minecraft.getMinecraft().gameSettings.keyBindForward.getKeyCode();

        long oldTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - oldTime < 2000 && Starter.Status == true) {
            KeyBinding.setKeyBindState(left, true);
        }
        KeyBinding.setKeyBindState(left, false);

    }

}
