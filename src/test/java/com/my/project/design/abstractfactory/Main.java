package com.my.project.design.abstractfactory;

/**
 * 抽象工厂: 产品簇进行扩展
 * 例: Car(Vehicle), AK47(Weapon), Bread(Food)
 * 扩展产品簇: 直接新增AbstracFactory实现即可
 * 使用抽象类有语义表达上的原因(名词用抽象类，形容词用接口)
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = ModernFactory.getInstance();
        Vehicle v = factory.createVehicle();
        v.go();
        Weapon w = factory.createWeapon();
        w.shoot();
        Food f = factory.createFood();
        f.printName();
    }
}
