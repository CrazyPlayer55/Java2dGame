package dev.crazy.game.entities.statics;

import dev.crazy.game.Handler;
import dev.crazy.game.gfx.Assets;
import dev.crazy.game.items.Item;
import dev.crazy.game.tiles.Tile;

import java.awt.*;

public class PalmTree extends StaticEntity{

    public PalmTree(Handler handler, float x, float y){
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);
        bounds = new Rectangle(22, 70, 3, 1);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.palmTree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    public void Die(){
        handler.getWorld().getItemManager().addItem(Item.coconutItem.createNew((int) x + 15, (int) y + 25));
        handler.getWorld().getItemManager().addItem(Item.coconutItem.createNew((int) x + 5, (int) y + 50));
        handler.getWorld().getItemManager().addItem(Item.coconutItem.createNew((int) x + 25, (int) y + 43));
    }
}
