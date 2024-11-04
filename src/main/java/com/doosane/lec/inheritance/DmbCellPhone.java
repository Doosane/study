package com.doosane.lec.inheritance;

public class DmbCellPhone extends Cellphone {
    // 필드
    int channel;

    // 생성자
    DmbCellPhone(String model, String color, int channel) {
        this.model = model;
        this.color = color;
        this.channel = channel;
    }

    //메소드
    void turnOnDmb() {
        System.out.println("channel"+"channel" + "Turning on dmb cell phone");
    }
    void changeChannelDmb(int channel) {
        this.channel = channel;
        System.out.println("channel"+"channel" + "Changed to " + this.channel);
    }
    void turnOffDmb() {
        System.out.println("Stop DMB channnel set");
    }
}
