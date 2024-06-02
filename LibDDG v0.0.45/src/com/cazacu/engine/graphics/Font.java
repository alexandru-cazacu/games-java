package com.cazacu.engine.graphics;

public class Font {
    public static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,:;'\"!?$%()-=+/ ";
    public static final int FONT_SIZE = 8;
    public static final int FONT_CHARS = 53;
    private Image image;
    private int[] pixels;
    
    public static Font font = new Font("/font.png");
    
    public Font(String path) {
        this.image = new Image(path);
        this.pixels = new int[FONT_SIZE * FONT_SIZE * FONT_CHARS];
        load();
    }
    
    private void load() {
        for (int i = 0; i < FONT_SIZE * FONT_SIZE * FONT_CHARS; i++) {
            pixels[i] = image.getPixels()[i];
        }
    }

    public int[] getPixels() {
        return pixels;
    }
}
