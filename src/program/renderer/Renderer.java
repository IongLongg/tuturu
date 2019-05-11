package program.renderer;

import program.core.GameObject;
import program.core.MapObject;

import java.awt.*;

public abstract class Renderer {
    public abstract void render(Graphics g, GameObject master);
    public abstract void render(Graphics g, MapObject master);
}
