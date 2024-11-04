package com.doosane.lec.interfacePrac06;

import com.doosane.lec.interfacePrac04.Audio;
import com.doosane.lec.interfacePrac04.Television;

public class MyClassExample {
    public static void main(String[] args) {
        System.out.println("1)------------------------------------");

        MyClass myClass1 = new MyClass();
        myClass1.rc.turnOn();
        myClass1.rc.setVolume(5);

        System.out.println("2)------------------------------------");

        MyClass myClass2 = new MyClass(new Audio());

        System.out.println("3)------------------------------------");

        MyClass myClass3 = new MyClass(new Audio());
        myClass3.methodA();

        System.out.println("4)------------------------------------");

        MyClass myClass4 = new MyClass();
        myClass4.methodB(new Television());


    }
}
