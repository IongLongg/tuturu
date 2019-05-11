package program.enemy;

import program.core.GameObject;

public class EnemySummoner extends GameObject {
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    Enemy enemy4;
    Enemy enemy5;
    Enemy enemy6;

    public EnemySummoner() {
        enemy1 = new Enemy();
        enemy1.position.set(0, 0);

        enemy2 = new Enemy();
        enemy2.position.set(0, 90);

        enemy3 = new Enemy();
        enemy3.position.set(0, 180);

        enemy4 = new Enemy();
        enemy4.position.set(0, 270);

        enemy5 = new Enemy();
        enemy5.position.set(0, 360);

        enemy6 = new Enemy();
        enemy6.position.set(0, 450);

    }
}
