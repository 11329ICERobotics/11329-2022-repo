package org.firstinspires.ftc.teamcode.commands.manipulators;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.subsystems.Capper.Capper;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class TeleopCapper implements DiInterfaces.ITickable, DiInterfaces.IDisposable {
    @DiContainer.Inject()
    public Capper capper;

    @DiContainer.Inject()
    public Telemetry telemetry;

    @DiContainer.Inject(id="gamepad2")
    public Gamepad gamepad2;

    boolean holdingCapMode = false;

    @Override
    public void Tick() {
        if(gamepad2.x){
            if(holdingCapMode == false) {
                holdingCapMode = true;
                if(RobotConfig.capMode == false) {
                    RobotConfig.capMode = true;
                    telemetry.log().add("Set Controller 2 to Cap Mode");
                }
                else if(RobotConfig.capMode){
                    RobotConfig.capMode = false;
                    telemetry.log().add("Set Controller 2 to Arm Mode");
                }
            }
        }
        else{
            holdingCapMode = false;
        }
        if(RobotConfig.capMode == true){
            capper.setYawMovement(gamepad2.left_stick_x);
            capper.setPitchMovement(gamepad2.left_stick_y * RobotConfig.pitchMotorSpeed);
            if(gamepad2.left_bumper){
                capper.setDistanceMovement(RobotConfig.distanceMotorSpeed);
            }
            else if(gamepad2.right_bumper){
                capper.setDistanceMovement(-RobotConfig.distanceMotorSpeed);
            }
            else{
                capper.setDistanceMovement(0.0);
            }
        }
    }
    @Override
    public void Dispose(){
        RobotConfig.capMode = false;
    }

}
