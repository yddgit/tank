package com.my.project;

import java.awt.*;

public class Tank {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    private TankFrame tf;
    private boolean live = true;

    public static final int SPEED = 5;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {

        if(!live) return;

        switch(dir) {
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        if(!moving) return;
        switch(dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }

    public void fire() {
        tf.bullets.add(new Bullet(this.x + 19, this.y + 22, this.dir, this.tf));
    }

    public int width() {
        int width = 0;
        switch(dir) {
            case UP:
                width = ResourceMgr.tankU.getWidth();
                break;
            case DOWN:
                width = ResourceMgr.tankD.getWidth();
                break;
            case LEFT:
                width = ResourceMgr.tankL.getWidth();
                break;
            case RIGHT:
                width = ResourceMgr.tankR.getWidth();
                break;
            default:
                break;
        }
        return width;
    }

    public int height() {
        int height = 0;
        switch(dir) {
            case UP:
                height = ResourceMgr.tankU.getHeight();
                break;
            case DOWN:
                height = ResourceMgr.tankD.getHeight();
                break;
            case LEFT:
                height = ResourceMgr.tankL.getHeight();
                break;
            case RIGHT:
                height = ResourceMgr.tankR.getHeight();
                break;
            default:
                break;
        }
        return height;
    }

    public void die() {
        this.live = false;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
