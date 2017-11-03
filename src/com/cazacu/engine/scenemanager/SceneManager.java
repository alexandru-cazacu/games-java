package com.cazacu.engine.scenemanager;

import com.cazacu.engine.framework.Game;
import com.cazacu.engine.framework.Renderer;

public class SceneManager extends Game {

	public static SceneManager manager = new SceneManager();

	private static int CURRENT_SCENE = 0;
	private static int SCENE_COUNT = 0;
	private static final int MAX_SCENES = 10;

	public static final Scene[] SCENES = new Scene[MAX_SCENES];

	public static void uploadScene(Scene scene) {
		SCENES[SCENE_COUNT] = scene;
		SCENE_COUNT++;
	}

	public static void loadScene(int sceneIndex) {
		CURRENT_SCENE = sceneIndex;
	}

	public static void loadScene(String sceneName) {
		for (int i = 0; i < SCENE_COUNT; i++) {
			if (SCENES[i].getClass().getSimpleName().equals(sceneName)) {
				CURRENT_SCENE = i;
			}
		}
	}

	@Override
	protected void Update(double dt) {
		SCENES[CURRENT_SCENE].Update(dt);
	}

	@Override
	protected void Render(Renderer r) {
		SCENES[CURRENT_SCENE].Render(r);
	}
}
