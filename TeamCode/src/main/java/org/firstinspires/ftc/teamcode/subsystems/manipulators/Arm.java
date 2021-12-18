package org.firstinspires.ftc.teamcode.subsystems.manipulators;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class Arm implements DiInterfaces.IInitializable, DiInterfaces.ITickable, DiInterfaces.IDisposable {
    @DiContainer.Inject(id="armMotor")
    public DcMotor armMotor;

    @DiContainer.Inject(id="intakeMotor")
    public DcMotor intakeMotor;

    @Override
    public void Initialize() {
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void Tick() {

    }

    @Override
    public void Dispose() {
        armMotor.setPower(0);
    }

    public void Run(double armPosition, double intakeSpeed) {
        RunArm(armPosition);
        RunIntake(intakeSpeed);
    }

    public void RunArm(double armPosition) {
        //write positioning code

    }

    // REMOVE THIS AND FIX IT YOU DUMMY
    public void RunArmPower(double power) {
        armMotor.setPower(power);
    }

    public boolean IsArmDoneMoving() {
        return true;
    }

    public void RunIntake(double intakeSpeed) {
        intakeMotor.setPower(intakeSpeed);
    }

    public void Stop() {
        Run(0, 0);
    }

    public double GetRealAngle() {
        return armMotor.getCurrentPosition();
    }
}