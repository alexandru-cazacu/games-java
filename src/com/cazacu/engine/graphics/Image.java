package com.cazacu.engine.graphics;

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
        int a = (pixels[29] >> 24) & 0xff;        
        image.flush();
    }
    
    public Image() {
        
    }
}
