package com.arun.designpatterns.observerpattern;

public interface SubjectInterface {
    void register(ObserverInterface obs);

    void deRegister(ObserverInterface obs);

    void eventHappened();
}
