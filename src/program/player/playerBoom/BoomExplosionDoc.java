package program.player.playerBoom;

import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

import java.awt.*;

public class BoomExplosionDoc extends BoomExplosion {

    public BoomExplosionDoc() {
        hitBox = new BoxCollider(this, 45, 135);
        r3 = new SingleImageRenderer("assests/image/playerBoom/bombbang_up_1.png");
        r4 = new SingleImageRenderer("assests/image/playerBoom/bombbang_down_1.png");
    }


    //TODO: render r1, r2 .... ra null

    @Override
    public void render(Graphics g) {
        if(r3 != null && r4 != null) {
            this.anchor.set(0.5, 1);//up right down left
            r3.render(g, this);
            this.anchor.set(0.5, 0.5);
            r4.render(g, this);
        }
        this.anchor.set(0.5, 0.5);
    }
}
