package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import org.firstinspires.ftc.teamcode.commands.autonav.Task;
import org.firstinspires.ftc.teamcode.subsystems.manipulators.DuckSpinner;

public class DuckSpinTask extends Task {
    long millis;

    long endTime;

    public DuckSpinTask(long millis) {
        this.millis = millis;
    }

    @Override
    public void Begin() {
        endTime = java.lang.System.currentTimeMillis() + millis;
    }

    @Override
    public boolean Execute() {
        autoNav.duckSpinner.Spin(true);

        return (endTime < System.currentTimeMillis());
    }

    @Override
    public void Stop() {
        autoNav.duckSpinner.Spin(false);
    }
}