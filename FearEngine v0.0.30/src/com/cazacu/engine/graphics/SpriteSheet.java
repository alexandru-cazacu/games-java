package com.cazacu.engine.graphics;

public class SpriteSheet {
    private Image image;
    public final int SIZE;
    public int[] pixels;
    
    public static SpriteSheet mainSheet = new SpriteSheet(new Image("/Sprites.png"), 64);
    public static SpriteSheet bg1 = new SpriteSheet(new Image("/background1.png"), 96);
    public static SpriteSheet bg2 = new SpriteSheet(new Image("/background2.png"), 96);
    public static SpriteSheet bg3 = new SpriteSheet(new Image("/background3.png"), 96);
    public static SpriteSheet title = new SpriteSheet(new Image("/Title.png"), 100);
    
    public SpriteSheet(Image image, int size) {
        SIZE = size;
        this.image = image;
        pixels = new int[SIZE*SIZE];
        load();
    }
    
    private void load() {
        for (int i = 0; i < SIZE*SIZE; i++) {
            pixels[i] = image.pixels[i];
        }
    }
}
