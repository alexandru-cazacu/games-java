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
    private boolean[] availableB;
    private Tetromino[] availableT;

    private final int gridW = 12;
    private final int gridH = 20;
    private final int tMaxSize = 5;

    private Tetromino currentTetromino, ghostTetromino, nextTetromino;
    private Vector2 currentTetrominoPos, ghostTetrominoPos;

    private int score;
    private double timer;
    private double gameTimer;
    private double roundTime;

    private boolean onDebug = false;
    private boolean onPause = false;

    public MainGame() {
        startGame();
    }

    private void startGame() {
        //Inizializza contatori e casualità dei Tetromini
        //Primo Tetromino J
        timer = 0;
        gameTimer = 0;
        score = 0;
        roundTime = 1;
        availableB = new boolean[]{true, true, true, true, true, true, true};
        availableT = new Tetromino[]{Tetromino.I, Tetromino.O, Tetromino.T, Tetromino.S, Tetromino.Z, Tetromino.J, Tetromino.L};

        //Inizializza griglia
        grid = new Sprite[gridW][gridH];

        //Inizializzo sfondo griglia
        for (int y = 0; y < gridH; y++) {
            for (int x = 0; x < gridW; x++) {
                grid[x][y] = Sprite.backLevel;
            }
        }

        //Inizializza ultimo strato
        //Inizializza primi 2 strati del pericolo
        for (int x = 0; x < gridW; x++) {
            grid[x][19] = Sprite.blockLevel;
            grid[x][0] = Sprite.backDanger;
            grid[x][1] = Sprite.backDanger;
        }

        //Inizializza i bordi laterali
        for (int y = 0; y < gridH; y++) {
            grid[0][y] = Sprite.blockLevel;
            grid[gridW - 1][y] = Sprite.blockLevel;
        }

        //Inizializza i Tetromini nella scena
        currentTetromino = new Tetromino(Tetromino.J);
        ghostTetromino = new Tetromino(Tetromino.J);
        nextTetromino = new Tetromino(Tetromino.J);

        //Genera il primo Tetromino
        newPiece();
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void newPiece() {
        currentTetromino = new Tetromino(nextTetromino);
        ghostTetromino = new Tetromino(nextTetromino);
        currentTetrominoPos = new Vector2(nextTetromino.spawnPos);
        ghostTetrominoPos = new Vector2(nextTetromino.spawnPos);

        int rand = ThreadLocalRandom.current().nextInt(0, 7);

        int avT = 0;
        while (availableB[rand] == false) {
            rand = ThreadLocalRandom.current().nextInt(0, 7);
            avT++;
            //Se tutti i Tetromini sono stati generati almeno una volta
            //Allora rimettili tutti disponibili
            if (avT == 40) {
                for (int j = 0; j < 7; j++) {
                    availableB[j] = true;
                }
                break;
            }
        }
        //Imposta il prossimo Tetromino
        nextTetromino = new Tetromino(availableT[rand]);
        availableB[rand] = false;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void fallPiece() {
        currentTetrominoPos.y++;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public boolean onCollisionBelow(Tetromino t, Vector2 pos) {
        for (int y = t.length - 1; y >= 0; y--) {
            for (int x = 0; x < t.length; x++) {
                if (t.grid[x][y] != Sprite.empty) {
                    if (grid[x + (int) (pos.x)][y + (int) (pos.y) + 1] == Sprite.blockLevel
                            || grid[x + (int) (pos.x)][y + (int) (pos.y) + 1] == Sprite.blockTetromino) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public boolean onCollisionLeft() {
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

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public boolean onCollisionRight() {
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

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void posePiece() {
        for (int y = 0; y < currentTetromino.length; y++) {
            for (int x = 0; x < currentTetromino.length; x++) {
                if (currentTetromino.grid[x][y] != Sprite.empty) {
                    grid[x + (int) (currentTetrominoPos.x)][y + (int) (currentTetrominoPos.y)] = currentTetromino.grid[x][y];
                }
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void deleteLine() {
        boolean goodLine;
        //Scorre verticalmente tranne le prime 2 e l'ultima riga
        for (int y = 2; y < gridH - 1; y++) {
            //Scorre orizzontalmente tranne la prima e l'ultima colonna
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
                score += 100;
                roundTime = roundTime / 100 * 99;
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public boolean isLosing() {
        for (int x = 1; x < gridW - 1; x++) {
            if (grid[x][0] == Sprite.blockTetromino || grid[x][1] == Sprite.blockTetromino) {
                return true;
            }
        }
        return false;
    }

    @Override
    //----------------------------------------------------------------------------------------------------------------------------------------------------
    public void Update(double dt) {
        //Abilita Pausa
        if (Input.getKeyDown(KeyEvent.VK_ESCAPE) || Input.getKeyDown(KeyEvent.VK_P)) {
            onPause = !onPause;
        }
        //Se non è in pausa
        if (!onPause) {
            timer += dt;
            gameTimer += dt;

            //Debug Mode
            if (Input.getKeyDown(KeyEvent.VK_F2)) {
                onDebug = !onDebug;
            }
            //Muove Tetromino sX
            if (Input.getKeyDown(KeyEvent.VK_A) && !onCollisionLeft()) {
                currentTetrominoPos.x--;
            }
            //Muove Tetromino dX
            if (Input.getKeyDown(KeyEvent.VK_D) && !onCollisionRight()) {
                currentTetrominoPos.x++;
            }

            //Ruota Tetromino sX
            if (Input.getKeyDown(KeyEvent.VK_Q)) {
                boolean canRotate = true;
                Tetromino rotTet = new Tetromino(currentTetromino);
                Vector2 rotTetPos = new Vector2(currentTetrominoPos);
                rotTet.rotateLeft();
                for (int y = 0; y < rotTet.length; y++) {
                    for (int x = 0; x < rotTet.length; x++) {
                        if (rotTet.grid[x][y] == Sprite.blockTetromino) {
                            if (grid[(int) (rotTetPos.x) + x][(int) (rotTetPos.y) + y] == Sprite.blockLevel
                                    || grid[(int) (rotTetPos.x) + x][(int) (rotTetPos.y) + y] == Sprite.blockTetromino) {
                                canRotate = false;
                            }
                        }
                    }
                }

                if (canRotate) {
                    currentTetromino.rotateLeft();
                } else {
                    canRotate = true;
                    rotTet = new Tetromino(currentTetromino);
                    rotTetPos = new Vector2(currentTetrominoPos);
                    rotTet.rotateLeft();
                    rotTetPos.x++;
                    for (int y = 0; y < rotTet.length; y++) {
                        for (int x = 0; x < rotTet.length; x++) {
                            if (rotTet.grid[x][y] == Sprite.blockTetromino) {
                                if (grid[(int) (rotTetPos.x) + x][(int) (rotTetPos.y) + y] == Sprite.blockLevel
                                        || grid[(int) (rotTetPos.x) + x][(int) (rotTetPos.y) + y] == Sprite.blockTetromino) {
                                    canRotate = false;
                                }
                            }
                        }
                    }

                    if (canRotate) {
                        currentTetromino.rotateLeft();
                        currentTetrominoPos.x++;
                    }
                }
            }
            //Ruota Tetromino dX
            if (Input.getKeyDown(KeyEvent.VK_E)) {
                boolean canRotate = true;
                Tetromino rotTet = new Tetromino(currentTetromino);
                Vector2 rotTetPos = new Vector2(currentTetrominoPos);
                rotTet.rotateRight();
                for (int y = 0; y < rotTet.length; y++) {
                    for (int x = 0; x < rotTet.length; x++) {
                        if (rotTet.grid[x][y] == Sprite.blockTetromino) {
                            if (grid[(int) (rotTetPos.x) + x][(int) (rotTetPos.y) + y] == Sprite.blockLevel
                                    || grid[(int) (rotTetPos.x) + x][(int) (rotTetPos.y) + y] == Sprite.blockTetromino) {
                                canRotate = false;
                            }
                        }
                    }
                }

                if (canRotate) {
                    currentTetromino.rotateRight();
                } else {
                    canRotate = true;
                    rotTet = new Tetromino(currentTetromino);
                    rotTetPos = new Vector2(currentTetrominoPos);
                    rotTet.rotateRight();
                    rotTetPos.x--;
                    for (int y = 0; y < rotTet.length; y++) {
                        for (int x = 0; x < rotTet.length; x++) {
                            if (rotTet.grid[x][y] == Sprite.blockTetromino) {
                                if (grid[(int) (rotTetPos.x) + x][(int) (rotTetPos.y) + y] == Sprite.blockLevel
                                        || grid[(int) (rotTetPos.x) + x][(int) (rotTetPos.y) + y] == Sprite.blockTetromino) {
                                    canRotate = false;
                                }
                            }
                        }
                    }

                    if (canRotate) {
                        currentTetromino.rotateRight();
                        currentTetrominoPos.x--;
                    }
                }
            }
            //Hard Drop
            if (Input.getKeyDown(KeyEvent.VK_W)) {
                while (!onCollisionBelow(currentTetromino, currentTetrominoPos)) {
                    currentTetrominoPos.y++;
                }
            }
            //Soft Drop
            if (Input.getKey(KeyEvent.VK_S)) {
                if (!onCollisionBelow(currentTetromino, currentTetrominoPos)) {
                    fallPiece();
                } else {
                    posePiece();
                    newPiece();
                    timer = 1;
                }
            }
        }

        //Verifica per eliminare eventuali linee complete
        deleteLine();

        //Condizione di sconfitta
        if (isLosing()) {
            GameOver.score = score;
            startGame();
            SceneManager.loadScene("GameOver");
        }

        //Movimento del Tetromino Ghost
        ghostTetromino = currentTetromino;
        ghostTetrominoPos = new Vector2(currentTetrominoPos);

        while (!onCollisionBelow(ghostTetromino, ghostTetrominoPos)) {
            ghostTetrominoPos.y++;
        }

        if (timer >= roundTime) {
            timer = 0;

            //Condizione per poggiare il pezzo corrente
            if (onCollisionBelow(currentTetromino, currentTetrominoPos)) {
                timer = 0;
                posePiece();
                newPiece();
            } else {
                fallPiece();
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void Render(Renderer r) {
        r.setBackgroundColor(0xff111111);

        //Disegna la griglia di gioco
        for (int y = 0; y < gridH; y++) {
            for (int x = 0; x < gridW; x++) {
                r.drawSpriteOnScreen(grid[x][y], new Vector2(x * 16 + 16, y * 16 + 16));
            }
        }

        //Disegna il Tetromino corrente
        for (int y = 0; y < currentTetromino.length; y++) {
            for (int x = 0; x < currentTetromino.length; x++) {
                Vector2 pos = new Vector2(x * 16 + (currentTetrominoPos.x + 1) * 16, y * 16 + (currentTetrominoPos.y + 1) * 16);
                r.drawSpriteOnScreen(currentTetromino.grid[x][y], pos);
            }
        }

        //Disegna il Tetromino Ghost
        for (int y = 0; y < ghostTetromino.length; y++) {
            for (int x = 0; x < ghostTetromino.length; x++) {
                if (ghostTetromino.grid[x][y] == Sprite.blockTetromino) {
                    Vector2 pos = new Vector2(x * 16 + (ghostTetrominoPos.x + 1) * 16, y * 16 + (ghostTetrominoPos.y + 1) * 16);
                    r.drawRectOnScreen(pos, 16, 16, 0xff00ff00);
                }
            }
        }

        //Tetromino Next: scritta, sfondo, disegno
        r.writeOnScreen("Next", 0xff00ff00, new Vector2(224, 20));
        r.drawRectOnScreen(new Vector2(224, 32), 16 * tMaxSize, 16 * tMaxSize, 0xff00ff00);
        for (int y = 0; y < nextTetromino.length; y++) {
            for (int x = 0; x < nextTetromino.length; x++) {
                Vector2 pos = new Vector2(0, 0);
                pos.x = x * 16 + 224 + (tMaxSize - nextTetromino.length) * 8;
                pos.y = y * 16 + 32 + (tMaxSize - nextTetromino.length) * 8;
                r.drawSpriteOnScreen(nextTetromino.grid[x][y], pos);
            }
        }

        //Scrive lo Score
        r.writeOnScreen("SCORE: " + score, 0xff00ff00, new Vector2(224, 132));

        if (onDebug) {
            int posY = 160;
            r.writeOnScreen("Round: " + new DecimalFormat("#0.00").format(timer), new Vector2(224, posY));
            r.writeOnScreen("Game: " + new DecimalFormat("#0.00").format(gameTimer), new Vector2(224, posY + 8));
            r.writeOnScreen("Tx: " + currentTetrominoPos.x, new Vector2(224, posY + 16));
            r.writeOnScreen("Ty: " + currentTetrominoPos.y, new Vector2(224, posY + 24));
            r.writeOnScreen("Rt: " + new DecimalFormat("#0.00").format(roundTime), new Vector2(224, posY + 32));

            //Scrive un elendo dei Tetromini disponibili e non
            for (int i = 0; i < availableB.length; i++) {
                if (availableB[i]) {
                    r.writeOnScreen("T", new Vector2(224, posY + 40 + 8 * i));
                    r.writeOnScreen("V", 0xff00ff00, new Vector2(240, posY + 40 + 8 * i));
                } else {
                    r.writeOnScreen("T", new Vector2(224, posY + 40 + 8 * i));
                    r.writeOnScreen("X", 0xffff0000, new Vector2(240, posY + 40 + 8 * i));
                }

            }

            //Disegna i limiti del Tetromino
            Vector2 p = new Vector2(0, 0);
            p.x = 16 + currentTetrominoPos.x * 16;
            p.y = 16 + currentTetrominoPos.y * 16;
            r.drawRectOnScreen(p, currentTetromino.length * 16, currentTetromino.length * 16, 0xffff0000);

            //Disegna il centro del Tetromino
            Vector2 p2 = new Vector2(0, 0);
            p2.x = 16 + currentTetrominoPos.x * 16 + currentTetromino.length * 16 / 2 - 2;
            p2.y = 16 + currentTetrominoPos.y * 16 + currentTetromino.length * 16 / 2 - 2;
            r.drawRectOnScreen(p2, 4, 4, 0xffff0000);
        }

        //Disegna la schermata di pausa
        if (onPause) {
            r.setBackgroundColor(0xff111111);
            r.writeOnScreen("Pause!", 0xffffffff, new Vector2(Renderer.SCREEN_WIDTH_PX / 2 - 24, Renderer.SCREEN_HEIGHT_PX / 2 - 4));
        }
    }
}
