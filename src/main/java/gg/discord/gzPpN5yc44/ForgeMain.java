package gg.discord.gzPpN5yc44;

import gg.discord.gzPpN5yc44.Commands.CommandHandler;
import gg.discord.gzPpN5yc44.HUD.HUDOverlay;
import gg.discord.gzPpN5yc44.HUD.MutantLog;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = "NetherWart", version = "0.5", name = "BOT", acceptedMinecraftVersions = "[1.8.9]")
public class ForgeMain {
    Starter keybind = new Starter();
    MutantLog mutantLog = new MutantLog();
    HUDOverlay HUD = new HUDOverlay();
    public static ForgeMain Instance;

    public static Logger logger = FMLLog.getLogger();

    public static KeyBinding keybinding = new KeyBinding("Start", 37, "NetherWart-Farmer");
    public static KeyBinding keybinding1 = new KeyBinding("Stop", 38, "NetherWart-Farmer");

    public static final String modId = "NetherWart";

    public static final String name = "BOT";

    public static final String version = "0.5";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        Instance = this;
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(HUD);
        MinecraftForge.EVENT_BUS.register(Instance.keybind);
        MinecraftForge.EVENT_BUS.register(mutantLog);
        ClientCommandHandler.instance.registerCommand(new CommandHandler());

        ClientRegistry.registerKeyBinding(keybinding);
        ClientRegistry.registerKeyBinding(keybinding1);


    }
}
