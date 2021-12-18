package org.firstinspires.ftc.teamcode.commands.manipulators;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.subsystems.manipulators.Arm;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class TeleopArm implements DiInterfaces.ITickable {
    @DiContainer.Inject()
    public Arm arm;

    @DiContainer.Inject(id="gamepad1")
    public Gamepad gamepad1;

    @DiContainer.Inject(id="gamepad2")
    public Gamepad gamepad2;

    @DiContainer.Inject()
    public Telemetry telemetry;

    double armAngle = 0;

    @Override
    public void Tick() {
        armAngle += -gamepad2.right_stick_y * RobotConfig.armSpeed;

        if (gamepad2.square) armAngle = RobotConfig.ArmPresets.startingConfig;
        if (gamepad2.dpad_right) armAngle = RobotConfig.ArmPresets.intake;

        if (gamepad2.dpad_up) armAngle = RobotConfig.ArmPresets.frontFirst;
        if (gamepad2.dpad_left) armAngle = RobotConfig.ArmPresets.frontSecond;
        if (gamepad2.dpad_down) armAngle = RobotConfig.ArmPresets.frontThird;

        if (gamepad2.cross) armAngle = RobotConfig.ArmPresets.backFirst;
        if (gamepad2.circle) armAngle = RobotConfig.ArmPresets.backSecond;
        if (gamepad2.triangle) armAngle = RobotConfig.ArmPresets.backThird;


        if (armAngle < RobotConfig.minArmAngle) armAngle = RobotConfig.minArmAngle;
        if (armAngle > RobotConfig.maxArmAngle) armAngle = RobotConfig.maxArmAngle;

        double intakeSpeed = (gamepad2.left_trigger * RobotConfig.outtakeSpeed - gamepad2.right_trigger * RobotConfig.intakeSpeed);

        telemetry.addData("TeleopArm Status", "ArmAngle: " + armAngle + " RealArmAngle: " + arm.GetRealAngle() + " IntakeSpeed: " + intakeSpeed + " BackLimit: " + arm.BackLimitBeenHit());

        arm.RunArmPower(-gamepad2.right_stick_y * RobotConfig.armSpeed);
        //arm.RunArm(armAngle);
        arm.RunIntake(intakeSpeed);
        //arm.Run(armAngle, intakeSpeed);
    }
}