package dev.crazy.game.states;

import dev.crazy.game.Game;
import dev.crazy.game.Handler;
import dev.crazy.game.entities.creatures.Player;
import dev.crazy.game.entities.statics.PalmTree;
import dev.crazy.game.gfx.Assets;
import dev.crazy.game.tiles.Tile;
import dev.crazy.game.tiles.WaterTile;
import dev.crazy.game.worlds.World;

import java.awt.*;

public class GameState extends State{

    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "game/worlds/world.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
}
