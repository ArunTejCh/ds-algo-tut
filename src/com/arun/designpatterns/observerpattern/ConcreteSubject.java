package com.arun.designpatterns.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements SubjectInterface{
    List<ObserverInterface> obsList = new ArrayList<>();


    @Override
    public void register(ObserverInterface obs) {
        obsList.add(obs);
    }

    @Override
    public void deRegister(ObserverInterface obs) {
        obsList.remove(obs);
    }

    @Override
    public void eventHappened(){
        for(ObserverInterface ob : obsList)
            ob.notify("eventHappened");
    }


}
