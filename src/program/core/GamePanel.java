package program.core;

import program.Background;
import program.enemy.Enemy;
import program.enemy.EnemySummoner;
import program.maps.Map;
import program.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;
    Enemy enemy;
    EnemySummoner summoner;

    public GamePanel() {
        background = new Background();
        player = new Player();
        enemy = new Enemy();
        summoner = new EnemySummoner();
        addMap();
    }

    private void addMap() {
        Map map = Map.load("assests/map/map2.json");
        map.generate();
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < GameObject.backgroundLayers.size(); i++) {
            GameObject object = GameObject.backgroundLayers.get(i);
            if(object.active) {
                object.render(g);
            }
        }

        for(int i = 0; i < GameObject.enemyLayers.size(); i++) {
            GameObject object = GameObject.enemyLayers.get(i);
            if(object.active) {
                object.render(g);
            }
        }

        for(int i = 0; i < GameObject.playerLayers.size(); i++) {
            GameObject object = GameObject.playerLayers.get(i);
            if(object.active) {
                object.render(g);
            }
        }

        for(int i = 0; i < GameObject.mapLayers.size(); i++) {
            GameObject object = GameObject.mapLayers.get(i);
            if(object.active) {
                object.render(g);
            }
        }

    }

    public void runAll() {
        for(int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.run();
            }
        }
    }

    public void gameLoop() {
        long lastTime = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime >= 1000 / 60) {
                this.repaint();
                this.runAll();
                lastTime = currentTime;
            }
        }
    }
}
