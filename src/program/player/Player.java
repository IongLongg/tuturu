package program.player;

import program.Settings;
import program.core.GameObject;
import program.core.GameWindow;
import program.maps.Box;
import program.maps.ItemShoes;
import program.maps.Wood;
import program.physics.BoxCollider;
import program.player.playerBoom.PlayerBoom;
import program.renderer.SingleImageRenderer;
import tklibs.Mathx;

public class Player extends GameObject {

    public Player() {
        GameObject.playerLayers.add(this);
        hitBox = new BoxCollider(this, 30, 20);
        renderer = new SingleImageRenderer("assests/image/player/0.png");
        position.set(Settings.PLAYER_START_X, Settings.PLAYER_START_Y);
    }

    public void run() {
        super.run();
        this.move();
        this.fire();
        this.limitPosition();
        this.getShoes();
    }

    private void getShoes() {
        ItemShoes itemShoes = GameObject.findIntersects(ItemShoes.class, this.hitBox);

        if (itemShoes != null) {
            itemShoes.deactive();
            Settings.PLAYER_SPEED += 3;
        }
    }

    int count = 0;
    public void fire() {
        count++;

        System.out.println(count);
        if(GameWindow.isFirePress && count > Settings.PLAYER_FIRE_DELAY) {
            PlayerBoom boom = new PlayerBoom();
            boom.position.set(this.position);
            count = 0;
        }
    }

    public void move() {
        double playerSpeed = Settings.PLAYER_SPEED;
        double vx = 0;
        double vy = 0;

        if(GameWindow.isUpPress) {
            vy -= playerSpeed;
        }
        if(GameWindow.isRightPress) {
            vx += playerSpeed;
        }
        if(GameWindow.isDownPress) {
            vy += playerSpeed;
        }
        if(GameWindow.isLeftPress) {
            vx -= playerSpeed;
        }

        if(vx != 0 && vy != 0) {
            double v = playerSpeed / Math.sqrt(2);
            vx = Math.signum(vx) * v;
            vy = Math.signum(vy) * v;
        }

        Box box = GameObject.findIntersects(Box.class, this.hitBox.shift(vx, vy));
        if (box != null){
            vx = 0;
            vy = 0;
        }

        Wood wood = GameObject.findIntersects(Wood.class, this.hitBox.shift(vx,vy));
        if (wood != null) {
            vx = 0;
            vy = 0;
        }

        velocity.set(vx, vy);
    }

    public void limitPosition() {
        position.setX(Mathx.clamp(position.x, anchor.x * Settings.PLAYER_WIDTH, Settings.BACKGROUND_WIDTH - anchor.x * Settings.PLAYER_WIDTH));
        position.setY(Mathx.clamp(position.y, anchor.y * Settings.PLAYER_HEIGHT, Settings.GAME_HEIGHT - anchor.x * Settings.PLAYER_HEIGHT));
    }
}
