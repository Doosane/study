package com.doosane.lec.abstractPrac.phone;

public abstract class Phone {
    // 필드
    public String owner;

    // 생성자
    public Phone(String owner) {
        this.owner = owner;
    }

    // 메소드
    public void turnOn(){
        System.out.println("Phone is turned on");
    }
    public void turnOff(){
        System.out.println("Phone is turned off");
    }
}
