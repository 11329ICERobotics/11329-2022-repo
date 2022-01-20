package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import org.firstinspires.ftc.teamcode.commands.autonav.Task;
import org.firstinspires.ftc.teamcode.subsystems.manipulators.DuckSpinner;

public class DuckSpinTask extends Task {
    long millis;
    boolean keepMode = false;
    boolean keepState = false;

    long endTime;

    public DuckSpinTask(long millis) {
        this.millis = millis;
    }
    public DuckSpinTask(boolean keepState) {
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
            autoNav.duckSpinner.Spin(keepState);
            return true;
        }

        autoNav.duckSpinner.Spin(true);

        return (endTime < System.currentTimeMillis());
    }

    @Override
    public void Stop() {
        if (keepMode) {
            autoNav.duckSpinner.Spin(keepState);
            return;
        }

        autoNav.duckSpinner.Spin(false);
    }

    @Override
    public ETA GetETA() {
        return new ETA(endTime - millis, System.currentTimeMillis(), endTime);
    }
}