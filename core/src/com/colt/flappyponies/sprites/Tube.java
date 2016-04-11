package com.colt.flappyponies.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

/**
 * Created by colt on 4/11/16.
 */

public class Tube {

    public static final int TUBE_WIDTH = 52; //Width of tube image.
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;
    private Random random;
    private Vector2 positionTopTube;
    private Vector2 positionBottomTube;
    private Texture topTube;
    private Texture bottomTube;

    //Constructor.
    public Tube(float x) {
        random = new Random();
        topTube = new Texture("graphics/toptube.png");
        bottomTube = new Texture("graphics/bottomtube.png");
        positionTopTube = new Vector2(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        positionBottomTube = new Vector2(x, positionTopTube.y - TUBE_GAP - bottomTube.getHeight()); //From bottom left, remember? :)
    }

    //Getters.
    public Texture getTextureTopTube() {
        return topTube;
    }

    public Texture getTextureBottomTube() {
        return bottomTube;
    }

    public Vector2 getPositionTopTube() {
        return positionTopTube;
    }

    public Vector2 getPositionBottomTube() {
        return positionBottomTube;
    }

    public void reposition(float x) {
        positionTopTube.set(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        positionBottomTube.set(x, positionTopTube.y - TUBE_GAP - bottomTube.getHeight());
    }

}