package com.doosane.lec.abstractPrac.animal;

public abstract class Animal {
    public String kind;

    public void breathe() {
        System.out.println("breathe!!");
    }
    public abstract void sound();
}
