package org.firstinspires.ftc.teamcode.subsystems.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class Drivetrain implements DiInterfaces.IInitializable, DiInterfaces.IDisposable {
    @DiContainer.Inject(id="frontLeftMotor")
    public DcMotorEx frontLeftMotor; // leftForwardEncoder

    @DiContainer.Inject(id="frontRightMotor")
    public DcMotorEx frontRightMotor; // rightForwardEncoder

    @DiContainer.Inject(id="backLeftMotor")
    public DcMotorEx backLeftMotor; // BackEncoder

    @DiContainer.Inject(id="backRightMotor")
    public DcMotorEx backRightMotor;

    @Override
    public void Initialize() {
        frontLeftMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        //frontLeftMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        frontRightMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        //frontRightMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        backLeftMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        //backLeftMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        backRightMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        //backRightMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void Dispose() {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    public void TankDrive(double leftPower, double rightPower) {
        frontRightMotor.setPower(-leftPower);
        backRightMotor.setPower(-leftPower);
        frontLeftMotor.setPower(rightPower);
        backLeftMotor.setPower(rightPower);
    }

    // rotational: + couter clockwise, - clockwise
    public void MecanumDrive(double vertical, double horizontal, double clockwise, double maxSpeed) {
        frontRightMotor.setPower((-clockwise + horizontal + vertical) * maxSpeed);
        backRightMotor.setPower((-clockwise - horizontal + vertical) * maxSpeed);
        frontLeftMotor.setPower(-(-clockwise + horizontal - vertical) * maxSpeed);
        backLeftMotor.setPower(-(-clockwise - horizontal - vertical) * maxSpeed);
    }

    public void Stop() {
        TankDrive(0, 0);
    }

    public double powerCurve(double input) {
        if (input < -1) return -1;
        if (input > 1) return 1;

        return Math.pow(input, 3);
    }
}
