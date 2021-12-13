package org.firstinspires.ftc.teamcode.commands.drivetrain;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.drivetrain.Drivetrain;
import org.firstinspires.ftc.teamcode.utilities.RobotConfig;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class TeleopDrive implements DiInterfaces.ITickable {
    @DiContainer.Inject()
    public Drivetrain drivetrain;

    @DiContainer.Inject(id="gamepad1")
    public Gamepad gamepad1;

    @DiContainer.Inject(id="gamepad2")
    public Gamepad gamepad2;

    @Override
    public void Tick() {
        double vertical = -powerCurve(gamepad1.right_stick_x);
        double horizontal = -powerCurve(gamepad1.left_stick_x);
        double rotational = powerCurve(gamepad1.left_stick_y);

        drivetrain.MecanumDrive(vertical, horizontal, rotational, (gamepad1.square ? RobotConfig.fastDriveSpeed : RobotConfig.slowDriveSpeed));
    }

    public double powerCurve(double input) {
        if (input < -1) return -1;
        if (input > 1) return 1;

        return Math.pow(input, 3);
    }
}
