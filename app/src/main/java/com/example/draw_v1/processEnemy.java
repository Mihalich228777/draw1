package com.example.draw_v1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class processEnemy extends Thread{

    ArrayList<enemy> enemyList = new ArrayList<enemy>();
    private float X0;
    private float Y0;

    private boolean runnable;

    private int numberOfEnemy; //пока что негде не используется
    private int index = 0;


    public processEnemy(int numberOfEnemy, float X0, float Y0){
        this.numberOfEnemy = numberOfEnemy;
        this.X0 = X0;
        this.Y0 = Y0;
        runnable = true;
    }


    public void creatEnemy(float x, float y){
         enemyList.add(new enemy(50,x,y,1,1)); // задём стартовые координаты
    }

    public void spawnEnemy(){
        creatEnemy(400,400);
        creatEnemy(0,0);
        creatEnemy(1000,100);
        creatEnemy(1000,1000);
    }


    public float getGipoten(enemy enemy){
        return (float) Math.sqrt(Math.pow(X0 - enemy.getX(), 2) + Math.pow(Y0 - enemy.getY(), 2));
    }


    private float getSpeed(enemy enemy, float cord0, float cord1){
        return (float) (cord0 - cord1) / getGipoten(enemy);
    }

    public void processSpeed(){
        for (int i = 0; i < enemyList.size(); i++) {
            enemy acc = enemyList.get(i);
            acc.setVx(getSpeed(acc, X0, acc.getX()));
            acc.setVy(getSpeed(acc, Y0, acc.getY()));
        }
    }


    @Override
    public void run() {
        while (runnable) {
            for (int i = 0; i < enemyList.size(); i++) {
                enemy acc = enemyList.get(i);
                acc.setX(acc.getX() + acc.getVx());
                acc.setY(acc.getY() + acc.getVy());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThreadEnemy(){
        runnable = false;
    }

    public ArrayList<enemy> getEnemyList() {
        return enemyList;
    }
}
