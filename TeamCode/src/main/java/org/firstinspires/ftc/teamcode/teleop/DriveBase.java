package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.HardwareInterface;

public abstract class DriveBase extends OpMode {
    public double degAngleFrontToFrontLeft = 47.726310993908;

    HardwareInterface hardwareInterface;

    public double armSpeed = 1;
    public double wristSpeed = 0.75;

    public double spinnerSpeed = 0.75;

    public double fastDriveSpeed = 0.75;
    public double slowDriveSpeed = 0.5;

    public double powerCurve(double input) {
        if (input < -1) return -1;
        if (input > 1) return 1;

        return Math.pow(input, 3);
    }

    @Override
    public void init() {
        hardwareInterface = new HardwareInterface(hardwareMap);
    }

    @Override
    public void loop() {
        double vertical = -powerCurve(gamepad1.right_stick_x);
        double horizontal = -powerCurve(gamepad1.left_stick_x);
        double rotational = powerCurve(gamepad1.left_stick_y);
        double armPower = gamepad2.right_stick_y;
        double wristPower = (gamepad2.left_trigger - gamepad2.right_trigger);
        boolean spin = gamepad1.circle;
        boolean spinReverse = gamepad1.cross;

        hardwareInterface.mecanumDrive(vertical, horizontal, rotational, (gamepad1.square ? fastDriveSpeed : slowDriveSpeed));
        hardwareInterface.armDrive(armPower * armSpeed);
        hardwareInterface.wristDrive(wristPower * wristSpeed);
        hardwareInterface.spinnerDrive((spin ? spinnerSpeed : 0) + (spinReverse ? -spinnerSpeed : 0));
    }
}
