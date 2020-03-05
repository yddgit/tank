package com.my.project.design.factorymethod;

public class PlaneFactory {
    private PlaneFactory() {}
    private static final PlaneFactory INSTANCE = new PlaneFactory();
    public static PlaneFactory getInstance() {
        return INSTANCE;
    }
    public Movable create() {
        System.out.println("A plane created");
        return new Plane();
    }
}
