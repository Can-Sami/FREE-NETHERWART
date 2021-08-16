package gg.discord.gzPpN5yc44.HUD;

import gg.discord.gzPpN5yc44.ForgeMain;
import gg.discord.gzPpN5yc44.Starter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HUDOverlay extends GuiScreen {

    @SubscribeEvent
    public void Render(RenderGameOverlayEvent.Post event){
        if (event.type == RenderGameOverlayEvent.ElementType.TEXT) {
            Minecraft.getMinecraft().fontRendererObj.drawString("BOT Running: " + Starter.Status, 10, 10, 0xB5F498, false);
        }
    }

}
