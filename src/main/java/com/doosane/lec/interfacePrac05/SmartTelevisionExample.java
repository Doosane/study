package com.doosane.lec.interfacePrac05;

import com.doosane.lec.interfacePrac04.RemoteControl;

public class SmartTelevisionExample {
    public static void main(String[] args) {
        SmartTelevision tv = new SmartTelevision();

        RemoteControl rc = tv;
        Searchable searchable = tv;
    }
}
