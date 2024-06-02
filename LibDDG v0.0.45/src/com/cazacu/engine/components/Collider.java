package com.cazacu.engine.components;

import com.cazacu.engine.physics.Vector2;

public class Collider {
    public Vector2 pos;
    public int width;
    public int height;
    
    public Collider(Vector2 pos, int w, int h) {
        this.pos = pos;
        this.width = w;
        this.height = h;
    }
}
