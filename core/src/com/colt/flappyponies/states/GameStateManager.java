package com.colt.flappyponies.states;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by colt on 4/11/16.
 */

public class GameStateManager {

    private Stack<State> states;

    //Constructor.
    public GameStateManager() {
        states = new Stack<State>();
    }

    public void push(State state) {
        states.push(state);
    }

    public void pop() {
        states.pop().dispose(); //Return, remove. Dispose.
    }

    public void set(State state) {
        states.pop().dispose();
        states.push(state);
    }

    public void update(float deltaTime) {
        states.peek().update(deltaTime);
    }

    public void render(SpriteBatch spriteBatch) {
        states.peek().render(spriteBatch);
    }

}