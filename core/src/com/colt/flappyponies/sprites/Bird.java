package com.colt.flappyponies.sprites;

import com.badlogic.gdx.graphics.Texture;
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
    private Texture bird;
    private Rectangle boundsBird;

    //Constructor.
    public Bird(int x, int y) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        bird = new Texture("graphics/bird.png");
        boundsBird = new Rectangle(position.x, position.y, bird.getWidth(), bird.getHeight()); //Could also use x, y for first paramaters, but naah.
    }

    public void update(float deltaTime) {
        if (position.y > 0)
            velocity.add(0, GRAVITY);
        velocity.scl(deltaTime); //Scale will multiply everything by deltaTime.
        position.add(MOVEMENT * deltaTime, velocity.y);
        if (position.y < 0)
            position.y = 0;
        velocity.scl(1 / deltaTime); //Reverses what is scaled previously.
        boundsBird.setPosition(position.x, position.y);
    }

    public void jump() {
        velocity.y = 250;
    }

    public void dispose() {
        bird.dispose();
    }

    //Getters.
    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }

    public Rectangle getBounds() {
        return boundsBird;
    }

}