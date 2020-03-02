package com.my.project;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    private int x;
    private int y;
    private Dir dir;
    private Group group = Group.BAD;
    private TankFrame tf;
    private boolean live = true;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {

        if(!live) return;

        switch(dir) {
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            default:
                break;
        }
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

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }

    public int width() {
        int width = 0;
        switch(dir) {
            case UP:
                width = ResourceMgr.bulletU.getWidth();
                break;
            case DOWN:
                width = ResourceMgr.bulletD.getWidth();
                break;
            case LEFT:
                width = ResourceMgr.bulletL.getWidth();
                break;
            case RIGHT:
                width = ResourceMgr.bulletR.getWidth();
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
                height = ResourceMgr.bulletU.getHeight();
                break;
            case DOWN:
                height = ResourceMgr.bulletD.getHeight();
                break;
            case LEFT:
                height = ResourceMgr.bulletL.getHeight();
                break;
            case RIGHT:
                height = ResourceMgr.bulletR.getHeight();
                break;
            default:
                break;
        }
        return height;
    }

    public void collisionWith(Tank tank) {
        if(this.group == tank.getGroup()) {
            return;
        }
        Rectangle rect1 = new Rectangle(this.x, this.y, this.width(), this.height());
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), tank.width(), tank.height());
        if(rect1.intersects(rect2)) {
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
