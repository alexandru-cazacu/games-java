package com.cazacu.engine.framework;

import com.cazacu.engine.components.Camera;
import com.cazacu.engine.components.Text;
import com.cazacu.engine.graphics.Color;
import com.cazacu.engine.graphics.Font;
import com.cazacu.engine.graphics.Sprite;
import com.cazacu.engine.physics.Tile;
import com.cazacu.engine.physics.Vector2;
import com.cazacu.engine.scenemanager.Level;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Renderer {

    // Variabili della finestra e grafica
    //--------------------------------------------------------------------------
    private static JFrame frame;
    private Canvas canvas;
    private BufferedImage image;
    private Graphics g;
    private BufferStrategy bs;

    // Variabili dei pixel e dello schermo
    //--------------------------------------------------------------------------
    public static final String TITLE = Text.TITLE;
    public static final int SCALE = 4;
    public static final int SCREEN_WIDTH_PX = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / SCALE);
    public static final int SCREEN_HEIGHT_PX = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / SCALE);
    private int screenPixels[];

    //--------------------------------------------------------------------------
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

        // Usa questo per Fullscreen
        //----------------------------------------
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        //----------------------------------------

        // Usa questo per windowed
        //----------------------------------------
        //frame.setLayout(new BorderLayout());
        //----------------------------------------
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();

        // Entrambi i metodi centrano la finestra
        //----------------------------------------
        frame.setLocation(new Point(0, 0));
        //frame.setLocationRelativeTo(null);
        //----------------------------------------

        //frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(3);
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

    //--------------------------------------------------------------------------
    /**
     *
     * @param hex
     */
    public void clearScreen(int hex) {
        for (int i = 0; i < SCREEN_WIDTH_PX * SCREEN_HEIGHT_PX; i++) {
            screenPixels[i] = hex;
        }
    }

    public void clearScreen(Color c) {
        clearScreen(c.toHex());
    }

    //--------------------------------------------------------------------------
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
                        int col = Font.font.getPixels()[(charIndex * Font.FONT_SIZE + (x - i * Font.FONT_SIZE) - posX) + (y - posY) * Font.FONT_SIZE * Font.FONT_CHARS];
                        if (col != 0xffff00ff) {
                            screenPixels[x + y * SCREEN_WIDTH_PX] = color;
                        }
                    }
                }
            }
        }
    }

    //--------------------------------------------------------------------------
    public void writeOnScreen(String text, int color) {
        writeOnScreen(text, color, new Vector2(0, 0));
    }

    //--------------------------------------------------------------------------
    public void writeOnScreen(String text, Vector2 pos) {
        writeOnScreen(text, 0xffffffff, pos);
    }

    //--------------------------------------------------------------------------
    public void writeOnScreen(String text) {
        writeOnScreen(text, 0xffffffff, new Vector2(0, 0));
    }

    public void drawFillRectOnLevel(Vector2 pos, int w, int h, int col, Camera cam) {
        int posX = (int) (pos.x - cam.pos.x);
        int posY = (int) (pos.y - cam.pos.y);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (posY + y >= 0 && posX + x >= 0 && posY + y < SCREEN_HEIGHT_PX && posX + x < SCREEN_WIDTH_PX) {
                    screenPixels[(x + posX) + (y + posY) * SCREEN_WIDTH_PX] = col;
                }
            }
        }
    }

    public void drawFillRectOnLevel(Vector2 pos, int w, int h, Color col, Camera cam) {
        drawFillRectOnLevel(pos, w, h, col.toHex(), cam);
    }

    public void drawFillRectOnLevel(Vector2 pos, int w, int h, Camera cam) {
        drawFillRectOnLevel(pos, w, h, 0xffffffff, cam);
    }

    public void drawFillRectOnScreen(Vector2 pos, int w, int h, int col) {
        drawFillRectOnLevel(pos, w, h, col, new Camera(new Vector2(0, 0)));
    }

    public void drawFillRectOnScreen(Vector2 pos, int w, int h, Color col) {
        drawFillRectOnLevel(pos, w, h, col.toHex(), new Camera(new Vector2(0, 0)));
    }

    public void drawFillRectOnScreen(Vector2 pos, int w, int h) {
        drawFillRectOnLevel(pos, w, h, 0xffffffff, new Camera(new Vector2(0, 0)));
    }

    //--------------------------------------------------------------------------
    /**
     *
     * @param pos
     * @param w
     * @param h
     * @param col
     * @param cam
     */
    public void drawEmptyRectOnLevel(Vector2 pos, int w, int h, int col, Camera cam) {
        int posX = (int) (pos.x - cam.pos.x);
        int posY = (int) (pos.y - cam.pos.y);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (posY + y >= 0 && posX + x >= 0 && posY + y < SCREEN_HEIGHT_PX && posX + x < SCREEN_WIDTH_PX) {
                    if (y == 0 || y == h - 1) {
                        screenPixels[(x + posX) + (y + posY) * SCREEN_WIDTH_PX] = col;
                    } else if (x == 0 || x == w - 1) {
                        screenPixels[(x + posX) + (y + posY) * SCREEN_WIDTH_PX] = col;
                    }
                }
            }
        }
    }

    public void drawEmptyRectOnLevel(Vector2 pos, int w, int h, Color col, Camera cam) {
        drawEmptyRectOnLevel(pos, w, h, col.toHex(), cam);
    }

    public void drawEmptyRectOnLevel(Vector2 pos, int w, int h, Camera cam) {
        drawEmptyRectOnLevel(pos, w, h, 0xffffffff, cam);
    }

    public void drawEmptyRectOnScreen(Vector2 pos, int w, int h, int col) {
        drawEmptyRectOnLevel(pos, w, h, col, new Camera(new Vector2(0, 0)));
    }

    public void drawEmptyRectOnScreen(Vector2 pos, int w, int h, Color col) {
        drawEmptyRectOnLevel(pos, w, h, col.toHex(), new Camera(new Vector2(0, 0)));
    }

    public void drawEmptyRectOnScreen(Vector2 pos, int w, int h) {
        drawEmptyRectOnLevel(pos, w, h, 0xffffffff, new Camera(new Vector2(0, 0)));
    }

    //--------------------------------------------------------------------------
    /**
     *
     * @param tile
     * @param cam
     */
    public void drawTileOnLevel(Tile tile, Camera cam) {
        int posX = (int) (tile.pos.x - cam.pos.x);
        int posY = (int) (tile.pos.y - cam.pos.y);

        for (int y = 0; y < tile.sprite.SPRITE_SIZE; y++) {
            for (int x = 0; x < tile.sprite.SPRITE_SIZE; x++) {
                if (posY + y >= 0 && posX + x >= 0 && posY + y < SCREEN_HEIGHT_PX && posX + x < SCREEN_WIDTH_PX) {
                    int col = tile.sprite.getPixels()[x + y * tile.sprite.SPRITE_SIZE];
                    if (col != 0xffff00ff) {
                        screenPixels[(x + posX) + (y + posY) * SCREEN_WIDTH_PX] = col;
                    }
                }
            }
        }
    }

    public void drawTileOnScreen(Tile tile) {
        drawTileOnLevel(tile, new Camera(new Vector2(0, 0)));
    }

    public void drawSpriteOnLevel(Sprite sprite, Vector2 pos, Camera cam) {
        drawTileOnLevel(new Tile(sprite, pos), cam);
    }

    public void drawSpriteOnScreen(Sprite sprite, Vector2 pos) {
        drawSpriteOnLevel(sprite, pos, new Camera(new Vector2(0, 0)));
    }

    //--------------------------------------------------------------------------
    public void update() {
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        bs.show();
    }

    //--------------------------------------------------------------------------
    public void cleanUp() {
        g.dispose();
        bs.dispose();
        image.flush();
        frame.dispose();
    }

    //--------------------------------------------------------------------------
    public Canvas getCanvas() {
        return canvas;
    }

    //--------------------------------------------------------------------------
    public BufferedImage getImage() {
        return image;
    }

    //--------------------------------------------------------------------------
    public static JFrame getJFrame() {
        return frame;
    }
}
