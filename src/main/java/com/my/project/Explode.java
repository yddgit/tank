package com.my.project;

import java.awt.*;

public class Explode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

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
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
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