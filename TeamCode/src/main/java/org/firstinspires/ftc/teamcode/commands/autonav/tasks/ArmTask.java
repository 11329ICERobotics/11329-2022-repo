package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import org.firstinspires.ftc.teamcode.commands.autonav.Task;

public class ArmTask extends Task {
    int positionDegrees = 0;
    boolean position = false;

    double intakeSpeed = 0;
    boolean intake = false;

    public ArmTask(Integer positionDegrees, Double intakeSpeed) {
        if (positionDegrees != null) {
            this.positionDegrees = positionDegrees;
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
            autoNav.arm.RunArm(positionDegrees);

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

