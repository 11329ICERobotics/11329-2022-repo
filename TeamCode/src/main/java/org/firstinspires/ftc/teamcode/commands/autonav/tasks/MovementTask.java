package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import org.firstinspires.ftc.teamcode.commands.autonav.Task;

public class MovementTask extends Task {
    long millis;
    float forwards;
    float left;
    float clockwise;
    float speed;

    long now;
    long startTime;
    long stopTime;
    long rampDuration;
    long rampUpTime;
    long rampDownTime;

    public MovementTask(long millis, float clockwiseMovementDegrees, float clockwiseRotationPower, float speed) {
        this.millis = millis;
        this.forwards = (float) Math.cos(Math.toRadians(clockwiseMovementDegrees));
        this.left = (float) -Math.sin(Math.toRadians(clockwiseMovementDegrees));
        this.clockwise = clockwiseRotationPower;
        this.speed = Math.max(-1.0f, Math.min(1.0f, speed));
    }

    public MovementTask(long millis, float clockwiseRotationPower, float speed) {
        this.millis = millis;
        this.forwards = 0;
        this.left = 0;
        this.clockwise = clockwiseRotationPower;
        this.speed = Math.max(-1.0f, Math.min(1.0f, speed));
    }

    @Override
    public void Begin() {
        now = System.currentTimeMillis();

        startTime = now;
        stopTime = startTime + millis;

        rampDuration = (long) (0.4 * millis);
        rampUpTime = startTime + rampDuration;
        rampDownTime = stopTime - rampDuration;
    }

    @Override
    public boolean Execute() {
        now = System.currentTimeMillis();

        if (now >= stopTime) return true;

        if (now < rampUpTime){
            autoNav.drivetrain.MecanumDrive(forwards, left, clockwise, (speed * Math.min(((float)(now-startTime)/(float)(rampUpTime-startTime)), 1)));
        } else if (now > rampDownTime) {
            autoNav.drivetrain.MecanumDrive(forwards, left, clockwise, (speed * (1 - ((float)(now - rampDownTime)/(float)(stopTime - rampDownTime)))));
        } else {
            autoNav.drivetrain.MecanumDrive(forwards, left, clockwise, speed);
        }

        return false;
    }

    @Override
    public void Stop() {
        autoNav.drivetrain.TankDrive(0, 0);
    }

    @Override
    public ETA GetETA() {
        return new ETA(startTime, now, stopTime);
    }
}
