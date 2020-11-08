package com.panyu.jase.reflect;

public class NoteBook {

    public void run(){
        System.out.println("note book run");
    }


    public void useUSB(USB usb){
        if (usb!=null){
            usb.open();
            usb.close();
        }
    }
}
