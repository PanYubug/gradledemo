package com.panyu.springdemo.soundsystem.jase.duotai;

//阶段一
/*
class NoteBook {
    public void run() {
        System.out.println("run");
    }

}
*/


/*
class Mouse{
    public void open(){
        System.out.println("鼠标开启");
    }

    public void close(){
        System.out.println("鼠标关闭");
    }
}


//阶段二
class NoteBook{
    public void run(){

    }

    //定义使用鼠标功能，鼠标不确定，定义成函数
    public void useMouse(Mouse m){

        if (!(m instanceof Mouse)){
            return;
        }
        m.open();
        m.close();
    }
}


//阶段三，如果还需要其他设备


*/

interface USB{
    //开启设备
    public void open();
    public void close();
}

class NoteBook{
    public void run() {
        System.out.println("run");
    }
    //定义了一个接口类型的引用
    public void useUSB(USB usb){
        if(usb!=null){
            usb.open();
            usb.close();
        }
    }
}

class MouseByUSB implements USB{

    @Override
    public void open() {
        System.out.println("mouse open");
    }

    @Override
    public void close() {
        System.out.println("mouse close");
    }
}

class KeyByUSB implements USB{

    @Override
    public void open() {
        System.out.println("Key open");
    }

    @Override
    public void close() {
        System.out.println("Key close");
    }
}

class USBTest{
    public static void main(String[] args) {
        NoteBook book = new NoteBook();
        book.run();
        book.useUSB(new KeyByUSB());

    }

}

public class DuoTaiTest {
}
