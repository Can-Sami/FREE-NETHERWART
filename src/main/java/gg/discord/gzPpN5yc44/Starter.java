package gg.discord.gzPpN5yc44;


import gg.discord.gzPpN5yc44.Movement.Forward;
import gg.discord.gzPpN5yc44.Movement.Left;
import gg.discord.gzPpN5yc44.Movement.Right;
import gg.discord.gzPpN5yc44.Whitelist.WhitelistHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import java.io.IOException;
import java.util.Timer;

public class Starter {
    public static volatile Boolean Status = false;
    public  volatile static Boolean tested = false;
    private Boolean Clicker = false;
    Timer timer = new Timer();
    Thread getP = new Thread(new WhitelistHandler());

    @SubscribeEvent
    public void onTickEvent(TickEvent.ClientTickEvent event){
        if(Clicker == true) {
            KeyBinding.onTick((Minecraft.getMinecraft()).gameSettings.keyBindAttack.getKeyCode());
        }

    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) throws InterruptedException, IOException {
        if (ForgeMain.keybinding.isKeyDown()) {
            if(!Status) {
                if(tested){
                    if(WhitelistHandler.Raw.contains("true")){
                        EntityPlayerSP entityPlayerSP = (Minecraft.getMinecraft()).thePlayer;
                        entityPlayerSP.addChatComponentMessage((IChatComponent) new ChatComponentText(EnumChatFormatting.YELLOW + "[FLEX SCRIPT]:" + EnumChatFormatting.WHITE + " You have" + EnumChatFormatting.AQUA + " successfully" + EnumChatFormatting.WHITE + " ran the FREE NetherWart Bot! You can always buy the PREMIUM from our discord:" + EnumChatFormatting.AQUA + " https://discord.gg/gzPpN5yc44"));
                        Status = true;
                        Clicker = true;
                        timer.schedule(new Left(), 1000, 71000);
                        timer.schedule(new Forward(), 34000, 71000);
                        timer.schedule(new Right(), 36000, 71000);
                        timer.schedule(new Forward(), 69000, 71000);

                } else{
                        EntityPlayerSP entityPlayerSP = (Minecraft.getMinecraft()).thePlayer;
                        entityPlayerSP.addChatComponentMessage((IChatComponent) new ChatComponentText(EnumChatFormatting.YELLOW + "[FLEX SCRIPT]:" + EnumChatFormatting.WHITE + " BOT creator has disabled this bot please join" + EnumChatFormatting.AQUA + " https://discord.gg/gzPpN5yc44" + EnumChatFormatting.WHITE + " for more info."));

                }
                    
                }
            }else{
                EntityPlayerSP entityPlayerSP = (Minecraft.getMinecraft()).thePlayer;
                entityPlayerSP.addChatComponentMessage((IChatComponent) new ChatComponentText(EnumChatFormatting.YELLOW + "[FLEX SCRIPT]:" + EnumChatFormatting.WHITE + " Bot is already running."));

            }
        }if(ForgeMain.keybinding1.isKeyDown()){
            if(Status) {
                Status = false;
                System.out.println(Status.booleanValue());
                timer.cancel();
                timer = new Timer();
                Clicker = false;
                EntityPlayerSP entityPlayerSP = (Minecraft.getMinecraft()).thePlayer;
                entityPlayerSP.addChatComponentMessage((IChatComponent) new ChatComponentText(EnumChatFormatting.YELLOW + "[FLEX SCRIPT]:" + EnumChatFormatting.WHITE + " Bot is stopping now..."));


            }
            else if(!Status) {
                EntityPlayerSP entityPlayerSP = (Minecraft.getMinecraft()).thePlayer;
                entityPlayerSP.addChatComponentMessage((IChatComponent) new ChatComponentText(EnumChatFormatting.YELLOW + "[FLEX SCRIPT]:" + EnumChatFormatting.WHITE + " Bot is not running?"));
            }

        }
    }

    @SubscribeEvent
    public void serverJoin(FMLNetworkEvent.ClientConnectedToServerEvent event){
        if((!tested)){
            getP.start();
        }
    }

}
