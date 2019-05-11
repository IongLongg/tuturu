package program.enemy;

import program.Settings;
import program.core.GameObject;
import program.maps.Box;
import program.maps.Wood;
import program.physics.BoxCollider;
import program.physics.Vector2D;
import program.player.Player;
import program.player.playerBoom.PlayerBoom;
import program.renderer.SingleImageRenderer;

public class Enemy extends GameObject {
    public int hp;

    public Enemy() {
        GameObject.enemyLayers.add(this);
        renderer = new SingleImageRenderer("assests/image/enemy/monster_left.png");
        hitBox = new BoxCollider(this, 30,30);
        hp = 1;
        velocity.set(3, 0);
    }

    @Override
    public void run() {
        super.run();
        this.killPlayer();
        this.intelligent();
    }

    public void killPlayer() {
        Player player = GameObject.findIntersects(Player.class, this.hitBox);
        if(player != null) {
            player.takeDamage(Settings.PLAYER_HP);
        }
    }

    public void intelligent() {
        if(this.outBoundRight() && this.onGoingRight()) {
            this.reverseVelocityX();
        }
        if(this.outBoundLeft() && this.onGoingLeft()) {
            this.reverseVelocityX();
        }

        PlayerBoom playerBoom = GameObject.findIntersects(PlayerBoom.class, this.hitBox.shift(this.velocity.x, this.velocity.y));

        if (playerBoom != null){
            this.reverseVelocityX();
        }

    }

    private boolean outBoundRight() {
        return this.position.x >= Settings.BACKGROUND_WIDTH
                - this.anchor.x * Settings.PLAYER_WIDTH;
    }

    private boolean outBoundLeft() {
        return this.position.x <= this.anchor.x * Settings.PLAYER_WIDTH;
    }

    private boolean onGoingRight() {
        return this.velocity.x > 0;
    }

    private boolean onGoingLeft() {
        return this.velocity.x < 0;
    }

    private void reverseVelocityX() {
        this.velocity.setX(-this.velocity.x);
    }

}
