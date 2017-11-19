package com.arun.designpatterns.statepattern;

public class Context {
    State state;

    public Context(){
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

    public void doAction(){
        this.state.doAction(this);
    }

}
