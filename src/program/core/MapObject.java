package program.core;

import program.physics.BoxCollider;
import program.physics.Vector2D;
import program.renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;

public class MapObject  {
    public Vector2D position;
    public boolean active;
    public Vector2D anchor;
    public Renderer renderer;
    public BoxCollider hitBox;
    public int hp;

    public static ArrayList<MapObject> objects = new ArrayList<>();

    public MapObject() {
        hp = 1;
        position = new Vector2D();
        active = true;
        anchor = new Vector2D(0, 0);
        hitBox = new BoxCollider(this, 45, 45);
        objects.add(this);
    }

    public void render(Graphics g) {
        if(renderer != null) {
            renderer.render(g, this);
        }
    }

    public void deactive() {
        active = false;
    }

    public void reset() {
        active = true;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if(hp <= 0) {
            hp = 0;
            this.deactive();
        }
    }
}
