package org.firstinspires.ftc.teamcode;

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

    public static double armSpeed = 1;//0.35;
    public static double intakeSpeed = 0.5;
    public static double outtakeSpeed = 0.35;

    public static double spinnerSpeed = 0.85;

    public static double fastDriveSpeed = 0.75;
    public static double slowDriveSpeed = 0.5;

    public static int minArmAngle = 0;
    public static int maxArmAngle = 2300;

    public static double intakeReleaseBlockAngle = 0;
    public static double intakeReleaseLeaveAngle = 1;

    public static final String colorSensor1ConfigFileName = "COLOR_SENSOR_CALIBRATION1.json";
    public static final String freightSensorName = "freightSensor";
    public static class ArmPresets {
        public static int intake = 2300;
        public static int startingConfig = 630;

        public static int frontFirst = 1360;
        public static int frontSecond = 1600;
        public static int frontThird = 1850;

        public static int backFirst = 0;
        public static int backSecond = 0;
        public static int backThird = 0;
    }

    public static long msForOneDuckSpin = 3200;
}
