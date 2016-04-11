package com.colt.flappyponies.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by colt on 4/11/16.
 */

public class Bird {

    private static final int GRAVITY = -15;
    private Vector2 position;
    private Vector2 velocity;
    private Texture bird;

    //Constructor.
    public Bird(int x, int y) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        bird = new Texture("graphics/bird.png");
    }

    public void update(float deltaTime) {
        velocity.add(0, GRAVITY);
        velocity.scl(deltaTime); //Scale will multiply everything by deltaTime.
        position.add(0, velocity.y);
        velocity.scl(1 / deltaTime); //Reverses waht is scaled previously.
    }

    //Getters.
    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }

}