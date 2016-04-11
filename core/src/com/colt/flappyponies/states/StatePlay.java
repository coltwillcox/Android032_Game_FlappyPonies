package com.colt.flappyponies.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.colt.flappyponies.Boot;
import com.colt.flappyponies.sprites.Bird;
import com.colt.flappyponies.sprites.Tube;

/**
 * Created by colt on 4/11/16.
 */

public class StatePlay extends State {

    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;
    private Texture background;
    private Bird bird;
    private Array<Tube> tubes;

    //Constructor.
    public StatePlay(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("graphics/background.png");
        bird = new Bird(50, 300);
        tubes = new Array<Tube>();
        for (int i = 1; i <= TUBE_COUNT; i++)
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
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
        camera.position.x = bird.getPosition().x + 80;
        for (Tube tube : tubes)
            if (camera.position.x - (camera.viewportWidth / 2) > tube.getPositionTopTube().x + tube.getTextureTopTube().getWidth())
                tube.reposition(tube.getPositionTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
        camera.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        spriteBatch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        for (Tube tube : tubes) {
            spriteBatch.draw(tube.getTextureTopTube(), tube.getPositionTopTube().x, tube.getPositionTopTube().y);
            spriteBatch.draw(tube.getTextureBottomTube(), tube.getPositionBottomTube().x, tube.getPositionBottomTube().y);
        }
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }

}