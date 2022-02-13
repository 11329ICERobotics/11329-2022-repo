package org.firstinspires.ftc.teamcode.commands.drivetrain;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.drivetrain.Drivetrain;
import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class TeleopDrive implements DiInterfaces.ITickable {
    @DiContainer.Inject()
    public Drivetrain drivetrain;

    @DiContainer.Inject(id="gamepad1")
    public Gamepad gamepad1;

    @DiContainer.Inject(id="gamepad2")
    public Gamepad gamepad2;

    @DiContainer.Inject()
    public Telemetry telemetry;

    public double speed = RobotConfig.slowDriveSpeed;
    public boolean isFast = false;
    public boolean isHoldingFast = false;

    public boolean isHoldingTurbo = false;
    public boolean isTurbo = false;
    @Override
    public void Tick() {
        double vertical = -powerCurve(gamepad1.left_stick_y);
        double horizontal = -powerCurve(gamepad1.left_stick_x);
        double rotational = powerCurve(gamepad1.right_stick_x);

        telemetry.addData("Drive Vertical", vertical);
        telemetry.addData("Drive Horizontal", horizontal);
        telemetry.addData("Drive Rotational", rotational);

        if (gamepad1.square) {
            if (!isHoldingFast) {
                isFast = !isFast;
                isHoldingFast = true;
            }
        } else {
            isHoldingFast = false;
        }

        if(gamepad1.left_bumper){
            if(!isHoldingTurbo){
                isTurbo = !isTurbo;
                isHoldingTurbo = true;
            }
        }
        else{
            isHoldingTurbo = false;
        }

        if(isFast && isTurbo){
            if(gamepad1.left_bumper){
                isFast = false;
            }
            else if(gamepad1.square){
                isTurbo = false;
            }
        }
        if(isTurbo){
            speed = RobotConfig.turboDriveSpeed;
        }
        else if(isFast){
            speed = RobotConfig.fastDriveSpeed;
        }
        else{
            speed = RobotConfig.slowDriveSpeed;
        }
        //speed =  (isFast ? RobotConfig.fastDriveSpeed : RobotConfig.slowDriveSpeed);



        drivetrain.MecanumDrive(vertical, horizontal, rotational,speed);
        //drivetrain.TankDrive(horizontal, rotational);
    }

    public double powerCurve(double input) {
        if (input < -1) return -1;
        if (input > 1) return 1;

        return Math.pow(input, 3);
    }
}
