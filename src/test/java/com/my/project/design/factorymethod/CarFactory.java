package com.my.project.design.factorymethod;

public class CarFactory {
    private CarFactory() {}
    private static final CarFactory INSTANCE = new CarFactory();
    public static CarFactory getInstance() {
        return INSTANCE;
    }
    public Movable create() {
        System.out.println("A car created");
        return new Car();
    }
}
