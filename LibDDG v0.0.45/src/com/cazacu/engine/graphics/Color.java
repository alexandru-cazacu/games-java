package com.cazacu.engine.graphics;

public class Color {

    // Variables
    private final int a, r, g, b;
    private int hex;

    // Constructors
    public Color(int a, int r, int g, int b) {
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(int r, int g, int b) {
        this.a = 255;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(Color c) {
        this.a = c.getA();
        this.r = c.getR();
        this.g = c.getG();
        this.b = c.getB();
    }

    // Methods
    public int toHex() {
        return (a << 24) + (r << 16) + (g << 8) + (b);
    }
    
    // Getter and Setters
    public int getA() {
        return a;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }  
}
