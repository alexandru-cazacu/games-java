package com.cazacu.engine.graphics;

public class Sprite {

    public int SPRITE_SIZE;
    public int x, y;
    public int[] pixels;
    public SpriteSheet sheet;

    public static Sprite blockLevel = new Sprite(16, 0, 0, SpriteSheet.mainSheet);
    public static Sprite blockTetromino = new Sprite(16, 1, 0, SpriteSheet.mainSheet);
    public static Sprite backLevel = new Sprite(16, 2, 0, SpriteSheet.mainSheet);
    public static Sprite backDanger = new Sprite(16, 3, 0, SpriteSheet.mainSheet);

    public static Sprite empty = new Sprite(16, 0, 1, SpriteSheet.mainSheet);

    public static Sprite bg1 = new Sprite(96, 0, 0, SpriteSheet.bg1);
    public static Sprite bg2 = new Sprite(96, 0, 0, SpriteSheet.bg2);
    public static Sprite bg3 = new Sprite(96, 0, 0, SpriteSheet.bg3);

    public static Sprite title = new Sprite(100, 0, 0, SpriteSheet.title);

    public Sprite(Sprite sprite) {
        this.SPRITE_SIZE = sprite.SPRITE_SIZE;
        this.x = sprite.x;
        this.y = sprite.y;
        this.sheet = sprite.sheet;
    }

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SPRITE_SIZE = size;
        pixels = new int[SPRITE_SIZE * SPRITE_SIZE];
        this.x = x * SPRITE_SIZE;
        this.y = y * SPRITE_SIZE;
        this.sheet = sheet;
        load();
    }

    private void load() {
        for (int y = 0; y < SPRITE_SIZE; y++) {
            for (int x = 0; x < SPRITE_SIZE; x++) {
                pixels[x + y * SPRITE_SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }
}
