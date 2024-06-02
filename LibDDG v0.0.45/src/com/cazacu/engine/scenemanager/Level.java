package com.cazacu.engine.scenemanager;

import com.cazacu.engine.graphics.Sprite;

public class Level {
    public final int WIDTH;
    public final int HEIGHT;
    private Sprite[][] tiles;
    
    public Level(int w, int h) {
        this.WIDTH = w;
        this.HEIGHT = h;
        this.tiles = new Sprite[w][h];
        
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                tiles[x][y] = Sprite.backLevel;
            }
        }
    }

    public Sprite[][] getTiles() {
        return tiles;
    }
}
