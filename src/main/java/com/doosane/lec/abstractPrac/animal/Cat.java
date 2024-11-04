package com.doosane.lec.abstractPrac.animal;

public class Cat extends Animal {
    public Cat() {
        this.kind = "포유류";
    }

    @Override
    public void sound() {
        System.out.println("Yaoeng Yaoeng~!!");
    }
}
