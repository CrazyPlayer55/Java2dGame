package dev.crazy.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 20, height = 20;
    public static BufferedImage sand, palmTree, coconut;
    public static BufferedImage[] player_down, player_up, player_right, player_left, water_anim, attack_left, attack_right;

    public static void init(){
        SpriteSheet beachSheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/areas/beach.png"));
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/entities/player.png"));
        SpriteSheet effectSheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheets/entities/effects.png"));

        player_down = new BufferedImage[4];
        player_up = new BufferedImage[4];
        player_right = new BufferedImage[4];
        player_left = new BufferedImage[4];
        water_anim = new BufferedImage[2];
        attack_left = new BufferedImage[4];
        attack_right = new BufferedImage[4];

        player_down[0] = playerSheet.crop(0, 0, width, height);
        player_down[1] = playerSheet.crop(0, height, width, height);
        player_down[2] = playerSheet.crop(0, height * 2, width, height);
        player_down[3] = playerSheet.crop(0, height * 3, width, height);

        player_up[0] = playerSheet.crop(width, 0, width, height);
        player_up[1] = playerSheet.crop(width, height, width, height);
        player_up[2] = playerSheet.crop(width, height * 2, width, height);
        player_up[3] = playerSheet.crop(width, height * 3, width, height);


        player_right[0] = playerSheet.crop(width * 2, 0, width, height);

        player_left[0] = playerSheet.crop(width * 3, 0, width, height);

        water_anim[0] = beachSheet.crop(width, 0, width, height);
        water_anim[1] = beachSheet.crop(width * 2, 0, width, height);

        attack_left[0] = effectSheet.crop(0, 0, width, height);
        attack_left[1] = effectSheet.crop(0, height, width, height);
        attack_left[2] = effectSheet.crop(0, height * 2, width, height);
        attack_left[3] = effectSheet.crop(0, height * 3, width, height);

        attack_right[0] = effectSheet.crop(width, 0, width, height);
        attack_right[1] = effectSheet.crop(width, height, width, height);
        attack_right[2] = effectSheet.crop(width, height * 2, width, height);
        attack_right[3] = effectSheet.crop(width, height * 3, width, height);

        sand = beachSheet.crop(0, 0, width, height);
        palmTree = beachSheet.crop(width * 3, 0, width, height);
        coconut = beachSheet.crop(width * 3, height, width, height);
    }

}
