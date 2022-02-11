package com.example.draw_v1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GameThread extends Thread{

    ArrayList<enemy> enemyList = new ArrayList<enemy>();
    ArrayList<bullet> bulletList = new ArrayList<bullet>();
    processEnemy processEnemy;
    processBullets processBullets;
    private base base;
    private final SurfaceHolder holder;

    private int index = 0;
    private boolean runnable;



    Paint paint = new Paint();



    public GameThread(SurfaceHolder holder){
        this.holder = holder;
        base = new base(540, 1200,200,10);
        processEnemy = new processEnemy(5,base.getX0(), base.getY0());
        processBullets = new processBullets(base.getX0(), base.getY0());

        runnable = true;


        processEnemy.spawnEnemy();
        enemyList = processEnemy.getEnemyList();
        bulletList = processBullets.getBulletsList();
        processEnemy.processSpeed();
        processEnemy.start();
        processBullets.start();
    }


    public void onClickForBullet(float x, float y){
        processBullets.newBullet(x, y);
    }



    public void stopThread(){
        runnable = false;
        processEnemy.stopThreadEnemy();
        processBullets.stopThreadBullet();
    }


    private void enemyProcessColision(enemy enemy){
        if((float) Math.sqrt(Math.pow(base.getY0() - enemy.getY(), 2) + Math.pow(base.getX0() - enemy.getX() ,2)) < base.getRadius() + enemy.getRadius()){
            enemyList.remove(enemy);
            base.setHp(base.getHp() - 1);
        }
    }


        //float distance = (float) Math.sqrt(Math.pow(bullet.getX() - enemy.getX() ,2) + Math.pow(bullet.getY() - enemy.getY() ,2));


// не получилось сделать колизию противника и пули


    @Override
    public void run() {
        while(runnable){
            Canvas canvas = holder.lockCanvas();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
            paint.setColor(Color.RED);
            canvas.drawCircle(base.getX0(), base.getY0(), base.getRadius(), paint);
            for (int i = 0; i < enemyList.size(); i++) {
                enemy enemy = enemyList.get(i);
                canvas.drawCircle(enemy.getX(), enemy.getY(), enemy.getRadius(), paint);
                enemyProcessColision(enemy);
            }         //понятие не имею как заменить этот цикл на foreach

            //Math.sqrt(Math.pow(base.getY0() - enemyList.get(1).getY(), 2) + Math.pow(base.getX0() - enemyList.get(1).getX() ,2))
            //canvas.drawText(String.valueOf(enemyList.size()), 300, 600, paint);

            for (int j = 0; j < bulletList.size(); j++) {
                bullet bullet = bulletList.get(j);
                canvas.drawCircle(bullet.getX(), bullet.getY(), bullet.getRadius(), paint);


            }         //понятие не имею как заменить этот цикл на foreach

            paint.setTextSize(100);
            canvas.drawText(base.getHp() + "hp", 10, 100, paint);

            holder.unlockCanvasAndPost(canvas);
        }
    }
}
