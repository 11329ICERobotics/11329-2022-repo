package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gyroscope;
import java.io.File;
import com.qualcomm.robotcore.util.ReadWriteFile;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.robot.Robot;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.system.AppUtil;

public class HardwareInterface {
    public HardwareMap hardwareMap;
    
    public BNO055IMU imu;

    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor backLeftMotor;
    public DcMotor backRightMotor;

    public DcMotor armMotor;
    public DcMotor wristMotor;

    public DcMotor spinnerMotor;
    
    public HardwareInterface(HardwareMap hm) {
        hardwareMap = hm;
        
        /*imu = hardwareMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.mode = BNO055IMU.SensorMode.NDOF;
        parameters.calibrationDataFile = "IMU_CALIBRATION.json";
        imu.initialize(parameters);*/

        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeft");
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRight");
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backLeftMotor = hardwareMap.get(DcMotor.class, "backLeft");
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backRightMotor = hardwareMap.get(DcMotor.class, "backRight");
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        //armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        wristMotor = hardwareMap.get(DcMotor.class, "wristMotor");
        wristMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        wristMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        wristMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        spinnerMotor = hardwareMap.get(DcMotor.class, "spinnerMotor");
        spinnerMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        spinnerMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        spinnerMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    
    public void stopAll() {
        frontRightMotor.setPower(0);
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontLeftMotor.setPower(0);
        armMotor.setPower(0);
        wristMotor.setPower(0);
        spinnerMotor.setPower(0);
    }
    
    public double TPStoRPM(double tps) {
        return (tps / 28) * 60;
    }
    
    public double RPMtoTPS(double rpm) {
        return (rpm / 60) * 28;
    }
    
    public void tankDrive(float leftPower, float rightPower) {
        frontRightMotor.setPower(-leftPower);
        backRightMotor.setPower(-leftPower);
        frontLeftMotor.setPower(rightPower);
        backLeftMotor.setPower(rightPower);
    }
    
    // rotational: + couter clockwise, - clockwise
    public void mecanumDrive(double vertical, double horizontal, double rotational, double maxSpeed) {
        frontRightMotor.setPower((vertical + horizontal - rotational) * maxSpeed);
        backRightMotor.setPower((vertical - horizontal - rotational) * maxSpeed);
        frontLeftMotor.setPower(-(vertical + horizontal + rotational) * maxSpeed);
        backLeftMotor.setPower(-(vertical - horizontal + rotational) * maxSpeed);
    }

    public void armDrive(double speed) {
        armMotor.setPower(speed);
    }

    public void wristDrive(double speed) {
        wristMotor.setPower(speed);
    }

    public void spinnerDrive(double speed) {
        spinnerMotor.setPower(speed);
    }
}
