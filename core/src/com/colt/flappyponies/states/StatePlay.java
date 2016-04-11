package com.colt.flappyponies.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.colt.flappyponies.Boot;
import com.colt.flappyponies.sprites.Bird;
import com.colt.flappyponies.sprites.Tube;

/**
 * Created by colt on 4/11/16.
 */

public class StatePlay extends State {

    private Texture background;
    private Bird bird;
    private Tube tube;

    //Constructor.
    public StatePlay(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("graphics/background.png");
        bird = new Bird(50, 300);
        tube = new Tube(100);
        camera.setToOrtho(false, Boot.WIDTH / 2, Boot.HEIGHT / 2); //false - don't use 0, 0 in top left, but use it in bottom left.
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched())
            bird.jump();
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
        spriteBatch.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        spriteBatch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        spriteBatch.draw(tube.getTextureTopTube(), tube.getPositionTopTube().x, tube.getPositionTopTube().y);
        spriteBatch.draw(tube.getTextureBottomTube(), tube.getPositionBottomTube().x, tube.getPositionBottomTube().y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }

}