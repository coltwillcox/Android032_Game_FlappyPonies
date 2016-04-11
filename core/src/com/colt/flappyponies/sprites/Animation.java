package com.colt.flappyponies.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by colt on 4/11/16.
 */

public class Animation {

    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount; //Number of frames in animation.
    private int frame; //Current frame index.

    //Constructor.
    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        this.frameCount = frameCount;
        frames = new Array<TextureRegion>();
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
        int frameWidth = region.getRegionWidth() / frameCount;
        for (int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
    }

    public void update(float deltaTime) {
        currentFrameTime += deltaTime;
        if (currentFrameTime >= maxFrameTime) {
            frame++;
            currentFrameTime = 0;
        }
        if (frame >= frameCount)
            frame = 0;
    }

    public TextureRegion getFrame() {
        return frames.get(frame);
    }

}