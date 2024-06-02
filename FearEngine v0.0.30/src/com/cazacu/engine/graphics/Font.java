package com.cazacu.engine.graphics;

import com.cazacu.engine.graphics.Image;

public class Font {
    public static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,:;'\"!?$%()-=+/ ";
    public static final int FONT_SIZE = 8;
    public static final int FONT_CHARS = 53;
    private Image image;
    public int[] pixels;
    
    public static Font font = new Font(new Image("/font.png"));
    
    public Font(Image image) {
        this.image = image;
        pixels = new int[FONT_SIZE * FONT_SIZE * FONT_CHARS];
        load();
    }
    
    private void load() {
        for (int i = 0; i < FONT_SIZE * FONT_SIZE * FONT_CHARS; i++) {
            pixels[i] = image.pixels[i];
        }
    }
}
