package org.firstinspires.ftc.teamcode.subsystems.Capper;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class Capper implements DiInterfaces.ITickable, DiInterfaces.IDisposable, DiInterfaces.IInitializable {
    @DiContainer.Inject(id="yawMotor")
    public Servo yawMotor;

    @DiContainer.Inject(id="pitchMotor")
    public CRServo pitchMotor;

    @DiContainer.Inject(id="distanceMotor")
    public CRServo distanceMotor;

    @DiContainer.Inject(id="distanceEncoder")
    public DcMotorEx distanceEncoder;
    @DiContainer.Inject()
    public Telemetry telemetry;

    double yawSpeed = 0;
    double pitchSpeed = 0;
    double distanceSpeed = 0;

    double targetDistance;
    public double yawPosition;

    boolean zeroing = false;
    public void setYawPosition(double position){
        this.yawPosition = position;
    }
    public void setYawMovement(double yawSpeed){
        telemetry.addData("Yaw Movement", yawMotor.getPosition() );
        telemetry.addData("Capper Speed", capperCurve(distanceEncoder.getCurrentPosition()));
        yawPosition = yawMotor.getPosition() + capperCurve(distanceEncoder.getCurrentPosition()) *yawSpeed;
    }
    public void zeroCapper(){
        if(distanceEncoder.getCurrentPosition() >0){
            //this.distanceSpeed = RobotConfig.CapperZeroingSpeed;
            this.zeroing = true;
        }

    }
    public void setPitchMovement(double pitchSpeed){

        this.pitchSpeed = pitchSpeed;
    }
    public void setDistanceMovement(double distanceSpeed){this.distanceSpeed = distanceSpeed;}

    public double capperCurve(int distance){
        if(distance<15000){
            return 0.005;
        }
        else if(distance >40000){
            return 0.0005;
        }
        else{
            return 0.005-distance/1000*0.0001;
        }


    }
    @Override
    public void Initialize() {

        yawPosition = RobotConfig.capperYawZero;//yawMotor.getPosition();
        distanceEncoder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    @Override
    public void Tick(){
        if(this.zeroing != true){
            distanceMotor.setPower(distanceSpeed);
        }
        else{
            if(distanceEncoder.getCurrentPosition()<0){
                distanceMotor.setPower(-0.5);
            }
            else if(distanceEncoder.getCurrentPosition()>0){
                distanceMotor.setPower(0.5);
            }
        }
        telemetry.addData("Yaw Pos", yawPosition);
        telemetry.addData("Encoder Reading", distanceEncoder.getCurrentPosition());
        yawMotor.setPosition(yawPosition);
        pitchMotor.setPower(pitchSpeed);
    }

    @Override
    public void Dispose() {

        pitchMotor.setPower(0);
        distanceMotor.setPower(0);
    }
    public void Stop(){
        pitchMotor.setPower(0);
        distanceMotor.setPower(0);
        yawMotor.setPosition(yawMotor.getPosition());
    }
}
