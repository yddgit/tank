package com.my.project.design.simplefactory;

/**
 * 简单工厂: 可扩展性不好
 */
public class SimpleFactory {
    public Car createCar() {
        // before processing
        return new Car();
    }

    public Plane createPlane() {
        // before processing
        return new Plane();
    }

    public Train createTrain() {
        // before processing
        return new Train();
    }
}
