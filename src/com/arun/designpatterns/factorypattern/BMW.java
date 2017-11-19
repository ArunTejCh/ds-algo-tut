package com.arun.designpatterns.factorypattern;

public class BMW implements Car{
    @Override
    public void assemble() {
        System.out.println("Assembling A BMW");
    }
}
