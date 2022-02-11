package com.example.draw_v1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class processBullets extends Thread{

    ArrayList<bullet> bulletList = new ArrayList<bullet>();
    private boolean runnable;

    private float X0;
    private float Y0;


    private int index = 0;
    public processBullets(float X0, float Y0){
        runnable = true;
        this.X0 = X0;
        this.Y0 = Y0;
    }

    public void newBullet(float x, float y){
        bulletList.add(new bullet(X0, Y0, x,y,20, 1));
        processSpeed(bulletList.get(index));
        index++;
    }




    public float getGipoten(bullet bullet){
        return (float) Math.sqrt(Math.pow(bullet.getDx() - X0, 2) + Math.pow(bullet.getDy() - Y0, 2));
    }

    private float getSpeed(bullet bullet, float cord0, float cord1){
        return (float) (cord0 - cord1) / getGipoten(bullet);
    }

    public void processSpeed(bullet bullet){
        bullet.setVx(getSpeed(bullet, bullet.getDx(), X0));
        bullet.setVy(getSpeed(bullet, bullet.getDy(), Y0));
    }

    @Override
    public void run() {

        while (runnable) {
            for (int i = 0; i < bulletList.size(); i++) {
                bullet acc = bulletList.get(i);
                acc.setX(acc.getX() + acc.getVx());
                acc.setY(acc.getY() + acc.getVy());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




    public void stopThreadBullet(){
        runnable = false;
    }
    public ArrayList<bullet> getBulletsList() {
        return bulletList;
    }
}
