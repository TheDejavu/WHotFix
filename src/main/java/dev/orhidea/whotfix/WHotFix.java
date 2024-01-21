package dev.orhidea.whotfix;

import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class WHotFix extends JavaPlugin implements Listener {

    private int yThreshold;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();
        yThreshold = getConfig().getInt("yThreshold", -1);
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {}

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onWitherMove(EntityMoveEvent event){
        Entity entity = event.getEntity();
        if (entity instanceof Wither){
            Location location = event.getTo();
            if (location.getBlockY() <= yThreshold)
                entity.remove();
        }
    }
}
