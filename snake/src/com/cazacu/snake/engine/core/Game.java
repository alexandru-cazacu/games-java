package com.cazacu.snake.engine.core;

public class Game implements Runnable{
    
    private Thread gameLoop;
    private Renderer renderer;
    private Input input;
    private boolean isRunning = false;
    
    //Prepara il ciclo di gioco.
    //--------------------------------------------------------------------------
    public void start() {
        if (isRunning)
            return;
        
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //width = (int) ((int) screenSize.getWidth()/scale);
        //height = (int) ((int) screenSize.getHeight()/scale);
        
        renderer = new Renderer(this);
        input = new Input(this);
        
        //GameContainer in parallelo. Inizio ciclo di gioco.
        gameLoop = new Thread(this);
        gameLoop.run();
    }
    
    //Ferma il ciclo di gioco.
    //--------------------------------------------------------------------------
    public void Stop() {
        if (!isRunning)
            return;
        
        isRunning = false;
    }
    
    //Il ciclo di gioco vero e proprio.
    //--------------------------------------------------------------------------
    public void run() {
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1e9;
        double deltaTime = 0;
        isRunning  = true;
        
        //--------------------------------------------------------------------------------
        while(isRunning) {           
            boolean isRendering = false;
            firstTime = System.nanoTime() / 1e9;
            deltaTime = firstTime - lastTime;
            lastTime = firstTime;

            this.Update(deltaTime);
            input.update();
            isRendering = true;
            
            if (isRendering) {
                renderer.clear();
                this.Render(renderer);
                renderer.update();
            }            
        }
        renderer.cleanUp();
    }
    
    public void Update(double dt) {
        
    }
    
    public void Render(Renderer r) {
        
    }

    public Renderer getRenderer() {
        return renderer;
    }
}
