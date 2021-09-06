package com.tankshow;
import javax.swing.*;

@SuppressWarnings({"all"})
public class Tanktest03 extends JFrame {

    MyPanel mp =null;
    public static void main(String[] args) {
        Tanktest03 tankt = new Tanktest03();
    }

    public Tanktest03(){
        mp = new MyPanel();
        //将mp放入Thread并启动
        Thread thread = new Thread(mp);
        thread.start();

        this.add(mp);
        this.setSize(1280,720);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
