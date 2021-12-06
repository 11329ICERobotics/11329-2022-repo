package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import java.util.Vector;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Quaternion;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import java.util.concurrent.Callable;
import com.qualcomm.hardware.bosch.BNO055IMU;


public class AutoNav {
    public Callable<Boolean> opModeIsActive;
    public Telemetry telemetry;
    public HardwareInterface hardwareInterface;
    //public ComputerVision computerVision;
    
    public Position position;
    public Orientation angles;
    public Acceleration gravity;
    public Acceleration acceleration;
    public Orientation lastAngles = new Orientation();
    double correctedAngle = 0;
    
    private int frontLeftEncoder = 0;
    private int backLeftEncoder = 0;
    private int backRightEncoder = 0;
    private int frontRightEncoder = 0;
    
    private int frontLeftPrevEncoder = 0;
    private int backLeftPrevEncoder = 0;
    private int backRightPrevEncoder = 0;
    private int frontRightPrevEncoder = 0;
    
    long deltaTime = 0;
    long prevTime = System.currentTimeMillis();
    
    //public PIDController translationController;
    //public PIDController rotationController;
    
    public final double wheelDiameterMM = 96;
    public final double ticksPerRot = 537.6;
    
    public final double ticksPerMM = ticksPerRot / (wheelDiameterMM * Math.PI);
    
    public AutoNav(Callable<Boolean> oma, Telemetry tm, HardwareInterface hi) { //, ComputerVision cv) {
        opModeIsActive = oma;
        telemetry = tm;
        hardwareInterface = hi;
        //computerVision = cv;
        
        position = new Position();
        
        /*translationController = new PIDController(0.002, 0.00006, 0.001);
        
        translationController.setInputRange(0, mmToTicks(5000));
        translationController.setTolerance(0.008);
        
        rotationController = new PIDController(0.072, 0, 0);//0.5, 0);//0.00006, 0.006);
        
        rotationController.setInputRange(0, 360);
        rotationController.setContinuous();
        rotationController.setTolerance(0.1);*/
        
        pollEncoders();
    }
    
    private void pollEncoders() {
        frontLeftEncoder = hardwareInterface.frontLeftMotor.getCurrentPosition();
        backLeftEncoder = hardwareInterface.backLeftMotor.getCurrentPosition();
        backRightEncoder = -hardwareInterface.backRightMotor.getCurrentPosition();
        frontRightEncoder = -hardwareInterface.frontRightMotor.getCurrentPosition();
    }
    
    private int[] computeEncoderDerivitives() {
        pollEncoders();
        
        int[] encoderDerivatives = { 
            frontLeftEncoder - frontLeftPrevEncoder, 
            backLeftEncoder - backLeftPrevEncoder, 
            backRightEncoder - backRightPrevEncoder, 
            frontRightEncoder - frontRightPrevEncoder 
        };
        
        frontLeftPrevEncoder = frontLeftEncoder;
        backLeftPrevEncoder = backLeftEncoder;
        backRightPrevEncoder = backRightEncoder;
        frontRightPrevEncoder = frontRightEncoder;
        
        return encoderDerivatives;
    }
    
    public void update() {
        long currentTime = System.currentTimeMillis();
        deltaTime = currentTime - prevTime;
        prevTime = currentTime;
                
        /*angles = hardwareInterface.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
        gravity = hardwareInterface.imu.getGravity();
        acceleration = hardwareInterface.imu.getLinearAcceleration();
        
        // convert angle from -180:180 (from Compass) to 0:360 (for PID library)
        correctedAngle = (angles.thirdAngle + 360) % 360;
        
        pollEncoders();

        telemetry.addData("status", hardwareInterface.imu.getSystemStatus().toShortString());
        telemetry.addData("calib", hardwareInterface.imu.getCalibrationStatus().toString());

        //telemetry.addData("position", position.toString());
        telemetry.addData("angle", "(" + angles.firstAngle + ", " + angles.secondAngle + ", " + angles.thirdAngle + ")deg");
        telemetry.addData("acceleration", acceleration.toString());
        
        telemetry.addData("corrected angle", correctedAngle);*/
    }
    
