package com.cazacu.engine.scenes;

import com.cazacu.engine.framework.Input;
import com.cazacu.engine.framework.Renderer;
import com.cazacu.engine.physics.Vector2;
import com.cazacu.engine.scenemanager.Scene;
import com.cazacu.engine.scenemanager.SceneManager;
import java.awt.event.KeyEvent;

public class GameOver extends Scene {

    public static int score;
    
    @Override
    public void Update(double dt) {
        if (Input.getKeyDown(KeyEvent.VK_ENTER)) { 
            SceneManager.loadScene("Menu");
        }
    }

    @Override
    public void Render(Renderer r) {
       r.setBackgroundColor(0xff111111);
       Vector2 pos = new Vector2(0, 0);
       pos.x = Renderer.SCREEN_WIDTH_PX / 2 - 40;
       pos.y = Renderer.SCREEN_HEIGHT_PX / 2 - 4;
       r.writeOnScreen("Game Over!", 0xffff0000, pos);
       r.writeOnScreen("Score: " + score, 0xffff0000, new Vector2(pos.x, pos.y + 16));
    }
    
}
