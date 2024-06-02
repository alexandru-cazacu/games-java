package com.cazacu.engine.physics;

import com.cazacu.engine.components.Collider;
import com.cazacu.engine.graphics.Sprite;

public class Tile {

    public Vector2 pos;
    public Sprite sprite;

    public Tile(Sprite sprite, Vector2 pos) {
        this.sprite = sprite;
        this.pos = pos;
    }
    
    public boolean OnCollisionBelow(Collider col) {
        return (pos.y + 16 >= col.pos.y - 1) && pos.x + 16 > col.pos.x && pos.x < col.pos.x + col.width && pos.y < col.pos.y + 16;
    }
}
