package com.colt.flappyponies;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.colt.flappyponies.states.GameStateManager;
import com.colt.flappyponies.states.StateMenu;

public class Boot extends ApplicationAdapter {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 854;
    public static final String TITLE = "FlappyPonies";
    private GameStateManager gameStateManager;
    private SpriteBatch batch; //Only one is needed per game.
    private Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
        gameStateManager = new GameStateManager();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gameStateManager.push(new StateMenu(gameStateManager));
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
        music.setLooping(true);
        music.setVolume(0.2f);
        music.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameStateManager.update(Gdx.graphics.getDeltaTime());
        gameStateManager.render(batch);
	}

    @Override
    public void dispose() {
        super.dispose();
        music.dispose();
    }

}