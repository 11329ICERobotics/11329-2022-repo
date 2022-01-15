package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;

public class RobotConfig {
    public static String frontLeftMotorName = "frontLeft";
    public static String frontRightMotorName = "frontRight";
    public static String backLeftMotorName = "backLeft";
    public static String backRightMotorName = "backRight";

    public static String armMotorName = "armMotor";

    public static String intakeMotorName = "intakeMotor";

    public static String spinnerMotorName = "spinnerMotor";

    public static String leftDistanceName = "leftDistance";
    public static String rightDistanceName = "rightDistance";
    public static String frontDistanceName = "frontDistance";
    public static String backDistanceName = "backDistance";

    public static String armButtonName = "armButton";

    public static String intakeReleaseServoName = "intakeRelease";

    public static final String freightSensorName = "freightSensor";
    public static final String ledLightsName = "LEDLights";
    public static double armSpeed = 1;//0.35;
    public static double intakeSpeed = 0.5;
    public static double outtakeSpeed = 0.35;

    public static double spinnerSpeed = 0.85;

    public static double fastDriveSpeed = 0.75;
    public static double slowDriveSpeed = 0.5;

    public static int minArmAngle = 0;
    public static int maxArmAngle = 2200;

    public static double intakeReleaseBlockAngle = 0.45;
    public static double intakeReleaseLeaveAngle = 0;

    public static final String colorSensor1ConfigFileName = "COLOR_SENSOR_CALIBRATION1.json";

    public static final RevBlinkinLedDriver.BlinkinPattern blockPattern = RevBlinkinLedDriver.BlinkinPattern.ORANGE;
    public static final RevBlinkinLedDriver.BlinkinPattern ballPattern = RevBlinkinLedDriver.BlinkinPattern.GREEN;
    public static final RevBlinkinLedDriver.BlinkinPattern duckPattern = RevBlinkinLedDriver.BlinkinPattern.YELLOW;
    public static final RevBlinkinLedDriver.BlinkinPattern absentPattern = RevBlinkinLedDriver.BlinkinPattern.WHITE;

    public static class ArmPresets {
        public static int intake = 2200;
        public static int startingConfig = 550;

        public static int frontFirst = 1360;
        public static int frontSecond = 1600;
        public static int frontThird = 1850;

        public static int backFirst = 0;
        public static int backSecond = 0;
        public static int backThird = 0;
    }

    public static long msForOneDuckSpin = 3200;
}
