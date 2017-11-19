package com.arun.designpatterns.factorypattern;

public class CarTest {
    public static void main(String[] args) {
        Car c1 = CarFactory.getCar("Toyota");
        c1.assemble();
        Car c2 = CarFactory.getCar("Ford");
        c2.assemble();
        Car c3 = CarFactory.getCar("BMW");
        c3.assemble();
    }
}
