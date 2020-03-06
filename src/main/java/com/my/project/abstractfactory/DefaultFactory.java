package com.my.project.abstractfactory;

import com.my.project.Explode;
import com.my.project.TankFrame;

public class DefaultFactory extends GameFactory {

    private DefaultFactory() {}
    private static final DefaultFactory INSTANCE = new DefaultFactory();
    public static DefaultFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x, y, tf);
    }

}
