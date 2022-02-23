package org.firstinspires.ftc.teamcode.utilities;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.subsystems.ColorSensor.pickupDetection;
import org.firstinspires.ftc.teamcode.subsystems.angleMeasure.IMUClass;
import org.firstinspires.ftc.teamcode.subsystems.drivetrain.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.manipulators.Arm;
import org.firstinspires.ftc.teamcode.subsystems.manipulators.DuckSpinner;
import org.firstinspires.ftc.teamcode.utilities.DiOpMode;

import java.lang.reflect.InvocationTargetException;

public abstract class OpModeBase extends DiOpMode {
    public abstract void InstallLower() throws IllegalAccessException, InvocationTargetException, InstantiationException;

    public abstract RobotSide GetSide();

    @Override
    public void Install() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Container.BindInstance(GetSide());

        //Container.BindInstance(hardwareMap.get(CRServo.class, RobotConfig.yawMotorName)).WithId("yawMotor");
        //Container.BindInstance(hardwareMap.get(CRServo.class, RobotConfig.pitchMotorName)).WithId("pitchMotor");
        //Container.BindInstance(hardwareMap.get(CRServo.class, RobotConfig.distanceMotorName)).WithId("distanceMotor");

        Container.BindInstance(hardwareMap.get(DcMotorEx.class, RobotConfig.frontLeftMotorName)).WithId("frontLeftMotor");
        Container.BindInstance(hardwareMap.get(DcMotorEx.class, RobotConfig.frontRightMotorName)).WithId("frontRightMotor");
        Container.BindInstance(hardwareMap.get(DcMotorEx.class, RobotConfig.backLeftMotorName)).WithId("backLeftMotor");
        Container.BindInstance(hardwareMap.get(DcMotorEx.class, RobotConfig.backRightMotorName)).WithId("backRightMotor");

        Container.BindInstance(hardwareMap.get(DcMotorEx.class, RobotConfig.armMotorName)).WithId("armMotor");
        Container.BindInstance(hardwareMap.get(DcMotorEx.class, RobotConfig.intakeMotorName)).WithId("intakeMotor");

        Container.BindInstance(hardwareMap.get(DcMotorEx.class, RobotConfig.spinnerMotorName)).WithId("spinnerMotor");

        //Container.BindInstance(hardwareMap.get(Rev2mDistanceSensor.class, RobotConfig.leftDistanceName)).WithId("leftDistance");
//        Container.BindInstance(hardwareMap.get(Rev2mDistanceSensor.class, RobotConfig.rightDistanceName)).WithId("rightDistance");
//        Container.BindInstance(hardwareMap.get(Rev2mDistanceSensor.class, RobotConfig.frontDistanceName)).WithId("frontDistance");
//        Container.BindInstance(hardwareMap.get(Rev2mDistanceSensor.class, RobotConfig.backDistanceName)).WithId("backDistance");

        Container.BindInstance(hardwareMap.get(TouchSensor.class, RobotConfig.armButtonName)).WithId("armButton");

        Container.BindInstance(hardwareMap.get(Servo.class, RobotConfig.intakeReleaseServoName)).WithId("intakeRelease");
        Container.BindInstance(hardwareMap.get(BNO055IMU.class, RobotConfig.IMUName)).WithId("IMU");
        Container.BindInstance(hardwareMap.get(RevColorSensorV3.class, RobotConfig.freightSensorName)).WithId("freightSensor");
        Container.BindInstance(hardwareMap.get(RevBlinkinLedDriver.class, RobotConfig.ledLightsName)).WithId("LEDLights");
        Container.BindInstance(hardwareMap.get(Rev2mDistanceSensor.class, RobotConfig.distanceSensorName)).WithId("distanceSensor");
        Container.BindInstance(telemetry);

        Container.Bind(IMUClass.class).AsSingle();
        Container.Bind(Drivetrain.class).AsSingle();
        Container.Bind(Arm.class).AsSingle();
        Container.Bind(DuckSpinner.class).AsSingle();
        Container.Bind(pickupDetection.class).AsSingle();

        InstallLower();
    }
}
