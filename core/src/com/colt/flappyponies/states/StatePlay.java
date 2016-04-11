package com.colt.flappyponies.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.colt.flappyponies.Boot;
import com.colt.flappyponies.sprites.Bird;

/**
 * Created by colt on 4/11/16.
 */

public class StatePlay extends State {

    private Bird bird;

    //Constructor.
    public StatePlay(GameStateManager gameStateManager) {
        super(gameStateManager);
        bird = new Bird(50, 300);
        camera.setToOrtho(false, Boot.WIDTH / 2, Boot.HEIGHT / 2); //false - don't use 0, 0 in top left, but use it in bottom left.
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        bird.update(deltaTime);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }

}