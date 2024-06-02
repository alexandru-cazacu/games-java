package com.cazacu.engine.components;

import com.cazacu.engine.framework.Renderer;
import com.cazacu.engine.physics.Vector2;

public class Collider {
    public Vector2 pos;
    public int width;
    public int height;
    public int color = 0xFFFF0000;
    
    public Collider(Vector2 pos, int w, int h) {
        this.pos = pos;
        this.width = w;
        this.height = h;
    }
    
    public void show(Renderer r) {
        r.drawRectOnScreen(pos, width, height, color);
    }
    
    public boolean onCollision(Collider col) {
        if (col.pos.x + (col.width - 1) >= pos.x && col.pos.x <= pos.x + (width - 1) && col.pos.y + (col.height - 1) >= pos.y && col.pos.y <= pos.y + (height - 1)) {
            return true;
        }
        return false;
    }
}
