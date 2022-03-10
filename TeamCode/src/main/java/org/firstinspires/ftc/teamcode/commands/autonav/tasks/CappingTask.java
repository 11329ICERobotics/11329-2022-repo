package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import org.firstinspires.ftc.teamcode.commands.autonav.AutoNav;
import org.firstinspires.ftc.teamcode.commands.autonav.Task;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;

public class CappingTask extends Task {
   double yawAngle;
   double distanceGoal;
   double pitchPower;
   double pitchTime;

   double startTime;
   double now;

   boolean distanceMet = false;
    public CappingTask(double yawAngle, double distanceGoal, double pitchPower, double pitchTime){
        this.yawAngle = yawAngle;
        this.distanceGoal = distanceGoal;
        this.pitchPower = pitchPower;
        this.pitchTime = pitchTime;
    }

    @Override
    public void Begin() {
        startTime = System.currentTimeMillis();
        autoNav.capper.yawPosition =yawAngle;

    }

    @Override
    public boolean Execute() {
        now = System.currentTimeMillis();
        if(!distanceMet){
            if(autoNav.capper.distanceEncoder.getCurrentPosition() > distanceGoal) {
                autoNav.capper.setDistanceMovement(1);
            }
            else if (autoNav.capper.distanceEncoder.getCurrentPosition() < distanceGoal){
                autoNav.capper.setDistanceMovement(-1);
            }
            if(Math.abs(autoNav.capper.distanceEncoder.getCurrentPosition()-distanceGoal) < 150){
                distanceMet = true;
            }
        }

        if(now >= startTime + pitchTime && distanceMet){
            return true;
        }
        else{
            autoNav.capper.setPitchMovement(pitchPower);
        }

        return false;
    }

    @Override
    public void Stop() {

    }

    @Override
    public ETA GetETA() {
        return null;
    }
}
