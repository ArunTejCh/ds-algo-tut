package com.arun.designpatterns.adapterpattern;

public class AdapterTest {
    public static void main(String[] args) {
        IndianPlug plug = new IndianPlug() {
            @Override
            public void getElectricity() {
                System.out.println("Taking indian power bzzz");
            }
        };

        USASocket socket = new USASocket();
        socket.plugIn(new IndiaToUSAAdapter(plug));
    }
}
