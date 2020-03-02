package com.my.project;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        // enemies
        for(int i=0; i<PropertyMgr.getTankInitCount(5); i++) {
            tf.enemies.add(new Tank(50 + i*60, 120, Dir.DOWN, Group.BAD, tf));
        }

        new Thread(() -> new Audio("audio/war1.wav").loop()).start();

        while(true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
