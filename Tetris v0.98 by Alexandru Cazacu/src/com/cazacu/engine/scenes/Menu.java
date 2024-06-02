package com.cazacu.engine.scenes;

import com.cazacu.engine.components.Text;
import com.cazacu.engine.graphics.Font;
import com.cazacu.engine.components.custom.Button;
import com.cazacu.engine.framework.Input;
import com.cazacu.engine.framework.Renderer;
import com.cazacu.engine.graphics.Sprite;
import com.cazacu.engine.physics.Vector2;
import com.cazacu.engine.scenemanager.Scene;
import com.cazacu.engine.scenemanager.SceneManager;
import java.awt.event.KeyEvent;

public class Menu extends Scene {

	private boolean debugMode = false;
	
	public Button play = new Button(new Vector2(Renderer.SCREEN_WIDTH_PX / 2 - 16, Renderer.SCREEN_HEIGHT_PX / 2), new Text("PLAY", 0xffffffff));
	public Button options = new Button(new Vector2(Renderer.SCREEN_WIDTH_PX / 2 - 28, Renderer.SCREEN_HEIGHT_PX / 2 + 16), new Text("OPTIONS", 0xffffffff));
	public Button exit = new Button(new Vector2(Renderer.SCREEN_WIDTH_PX / 2 - 16, Renderer.SCREEN_HEIGHT_PX / 2 + 32), new Text("EXIT", 0xffffffff));

	//----------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public void Update(double dt) {

		if (Input.getKeyDown(KeyEvent.VK_F2)) {
			debugMode = !debugMode;
		}

		if (play.collider.onCollision(Input.mouseCol) && Input.getMouseButtonDown(1)) {
			SceneManager.loadScene("MainGame");
		}
		if (options.collider.onCollision(Input.mouseCol) && Input.getMouseButtonDown(1)) {
			SceneManager.loadScene("Options");
		}
		if (exit.collider.onCollision(Input.mouseCol) && Input.getMouseButtonDown(1)) {
			System.exit(0);
		}

		if (play.collider.onCollision(Input.mouseCol)) {
			play.text.color = 0xff22ff22;
		} else {
			play.text.color = 0xffffffff;
		}

		if (options.collider.onCollision(Input.mouseCol)) {
			options.text.color = 0xff22ff22;
		} else {
			options.text.color = 0xffffffff;
		}

		if (exit.collider.onCollision(Input.mouseCol)) {
			exit.text.color = 0xff22ff22;
		} else {
			exit.text.color = 0xffffffff;
		}
	}

	//----------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public void Render(Renderer r) {

		r.setBackgroundColor(0xff111111);

		r.drawSpriteOnScreen(Sprite.title, new Vector2((r.SCREEN_WIDTH_PX / 2) - (Sprite.title.SPRITE_SIZE / 2), (r.SCREEN_HEIGHT_PX / 2) - (Sprite.title.SPRITE_SIZE / 2) - 40));

		r.writeOnScreen(play.text.text, play.text.color, play.pos);
		r.writeOnScreen(options.text.text, options.text.color, options.pos);
		r.writeOnScreen(exit.text.text, exit.text.color, exit.pos);

		r.writeOnScreen(Text.VERSION, 0xffffffff, new Vector2(0, Renderer.SCREEN_HEIGHT_PX - Font.FONT_SIZE));
	}
}
