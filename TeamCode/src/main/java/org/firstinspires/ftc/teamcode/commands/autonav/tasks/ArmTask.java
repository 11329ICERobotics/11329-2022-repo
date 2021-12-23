package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import org.firstinspires.ftc.teamcode.commands.autonav.Task;

public class ArmTask extends Task {
    int positionTicks = 0;
    boolean position = false;

    double intakeSpeed = 0;
    boolean intake = false;

    public ArmTask(Integer positionTicks, Double intakeSpeed) {
        if (positionTicks != null) {
            this.positionTicks = positionTicks;
            position = true;
        }

        if (intakeSpeed != null) {
            this.intakeSpeed = intakeSpeed;
            intake = true;
        }
    }

    @Override
    public void Begin() { }

    @Override
    public boolean Execute() {
        if (intake) {
            autoNav.arm.RunIntake(intakeSpeed);
        }

        if (position) {
            autoNav.arm.RunArm(positionTicks);

            return autoNav.arm.IsArmDoneMoving();
        }

        return true;
    }

    @Override
    public void Stop() { }

    @Override
    public ETA GetETA() {
        return new ETA();
    }
}

