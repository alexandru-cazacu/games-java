package com.cazacu.game;

import com.cazacu.engine.scenemanager.SceneManager;
import com.cazacu.engine.scenes.*;

public class Main {

	public static void main(String args[]) {
		SceneManager.uploadScene(new Menu("Menu"));
		SceneManager.uploadScene(new Options("Options"));
		SceneManager.uploadScene(new MainGame("Game"));
                SceneManager.uploadScene(new GameOver("GameOver"));

		SceneManager.loadScene(0);
		SceneManager.manager.start();

	}
}
