package org.firstinspires.ftc.teamcode.commands.drivetrain;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.drivetrain.Drivetrain;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;

public class AutoDrive {
    @DiContainer.Inject()
    public Drivetrain drivetrain;

    @DiContainer.Inject()
    public Telemetry telemetry;

    // REWRITE THIS BUT WITH THE PROPER DI INTERFACE COMPATIBILITY SO THAT WAY WE DONT NEED A HACKY DUMB CALLABLE PLS THX
    /*public void goForTime(long millis, float forwards, float left, float clockwise, float speed) {
        try {
            speed = Math.max(-1.0f, Math.min(1.0f, speed));

            telemetry.log().add("Driving for " + millis + " milliseconds at " + speed + " power.");

            long now = java.lang.System.currentTimeMillis();

            long startTime = now;
            long stopTime = startTime + millis;

            long rampDuration = (long) (0.4 * millis);
            long rampUpTime = startTime + rampDuration;
            long rampDownTime = stopTime - rampDuration;

            telemetry.log().add("Starting at " + startTime);

            drivetrain.TankDrive(0, 0);

            do {
                now = java.lang.System.currentTimeMillis();
                drivetrain.MecanumDrive(forwards, left, clockwise, (float) (speed * Math.min(((float)(now-startTime)/(float)(rampUpTime-startTime)), 1)));
            } while(now < rampUpTime && opModeIsActive.call());

            drivetrain.MecanumDrive(forwards, left, clockwise, speed);

            do {
                now = java.lang.System.currentTimeMillis();
                // motor power is constant here
            } while(now < rampDownTime && opModeIsActive.call());

            do {
                now = java.lang.System.currentTimeMillis();
                drivetrain.MecanumDrive(forwards, left, clockwise, (float) (speed * (1 - ((float)(now - rampDownTime)/(float)(stopTime - rampDownTime)))));
            } while(now < stopTime && opModeIsActive.call());

            drivetrain.MecanumDrive(forwards, left, clockwise, 0f);
        } catch (Exception e) {
            drivetrain.TankDrive(0, 0);

            telemetry.log().add("ERROR!!!!!!!!!!!!!!!!!!!!!");
        }
    }*/
}
