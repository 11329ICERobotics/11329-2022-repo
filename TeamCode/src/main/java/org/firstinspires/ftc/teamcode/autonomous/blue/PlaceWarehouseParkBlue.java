package org.firstinspires.ftc.teamcode.autonomous.blue;

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

@Autonomous(name="Place and Warehouse Park Blue", group="Blue")
public class PlaceWarehouseParkBlue extends AutoBase {
    @Override
    public void Run() {
        autoNav.AddTask(new ReadBarcodeTask());
        autoNav.AddTask(new ReleaseIntakeTask(RobotConfig.msForReleaseIntake));
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
                        ThirdPosition();
                        break;
                }

                Park();
            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });


        autoNav.AddTask(new ArmTask(1000, null));
        autoNav.AddTask(new MovementTask(1200, 90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1700,-1, -0.5f));
    }

    public void Park() {
        autoNav.AddTask(new ArmTask(1000, null));
        autoNav.AddTask(new MovementTask(1700,-1, 0.5f));
        autoNav.AddTask(new MovementTask(1300, -90, 0, 0.5f));

        // Park

        autoNav.AddTask(new MovementTask(2000, -10, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1850, 90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1000, 0, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1250,-1, 0.5f));
        autoNav.AddTask(new MovementTask(1250, 90, 0, 0.5f));
    }

    public void FirstPosition() {
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, RobotConfig.intakeSpeed));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(625, 0, 0, 0.25f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, 0.0));
        autoNav.AddTask(new MovementTask(625, -180, 0, 0.25f)); //0050
        //autoNav.AddTask(new MovementTask(2850, 90, 0, 0.5f));
    }

    public void SecondPosition() {
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, RobotConfig.intakeSpeed));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(850, 0, 0, 0.25f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, 0.0));
        autoNav.AddTask(new MovementTask(850, -180, 0, 0.25f));
        //autoNav.AddTask(new MovementTask(2850, 90, 0, 0.5f));
    }

    public void ThirdPosition() {
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, RobotConfig.intakeSpeed));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(1350, 0, 0, 0.25f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));
        autoNav.AddTask(new MovementTask(1350, -180, 0, 0.25f));
        //autoNav.AddTask(new MovementTask(2850, 90, 0, 0.5f));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Blue;
    }
}
