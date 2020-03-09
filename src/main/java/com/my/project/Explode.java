package com.my.project;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explode {

    private int x;
    private int y;
    private TankFrame tf;

    private boolean living = true;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    private int step = 0;

    public void paint(Graphics g) {
        if(!living) return;

        if(step >= ResourceMgr.explodes.length) {
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
        BufferedImage image = ResourceMgr.explodes[step++];
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