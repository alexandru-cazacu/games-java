package com.cazacu.snake.engine.physics;

public class Transform {
    private String name = "null";
    private String tag = "null";
    public Vector2 position;
    public int depth;
    
    public Transform(Vector2 position, int depth) {
        this.position = position;
        this.depth = depth;
    }
    
    public Transform(Vector2 position) {
        this.position = position;
        this.depth = 0;
    }
    
    public Transform(int depth) {
        this.position = new Vector2(0, 0);
        this.depth = depth;
    }
    
    public Transform() {
        this.position = new Vector2(0, 0);
        this.depth = 0;
    }
}
