package com.my.project;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private Group group = Group.BAD;
    private boolean moving = true;
    private TankFrame tf;
    private boolean live = true;
    private Random random = new Random();

    public static final int SPEED = 5;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
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
                g.drawImage(Group.GOOD.equals(this.group) ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(Group.GOOD.equals(this.group) ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(Group.GOOD.equals(this.group) ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(Group.GOOD.equals(this.group) ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {

        if(!moving) return;

        if(Group.GOOD.equals(this.group)) {
            new Thread(() -> {
                try(Audio explode = new Audio("audio/tank_move.wav")) {
                    explode.play();
                }
            }).start();
        }

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

        if(Group.BAD.equals(this.group) && random.nextInt(10) > 8) {
            this.fire();
        }
    }

    public void fire() {
        Bullet b = new Bullet(this.x, this.y, this.dir, this.group, this.tf);
        b.setX(this.x + this.width()/2 - b.width()/2);
        b.setY(this.y + this.height()/2 - b.height()/2);
        tf.bullets.add(b);
        if(Group.GOOD.equals(this.group)) {
            new Thread(() -> {
                try(Audio explode = new Audio("audio/tank_fire.wav")) {
                    explode.play();
                }
            }).start();
        }
    }

    public int width() {
        int width = 0;
        switch(dir) {
            case UP:
                width = (Group.GOOD.equals(this.group) ? ResourceMgr.goodTankU : ResourceMgr.badTankU).getWidth();
                break;
            case DOWN:
                width = (Group.GOOD.equals(this.group) ? ResourceMgr.goodTankD : ResourceMgr.badTankD).getWidth();
                break;
            case LEFT:
                width = (Group.GOOD.equals(this.group) ? ResourceMgr.goodTankL : ResourceMgr.badTankL).getWidth();
                break;
            case RIGHT:
                width = (Group.GOOD.equals(this.group) ? ResourceMgr.goodTankR : ResourceMgr.badTankR).getWidth();
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
                height = (Group.GOOD.equals(this.group) ? ResourceMgr.goodTankU : ResourceMgr.badTankU).getHeight();
                break;
            case DOWN:
                height = (Group.GOOD.equals(this.group) ? ResourceMgr.goodTankD : ResourceMgr.badTankD).getHeight();
                break;
            case LEFT:
                height = (Group.GOOD.equals(this.group) ? ResourceMgr.goodTankL : ResourceMgr.badTankL).getHeight();
                break;
            case RIGHT:
                height = (Group.GOOD.equals(this.group) ? ResourceMgr.goodTankR : ResourceMgr.badTankR).getHeight();
                break;
            default:
                break;
        }
        return height;
    }

    public void die() {
        this.live = false;
        int eX = this.x + this.width()/2 - Explode.WIDTH/2;
        int eY = this.y + this.height()/2 - Explode.HEIGHT/2;
        tf.explodes.add(new Explode(eX, eY, tf));
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
