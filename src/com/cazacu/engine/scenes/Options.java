package com.cazacu.engine.scenes;

import com.cazacu.engine.components.Text;
import com.cazacu.engine.components.custom.Button;
import com.cazacu.engine.framework.Input;
import com.cazacu.engine.framework.Renderer;
import com.cazacu.engine.graphics.Font;
import com.cazacu.engine.physics.Vector2;
import com.cazacu.engine.scenemanager.Scene;
import com.cazacu.engine.scenemanager.SceneManager;

public class Options extends Scene {

	private Button back = new Button(new Vector2(Renderer.SCREEN_WIDTH_PX - 64, Renderer.SCREEN_HEIGHT_PX - 40), new Text("BACK", 0xffffffff));

	@Override
	public void Update(double dt) {
		if (back.collider.onCollision(Input.mouseCol) && Input.getMouseButtonDown(1)) {
			SceneManager.loadScene("Menu");
		}

		if (back.collider.onCollision(Input.mouseCol)) {
			back.text.color = 0xff22ff22;
		} else {
			back.text.color = 0xffffffff;
		}
	}

	@Override
	public void Render(Renderer r) {
		r.setBackgroundColor(0xff111111);

		r.writeOnScreen("-OPTIONS-", 0xffffffff, new Vector2(30, 30));

		r.writeOnScreen(back.text.text, back.text.color, back.pos);

		r.writeOnScreen("ALPHA v0.0.24", 0xffffffff, new Vector2(0, Renderer.SCREEN_HEIGHT_PX - Font.FONT_SIZE));
	}
}
