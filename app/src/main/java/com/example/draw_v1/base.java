package com.example.draw_v1;

public class base {

    private float X0;
    private float Y0;
    private float radius;
    private int hp;

    public base(float X0, float Y0, float radius, int hp){
        this.X0 = X0;
        this.Y0 = Y0;
        this.radius = radius;
        this.hp = hp;
    }

    public float getX0() {
        return X0;
    }

    public float getY0() {
        return Y0;
    }

    public float getRadius() {
        return radius;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
