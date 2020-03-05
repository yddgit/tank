package com.my.project.design.abstractfactory;

public class ModernFactory extends AbstractFactory {

    private ModernFactory() {}
    private static final ModernFactory INSTANCE = new ModernFactory();
    public static ModernFactory getInstance() {
        return INSTANCE;
    }

    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }

}
