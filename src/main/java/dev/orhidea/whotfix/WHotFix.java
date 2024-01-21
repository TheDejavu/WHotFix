package dev.orhidea.whotfix;

import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class WHotFix extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onWitherMove(EntityMoveEvent event){
        Entity entity = event.getEntity();
        if (entity instanceof Wither){
            Location location = event.getTo();
            if (location.getY() <= -1)
                entity.remove();
        }
    }
}
