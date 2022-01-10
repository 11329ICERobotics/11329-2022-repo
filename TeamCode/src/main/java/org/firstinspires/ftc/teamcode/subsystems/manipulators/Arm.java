package org.firstinspires.ftc.teamcode.subsystems.manipulators;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class Arm implements DiInterfaces.IInitializable, DiInterfaces.ITickable, DiInterfaces.IDisposable {
    @DiContainer.Inject(id="armMotor")
    public DcMotorEx armMotor;

    @DiContainer.Inject(id="intakeMotor")
    public DcMotorEx intakeMotor;

    @DiContainer.Inject(id="armButton")
    public TouchSensor backLimit;

    @DiContainer.Inject(id="intakeRelease")
    public Servo intakeRelease;

    @DiContainer.Inject
    public Telemetry telemetry;

    public boolean resettingArm = false;
    public int targetPosition = RobotConfig.ArmPresets.startingConfig;
    public boolean runToTarget = true;
    public double nonTargetPower = 0;

    @Override
    public void Initialize() {
        armMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        armMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        armMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        intakeMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        intakeMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void Tick() {
        if (runToTarget) {
            if (!IsArmDoneMoving()) {
                armMotor.setPower(Math.copySign(GetArmPower(), GetArmError()));
            } else {
                armMotor.setPower(0);
            }

            if (BackLimitBeenHit()) {
                if (targetPosition < 0) targetPosition = 0;

                if (resettingArm) {
                    armMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
                    targetPosition = 0;
                    armMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
                    resettingArm = false;
                }
            }
        } else {
            if (BackLimitBeenHit() && nonTargetPower < 0) nonTargetPower = 0;

            armMotor.setPower(nonTargetPower);
            targetPosition = GetRealAngle();
        }
    }

    @Override
    public void Dispose() {
        armMotor.setPower(0);
    }

    public void Run(int armPosition, double intakeSpeed) {
        RunArm(armPosition);
        RunIntake(intakeSpeed);
    }

    public void RunArm(int armPosition) {
        if (resettingArm) return;

        targetPosition = armPosition;
    }

    public void ZeroArm() {
        resettingArm = true;
        targetPosition = -99999;
    }

    public void MoveServo(boolean block) {
        if (block) intakeRelease.setPosition(RobotConfig.intakeReleaseBlockAngle);
        else intakeRelease.setPosition(RobotConfig.intakeReleaseLeaveAngle);
    }

    public boolean IsArmDoneMoving() {
        return Math.abs(GetArmError()) < 0.01 * (RobotConfig.maxArmAngle - RobotConfig.minArmAngle); //armMotor.getTargetPositionTolerance();
    }

    public double GetArmError() {
        return targetPosition - GetRealAngle();
    }

    public void OverridePositionalControl(boolean doit) {
        runToTarget = !doit;
    }

    public void OverridePower(double power) {
        nonTargetPower = power;
    }

    public void RunIntake(double intakeSpeed) {
        intakeMotor.setPower(intakeSpeed);
    }

    public double GetArmPower() {
        if ((GetRealAngle() > 1000 && targetPosition < GetRealAngle()) ||
            (GetRealAngle() < 1000 && targetPosition > GetRealAngle())) {
            return 1.0;
        } else {
            return 0.75;
        }
    }

    public void Stop() {
        Run(0, 0);
    }

    public int GetRealAngle() {
        return armMotor.getCurrentPosition();
    }

    public boolean BackLimitBeenHit() {
        return backLimit.isPressed();
    }
}