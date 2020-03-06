package com.my.project.abstractfactory;

import com.my.project.TankFrame;

public class LightFactory extends GameFactory {

    private LightFactory() {}
    private static final LightFactory INSTANCE = new LightFactory();
    public static LightFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new LightExplode(x, y, tf);
    }

}
