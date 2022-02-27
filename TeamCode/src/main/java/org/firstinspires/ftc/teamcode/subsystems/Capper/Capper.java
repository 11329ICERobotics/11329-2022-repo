package org.firstinspires.ftc.teamcode.subsystems.Capper;

import com.qualcomm.robotcore.hardware.CRServo;
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

    @DiContainer.Inject()
    public Telemetry telemetry;

    double yawSpeed = 0;
    double pitchSpeed = 0;
    double distanceSpeed = 0;

    double yawPosition;
    public void setYawMovement(double yawSpeed){
        yawPosition = yawMotor.getPosition() + yawSpeed* RobotConfig.yawMotorSpeed;
    }
    public void setPitchMovement(double pitchSpeed){this.pitchSpeed = pitchSpeed;}
    public void setDistanceMovement(double distanceSpeed){this.distanceSpeed = distanceSpeed;}

    @Override
    public void Initialize() {
        yawPosition = yawMotor.getPosition();
    }
    @Override
    public void Tick(){

        yawMotor.setPosition(yawPosition);
        pitchMotor.setPower(pitchSpeed);
        distanceMotor.setPower(distanceSpeed);
    }

    @Override
    public void Dispose() {

        pitchMotor.setPower(0);
        distanceMotor.setPower(0);
    }
}
