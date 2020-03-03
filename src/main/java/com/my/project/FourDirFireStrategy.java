package com.my.project;

public class FourDirFireStrategy implements FireStrategy {

    private FourDirFireStrategy() {}

    private static final FourDirFireStrategy INSTANCE = new FourDirFireStrategy();
    public static FourDirFireStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public void fire(Tank tank) {
        for (Dir dir : Dir.values()) {
            Bullet b = new Bullet(tank.getX(), tank.getY(), dir, tank.getGroup(), tank.getTf());
            b.setX(tank.getX() + tank.width()/2 - b.width()/2);
            b.setY(tank.getY() + tank.height()/2 - b.height()/2);
            tank.getTf().bullets.add(b);
        }
        if(Group.GOOD.equals(tank.getGroup())) {
            new Thread(() -> {
                try(Audio fire = new Audio("audio/tank_fire.wav")) {
                    fire.play();
                }
            }).start();
        }
    }
}
