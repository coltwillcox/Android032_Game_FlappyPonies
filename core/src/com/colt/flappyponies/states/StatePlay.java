package com.colt.flappyponies.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.colt.flappyponies.Boot;
import com.colt.flappyponies.sprites.Bird;
import com.colt.flappyponies.sprites.Tube;

/**
 * Created by colt on 4/11/16.
 */

public class StatePlay extends State {

    private static final int GROUND = -50;
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;
    private Texture background;
    private Texture ground;
    private Bird bird;
    private Array<Tube> tubes;
    private Vector2 groundPosition1;
    private Vector2 groundPosition2;

    //Constructor.
    public StatePlay(GameStateManager gameStateManager) {
        super(gameStateManager);
        camera.setToOrtho(false, Boot.WIDTH / 2, Boot.HEIGHT / 2);
        background = new Texture("graphics/background.png");
        ground = new Texture("graphics/ground.png");
        bird = new Bird(50, 300);
        tubes = new Array<Tube>();
        for (int i = 1; i <= TUBE_COUNT; i++)
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        groundPosition1 = new Vector2(camera.position.x - (camera.viewportWidth / 2), GROUND);
        groundPosition2 = new Vector2(groundPosition1.x + ground.getWidth(), GROUND);
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

        //Move tubes, make first last.
        for (Tube tube : tubes) {
            if (camera.position.x - (camera.viewportWidth / 2) > tube.getPositionTopTube().x + tube.getTextureTopTube().getWidth())
                tube.reposition(tube.getPositionTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            //Collide check. Compare every tube with the bird.
            if (tube.collides(bird.getBounds())) {
                gameStateManager.set(new StatePlay(gameStateManager));
                break;
            }
        }

        //Move ground, make first second.
        if (camera.position.x - (camera.viewportWidth / 2) > groundPosition1.x + ground.getWidth())
            groundPosition1.add(ground.getWidth() * 2, 0);
        if (camera.position.x - (camera.viewportWidth / 2) > groundPosition2.x + ground.getWidth())
            groundPosition2.add(ground.getWidth() * 2, 0);

        //Check bird collision with ground.
        if (bird.getPosition().y <= ground.getHeight() + GROUND)
            gameStateManager.set(new StatePlay(gameStateManager));
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
        spriteBatch.draw(ground, groundPosition1.x, groundPosition1.y);
        spriteBatch.draw(ground, groundPosition2.x, groundPosition2.y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        ground.dispose();
        bird.dispose();
        for (Tube tube : tubes)
            tube.dispose();
    }

}