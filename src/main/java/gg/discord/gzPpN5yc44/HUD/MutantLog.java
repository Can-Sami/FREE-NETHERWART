package gg.discord.gzPpN5yc44.HUD;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.LinkedList;


public class MutantLog {
    public static int MutantCounter = 0;

    private int counter = 0;
    private int lastCounter = 0;

    public void updateCounter() {
        ItemStack stack = Minecraft.getMinecraft().thePlayer.getHeldItem();
        if(stack != null && stack.hasTagCompound()){
            NBTTagCompound tag = stack.getTagCompound();
            if(tag.hasKey("ExtraAttributes", 10)) {
                NBTTagCompound ea = tag.getCompoundTag("ExtraAttributes");
                if(ea.hasKey("mined_crops", 99)) {
                    counter = ea.getInteger("mined_crops");
                    System.out.println("queue:");
                } else if(ea.hasKey("farmed_cultivating", 99)) {
                    counter = ea.getInteger("farmed_cultivating");
                    System.out.println("queue with cult:" + counter);
                }
            }
        }

    }
}
