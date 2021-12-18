package org.firstinspires.ftc.teamcode.commands.autonav;

public abstract class Task {
    public abstract void Begin();
    public abstract boolean Execute();
    public abstract void Stop();
    public AutoNav autoNav;
}
