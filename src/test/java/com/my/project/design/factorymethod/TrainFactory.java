package com.my.project.design.factorymethod;

public class TrainFactory {
    private TrainFactory() {}
    private static final TrainFactory INSTANCE = new TrainFactory();
    public static TrainFactory getInstance() {
        return INSTANCE;
    }
    public Movable create() {
        System.out.println("A train created");
        return new Train();
    }
}
