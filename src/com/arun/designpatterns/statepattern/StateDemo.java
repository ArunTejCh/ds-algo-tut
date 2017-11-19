package com.arun.designpatterns.statepattern;

public class StateDemo {
    public static void main(String[] args) {
        Context con = new Context();

        ConcreteState1 con1 = new ConcreteState1();
        con1.doAction(con);

        ConcreteState2 con2 = new ConcreteState2();
        con2.doAction(con);

        con.doAction();
    }
}
