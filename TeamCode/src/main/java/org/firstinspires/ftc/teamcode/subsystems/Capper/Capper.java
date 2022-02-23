package org.firstinspires.ftc.teamcode.subsystems.Capper;

import com.qualcomm.robotcore.hardware.CRServo;
import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class Capper implements DiInterfaces.ITickable, DiInterfaces.IDisposable, DiInterfaces.IInitializable {
    @DiContainer.Inject(id="yawMotor")
    public CRServo yawMotor;

    @DiContainer.Inject(id="pitchMotor")
    public CRServo pitchMotor;

    @DiContainer.Inject(id="distanceMotor")
    public CRServo distanceMotor;

    double yawSpeed = 0;
    double pitchSpeed = 0;
    double distanceSpeed = 0;

    public void setYawMovement(double yawSpeed){this.yawSpeed = yawSpeed;}
    public void setPitchMovement(double pitchSpeed){this.pitchSpeed = pitchSpeed;}
    public void setDistanceMovement(double distanceSpeed){this.distanceSpeed = distanceSpeed;}

    @Override
    public void Initialize() {

    }
    @Override
    public void Tick(){
        yawMotor.setPower(yawSpeed);
        pitchMotor.setPower(pitchSpeed);
        distanceMotor.setPower(distanceSpeed);
    }

    @Override
    public void Dispose() {
        yawMotor.setPower(0);
        pitchMotor.setPower(0);
        distanceMotor.setPower(0);
    }
}
