package dev.crazy.game.entities.statics;

import dev.crazy.game.Handler;
import dev.crazy.game.entities.Entity;

public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }

}