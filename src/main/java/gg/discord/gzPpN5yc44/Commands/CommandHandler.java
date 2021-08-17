package gg.discord.gzPpN5yc44.Commands;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class CommandHandler extends CommandBase {
    public static Boolean antiStuck = false;

    @Override
    public String getCommandName() {
        return "antistuck";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/antistuck";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        System.out.println(antiStuck);
        System.out.println("command passed");
        if (iCommandSender instanceof EntityPlayer){
            if(antiStuck == false){
                EntityPlayerSP entityPlayerSP = (Minecraft.getMinecraft()).thePlayer;
                entityPlayerSP.addChatComponentMessage((IChatComponent) new ChatComponentText(EnumChatFormatting.YELLOW + "[FLEX SCRIPT]" + EnumChatFormatting.WHITE + " This is a" + EnumChatFormatting.GREEN + " Premium" + EnumChatFormatting.WHITE + " feature like FailSafe. If you wish to purchase you can join our discord:" + EnumChatFormatting.GREEN + " https://discord.gg/gzPpN5yc44"));


            }



        }

    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }


}