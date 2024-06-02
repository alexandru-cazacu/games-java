package com.cazacu.engine.framework;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Game extends Thread {

    private Thread gameLoop;
    private static Renderer renderer;
    private Input input;
    private boolean isRunning = false;
    private final double frameCap = 1.0 / 60.0;
    private double elapsedFrameTime = 0;

    @Override
    public void start() {
        if (isRunning) {
            return;
        }

        isRunning = true;

        renderer = new Renderer(this);
        input = new Input(this);

        gameLoop = new Thread(this);
        gameLoop.run();
    }

    //Il ciclo di gioco vero e proprio.
    //--------------------------------------------------------------------------
    @Override
    public void run() {
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1e9;
        double deltaTime = 0;

        int fps = 0;
        double time = 0;

        //--------------------------------------------------------------------------------
        while (isRunning) {
            this.Update(deltaTime);
            input.update();
            renderer.clearScreen(0xff00aaaa);
            this.Render(renderer);
            renderer.update();

            firstTime = System.nanoTime() / 1e9;
            deltaTime = firstTime - lastTime;
            lastTime = firstTime;

            elapsedFrameTime = deltaTime;

            try {
                Thread.sleep((long) (17 - deltaTime));
            } catch (InterruptedException ex) {
                System.err.println("Game Thread sleep error");
            }
        }
        renderer.cleanUp();
    }

    protected abstract void Update(double dt);

    protected abstract void Render(Renderer r);

    public static Renderer getRenderer() {
        return renderer;
    }
}
