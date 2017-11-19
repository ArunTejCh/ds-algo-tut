package com.arun.designpatterns.adapterpattern;

public class USASocket {

    public void plugIn(UsPlug plug){
        System.out.println("Providing USA power bzzz");
        plug.getElecticity();
    }
}
