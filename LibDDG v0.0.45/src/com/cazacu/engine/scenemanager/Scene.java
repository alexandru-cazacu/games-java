package com.cazacu.engine.scenemanager;

import com.cazacu.engine.framework.Renderer;

public abstract class Scene {
    public abstract void Update(double dt);
    public abstract void Render(Renderer r);
    public abstract void Start();
}