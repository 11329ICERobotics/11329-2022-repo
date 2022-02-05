package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.commands.autonav.Task;
//import org.firstinspires.ftc.teamcode.subsystems..DistanceSensor;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;

public class toDistanceTask extends Task {


    private long distanceGoal;
    private double speed;

    public toDistanceTask (long distanceGoal, double speed){
        this.distanceGoal = distanceGoal;
        this.speed = speed;



    }
    @Override
    public void Begin() {

    }

    @Override
    public boolean Execute() {
        double currentPoint = autoNav.distanceSensor.getDistance(DistanceUnit.CM);
        autoNav.telemetry.addData("Distance:", currentPoint);
        if (Math.abs(currentPoint-distanceGoal)< 5) return true;

        else if (currentPoint-distanceGoal< 0){
            autoNav.drivetrain.TankDrive(-speed, speed);
        }
        else if (currentPoint-distanceGoal>0){
            autoNav.drivetrain.TankDrive(speed, -speed);
        }
        return false;
    }

    @Override
    public void Stop() {
        autoNav.drivetrain.TankDrive(0, 0);
    }

    @Override
    public ETA GetETA() {
        return new ETA();
    }
}
