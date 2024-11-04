package com.doosane.lec.interfacePrac05;

import com.doosane.lec.interfacePrac04.RemoteControl;

public class SmartTelevision implements RemoteControl, Searchable{
    private int volume;


    public void turnOn() {
        System.out.println("SmartTelevision: turned on");
    }


    public void turnOff() {
        System.out.println("SmartTelevision: turned off");
    }


    public void setVolume(int volume) {
         if(volume>RemoteControl.MAX_VOLUME) {
             this.volume = RemoteControl.MAX_VOLUME;
         } else if(volume<RemoteControl.MIN_VOLUME) {
             this.volume = RemoteControl.MIN_VOLUME;
         } else {
             this.volume = volume;
         }
         System.out.println("NOW TV VOLUME IS " + this.volume);
    }

    public void search(String url) {
        System.out.println(url + "is searhching.");
    }


}
