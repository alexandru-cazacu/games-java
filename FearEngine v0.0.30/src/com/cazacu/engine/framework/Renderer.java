package com.cazacu.engine.framework;

import com.cazacu.engine.graphics.Font;
import com.cazacu.engine.graphics.Sprite;
import com.cazacu.engine.physics.Vector2;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Renderer {

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    private static JFrame frame;
    private Canvas canvas;
    private BufferedImage image;
    private Graphics g;
    private BufferStrategy bs;

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public static final String TITLE = "FearEngine v0.0.28 by Alexandru Cazacu";
    public static final int SCALE = 2;
    public static final int SCREEN_WIDTH_PX = 832 / SCALE;
    public static final int SCREEN_HEIGHT_PX = 704 / SCALE;
    private int screenPixels[];

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public Renderer(Game gc) {
        image = new BufferedImage(SCREEN_WIDTH_PX, SCREEN_HEIGHT_PX, BufferedImage.TYPE_INT_RGB);
        screenPixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        Dimension s = new Dimension(SCREEN_WIDTH_PX * SCALE, SCREEN_HEIGHT_PX * SCALE);

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

        System.out.println("Renderer: WIDTH: " + SCREEN_WIDTH_PX * SCALE);
        System.out.println("Renderer: HEIGHT: " + SCREEN_HEIGHT_PX * SCALE);
        System.out.println("Renderer: Canvas Width: " + canvas.getWidth());
        System.out.println("Renderer: Canvas Height: " + canvas.getHeight());
        System.out.println("Renderer: Frame Width: " + frame.getWidth());
        System.out.println("Renderer: Frame Height: " + frame.getHeight());
        System.out.println("Renderer: Screen Pixels: " + screenPixels.length);
    }

	//----------------------------------------------------------------------------------------------------------------------------------------------------
    public void clearScreen(int color) {
        for (int i = 0; i < SCREEN_WIDTH_PX * SCREEN_HEIGHT_PX; i++) {
            screenPixels[i] = color;
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void drawSpriteOnScreen(Sprite sprite, Vector2 pos) {

        int posX = (int) pos.x;
        int posY = (int) pos.y;

        for (int y = 0; y < sprite.SPRITE_SIZE; y++) {
            for (int x = 0; x < sprite.SPRITE_SIZE; x++) {
                int col = sprite.pixels[x + y * sprite.SPRITE_SIZE];
                if (col != 0xffff00ff) {
                    screenPixels[(x + posX) + (y + posY) * SCREEN_WIDTH_PX] = col;
                }
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void setBackgroundColor(int color) {
        for (int i = 0; i < SCREEN_WIDTH_PX * SCREEN_HEIGHT_PX; i++) {
            screenPixels[i] = color;
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void setBackgroundImage(Sprite sprite, Vector2 coord) {
        for (int y = 0; y < SCREEN_HEIGHT_PX; y++) {
            for (int x = 0; x < SCREEN_WIDTH_PX; x++) {

                int posX = (int) (x + coord.x);
                int posY = (int) (y + coord.y);

                while (posX > sprite.SPRITE_SIZE - 1) {
                    posX -= sprite.SPRITE_SIZE;
                }

                while (posX < 0) {
                    posX += sprite.SPRITE_SIZE - 1;
                }

                while (posY > sprite.SPRITE_SIZE - 1) {
                    posY -= sprite.SPRITE_SIZE;
                }

                while (posY < 0) {
                    posY += sprite.SPRITE_SIZE - 1;
                }

                int col = sprite.pixels[posX + posY * sprite.SPRITE_SIZE];
                if (col != 0xffff00ff) {
                    screenPixels[x + y * SCREEN_WIDTH_PX] = col;
                }
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void setBackgroundImage(Sprite sprite) {
        setBackgroundImage(sprite, new Vector2(0, 0));
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void writeOnScreen(String text, int color, Vector2 pos) {
        text = text.toUpperCase();
        int posX = (int) pos.x;
        int posY = (int) pos.y;

        //Scorre ciascuna lettera del testo passato
        for (int i = 0; i < text.length(); i++) {
            //Trova il relativo numero della lettera
            int charIndex = Font.font.chars.indexOf(text.charAt(i));
            if (charIndex >= 0) {
                //Scorre una casella dello schermo verticalmente
                for (int y = posY; y < Font.FONT_SIZE + posY; y++) {
                    //Scorre una casella dello schermo orizzontalmente
                    for (int x = i * Font.FONT_SIZE + posX; x < i * Font.FONT_SIZE + Font.FONT_SIZE + posX; x++) {
                        //Prende il colore del relativo indice nell'immagine dei font
                        int col = Font.font.pixels[(charIndex * Font.FONT_SIZE + (x - i * Font.FONT_SIZE) - posX) + (y - posY) * Font.FONT_SIZE * Font.FONT_CHARS];
                        if (col != 0xffff00ff) {
                            screenPixels[x + y * SCREEN_WIDTH_PX] = color;
                        }
                    }
                }
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void writeOnScreen(String text, int color) {
        writeOnScreen(text, color, new Vector2(0, 0));
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void writeOnScreen(String text, Vector2 pos) {
        writeOnScreen(text, 0xffffffff, pos);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void writeOnScreen(String text) {
        writeOnScreen(text, 0xffffffff, new Vector2(0, 0));
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void drawRectOnScreen(Vector2 pos, int w, int h, int col) {
        int posX = (int) pos.x;
        int posY = (int) pos.y;

        for (int x = posX; x < posX + w; x++) {
            screenPixels[x + posY * SCREEN_WIDTH_PX] = col;
            screenPixels[x + (posY + h - 1) * SCREEN_WIDTH_PX] = col;
        }

        for (int y = posY; y < posY + h; y++) {
            screenPixels[posX + y * SCREEN_WIDTH_PX] = col;
            screenPixels[(posX + w - 1) + y * SCREEN_WIDTH_PX] = col;
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void update() {
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        bs.show();
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void cleanUp() {
        g.dispose();
        bs.dispose();
        image.flush();
        frame.dispose();
    }

	//----------------------------------------------------------------------------------------------------------------------------------------------------
    public Canvas getCanvas() {
        return canvas;
    }

	//----------------------------------------------------------------------------------------------------------------------------------------------------
    public BufferedImage getImage() {
        return image;
    }

	//----------------------------------------------------------------------------------------------------------------------------------------------------
    public static JFrame getJFrame() {
        return frame;
    }
}
