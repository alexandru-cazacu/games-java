package com.cazacu.engine.scenes;

import com.cazacu.engine.components.Camera;
import com.cazacu.engine.components.Collider;
import com.cazacu.engine.framework.Input;
import com.cazacu.engine.framework.Renderer;
import com.cazacu.engine.graphics.Color;
import com.cazacu.engine.graphics.Sprite;
import com.cazacu.engine.physics.Tile;
import com.cazacu.engine.physics.Vector2;
import com.cazacu.engine.scenemanager.Scene;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Menu extends Scene {

    private Vector2 playerVelocity = new Vector2(0, 0);
    private Vector2 gravity = new Vector2(0, 87.2f * 3f);
    private float currentSpeed;
    private final float walkSpeed = 100;
    private final float runSpeed = 200;
    private final float jumpSpeed = 120;
    private int jumpCount;
    private int jumpMaxCount = 2;
    private int score;

    private int currentHealth;
    private int maxHealth = 100;
    private int currentMana;
    private int maxMana = 100;

    private boolean debugMode;
    private double timer;
    private int fps;
    private final Camera cam = new Camera(new Vector2(0, 0));

    private Tile player = new Tile(Sprite.spike, new Vector2(30, 30));

    private List<Tile> levelTile = new ArrayList();
    private List<Collider> levelCollider = new ArrayList();

    @Override
    public void Start() {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {

            }
        }

        for (int x = 0; x < 40; x++) {
            levelTile.add(new Tile(Sprite.blockLevel, new Vector2(x * 16, 0)));
            levelTile.add(new Tile(Sprite.blockLevel, new Vector2(x * 16, 160)));
        }

        for (int y = 1; y < 10; y++) {
            levelTile.add(new Tile(Sprite.blockLevel, new Vector2(0, y * 16)));
            levelTile.add(new Tile(Sprite.blockLevel, new Vector2(624, y * 16)));
        }

        levelCollider.add(new Collider(new Vector2(0, 160), 639, 16));
    }

    @Override
    public void Update(double dt) {
        timer += dt;
        fps = (int) (1 / dt);

        if (Input.getKeyDown(KeyEvent.VK_H)) {
            currentHealth += 5;
        }
        if (Input.getKeyDown(KeyEvent.VK_M)) {
            currentMana += 5;
        }
        if (Input.getKeyDown(KeyEvent.VK_G)) {
            maxHealth += 5;
        }
        if (Input.getKeyDown(KeyEvent.VK_N)) {
            maxMana += 5;
        }

        // Camminata o corsa
        if (Input.getKey(KeyEvent.VK_SHIFT)) {
            currentSpeed = runSpeed;
        } else {
            currentSpeed = walkSpeed;
        }

        // Movimento
        if (Input.getKey(KeyEvent.VK_A)) {
            playerVelocity.x = -currentSpeed;
        } else if (Input.getKey(KeyEvent.VK_D)) {
            playerVelocity.x = currentSpeed;
        } else {
            playerVelocity.x = 0;
        }

        // Teletrasporto
        if (Input.getMouseButtonDown(3)) {
            player.pos.x += playerVelocity.x;
        }

        // Salto in aria
        if (Input.getKeyDown(KeyEvent.VK_SPACE) && jumpCount == 1) {
            playerVelocity.y = -jumpSpeed;
            jumpCount = 0;
        }
        player.pos.x += playerVelocity.x * dt;
        player.pos.y += playerVelocity.y * dt;

        for (Collider c : levelCollider) {

            // Salto da terra
            if (Input.getKeyDown(KeyEvent.VK_SPACE) && player.OnCollisionBelow(c)) {
                playerVelocity.y = -jumpSpeed;
                player.pos.y = c.pos.y - 18;
                jumpCount = 1;
            }
            // Gravità in aria
            if (!player.OnCollisionBelow(c)) {
                playerVelocity.x += gravity.x * dt;
                playerVelocity.y += gravity.y * dt;
            } else {
                playerVelocity.y = 0;
                player.pos.y = c.pos.y - 16;
            }
        }

        //cam.pos = new Vector2(player.pos.x - Renderer.SCREEN_WIDTH_PX / 2 + 8, player.pos.y - Renderer.SCREEN_HEIGHT_PX / 2 + 8);
        cam.pos = new Vector2(player.pos.x - Renderer.SCREEN_WIDTH_PX / 2 + 8, 0);

        if (Input.getKeyDown(KeyEvent.VK_F2)) {
            debugMode = !debugMode;
        }
    }

    @Override
    public void Render(Renderer r) {
        r.clearScreen(new Color(50, 50, 50));

        for (Tile t : levelTile) {
            r.drawTileOnLevel(t, cam);
        }

        r.drawTileOnLevel(player, cam);

        r.drawEmptyRectOnScreen(new Vector2(10, 10), 100, 12, 0xff000000);
        r.drawFillRectOnScreen(new Vector2(11, 11), 98, 10, 0xff138811);
        r.drawFillRectOnScreen(new Vector2(11, 11), currentHealth * 100 / maxHealth - 2, 10, 0xff00bb00);
        r.writeOnScreen(currentHealth + "/" + maxHealth, new Vector2(12, 12));

        r.drawEmptyRectOnScreen(new Vector2(10, 24), 100, 12, 0xff000000);
        r.drawFillRectOnScreen(new Vector2(11, 25), 98, 10, 0xff304a75);
        r.drawFillRectOnScreen(new Vector2(11, 25), currentMana * 100 / maxMana - 2, 10, 0xff68a2ff);
        r.writeOnScreen(currentMana + "/" + maxMana, new Vector2(12, 26));

        if (debugMode) {
            r.drawFillRectOnScreen(new Vector2(0, 0), 160, 160, 0xff888888);
            r.writeOnScreen("player x: " + player.pos.x, new Vector2(0, 0));
            r.writeOnScreen("player y: " + player.pos.y, new Vector2(0, 8));
            r.writeOnScreen("cam x: " + cam.pos.x, new Vector2(0, 16));
            r.writeOnScreen("cam y: " + cam.pos.y, new Vector2(0, 24));
            r.writeOnScreen("FPS: " + fps, new Vector2(0, 32));

            r.writeOnScreen("velx: " + playerVelocity.x, new Vector2(0, 48));
            r.writeOnScreen("vely: " + playerVelocity.y, new Vector2(0, 56));

            r.drawEmptyRectOnLevel(player.pos, 16, 16, cam);

            for (Collider c : levelCollider) {
                r.drawEmptyRectOnLevel(c.pos, c.width, c.height, cam);
            }
        }
    }
}
