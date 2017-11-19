package com.arun.designpatterns.observerpattern;

public class ConcreteObserver implements ObserverInterface{

    @Override
    public void notify(String event) {
        System.out.println("Received event: "+event);
    }
}
