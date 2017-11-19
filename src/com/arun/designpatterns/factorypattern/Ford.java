package com.arun.designpatterns.factorypattern;

public class Ford implements Car{

    @Override
    public void assemble() {
        System.out.println("Assembling A Ford");
    }
}
