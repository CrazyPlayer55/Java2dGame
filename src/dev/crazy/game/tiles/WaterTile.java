package dev.crazy.game.tiles;

import dev.crazy.game.gfx.Animation;
import dev.crazy.game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WaterTile extends Tile{

    public WaterTile(int id) {
        super(Assets.water_anim[0], id);
    }

    @Override
    public boolean isSolid(){
        return true;
    }

}
