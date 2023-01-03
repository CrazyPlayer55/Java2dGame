package dev.crazy.game;

import dev.crazy.game.display.Display;

public class launcher {

    public static void main(String[] args){
        Game game = new Game("Crazy's Sandbox Game", 1024, 768);
        game.start();
    }

}
