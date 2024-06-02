package com.cazacu.engine.graphics;

public class Sprite {

    public final int SPRITE_SIZE;
    private int posX, posY;
    private int[] pixels;
    private SpriteSheet sheet;

    public static Sprite blockLevel = new Sprite(16, 0, 0, SpriteSheet.tetrisSheet);
    public static Sprite blockTetromino = new Sprite(16, 1, 0, SpriteSheet.tetrisSheet);
    public static Sprite backLevel = new Sprite(16, 2, 0, SpriteSheet.tetrisSheet);
    public static Sprite backDanger = new Sprite(16, 3, 0, SpriteSheet.tetrisSheet);

    public static Sprite platform_left = new Sprite(16, 0, 0, SpriteSheet.levelSheet);
    public static Sprite platform_middle = new Sprite(16, 1, 0, SpriteSheet.levelSheet);
    public static Sprite platform_right = new Sprite(16, 2, 0, SpriteSheet.levelSheet);

    public static Sprite platform_middle_only = new Sprite(16, 3, 0, SpriteSheet.levelSheet);

    public static Sprite terrain_middle_top = new Sprite(16, 4, 0, SpriteSheet.levelSheet);
    public static Sprite terrain_middle_middle = new Sprite(16, 4, 1, SpriteSheet.levelSheet);
    public static Sprite terrain_middle_bot = new Sprite(16, 4, 2, SpriteSheet.levelSheet);

    public static Sprite terrain_top_left = new Sprite(16, 0, 1, SpriteSheet.levelSheet);
    public static Sprite terrain_top_middle = new Sprite(16, 1, 1, SpriteSheet.levelSheet);
    public static Sprite terrain_top_right = new Sprite(16, 2, 1, SpriteSheet.levelSheet);

    public static Sprite terrain_bottom_left = new Sprite(16, 0, 2, SpriteSheet.levelSheet);
    public static Sprite terrain_bottom_middle = new Sprite(16, 1, 2, SpriteSheet.levelSheet);
    public static Sprite terrain_bottom_right = new Sprite(16, 2, 2, SpriteSheet.levelSheet);

    public static Sprite spike = new Sprite(16, 5, 0, SpriteSheet.levelSheet);
    
    public static Sprite wall = new Sprite(16, 6, 0, SpriteSheet.levelSheet);
    
    public static Sprite empty = new Sprite(16, 7, 0, SpriteSheet.levelSheet);

//    public Sprite(Sprite sprite) {
//        this.SPRITE_SIZE = sprite.SPRITE_SIZE;
//        this.posX = sprite.posX;
//        this.posY = sprite.posY;
//        this.sheet = sprite.sheet;
//    }
    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        this.SPRITE_SIZE = size;
        this.pixels = new int[SPRITE_SIZE * SPRITE_SIZE];
        this.posX = x * SPRITE_SIZE;
        this.posY = y * SPRITE_SIZE;
        this.sheet = sheet;
        load();
    }

    private void load() {
        for (int y = 0; y < SPRITE_SIZE; y++) {
            for (int x = 0; x < SPRITE_SIZE; x++) {
                pixels[x + y * SPRITE_SIZE] = sheet.pixels[(x + this.posX) + (y + this.posY) * sheet.WIDTH];
            }
        }
    }

    public int[] getPixels() {
        return pixels;
    }
}
