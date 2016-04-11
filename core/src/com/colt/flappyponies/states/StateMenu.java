package com.colt.flappyponies.states;

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
        background = new Texture("graphics/background.png");
        playbutton = new Texture("graphics/playbutton.png");

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, Boot.WIDTH, Boot.HEIGHT); //Remember, BOTTOM LEFT!
        spriteBatch.draw(playbutton, (Boot.WIDTH / 2) - (playbutton.getWidth() / 2), (Boot.HEIGHT / 2) - (playbutton.getHeight() / 2));
        spriteBatch.end();
    }

}