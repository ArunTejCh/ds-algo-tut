package com.arun.designpatterns.factorypattern;

public class Toyota implements Car{
    @Override
    public void assemble() {
        System.out.println("Assembling A Toyota");
    }
}
