package com.cazacu.game;

import com.cazacu.engine.scenemanager.SceneManager;
import com.cazacu.engine.scenes.*;

public class Main {

	public static void main(String args[]) {
		SceneManager.uploadScene(new Menu());
		SceneManager.uploadScene(new Options());
		SceneManager.uploadScene(new MainGame());
                SceneManager.uploadScene(new GameOver());

		SceneManager.loadScene(0);
		SceneManager.manager.start();

	}
}
