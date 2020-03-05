package com.my.project.design.factorymethod;

/**
 * 工厂方法: 产品维度扩展
 * 扩展产品: 添加产品和工厂类即可
 * 如果所有工厂都继承同一个接口(或抽象类), 则工厂方法就是抽象工厂的一个特例, 只不过生产的是只包含一个产品的产品簇
 */
public class Main {
    public static void main(String[] args) {
        Movable m = CarFactory.getInstance().create();
        m.go();
        m = PlaneFactory.getInstance().create();
        m.go();
        m = TrainFactory.getInstance().create();
        m.go();
    }
}
