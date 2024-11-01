package com.yellowbrossproductions.illageandspillage.client.tool;

public class ControlledAnimation {
    private int timer = 0;
    private int prevtimer = 0;
    private int duration;
    private int timerChange;

    public ControlledAnimation(int d) {
        this.duration = d;
    }

    public void setDuration(int d) {
        this.timer = 0;
        this.prevtimer = 0;
        this.duration = d;
    }

    public int getTimer() {
        return this.timer;
    }

    public int getPrevTimer() {
        return this.prevtimer;
    }

    public void setTimer(int time) {
        this.timer = time;
        this.prevtimer = time;
        if (this.timer > this.duration) {
            this.timer = this.duration;
        } else if (this.timer < 0) {
            this.timer = 0;
        }

    }

    public void resetTimer() {
        this.timer = 0;
        this.prevtimer = 0;
    }

    public void increaseTimer() {
        if (this.timer < this.duration) {
            ++this.timer;
            this.timerChange = 1;
        }

    }

    public boolean canIncreaseTimer() {
        return this.timer < this.duration;
    }

    public void increaseTimer(int time) {
        int newTime = this.timer + time;
        if (newTime <= this.duration && newTime >= 0) {
            this.timer = newTime;
        } else {
            this.timer = newTime < 0 ? 0 : this.duration;
        }

    }

    public void decreaseTimer() {
        if ((double) this.timer > 0.0) {
            --this.timer;
            this.timerChange = -1;
        }

    }

    public boolean canDecreaseTimer() {
        return (double) this.timer > 0.0;
    }

    public void decreaseTimer(int time) {
        if ((double) (this.timer - time) > 0.0) {
            this.timer -= time;
        } else {
            this.timer = 0;
        }

    }

    public float getAnimationFraction() {
        return (float) this.timer / (float) this.duration;
    }
}
