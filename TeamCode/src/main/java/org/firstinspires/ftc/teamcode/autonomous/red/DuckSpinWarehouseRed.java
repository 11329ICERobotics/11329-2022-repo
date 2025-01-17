package org.firstinspires.ftc.teamcode.autonomous.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.autonomous.AutoBase;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ArmTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.CustomTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.DuckSpinTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.MovementTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ReadBarcodeTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ReleaseIntakeTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.WaitTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;
//WareHouse Untested
@Autonomous(name="Duck Spin Park Warehouse Red", group="Red")
public class DuckSpinWarehouseRed extends AutoBase {
    @Override
    public void Run() {
        autoNav.AddTask(new ReadBarcodeTask());
        autoNav.AddTask(new ReleaseIntakeTask(RobotConfig.msForReleaseIntake));
        autoNav.AddTask(new MovementTask(500, 0, 0, 0.02f));
        autoNav.AddTask(new CustomTask() {
            @Override
            public void begin() {
                telemetry.log().add("what did we see?");
                telemetry.log().add(autoNav.computerVision.GetBarcodeStatus().toString());

                switch (autoNav.computerVision.GetBarcodeStatus()) {
                    case One:
                        FirstPosition();
                        break;
                    case Two:
                        SecondPosition();
                        break;
                    case Three:
                    case Reading:
                        ThirdPosition();
                        break;
                }

                SpinDuck();
            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });
    }

    public void SpinDuck() {
        autoNav.AddTask(new ArmTask(1000, null));
        autoNav.AddTask(new MovementTask(1600, 260, -0.5f, 1f));
        autoNav.AddTask(new MovementTask(300, 180, 0, 1f));
        autoNav.AddTask(new DuckSpinTask(true));
        autoNav.AddTask(new MovementTask(RobotConfig.msForOneDuckSpin, 180, 0, 0.05f));
        autoNav.AddTask(new DuckSpinTask(false));
        autoNav.AddTask(new MovementTask(2500, 90, 0, 1f));
        autoNav.AddTask(new MovementTask(1250,1, 0.5f));
        autoNav.AddTask(new MovementTask(1500, 0, 0, 1f));
    }

    public void FirstPosition() {
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, RobotConfig.intakeSpeed));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(6000, -90, 0, 0.25f));
        autoNav.AddTask(new MovementTask(500, 90, 0, 0.25f));
        autoNav.AddTask(new MovementTask(700, 0, 0, 0.25f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, 0.0));
        autoNav.AddTask(new MovementTask(700, 180, 0, 0.25f));
        autoNav.AddTask(new MovementTask(2850, 90, 0, 0.5f));
    }

    public void SecondPosition() {
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, RobotConfig.intakeSpeed));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(6000, -90, 0, 0.25f));
        autoNav.AddTask(new MovementTask(500, 90, 0, 0.25f));
        autoNav.AddTask(new MovementTask(800, 0, 0, 0.25f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, 0.0));
        autoNav.AddTask(new MovementTask(800, 180, 0, 0.25f));
        autoNav.AddTask(new MovementTask(2850, 90, 0, 0.5f));
    }

    public void ThirdPosition() {
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, RobotConfig.intakeSpeed));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(5500, -90, 0, 0.25f));
        autoNav.AddTask(new MovementTask(1300, 0, 0, 0.25f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));
        autoNav.AddTask(new MovementTask(1300, 180, 0, 0.25f));
        autoNav.AddTask(new MovementTask(2850, 90, 0, 0.5f));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Red;
    }
}
