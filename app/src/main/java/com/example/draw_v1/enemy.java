package com.example.draw_v1;

public class enemy {
    private float radius;
    private float x;
    private float y;
    private int hp;
    private int damage;
    private float Vx;
    private float Vy;

    public enemy(float radius, float x, float y, int hp, int damage) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.damage = damage;
    }

    public float getRadius() {
        return radius;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getHp() { return hp; }

    public int getDamage() { return damage; }


    public float getVx() { return Vx; }

    public float getVy() { return Vy; }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setVx(float vx) { Vx = vx; }

    public void setVy(float vy) { Vy = vy; }
}
