package com.cazacu.engine.graphics;

public class SpriteSheet {

    public final Image image;
    public final int WIDTH;
    public final int HEIGHT;
    public final int[] pixels;

    public static SpriteSheet levelSheet = new SpriteSheet("/spritesheet_level.png", 128, 64);
    public static SpriteSheet tetrisSheet = new SpriteSheet(new Image("/spritesheet_tetris.png"), 64, 64);

    public SpriteSheet(Image image, int w, int h) {
        this.WIDTH = w;
        this.HEIGHT = h;
        this.image = image;
        pixels = new int[WIDTH * HEIGHT];
        load();
    }

    public SpriteSheet(String path, int w, int h) {
        this.WIDTH = w;
        this.HEIGHT = h;
        this.image = new Image(path);
        pixels = new int[WIDTH * HEIGHT];
        load();
    }

    private void load() {
        for (int i = 0; i < WIDTH * HEIGHT; i++) {
            pixels[i] = image.getPixels()[i];
        }
    }
}
