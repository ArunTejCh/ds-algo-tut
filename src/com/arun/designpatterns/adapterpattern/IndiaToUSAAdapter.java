package com.arun.designpatterns.adapterpattern;

public class IndiaToUSAAdapter implements UsPlug{

    IndianPlug plug;

    public IndiaToUSAAdapter(IndianPlug input){
        this.plug = input;
    }

    @Override
    public void getElecticity() {
        this.plug.getElectricity();
    }
}
