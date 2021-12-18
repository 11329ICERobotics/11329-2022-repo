package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import org.firstinspires.ftc.teamcode.commands.autonav.Task;

public class WaitTask extends Task {
    long millis;

    long endTime;

    public WaitTask(long millis) {
        this.millis = millis;
    }

    @Override
    public void Begin() {
        endTime = java.lang.System.currentTimeMillis() + millis;
    }

    @Override
    public boolean Execute() {
        return (endTime < System.currentTimeMillis());
    }

    @Override
    public void Stop() { }
}
