package com.my.project.abstractfactory;

import com.my.project.TankFrame;

public abstract class GameFactory {
    public static final GameFactory DEFAULT = DefaultFactory.getInstance();
    public static final GameFactory LIGHT = LightFactory.getInstance();
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
}
