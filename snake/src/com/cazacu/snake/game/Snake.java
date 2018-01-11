package com.cazacu.snake.game;

import com.cazacu.snake.engine.core.Renderer;
import com.cazacu.snake.engine.gfx.Image;
import com.cazacu.snake.engine.physics.Vector2;

public class Snake {
    private static final int MAX = Renderer.WIDTH*Renderer.HEIGHT;
    public Image image[] = new Image[MAX];
    public Vector2 position[] = new Vector2[MAX];
    public static int LENGHT = 5;
    public Vector2 direction = new Vector2(0, 1);
    public boolean isAlive = true;
    public Image refImage = new Image("/snake.png");
    
    public Snake() {
        
        for (int i = 0; i < MAX; i++) {
            image[i] = refImage;
            position[i] = new Vector2(50, 50);
        }
        
        for (int i = 0; i < LENGHT; i++) {
            position[i] = new Vector2(50+i, 50);
        }
    }
    
    public void growSnake() {
        LENGHT += 10;
    }
    
    public void moveSnake(Vector2 direction) {
        if (this.direction.x - direction.x != 0 && this.direction.y - direction.y != 0) {
            this.direction.x = direction.x;
            this.direction.y = direction.y;   
        }        
    }
    
    public void moveSnake() {
        if (isAlive) {
            for (int i = LENGHT-1; i > 0; i--) {
               Vector2 temp = new Vector2(0, 0);
               position[i].x = position[i-1].x;
               position[i].y = position[i-1].y;
           }

           for (int i = LENGHT; i < MAX; i++) {
               position[i].x = position[0].x;
               position[i].y = position[0].y;
            }

           position[0].x += direction.x;
           position[0].y += direction.y;           
        }
    }
    
    public void resetSnake() {
        LENGHT = 5;
        direction = new Vector2(0, 32);
        isAlive = true;
        
        for (int i = 0; i < LENGHT; i++) {
            position[i] = new Vector2(50+i, 50);
        }
    }
}
