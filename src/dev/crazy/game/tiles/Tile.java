package dev.crazy.game.tiles;

import dev.crazy.game.entities.statics.PalmTree;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //Static
    public static Tile[] tiles = new Tile[256];
    public static Tile sandTile = new SandTile(0);
    public static Tile waterTile = new WaterTile(1);

    //Class
    public static final int TILE_WIDTH = 40, TILE_HEIGHT = 40;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_WIDTH, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }

}
