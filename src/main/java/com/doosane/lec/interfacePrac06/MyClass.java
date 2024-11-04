package com.doosane.lec.interfacePrac06;

import com.doosane.lec.interfacePrac04.Audio;
import com.doosane.lec.interfacePrac04.RemoteControl;
import com.doosane.lec.interfacePrac04.Television;

public class MyClass {
    // 필드
    RemoteControl rc = new Television();

    // 생성자
    MyClass() {
    }

    MyClass(RemoteControl rc) {
        this.rc = rc;
        rc.turnOn();
        rc.setVolume(5);
    }

    //메소드
    void methodA() {
        RemoteControl rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);
    }
    void methodB(RemoteControl rc) {
        rc.turnOn();
        rc.setVolume(5);
    }
}
