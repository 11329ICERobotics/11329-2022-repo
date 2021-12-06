package org.firstinspires.ftc.teamcode.utilities.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class Drivetrain implements DiInterfaces.IInitializable, DiInterfaces.ITickable, DiInterfaces.IDisposable {
    @DiContainer.Inject(id="frontLeftMotor")
    public DcMotor frontLeftMotor; // leftForwardEncoder

    @DiContainer.Inject(id="frontRightMotor")
    public DcMotor frontRightMotor; // rightForwardEncoder

    @DiContainer.Inject(id="backLeftMotor")
    public DcMotor backLeftMotor; // BackEncoder

    @DiContainer.Inject(id="backRightMotor")
    public DcMotor backRightMotor;

    @DiContainer.Inject(id="gamepad1")
    public Gamepad gamepad1;

    @DiContainer.Inject(id="gamepad2")
    public Gamepad gamepad2;

    @Override
    public void Initialize() {
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void Tick() {
        double vertical = -powerCurve(gamepad1.left_stick_y) - powerCurve(gamepad2.left_stick_y);
        double horizontal = -powerCurve(gamepad1.left_stick_x) - powerCurve(gamepad2.left_stick_x);
        double rotational = -powerCurve(gamepad1.right_stick_x) - powerCurve(gamepad2.right_stick_x);

        frontLeftMotor.setPower(vertical - horizontal - rotational);
        frontRightMotor.setPower(vertical + horizontal + rotational);
        backLeftMotor.setPower(vertical + horizontal - rotational);
        backRightMotor.setPower(vertical - horizontal + rotational);
    }

    @Override
    public void Dispose() {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }


    public double powerCurve(double input) {
        if (input < -1) return -1;
        if (input > 1) return 1;

        return Math.pow(input, 3);
    }
}
