package com.my.project;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {
    private static final int SPEED = PropertyMgr.getBulletSpeed(10);
    private int x;
    private int y;
    private Dir dir;
    private Group group = Group.BAD;
    private TankFrame tf;
    private boolean live = true;
    private Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        this.rectangle.x = this.x;
        this.rectangle.y = this.y;
        this.rectangle.width = this.width();
        this.rectangle.height = this.height();
    }

    private BufferedImage currentImage() {
        switch(dir) {
            case UP:
                return ResourceMgr.bulletU;
            case DOWN:
                return ResourceMgr.bulletD;
            case LEFT:
                return ResourceMgr.bulletL;
            case RIGHT:
                return ResourceMgr.bulletR;
            default:
                return null;
        }
    }

    public void paint(Graphics g) {
        if(!live) return;
        g.drawImage(currentImage(), x, y, null);
        move();
    }

    private void move() {
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

        this.rectangle.x = this.x;
        this.rectangle.y = this.y;

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }

    public int width() {
        return currentImage().getWidth();
    }

    public int height() {
        return currentImage().getHeight();
    }

    public void collisionWith(Tank tank) {
        if(this.group == tank.getGroup()) {
            return;
        }
        if(rectangle.intersects(tank.getRectangle())) {
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.live = false;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
}
