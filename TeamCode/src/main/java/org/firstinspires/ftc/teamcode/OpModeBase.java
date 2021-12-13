package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.drivetrain.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.manipulators.Arm;
import org.firstinspires.ftc.teamcode.subsystems.manipulators.DuckSpinner;
import org.firstinspires.ftc.teamcode.utilities.RobotConfig;
import org.firstinspires.ftc.teamcode.utilities.DiOpMode;

import java.lang.reflect.InvocationTargetException;

public abstract class OpModeBase extends DiOpMode {
    public abstract void InstallLower() throws IllegalAccessException, InvocationTargetException, InstantiationException;

    @Override
    public void Install() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Container.BindInstance(hardwareMap.get(DcMotor.class, RobotConfig.frontLeftMotorName)).WithId("frontLeft");
        Container.BindInstance(hardwareMap.get(DcMotor.class, RobotConfig.frontRightMotorName)).WithId("frontRight");
        Container.BindInstance(hardwareMap.get(DcMotor.class, RobotConfig.backLeftMotorName)).WithId("backLeft");
        Container.BindInstance(hardwareMap.get(DcMotor.class, RobotConfig.backRightMotorName)).WithId("backRight");

        Container.BindInstance(hardwareMap.get(DcMotor.class, RobotConfig.armMotorName)).WithId("armMotor");
        Container.BindInstance(hardwareMap.get(DcMotor.class, RobotConfig.intakeMotorName)).WithId("intakeMotor");

        Container.BindInstance(hardwareMap.get(DcMotor.class, RobotConfig.spinnerMotorName)).WithId("spinnerMotor");

        Container.BindInstance(telemetry);

        Container.Bind(Drivetrain.class).AsSingle();
        Container.Bind(Arm.class).AsSingle();
        Container.Bind(DuckSpinner.class).AsSingle();

        InstallLower();
    }
}
