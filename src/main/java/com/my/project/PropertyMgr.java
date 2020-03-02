package com.my.project;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    private static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public static int getTankInitCount(int defaultCount) {
        return Integer.parseInt(get("tank.count.init", Integer.toString(defaultCount)));
    }

    public static int getTankSpeed(int defaultSpeed) {
        return Integer.parseInt(get("tank.speed", Integer.toString(defaultSpeed)));
    }

    public static int getBulletSpeed(int defaultSpeed) {
        return Integer.parseInt(get("bullet.speed", Integer.toString(defaultSpeed)));
    }

    public static int getGameWidth(int defaultWidth) {
        return Integer.parseInt(get("game.width", Integer.toString(defaultWidth)));
    }

    public static int getGameHeight(int defaultHeight) {
        return Integer.parseInt(get("game.height", Integer.toString(defaultHeight)));
    }
}
