package com.cazacu.engine.physics;

public class Vector2 {

    public float x;
    public float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
    }

    public void sum(Vector2 v) {
        x += v.x;
        y += v.y;
    }

    public void sum(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public float magnitude() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2 normalized() {
        if (x == 0 && y == 0) {
            return new Vector2(0, 0);
        } else {
            return new Vector2(x / magnitude(), y / magnitude());
        }
    }

    public void lerp(Vector2 v, double time) {
        float diffX = v.x - this.x;
        float diffY = v.y - this.y;

        if (diffX > time) {
            this.x += time;
        }
        else if (diffX < -time) {
            this.x -= time;
        }

        if (diffY > time) {
            this.y += time;
        }
        else if (diffY < -time) {
            this.y -= time;
        }
    }
}
