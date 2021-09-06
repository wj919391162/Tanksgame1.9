package com.tankshow;

public class Tank {
    private int x;
    private int y;
    private  int direct;//tank direction--- 0-up 1-r 2-down 3-r
    private int speed = 1;

    public void mup(){
        y-=speed;
    }

    public void mr(){
        x+=speed;
    }

    public void md(){
        y+=speed;
    }

    public void ml(){
        x-=speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
