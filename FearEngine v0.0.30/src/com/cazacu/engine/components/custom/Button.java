package com.cazacu.engine.components.custom;

import com.cazacu.engine.components.*;
import com.cazacu.engine.graphics.Font;
import com.cazacu.engine.physics.Vector2;

public class Button {

    public Vector2 pos;
    public Collider collider;
    public Text text;

    public Button(Vector2 pos, Collider c, Text txt) {
        this.pos = pos;
        this.collider = c;
        this.text = txt;
    }

    public Button(Vector2 pos, Text txt) {
        this.pos = pos;
        this.text = txt;
        this.collider = new Collider(this.pos, text.text.length() * Font.FONT_SIZE, Font.FONT_SIZE);
    }

    public Button(Vector2 pos) {
        this.pos = pos;
        text = new Text("INSERT TEXT HERE!", 0xffffffff);
        this.collider = new Collider(this.pos, text.text.length() * Font.FONT_SIZE, Font.FONT_SIZE);
    }

}
