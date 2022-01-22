package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import org.firstinspires.ftc.teamcode.commands.autonav.Task;

public class ReleaseIntakeTask extends Task {
    long millis;
    boolean keepMode = false;
    boolean keepState = false;

    long endTime;

    public ReleaseIntakeTask(long millis) {
        this.millis = millis;
    }
    public ReleaseIntakeTask(boolean keepState) {
        this.millis = 0;

        keepMode = true;
        this.keepState = keepState;
    }

    @Override
    public void Begin() {
        endTime = System.currentTimeMillis() + millis;
    }

    @Override
    public boolean Execute() {
        if (keepMode) {
            autoNav.duckSpinner.Release(keepState);
            return true;
        }

        autoNav.duckSpinner.Release(true);

        return (endTime < System.currentTimeMillis());
    }

    @Override
    public void Stop() {
        if (keepMode) {
            autoNav.duckSpinner.Release(keepState);
            return;
        }

        autoNav.duckSpinner.Release(false);
    }

    @Override
    public ETA GetETA() {
        return new ETA(endTime - millis, System.currentTimeMillis(), endTime);
    }
}