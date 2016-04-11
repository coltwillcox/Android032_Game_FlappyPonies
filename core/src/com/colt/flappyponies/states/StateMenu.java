package com.colt.flappyponies.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.colt.flappyponies.Boot;

/**
 * Created by colt on 4/11/16.
 */

public class StateMenu extends State {

    private Texture background;
    private Texture playbutton;

    public StateMenu(GameStateManager gameStateManager) {
        super(gameStateManager);
        camera.setToOrtho(false, Boot.WIDTH / 2, Boot.HEIGHT / 2); //false - don't use 0, 0 in top left, but use it in bottom left.
        background = new Texture("graphics/background.png");
        playbutton = new Texture("graphics/playbutton.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gameStateManager.set(new StatePlay(gameStateManager));
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0); //Remember, BOTTOM LEFT!
        spriteBatch.draw(playbutton, camera.position.x - (playbutton.getWidth() / 2), camera.position.y - (playbutton.getHeight() / 2));
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playbutton.dispose();
    }

}