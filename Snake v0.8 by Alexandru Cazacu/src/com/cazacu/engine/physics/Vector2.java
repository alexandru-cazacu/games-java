package com.cazacu.engine.physics;

public class Vector2 {
    public double x;
    public double y;
    
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Vector2(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
    }
}
