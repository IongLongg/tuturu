package program.maps;

import program.core.GameObject;
import program.core.MapObject;
import program.physics.BoxCollider;
import program.renderer.SingleImageRenderer;

public class Wood extends GameObject {
    public Wood() {
        GameObject.mapLayers.add(this);
        hp = 1;
        anchor.set(0, 0);
        hitBox = new BoxCollider(this, 45, 45);
        renderer = new SingleImageRenderer("assests/image/map/box/wood.png");
    }
}
