package com.my.project;

import java.awt.*;

public class Tank {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    public static final int SPPED = 10;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }

    private void move() {
        if(!moving) return;
        switch(dir) {
            case LEFT:
                x -= SPPED;
                break;
            case UP:
                y -= SPPED;
                break;
            case RIGHT:
                x += SPPED;
                break;
            case DOWN:
                y += SPPED;
                break;
        }
    }
    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
