package com.doosane.lec.interfacePrac04;

public class Television implements RemoteControl{
    //필드
    private int volume;

    //turnOn() 추상 메소드의 실체 메소드
    public void turnOn() {
        System.out.println("TV is on");
    }

    //turnOff() 추상 메소드의 실체 메소드
    public void turnOff() {
        System.out.println("TV is off");
    }

    //setVolume() 추상 메소드의 실체 메소드
    public void setVolume(int volume) {
        if(volume>RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else if (volume<RemoteControl.MIN_VOLUME) {
            this.volume = RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("Now TV Volume " + this.volume);
    }
}
