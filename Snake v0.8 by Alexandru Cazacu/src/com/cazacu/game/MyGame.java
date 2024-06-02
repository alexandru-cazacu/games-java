package com.cazacu.game;

import com.cazacu.engine.core.*;
import com.cazacu.engine.gfx.*;
import com.cazacu.engine.physics.Vector2;
import java.awt.event.KeyEvent;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandru Cazacu
 * @version 0.4
**/
public class MyGame extends Game {
    private Snake snake = new Snake();
    private Image fruit = new Image("/fruit.png");
    
    private Vector2 fruitPosition = new Vector2(20, 20);
    
    private double timer = 0;
    
    private double gameTimer = 0;
    private double gameTimerOUT = 0;
    
    private float speed = 0.08f;
    
    public static void main(String args[]) {
        MyGame game = new MyGame();
        game.start();
    }
    
    //--------------------------------------------------------------------------------------------------------
    @Override
    public void Update(double dt) {    
        
        gameTimer += dt;
        
        System.out.println((int) (1.0f/dt));
        
        //System.out.println((int)gameTimer);
        
        if (Input.isKeyPressed(KeyEvent.VK_W))     snake.moveSnake(new Vector2(0, -1));
        if (Input.isKeyPressed(KeyEvent.VK_A))     snake.moveSnake(new Vector2(-1, 0));
        if (Input.isKeyPressed(KeyEvent.VK_S))     snake.moveSnake(new Vector2(0, 1));
        if (Input.isKeyPressed(KeyEvent.VK_D))     snake.moveSnake(new Vector2(1, 0));
        
        if (Input.isKeyPressed(KeyEvent.VK_R)) {
            snake.resetSnake();
            timer = 0;
        }
        
        if (snake.position[0].x == fruitPosition.x && snake.position[0].y == fruitPosition.y) {
            snake.growSnake();
            fruitPosition = new Vector2(ThreadLocalRandom.current().nextInt(1, Renderer.WIDTH), ThreadLocalRandom.current().nextInt(1, Renderer.HEIGHT));
            fruit.Randomize();
            snake.refImage.Randomize();
        }
        
        if (snake.position[0].x < 0)
            snake.position[0].x = Renderer.WIDTH - 1;
        if (snake.position[0].x >= Renderer.WIDTH)
            snake.position[0].x = 0;
        if (snake.position[0].y < 0)
            snake.position[0].y = Renderer.HEIGHT - 1;
        if (snake.position[0].y >= Renderer.HEIGHT)
            snake.position[0].y = 0;
        
        timer += dt;
        
        if (timer > speed) {
            snake.moveSnake();
            timer -= speed;
        }
        
        for(int i = 1; i < Snake.LENGHT; i++) {
            if (snake.position[0].x == snake.position[i].x && snake.position[0].y == snake.position[i].y) {
                snake.isAlive = false;
                //JOptionPane panel = new JOptionPane();
                //JOptionPane.showMessageDialog(Renderer.getJFrame(), "MSG");
                

            }
        }
    }

    //--------------------------------------------------------------------------------------------------------
    @Override
    public void Render(Renderer r) {      
        for (int i = 0; i < Snake.LENGHT; i++) {
            r.drawWorldImage(snake.image[i], snake.position[i]);
        }
        r.drawWorldImage(fruit, fruitPosition);
    }
}
