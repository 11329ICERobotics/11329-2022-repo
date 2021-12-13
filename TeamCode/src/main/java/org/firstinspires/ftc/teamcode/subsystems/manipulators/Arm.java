package org.firstinspires.ftc.teamcode.subsystems.manipulators;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class Arm implements DiInterfaces.IInitializable, DiInterfaces.IDisposable {
    @DiContainer.Inject(id="armMotor")
    public DcMotor armMotor;

    @DiContainer.Inject(id="intakeMotor")
    public DcMotor intakeMotor;

    public void Run(double armSpeed, double intakeSpeed) {
        armMotor.setPower(armSpeed);
        intakeMotor.setPower(intakeSpeed);
    }

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
    public void Dispose() {
        armMotor.setPower(0);
    }
}