package com.tankshow;

public class Shot implements Runnable{
    //记录一个子弹坐标
    int x;
    int y;
    int direct = 0;
    int speed = 2;
    boolean isLive = true ;

    //构造器
    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //根据方向改变x，y的坐标
            switch (direct){
                case 0://up
                    y -= speed;
                    break;
                case 1://right
                    x += speed;
                    break;
                case 2://down
                    y += speed;
                    break;
                case 3://left
                    x -= speed;
                    break;
            }
            System.out.println("子弹 x="+x+"y="+y);

            if( !(x>=0 && x<= 1000 && y>=0 && y<= 750)){
                isLive = false;
                break;
            }
        }
    }
}
