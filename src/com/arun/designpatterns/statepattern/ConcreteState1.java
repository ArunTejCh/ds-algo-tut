package com.arun.designpatterns.statepattern;

public class ConcreteState1 implements State {
    @Override
    public void doAction(Context con) {
        System.out.println("In concrete state 1");
        con.setState(this);
    }
}
