package com.tankshow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//为了让panel可以不停重绘需要实现runnable接口当做一个线程使用
//为了监听 键盘事件 视线KeyListener
public class MyPanel extends JPanel implements KeyListener,Runnable{

    Mhero hero = null;
    //定义敌人tank放入vector
    Vector<EnemyTank> et = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel(){
        hero =new Mhero(300,300);//初始化一个坦克
        hero.setSpeed(5);

        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
           EnemyTank enemyTank=new EnemyTank(100*(i+1),0);
           enemyTank.setDirect(2); //初始化方向
           et.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);   //填充背景
        //draw tank---封装方法
        drawT(hero.getX(), hero.getY(), g,hero.getDirect(),0);
        //画出 敌人tank
        for (int i = 0; i < et.size(); i++) {
            EnemyTank enemyTank = et.get(i);
            drawT(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),1);
        }
        //子弹
        if(hero.shot != null && hero.shot.isLive == true){
            g.setColor(Color.green);
            g.draw3DRect(hero.shot.x,hero.shot.y,5,5,false);

        }
    }

    //编写画坦克方法
    public  void drawT(int x,int y,Graphics g,int direction,int type){

        switch (type) {
            case 0:  //my tank
                g.setColor(Color.yellow);
                break;
            case 1:  //other tank
                g.setColor(Color.red);
                break;
        }

        //根据坦克的方向来绘制坦克  0=up 1=r 2=down 3=l
        switch(direction){
            case 0:
                g.fill3DRect(x,y, 10,60, false);
                g.fill3DRect(x+30,y, 10,60, false);
                g.fill3DRect(x+10,y+10, 20,40, false);
                g.fillOval(x+10,y+20, 20,20);
                g.drawLine(x+20,y+30,x+20,y);
                break;
            case 1:
                g.fill3DRect(x,y, 60,10, false);
                g.fill3DRect(x,y+30, 60,10, false);
                g.fill3DRect(x+10,y+10, 40,20, false);
                g.fillOval(x+20,y+10, 20,20);
                g.drawLine(x+30,y+20,x+60,y+20);
                break;
            case 2:
                g.fill3DRect(x,y, 10,60, false);
                g.fill3DRect(x+30,y, 10,60, false);
                g.fill3DRect(x+10,y+10, 20,40, false);
                g.fillOval(x+10,y+20, 20,20);
                g.drawLine(x+20,y+30,x+20,y+60);
                break;
            case 3:
                g.fill3DRect(x,y, 60,10, false);
                g.fill3DRect(x,y+30, 60,10, false);
                g.fill3DRect(x+10,y+10, 40,20, false);
                g.fillOval(x+20,y+10, 20,20);
                g.drawLine(x+30,y+20,x,y+20);
                break;
            default:
                System.out.println("暂时没处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);
            hero.mup();
        } else if (e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirect(1);
            hero.mr();
        } else if (e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirect(2);
            hero.md();
        } else if (e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirect(3);
            hero.ml();
        }
        //j===shot
        if(e.getKeyCode() == KeyEvent.VK_J) {
           hero.shotEnemyTank();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔100ms，重绘区域

        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }

    }
}
