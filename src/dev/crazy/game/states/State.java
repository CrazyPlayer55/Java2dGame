package dev.crazy.game.states;

import dev.crazy.game.Handler;

import java.awt.*;

public abstract class State {

    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getCurrentState(){
        return currentState;
    }

    //Class

    protected Handler handler;

    public State(Handler handler){
        this.handler = this.handler;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

}
