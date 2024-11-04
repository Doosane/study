package com.doosane.lec.inheritance;

public class DmbCellPhoneExample {
    public static void main(String[] args) {
        // DmbCellPhone 객체 생성
        DmbCellPhone dmbCellPhone = new DmbCellPhone("Iphone", "black", 16);

        //CellPhone 클래스로 부터 상속 받은 필드
        System.out.println("model: " + dmbCellPhone);
        System.out.println("color: " + dmbCellPhone);

        // DmbCellPhone 클래스의 필드
        System.out.println("channel: "  + dmbCellPhone.channel);

        //CellPhone 클래스로부터 상속받은 메소드 호출
        dmbCellPhone.powerOn();
        dmbCellPhone.bell();
        dmbCellPhone.sendVoice("hello.");
        dmbCellPhone.receiveVoice("hello , this id doosan speacking");
        dmbCellPhone.sendVoice(" ah~ hello doosan");
        dmbCellPhone.hangUp();

        //DmbCellPhone 클래스의 메소드 호출
        dmbCellPhone.turnOnDmb();
        dmbCellPhone.changeChannelDmb(12);
        dmbCellPhone.turnOffDmb();
    }
}
