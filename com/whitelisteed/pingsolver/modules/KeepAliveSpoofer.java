package com.whitelisteed.pingsolver;

import meteordevelopment.meteorclient.events.network.PacketEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.c2s.play.ClientKeepAliveC2SPacket;

public class KeepAliveSpoofer extends Module {
    public KeepAliveSpoofer() {
        super(Category.Misc, "KeepAliveSpoofer", "Spoofs keep alive packets to avoid disconnects on high ping.");
    }

    @EventHandler
    private void onSend(PacketEvent.Send event) {
        if (event.packet instanceof ClientKeepAliveC2SPacket packet) {
            event.setCancelled(true);
            // Send a slightly modified spoofed packet to prevent timeout
            mc.getNetworkHandler().sendPacket(new ClientKeepAliveC2SPacket(packet.getId() + 1));
        }
    }
}
