package program.player.playerBoom;

import program.core.GameObject;
import program.enemy.Enemy;
import program.maps.Box;
import program.physics.BoxCollider;
import program.renderer.Renderer;
import program.renderer.SingleImageRenderer;

import java.awt.*;

public class BoomExplosionNgang extends BoomExplosion {

    public BoomExplosionNgang() {
        hitBox = new BoxCollider(this, 135, 45);
        r1 = new SingleImageRenderer("assests/image/playerBoom/bombbang_right_1.png");
        r2 = new SingleImageRenderer("assests/image/playerBoom/bombbang_left_1.png");
    }


    //TODO: render r1, r2 .... ra null

    @Override
    public void render(Graphics g) {
        if(r1 != null && r2 != null) {
            this.anchor.set(0, 0.5);//up right down left
            r1.render(g, this);
            this.anchor.set(1, 0.5);
            r2.render(g, this);
        }
        this.anchor.set(0.5, 0.5);
    }
}
