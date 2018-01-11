package com.cazacu.snake.engine.core;

import com.cazacu.snake.engine.components.Camera;
import com.cazacu.snake.engine.gfx.Image;
import com.cazacu.snake.engine.physics.Vector2;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Renderer {
    
    //---------------------------------
    private static JFrame frame;
    private Canvas canvas;
    private BufferedImage image;
    private Graphics g;
    private BufferStrategy bs;
    private Camera camera;
    
    //---------------------------------
    public static final int WORLD_WIDTH = 100;
    public static final int WORLD_HEIGHT = 100;
    private int worldPixels[];
    
    //---------------------------------
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    public static final int SCALE = 8;
    public static final String TITLE = "FearEngine v0.0.7 by Alexandru Cazacu";
    
    private int screenPixels[];
    
    //--------------------------------------------------------------------------
    public Renderer(Game gc) {
        worldPixels = new int[WORLD_WIDTH*WORLD_HEIGHT];
        
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        screenPixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        
        Dimension s = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
        
        canvas = new Canvas();
        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setMinimumSize(s);
        
        frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
        canvas.createBufferStrategy(1);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
        
        System.out.println("WIDTH: "+WIDTH*SCALE);
        System.out.println("HEIGHT: "+HEIGHT*SCALE);
        System.out.println("Canvas Width: "+canvas.getWidth());
        System.out.println("Canvas Height: "+canvas.getHeight());
        System.out.println("Frame Width: "+frame.getWidth());
        System.out.println("Frame Height: "+frame.getHeight());
        System.out.println("Screen Pixels: "+screenPixels.length);
    }
    
    //Metodo che prende dei valori e li disegna nel mondo.
    //--------------------------------------------------------------------------
    public void setWorldPixel(int x, int y, int color) {
        if(x < 0 || x >= WORLD_WIDTH || y < 0 || y >= WORLD_HEIGHT) {
            return;
        }
        
        worldPixels[x + y * WORLD_WIDTH] = color;
    }
    
    //Pulisce lo schermo.
    //--------------------------------------------------------------------------
    public void clear() {
        for (int x = 0; x < WORLD_WIDTH; x++) {
            for (int y = 0; y < WORLD_HEIGHT; y++) {
                setWorldPixel(x, y, 0xff000000);
            }
        }
    }
    
    //Disegna un'immagine nel mondo di gioco data la sua posizione.
    //--------------------------------------------------------------------------
    public void drawWorldImage(Image image, Vector2 pos) {
        for (int x = 0; x < image.width; x++) {
            for (int y = 0; y < image.height; y++) {
                setWorldPixel(x + (int)pos.x, y + (int)pos.y, image.pixels[x + y * image.width]);
            }
        }
        drawScreen();
    }
    
    //Disegna il contenuto della finestra di gioco.
    //--------------------------------------------------------------------------
    public void drawScreen() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                //screenPixels[x + y * WIDTH] = worldPixels[(x + (int)(camera.position.x)) + (y + (int)(camera.position.y)) * WORLD_WIDTH];   
                screenPixels[x + y * WIDTH] = worldPixels[x + y * WORLD_WIDTH];   
            }
        }
    }
    
    //Update the window content.
    //--------------------------------------------------------------------------
    public void update() {
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        //g.drawImage(image, 5, 5, WIDTH*SCALE, HEIGHT*SCALE, null);
        bs.show();
    }

    public void cleanUp() {
        g.dispose();
        bs.dispose();
        image.flush();
        frame.dispose();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public BufferedImage getImage() {
        return image;
    }
    
    public void setCamera(Camera camera) {
        this.camera = camera;
    }
    
    public static JFrame getJFrame() {
        return frame;
    }
}
