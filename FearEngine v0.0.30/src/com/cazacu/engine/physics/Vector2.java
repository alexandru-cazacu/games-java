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
    
    //Ritorna il valore della lunghezza del vettore
    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }
    
    //Ritorna un nuovo vettore con la stessa direzione, lunghezza 1
    public Vector2 normalized() {
        return new Vector2(x / magnitude(), y / magnitude());
    }
    
    //Modifica il vettore con la stessa direzione, lunghezza 1
    public void Normalize() {
        double tX = x / magnitude();
        double tY = y / magnitude();
        
        x = tX;
        y = tY;
    }
    
    public void sum(Vector2 v) {
        x += v.x;
        y += v.y;
    }
    
    public void sum(double x, double y) {
        this.x += x;
        this.y += y;
    }
    
    
}
