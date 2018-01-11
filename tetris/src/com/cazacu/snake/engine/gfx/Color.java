package com.cazacu.snake.engine.gfx;

public class Color {
    public float a, r, g, b;
    
    public static Color WHITE = new Color(1, 1, 1, 1);
    public static Color BLACK = new Color(1, 0, 0, 0);
    public static Color RED = new Color(1, 1, 0, 0);
    public static Color GREEN = new Color(1, 0, 1, 0);
    public static Color BLU = new Color(1, 0, 0, 0);
    
    public Color(float a, float r, float g, float b) {
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
