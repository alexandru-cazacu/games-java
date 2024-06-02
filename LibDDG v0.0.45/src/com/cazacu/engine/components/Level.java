package com.cazacu.engine.components;

import com.cazacu.engine.graphics.Sprite;

public class Level {
    public Sprite[][] sprites;
    private int w;
    private int h;
    
    public Level(int w, int h) {
        this.w = w;
        this.h = h;
        sprites = new Sprite[w][h];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x <w; x++) {
                int n = (int) (Math.random()*10);
                if (n == 0) {
                    sprites[x][y] = Sprite.blockTetromino;   
                }
                if (n == 1) {
                    sprites[x][y] = Sprite.blockLevel;   
                }
                else {
                    sprites[x][y] = Sprite.backDanger;   
                }
            }
        }
    }
}
