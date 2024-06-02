package com.cazacu.game;

import com.cazacu.engine.scenemanager.SceneManager;
import com.cazacu.engine.scenes.Menu;

public class Main {

    public static void main(String args[]) {

        SceneManager.uploadScene(new Menu());
        SceneManager.loadScene("Menu");
        SceneManager.StartGame();
    }
}