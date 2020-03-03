package com.my.project;

public class DefaultFireStrategy implements FireStrategy {

    private DefaultFireStrategy() {}

    private static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();
    public static FireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(Tank tank) {
        Bullet b = new Bullet(tank.getX(), tank.getY(), tank.getDir(), tank.getGroup(), tank.getTf());
        b.setX(tank.getX() + tank.width()/2 - b.width()/2);
        b.setY(tank.getY() + tank.height()/2 - b.height()/2);
        tank.getTf().bullets.add(b);
        if(Group.GOOD.equals(tank.getGroup())) {
            new Thread(() -> {
                try(Audio fire = new Audio("audio/tank_fire.wav")) {
                    fire.play();
                }
            }).start();
        }
    }
}
