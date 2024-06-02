package com.cazacu.engine.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
    private int width;
    private int height;
    private int pixels[];
    
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
        
        this.width = image.getWidth();
        this.height = image.getHeight();
        
        this.pixels = image.getRGB(0, 0, width, height, null, 0, width);
        //int a = (pixels[29] >> 24) & 0xff;        
        image.flush();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getPixels() {
        return pixels;
    }
    
    public int getPixel(int i) {
        return pixels[i];
    }
}
