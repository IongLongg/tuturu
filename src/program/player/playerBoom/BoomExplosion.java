package program.player.playerBoom;

import program.core.GameObject;
import program.enemy.Enemy;
import program.maps.Box;
import program.maps.Wood;
import program.physics.BoxCollider;
import program.renderer.Renderer;
import program.renderer.SingleImageRenderer;

import java.awt.*;

public class BoomExplosion extends GameObject {
    public int damage;
    Renderer r1;
    Renderer r2;
    Renderer r3;
    Renderer r4;

    public BoomExplosion() {
        GameObject.playerLayers.add(this);
        damage = 1;
    }


    //TODO: render r1, r2 .... ra null

    @Override
    public void run() {
        this.killEnemy();
        killThis();
//        this.killBox();
        this.killWood();
    }

    int count = 0;
    public void killThis() {
        count++;
        if(count > 30) {
            this.deactive();
            count = 0;
        }
    }

    public void killEnemy() {
        Enemy enemy = GameObject.findIntersects(Enemy.class, this.hitBox);
        if(enemy != null) {
            enemy.takeDamage(this.damage);
        }
    }

    public void killBox() {
        Box box = GameObject.findIntersects(Box.class, this.hitBox);
        if(box != null) {
            box.takeDamage(this.damage);
        }
    }

    public void killWood() {
        Wood wood = GameObject.findIntersects(Wood.class, this.hitBox);
        if(wood != null) {
            wood.takeDamage(this.damage);
        }
    }

}