    public void goForTime(long millis, float forwards, float left, float clockwise, float speed) {
        try {
            speed = Math.max(-1.0f, Math.min(1.0f, speed));
        
            telemetry.log().add("Driving for " + millis + " milliseconds at " + speed + " power.");
        
            long now = java.lang.System.currentTimeMillis();
        
            long startTime = now;
            long stopTime = startTime + millis;
        
            long rampDuration = (long) (0.4 * millis);
            long rampUpTime = startTime + rampDuration;
            long rampDownTime = stopTime - rampDuration;
        
            telemetry.log().add("Starting at " + startTime);
        
            hardwareInterface.tankDrive(0, 0);
        
            do {
                now = java.lang.System.currentTimeMillis();
                hardwareInterface.mecanumDrive(forwards, left, clockwise, (float) (speed * Math.min(((float)(now-startTime)/(float)(rampUpTime-startTime)), 1)));
            } while(now < rampUpTime && opModeIsActive.call());
        
            hardwareInterface.mecanumDrive(forwards, left, clockwise, speed);
        
            do {
                now = java.lang.System.currentTimeMillis();
                // motor power is constant here
            } while(now < rampDownTime && opModeIsActive.call());
        
            do {
                now = java.lang.System.currentTimeMillis();
                hardwareInterface.mecanumDrive(forwards, left, clockwise, (float) (speed * (1 - ((float)(now - rampDownTime)/(float)(stopTime - rampDownTime)))));
            } while(now < stopTime && opModeIsActive.call());
        
            hardwareInterface.mecanumDrive(forwards, left, clockwise, 0f);
        } catch (Exception e) {
            hardwareInterface.mecanumDrive(0, 0, 0, 0f);
            
            telemetry.log().add("ERROR!!!!!!!!!!!!!!!!!!!!!");
        }
    }
    
    public void doNothing(long millis){
        goForTime(millis, 0, 0, 0, 0);
    }
    
    /*public void goToRelativeRotation(float rotation, float speed) {
        float correctedRotation = rotation;//(rotation + 360) % 360;
        
        float targetAngle = (float) ((correctedAngle + correctedRotation + 360) % 360);
        
        goToAbsoluteRotation(targetAngle, speed);
    }
    
    public void goToAbsoluteRotation(float rotation, float speed) {
        update();
        
        float targetAngle = (rotation + 360) % 360;
        
        double startAngle = correctedAngle;
        
        telemetry.log().add("starting at " + startAngle);
        telemetry.log().add("going to " + targetAngle);
        
        rotationController.reset();
        rotationController.setSetpoint(targetAngle);
        rotationController.setOutputRange(0, speed);
        rotationController.enable();
        
        telemetry.log().add("start");
        
        try {
            do {
                update();
                
                float power = (float) rotationController.performPID(correctedAngle);
                
                hardwareInterface.mecanumDrive(0, 0, -1, power);
                
                telemetry.addData("Target", rotation + "deg");
                telemetry.addData("Corrected Target", targetAngle + "deg");
                telemetry.addData("Current", correctedAngle + "deg");
                telemetry.update();
            } while (opModeIsActive.call() && !rotationController.onTarget());
        } catch (Exception e) {
            telemetry.log().add(e.toString());
        }
        
        
        hardwareInterface.tankDrive(0, 0);
        
        telemetry.log().add("stop");
        
        rotationController.disable();
    }
    
    public double mmToTicks(float distance) {
        return distance * ticksPerMM;
    }
    
    public Float getAngleErrorFromVuMarks(boolean color) {
        float angleError = 0;
        VectorF robotPosition;
        Orientation robotOrientation;
        VectorF targetPosition;
        
        if (color) robotPosition = computerVision.getPositionToVuMark(computerVision.ultimateGoalBlueLogoTarget);
        else robotPosition = computerVision.getPositionToVuMark(computerVision.ultimateGoalRedLogoTarget);
        
        if (color) robotOrientation = computerVision.getOrientationToVuMark(computerVision.ultimateGoalBlueLogoTarget);
        else robotOrientation = computerVision.getOrientationToVuMark(computerVision.ultimateGoalRedLogoTarget);
        
        if (color) targetPosition = computerVision.ultimateGoalBlueLogoTarget.getLocation().getTranslation();
        else targetPosition = computerVision.ultimateGoalRedLogoTarget.getLocation().getTranslation();
    
        if (robotPosition == null || targetPosition == null) {
            return null;
        }
        
        angleError = (float) Math.atan((targetPosition.get(0) - robotPosition.get(0)) / (targetPosition.get(1) - robotPosition.get(1)));
        
        angleError *= (float) (180 / Math.PI);
        
        angleError -= robotOrientation.thirdAngle;
        
        return angleError;
    }

    public void targetGoal(float speed, boolean color) {
        telemetry.log().add("looking...");
        Float angleError = getAngleErrorFromVuMarks(true);

        if (angleError == null) {
            telemetry.log().add("vumark not found...");
            return;
        }
        
        telemetry.log().add("off by " + angleError + " degrees");

        goToRelativeRotation(angleError, speed);
    }*/
}