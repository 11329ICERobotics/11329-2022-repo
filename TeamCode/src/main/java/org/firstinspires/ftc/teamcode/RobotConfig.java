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

    public static double armSpeed = 1;//0.35;
    public static double intakeSpeed = 0.5;
    public static double outtakeSpeed = 0.45;

    public static double spinnerSpeed = 0.9;

    public static double fastDriveSpeed = 0.75;
    public static double slowDriveSpeed = 0.5;

    public static double minArmAngle = 0;
    public static double maxArmAngle = 180;

    public static class ArmPresets {
        public static double intake = 0;
        public static double startingConfig = 0;

        public static double frontFirst = 0;
        public static double frontSecond = 0;
        public static double frontThird = 0;

        public static double backFirst = 0;
        public static double backSecond = 0;
        public static double backThird = 0;
    }

    public static long msForOneDuckSpin = 3000;
}
