package com.doosane.lec.abstractPrac.phone;

public class SmartPhone extends Phone {
    //생성자
    public SmartPhone(String owner) {
        super(owner);
    }
    //메소드
    public void internetSearch() {
        System.out.println("Internet Search");
    }

}
