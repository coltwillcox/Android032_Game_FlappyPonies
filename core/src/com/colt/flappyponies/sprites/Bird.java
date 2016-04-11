package com.colt.flappyponies.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by colt on 4/11/16.
 */

public class Bird {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private Vector2 position;
    private Vector2 velocity;
    private Texture texture;
    private Rectangle boundsBird;
    private Animation birdAnimation;
    private Sound flap;

    //Constructor.
    public Bird(int x, int y) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);

        texture = new Texture("graphics/birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);
        boundsBird = new Rectangle(position.x, position.y, texture.getWidth() / 3, texture.getHeight()); //Could also use x, y for first paramaters, but naah.

        flap = Gdx.audio.newSound(Gdx.files.internal("sounds/flap.ogg"));
    }

    public void update(float deltaTime) {
        if (position.y > 0)
            velocity.add(0, GRAVITY);
        velocity.scl(deltaTime); //Scale will multiply everything by deltaTime.
        position.add(MOVEMENT * deltaTime, velocity.y);
        if (position.y < 0)
            position.y = 0;
        velocity.scl(1 / deltaTime); //Reverses what is scaled previously.
        birdAnimation.update(deltaTime);
        boundsBird.setPosition(position.x, position.y);
    }

    public void jump() {
        velocity.y = 250;
        flap.play(0.5f);
    }

    public void dispose() {
        texture.dispose();
        flap.dispose();
    }

    //Getters.
    public Vector2 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }

    public Rectangle getBounds() {
        return boundsBird;
    }

}