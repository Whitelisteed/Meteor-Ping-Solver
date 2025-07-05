package com.whitelisteed.pingsolver;

import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;

public class MyAddon extends MeteorAddon {
    @Override
    public void onInitialize() {
        // Register your module(s) here
        Modules.get().add(new KeepAliveSpoofer());
    }

    @Override
    public String getPackage() {
        return "com.yourname.addonname";
    }
}
