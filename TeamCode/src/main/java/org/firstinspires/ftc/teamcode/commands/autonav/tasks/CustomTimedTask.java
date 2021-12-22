package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import org.firstinspires.ftc.teamcode.commands.autonav.Task;

public abstract class CustomTimedTask extends Task {
    float millis;

    float endTime;

    public CustomTimedTask(float millis) {
        this.millis = millis;
    }

    public abstract void begin();
    public abstract void execute();
    public abstract void stop();

    @Override
    public void Begin() {
        begin();

        endTime = System.currentTimeMillis() + millis;
    }

    @Override
    public boolean Execute() {
        execute();

        return (endTime < System.currentTimeMillis());
    }

    @Override
    public void Stop() {
        stop();
    }

    @Override
    public ETA GetETA() {
        return new ETA(endTime - millis, System.currentTimeMillis(), endTime);
    }
}