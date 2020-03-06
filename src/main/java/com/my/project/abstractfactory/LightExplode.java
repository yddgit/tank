package com.my.project.abstractfactory;

import com.my.project.Audio;
import com.my.project.ResourceMgr;
import com.my.project.TankFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LightExplode extends BaseExplode {

    private int x;
    private int y;
    private TankFrame tf;

    private boolean living = true;

    public LightExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    private int step = 0;

    public void paint(Graphics g) {
        if(!living) return;

        if(step >= ResourceMgr.lightExplodes.length) {
            this.die();
            return;
        }
        if(step == 1) {
            new Thread(() -> {
                try(Audio explode = new Audio("audio/explode.wav")) {
                    explode.play();
                }
            }).start();
        }
        BufferedImage image = ResourceMgr.lightExplodes[step++];
        g.drawImage(image, x - image.getWidth()/2, y - image.getHeight()/2, null);
    }

    private void die() {
        this.living = false;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }
}