package com.colt.flappyponies.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.colt.flappyponies.Boot;

/**
 * Created by colt on 4/11/16.
 */

public class StatePlay extends State {

    private Texture bird;

    //Constructor.
    public StatePlay(GameStateManager gameStateManager) {
        super(gameStateManager);
        bird = new Texture("graphics/bird.png");
        camera.setToOrtho(false, Boot.WIDTH / 2, Boot.HEIGHT / 2); //false - don't use 0, 0 in top left, but use it in bottom left.
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bird, 50, 50);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        bird.dispose();
    }

}