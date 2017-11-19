package com.arun.designpatterns.observerpattern;

public class ObserverTest {
    public static void main(String[] args) {
        ObserverInterface ob = new ConcreteObserver();
        SubjectInterface sub = new ConcreteSubject();
        sub.register(ob);
        sub.eventHappened();
    }
}
