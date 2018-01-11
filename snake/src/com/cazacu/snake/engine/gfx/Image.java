package com.cazacu.snake.engine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
    public int width;
    public int height;
    public int pixels[];
    
    public Image(String path) {
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(Image.class.getResourceAsStream(path));
        }
        catch (IOException e) {
            System.err.println("Image not found...");
            System.err.println("Printing Stack Trace");
            e.printStackTrace();
        }
        
        width = image.getWidth();
        height = image.getHeight();
        pixels = image.getRGB(0, 0, width, height, null, 0, width);
        //pixels = image.getRGB(0, 0, 5, 5, null, 0, 5);
        
        image.flush();
    }
    
    public void Randomize() {
        for (int i = 0; i < width*height; i++) {
            int r = (int) (Math.random()*200+55);
            int g = (int) (Math.random()*200+55);
            int b = (int) (Math.random()*200+55);
            pixels[i] = (r<<16) | (g<<8) | b;
        }
    }
}
