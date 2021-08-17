package gg.discord.gzPpN5yc44.HUD;

import gg.discord.gzPpN5yc44.Starter;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.LinkedList;


public class MutantLog {

    public static long MutantCounter = 0;
    private Boolean firstBlockBreak = false;

    private long counterFirst = 0;
    private long counter = 0;
    private long counterCult = 0;


    public void updateCounter() {
        ItemStack stack = Minecraft.getMinecraft().thePlayer.getHeldItem();
        if(stack != null && stack.hasTagCompound()){
            NBTTagCompound tag = stack.getTagCompound();
            if(tag.hasKey("ExtraAttributes", 10)) {
                NBTTagCompound ea = tag.getCompoundTag("ExtraAttributes");
                if(ea.hasKey("mined_crops", 99)) {
                    counter = ea.getInteger("mined_crops");
                } else if(ea.hasKey("farmed_cultivating", 99)) {
                    counter = ea.getInteger("farmed_cultivating");
                }
            }
        }

    }
    @SubscribeEvent
    public void blockBreak(TickEvent.ClientTickEvent event) {
        if (Minecraft.getMinecraft().theWorld == null) return;
        if (Minecraft.getMinecraft().thePlayer == null) return;
        ItemStack stack = Minecraft.getMinecraft().thePlayer.getHeldItem();
        if (stack != null && stack.hasTagCompound()) {
            if(stack.getDisplayName().contains("Newton Nether") && Starter.Status) {
                if (!firstBlockBreak) {
                    NBTTagCompound tag = stack.getTagCompound();
                    if (tag.hasKey("ExtraAttributes", 10)) {
                        firstBlockBreak = true;
                        updateCounter();
                        counterFirst = counter + counterCult + 1;
                    }
                } else if (firstBlockBreak) {

                    NBTTagCompound tag = stack.getTagCompound();
                    if (tag.hasKey("ExtraAttributes", 10)) {
                        updateCounter();
                        MutantCounter = counter + counterCult - counterFirst + 1;

                    }
                }
            }
        }
    }
}
