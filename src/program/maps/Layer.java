package program.maps;

import program.core.GameObject;
import program.core.MapObject;

import java.util.List;

public class Layer {
    private List<Integer> data;
    private int width;
    private int height;

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    public void generate() {
        for(int tileY = 0; tileY < height; tileY++) {
            for(int tileX = 0; tileX < width; tileX++) {
                int mapData = data.get(tileY * width + tileX);

                if(mapData == 1) {
                    Box box = new Box();
                    box.position.set(tileX * 45, tileY * 45);
                    GameObject.mapLayers.add(box);
                }

                if(mapData == 4) {
                    Wood wood = new Wood();
                    wood.position.set(tileX * 45, tileY * 45);
                    GameObject.mapLayers.add(wood);
                }

                if(mapData == 3) {
                    Shadow shadow = new Shadow();
                    shadow.position.set(tileX * 45, tileY * 45);
                    GameObject.mapLayers.add(shadow);
                }

                if (mapData == 5) {
                    ItemBomb itemBomb = new ItemBomb();
                    itemBomb.position.set(tileX * 45, tileY * 45);
                    GameObject.mapLayers.add(itemBomb);
                }
                if (mapData == 6) {
                    ItemShoes itemShoes = new ItemShoes();
                    itemShoes.position.set(tileX * 45, tileY * 45);
                    GameObject.mapLayers.add(itemShoes);
                }
                if (mapData == 7) {
                    ItemBombSize itemBombSize = new ItemBombSize();
                    itemBombSize.position.set(tileX * 45, tileY * 45);
                    GameObject.mapLayers.add(itemBombSize);
                }

            }
        }
    }
}
