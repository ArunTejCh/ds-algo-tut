package com.arun.designpatterns.statepattern;

public class ConcreteState2 implements State {
    @Override
    public void doAction(Context con) {
        System.out.println("In concrete state 2");
        con.setState(this);
    }
}
