package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import org.firstinspires.ftc.teamcode.commands.autonav.Task;

public abstract class CustomTask extends Task {
    public CustomTask() {

    }

    public abstract void begin();
    public abstract boolean execute();
    public abstract void stop();

    @Override
    public void Begin() {
        begin();
    }

    @Override
    public boolean Execute() {
        return execute();
    }

    @Override
    public void Stop() {
        stop();
    }
}