package com.cazacu.engine.scenes;

import com.cazacu.engine.framework.Input;
import com.cazacu.engine.framework.Renderer;
import com.cazacu.engine.graphics.Sprite;
import com.cazacu.engine.physics.Vector2;
import com.cazacu.engine.scenemanager.Scene;
import com.cazacu.engine.scenemanager.SceneManager;
import com.cazacu.game.Tetromino;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class MainGame extends Scene {

    private Sprite[][] grid;
    private final int gridW = 12;
    private final int gridH = 20;

    private Tetromino currentTetromino;
    private Tetromino ghostTetromino = Tetromino.S;
    private Tetromino nextTetromino = new Tetromino(Tetromino.S);
    private Tetromino holdTetromino = new Tetromino(Tetromino.I);

    private Vector2 currentTetrominoPos = new Vector2(0, 0);
    private Vector2 ghostTetrominoPos = new Vector2(0, 0);

    private int score;
    private double timer;
    private double gameTime;

    private boolean debugMode = false;

    private int nextTetrominoMaxSize = 5;

    public MainGame(String name) {
        this.name = name;
        initGame();
    }

    public void initGame() {
        timer = 0;
        gameTime = 0;
        score = 0;

        grid = new Sprite[gridW][gridH];

        for (int y = 0; y < gridH; y++) {
            for (int x = 0; x < gridW; x++) {
                grid[x][y] = Sprite.backLevel;
            }
        }

        for (int x = 0; x < gridW; x++) {
            grid[x][19] = Sprite.blockLevel;
            grid[x][0] = Sprite.backDanger;
            grid[x][1] = Sprite.backDanger;
        }

        for (int y = 0; y < gridH; y++) {
            grid[0][y] = Sprite.blockLevel;
            grid[gridW - 1][y] = Sprite.blockLevel;
        }

        newPiece();
    }

    public void newPiece() {
        int n = ThreadLocalRandom.current().nextInt(0, 8);

        switch (n) {
            case 0:
                currentTetromino = Tetromino.I;
                break;
            case 1:
                currentTetromino = Tetromino.O;
                break;
            case 2:
                currentTetromino = Tetromino.T;
                break;
            case 3:
                currentTetromino = Tetromino.S;
                break;
            case 4:
                currentTetromino = Tetromino.Z;
                break;
            case 5:
                currentTetromino = Tetromino.J;
                break;
            case 6:
                currentTetromino = Tetromino.L;
                break;
            default:
                currentTetromino = Tetromino.O;
                break;
        }
        currentTetrominoPos.x = currentTetromino.spawnPos.x;
        currentTetrominoPos.y = currentTetromino.spawnPos.y;

        deleteLine();
    }

    public void fallPiece() {
        currentTetrominoPos.y++;
    }

    public boolean isCollisionBelow(Tetromino t, Vector2 v) {
        for (int y = t.length - 1; y >= 0; y--) {
            for (int x = 0; x < t.length; x++) {
                if (t.grid[x][y] != Sprite.empty) {
                    if (grid[x + (int) (v.x)][y + (int) (v.y) + 1] == Sprite.blockLevel
                            || grid[x + (int) (v.x)][y + (int) (v.y) + 1] == Sprite.blockTetromino) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCollisionLeft() {
        for (int x = 0; x < currentTetromino.length; x++) {
            for (int y = 0; y < currentTetromino.length; y++) {
                if (currentTetromino.grid[x][y] != Sprite.empty) {
                    if (grid[x + (int) (currentTetrominoPos.x) - 1][y + (int) (currentTetrominoPos.y)] == Sprite.blockLevel
                            || grid[x + (int) (currentTetrominoPos.x) - 1][y + (int) (currentTetrominoPos.y)] == Sprite.blockTetromino) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCollisionRight() {
        for (int x = 0; x < currentTetromino.length; x++) {
            for (int y = 0; y < currentTetromino.length; y++) {
                if (currentTetromino.grid[x][y] != Sprite.empty) {
                    if (grid[x + (int) (currentTetrominoPos.x) + 1][y + (int) (currentTetrominoPos.y)] == Sprite.blockLevel
                            || grid[x + (int) (currentTetrominoPos.x) + 1][y + (int) (currentTetrominoPos.y)] == Sprite.blockTetromino) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void posePiece() {
        for (int y = 0; y < currentTetromino.length; y++) {
            for (int x = 0; x < currentTetromino.length; x++) {
                if (currentTetromino.grid[x][y] != Sprite.empty) {
                    grid[x + (int) (currentTetrominoPos.x)][y + (int) (currentTetrominoPos.y)] = currentTetromino.grid[x][y];
                }
            }
        }
    }

    public void deleteLine() {
        boolean goodLine;
        //Scorro verticalmente tranne le prime 2 e l'ultima riga
        for (int y = 2; y < gridH - 1; y++) {
            //Scorro orizzontalmente tranne la prima e l'ultima colonna
            goodLine = true;
            for (int x = 1; x < gridW - 1; x++) {
                if (grid[x][y] == Sprite.backLevel) {
                    goodLine = false;
                    break;
                }
            }
            if (goodLine) {
                for (int yy = y; yy > 3; yy--) {
                    for (int xx = 1; xx < gridW - 1; xx++) {
                        grid[xx][yy] = grid[xx][yy - 1];
                    }
                }
                score += 1000;
                goodLine = true;
            }
        }
    }

    public boolean isLosing() {
        for (int x = 1; x < gridW - 1; x++) {
            if (grid[x][0] == Sprite.blockTetromino || grid[x][1] == Sprite.blockTetromino) {
                return true;
            }
        }
        return false;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void Update(double dt) {
        timer += dt;
        gameTime += dt;

        //Condizione per poggiare il pezzo corrente
        if (isCollisionBelow(currentTetromino, currentTetrominoPos)) {
            timer = 0;
            posePiece();
            newPiece();
        }

        //Verifica per eliminare eventuali linee complete
        deleteLine();

        //Condizione di sconfitta
        if (isLosing()) {
            GameOver.score = score;
            SceneManager.loadScene("GameOver");
        }

        ghostTetromino = currentTetromino;
        ghostTetrominoPos.y = currentTetrominoPos.y;
        ghostTetrominoPos.x = currentTetrominoPos.x;
        while (!isCollisionBelow(ghostTetromino, ghostTetrominoPos)) {
            ghostTetrominoPos.y++;
        }

        if (timer >= 1) {
            timer = 0;
            fallPiece();
        }

        if (Input.getKeyDown(KeyEvent.VK_F2)) {
            debugMode = !debugMode;
        }

        if (Input.getKey(KeyEvent.VK_S)) {
            if (!isCollisionBelow(currentTetromino, currentTetrominoPos)) {
                fallPiece();
            } else {
                posePiece();
                newPiece();
                timer = 1;
            }
        }

        if (Input.getKeyDown(KeyEvent.VK_A) && !isCollisionLeft()) {
            currentTetrominoPos.x--;
        }
        if (Input.getKeyDown(KeyEvent.VK_D) && !isCollisionRight()) {
            currentTetrominoPos.x++;
        }

        if (Input.getKeyDown(KeyEvent.VK_Q)) {
            currentTetromino.rotateLeft();
        }
        if (Input.getKeyDown(KeyEvent.VK_E)) {
            currentTetromino.rotateRight();
        }

        if (Input.getKeyDown(KeyEvent.VK_W)) {
            while (!isCollisionBelow(currentTetromino, currentTetrominoPos)) {
                currentTetrominoPos.y++;
            }
        }

        if (Input.getKeyDown(KeyEvent.VK_SPACE)) {
            Tetromino temp = currentTetromino;
            currentTetromino = holdTetromino;
            holdTetromino = temp;
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void Render(Renderer r) {
        r.setBackgroundColor(0xff111111);

        //Disegno la griglia di gioco
        for (int y = 0; y < gridH; y++) {
            for (int x = 0; x < gridW; x++) {
                r.drawSpriteOnScreen(grid[x][y], new Vector2(x * 16 + 16, y * 16 + 16));
            }
        }

        //Disegno il Tetromino corrente
        for (int y = 0; y < currentTetromino.length; y++) {
            for (int x = 0; x < currentTetromino.length; x++) {
                r.drawSpriteOnScreen(currentTetromino.grid[x][y], new Vector2(x * 16 + (currentTetrominoPos.x + 1) * 16, y * 16 + (currentTetrominoPos.y + 1) * 16));
            }
        }

        //Disegno il Tetromino Ghost
        for (int y = 0; y < ghostTetromino.length; y++) {
            for (int x = 0; x < ghostTetromino.length; x++) {
                //r.drawSpriteOnScreen(ghostTetromino.grid[x][y], new Vector2(x * 16 + (ghostTetrominoPos.x + 1) * 16, y * 16 + (ghostTetrominoPos.y + 1) * 16));
                if (ghostTetromino.grid[x][y] == Sprite.blockTetromino) {
                    r.drawRectOnScreen(new Vector2(x * 16 + (ghostTetrominoPos.x + 1) * 16, y * 16 + (ghostTetrominoPos.y + 1) * 16), 16, 16, 0xff00ff00);
                }
            }
        }

        //Scritta del Tetromino Next
        r.writeOnScreen("Next", 0xff00ff00, new Vector2(224, 20));
        //Sfondo del Tetromino Next
        r.drawRectOnScreen(new Vector2(224, 32), 16 * nextTetrominoMaxSize, 16 * nextTetrominoMaxSize, 0xff00ff00);
        //Disegno del Tetromino Next
        for (int y = 0; y < nextTetromino.length; y++) {
            for (int x = 0; x < nextTetromino.length; x++) {
                Vector2 pos = new Vector2(0, 0);
                pos.x = x * 16 + 224 + (nextTetrominoMaxSize - nextTetromino.length) * 8;
                pos.y = y * 16 + 32 + (nextTetrominoMaxSize - nextTetromino.length) * 8;
                r.drawSpriteOnScreen(nextTetromino.grid[x][y], pos);
            }
        }

        //Scritta del Tetromino Hold
        r.writeOnScreen("Hold", 0xff00ff00, new Vector2(320, 20));
        //Sfondo del Tetromino Hold
        r.drawRectOnScreen(new Vector2(320, 32), 16 * nextTetrominoMaxSize, 16 * nextTetrominoMaxSize, 0xff00ff00);
        //Disegno del Tetromino Hold
        for (int y = 0; y < holdTetromino.length; y++) {
            for (int x = 0; x < holdTetromino.length; x++) {
                Vector2 pos = new Vector2(0, 0);
                pos.x = x * 16 + 320 + (nextTetrominoMaxSize - holdTetromino.length) * 8;
                pos.y = y * 16 + 32 + (nextTetrominoMaxSize - holdTetromino.length) * 8;
                r.drawSpriteOnScreen(holdTetromino.grid[x][y], pos);
            }
        }

        r.writeOnScreen("SCORE: " + score, 0xff00ff00, new Vector2(224, 132));

        if (debugMode) {
            int posY = 160;
            r.writeOnScreen("R T: " + new DecimalFormat("#0.00").format(timer), new Vector2(224, posY));
            r.writeOnScreen("G T: " + new DecimalFormat("#0.00").format(gameTime), new Vector2(224, posY + 8));
            r.writeOnScreen("Piece x: " + currentTetrominoPos.x, new Vector2(224, posY + 16));
            r.writeOnScreen("Piece y: " + currentTetrominoPos.y, new Vector2(224, posY + 24));
        }
    }
}
