package com.example.draw_v1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.concurrent.TimeUnit;

public class GameView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener {

    public final GameThread GameThread;

    public GameView(Context context) {
        super(context);
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        GameThread = new GameThread(surfaceHolder);
        setOnTouchListener(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        GameThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        GameThread.stopThread();
        while(GameThread.isAlive()){
            try {
                TimeUnit.MILLISECONDS.sleep(10);
                GameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GameThread.onClickForBullet(motionEvent.getX(), motionEvent.getY());
        return false;
    }
}




