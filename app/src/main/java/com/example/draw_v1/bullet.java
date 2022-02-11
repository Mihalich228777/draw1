package com.example.draw_v1;

public class bullet {

    private float x;
    private float y;
    private float dx;
    private float dy;
    private float radius;
    private float damage;
    private float Vx;
    private float Vy;

    public bullet(float x, float y, float dx, float dy, float radius, float damage) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.damage = damage;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getRadius() {
        return radius;
    }

    public float getDamage() {
        return damage;
    }

    public float getVx() {
        return Vx;
    }

    public float getVy() {
        return Vy;
    }

    public float getDx() {
        return dx;
    }

    public float getDy() {
        return dy;
    }

    public void setVx(float vx) {
        Vx = vx;
    }

    public void setVy(float vy) {
        Vy = vy;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
