package com.arun.designpatterns.factorypattern;

public class CarFactory {

    public static Car getCar(String carType){
        Car inst = null;
        switch (carType){
            case "Toyota":
                inst = new Toyota();
                break;
            case "Ford":
                inst = new Ford();
                break;
            case "BMW":
                inst = new BMW();
                break;
            default:
                System.out.println("Unrecognized Cartype returning null");
        }
        return inst;
    }
}
