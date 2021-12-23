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
    public static int maxArmAngle = 2070;

    public static double intakeReleaseBlockAngle = 0;
    public static double intakeReleaseLeaveAngle = 1;

    public static class ArmPresets {
        public static int intake = 2070;
        public static int startingConfig = 500;

        public static int frontFirst = 1360;
        public static int frontSecond = 1670;
        public static int frontThird = 1900;

        public static int backFirst = 0;
        public static int backSecond = 0;
        public static int backThird = 0;
    }

    public static long msForOneDuckSpin = 3200;
}
