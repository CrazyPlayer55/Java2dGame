package dev.crazy.game.states;

import dev.crazy.game.Game;
import dev.crazy.game.Handler;
import dev.crazy.game.gfx.Assets;
import dev.crazy.game.ui.ClickListener;
import dev.crazy.game.ui.UIImageButton;
import dev.crazy.game.ui.UIManager;

import java.awt.*;

public class MenuState extends State{

    private UIManager uiManager;
    private Handler handler;

    public MenuState(Handler handler){
        super(handler);
        this.handler = handler;
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(250, 200, 80, 80, Assets.water_anim, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
