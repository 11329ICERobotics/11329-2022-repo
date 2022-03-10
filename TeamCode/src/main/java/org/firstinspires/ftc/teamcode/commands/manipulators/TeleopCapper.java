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
    boolean pitchFast = false;
    boolean holdingPitchFast = true;


    @Override
    public void Tick() {
        if(gamepad2.y){
            if(holdingCapMode == false) {
                holdingCapMode = true;
                if(RobotConfig.capMode == false) {
                    RobotConfig.capMode = true;
                    telemetry.log().add("Set Controller 2 to Cap Mode");
                }
                else if(RobotConfig.capMode){
                    RobotConfig.capMode = false;

                    capper.setYawPosition(RobotConfig.capperYawZero);
                    telemetry.log().add("Set Controller 2 to Arm Mode");
                }
            }
        }
        else{
            holdingCapMode = false;
        }
        if(RobotConfig.capMode == true){
            if(gamepad2.left_trigger > 0) {
                if(holdingPitchFast == false) {
                    holdingPitchFast = true;
                    pitchFast = true;
                }
            }
            else if( gamepad2.left_trigger == 0){
                pitchFast = false;
                holdingPitchFast = false;
            }
            capper.setYawMovement(gamepad2.left_stick_x);
            if(pitchFast == true){
                capper.setPitchMovement(gamepad2.left_stick_y * RobotConfig.pitchMotorSpeedFast);
            }
            else{
                capper.setPitchMovement(gamepad2.left_stick_y * RobotConfig.pitchMotorSpeedSlow);
            }

            if(gamepad2.left_bumper){
                capper.setDistanceMovement(RobotConfig.distanceMotorSpeed);
            }
            else if(gamepad2.right_bumper){
                capper.setDistanceMovement(-RobotConfig.distanceMotorSpeed);
            }
            else if(gamepad2.b){
                capper.zeroCapper();
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
