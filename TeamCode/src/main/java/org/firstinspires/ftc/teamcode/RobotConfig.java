package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;

public class  RobotConfig {
    public static int  possibleExtraBlocks = 3;
    public static String frontLeftMotorName = "frontLeft";
    public static String frontRightMotorName = "frontRight";
    public static String backLeftMotorName = "backLeft";
    public static String backRightMotorName = "backRight";
    public static String distanceEncoderName = "distanceEncoder";

    public static String armMotorName = "armMotor";

    public static String intakeMotorName = "intakeMotor";

    public static String spinnerMotorName = "spinnerMotor";

    public static String leftDistanceName = "leftDistance";
    public static String rightDistanceName = "rightDistance";
    public static String frontDistanceName = "frontDistance";
    public static String backDistanceName = "backDistance";
    public static String IMUName = "IMU";
    public static String armButtonName = "armButton";

    public static String intakeReleaseServoName = "intakeRelease";
    public static String distanceSensorName = "distanceSensor";
    public static final String freightSensorName = "freightSensor";
    public static final String ledLightsName = "LEDLights";

    public static String yawMotorName = "yawMotor";
    public static String pitchMotorName = "pitchMotor";
    public static String distanceMotorName = "distanceMotor";

    public static double yawMotorSpeed = 0.0005;
    public static double pitchMotorSpeedSlow = 0.1;
    public static double pitchMotorSpeedFast = 0.4;
    public static double distanceMotorSpeed = 1;

    public static double capperYawZero = 0.4488888;

    public static double armSpeed = 1;//0.35;
    public static double intakeSpeed = 0.45;
    public static double outtakeSpeed = 0.35;

    public static double spinnerSpeed = 0.85;
    public static double spinnerStart = 0.5;
    public static double spinnerEnd = 1.0;
    public static float spinnerRate = 600f;

    public static double turboDriveSpeed = 0.35;
    public static double fastDriveSpeed = 0.9;//.75
    public static double slowDriveSpeed = 0.5;//.75

    public static int minArmAngle = 0;
    public static int maxArmAngle = 2250;

    public static double intakeReleaseBlockAngle = 0.46;
    public static double intakeReleaseLeaveAngle = 0.0;

    public static boolean capMode = false;
    public static final String colorSensor1ConfigFileName = "COLOR_SENSOR_CALIBRATION1.json";

    public static final RevBlinkinLedDriver.BlinkinPattern blockPattern = RevBlinkinLedDriver.BlinkinPattern.ORANGE;
    public static final RevBlinkinLedDriver.BlinkinPattern ballPattern = RevBlinkinLedDriver.BlinkinPattern.WHITE;
    public static final RevBlinkinLedDriver.BlinkinPattern duckPattern = RevBlinkinLedDriver.BlinkinPattern.YELLOW;
    public static final RevBlinkinLedDriver.BlinkinPattern absentPattern = RevBlinkinLedDriver.BlinkinPattern.BLACK;

    public static class ArmPresets {
        public static int intake = 2220;
        public static int startingConfig = 550;

        public static int frontFirst = 1360;
        public static int frontSecond = 1650;
        public static int frontThird = 1964;

        public static int backFirst = 686;
        public static int backSecond = 0;
        public static int backThird = 230;
    }

    public static long msForOneDuckSpin = 3200;

    public static long msForReleaseIntake = 250;
}
