package dev.crazy.game.entities.creatures;

import dev.crazy.game.Handler;
import dev.crazy.game.entities.Entity;
import dev.crazy.game.gfx.Animation;
import dev.crazy.game.gfx.Assets;
import dev.crazy.game.inventory.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    //Animations
    private Animation animDown, animUp, animLeft, animRight;
    public int facing;//1=down, 2=up, 3=left, 4=right
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    //Inventory
    private Inventory inventory;

    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isSolid();
    }

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 8;
        bounds.y = 20;
        bounds.width = 20;
        bounds.height = 20;

        //Animations
        animDown = new Animation(150, Assets.player_down);
        animUp = new Animation(150, Assets.player_up);
        animLeft = new Animation(150, Assets.player_left);
        animRight = new Animation(150, Assets.player_right);

        inventory = new Inventory(handler);
    }

    @Override
    public void tick() {
        //Animations
        if(facing == 1)
            animDown.tick();
        if(facing == 2)
            animUp.tick();

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //inventory
        inventory.tick();
    }

    private void checkAttacks(){
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;

        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 40;
        ar.width = arSize;
        ar.height = arSize;

        if(facing == 2) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        }else if(facing == 1) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        }else if(facing == 3) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else if(facing == 4) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else{
            return;
        }

        attackTimer = 0;

        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0, 0).intersects(ar)) {
                e.hurt(1);
            }
            return;
        }
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;
        speed = Creature.DEFAULT_SPEED;

        if(handler.getKeyManager().up) {
            yMove = -speed;
            facing = 2;
        }
        if(handler.getKeyManager().down){
            yMove = speed;
            facing = 1;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
            facing = 3;
        }
        if(handler.getKeyManager().right){
            xMove = speed;
            facing = 4;
        }
        if(handler.getKeyManager().E)
            handler.getWorld().spawnPalmTree(getX(), getY() + 15);
        if(handler.getKeyManager().F)
            checkAttacks();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(
                getCurrentAnimationFrame(),
                (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()),
                width,
                height,
                null
        );
        inventory.render(g);
    }

    public void Die(){
        System.out.println("You Lose");
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            return animUp.getCurrentFrame();
        }else if(yMove > 0){
            return animDown.getCurrentFrame();
        }else{
            if(facing == 1){
                return Assets.player_down[0];
            }else if(facing == 2){
                return Assets.player_up[0];
            }else if(facing == 3){
                return Assets.player_left[0];
            }else if(facing == 4){
                return Assets.player_right[0];
            }else{
                return Assets.player_down[0];
            }
        }
    }

    //Getters and Setters
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
