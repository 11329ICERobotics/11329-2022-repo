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

import java.util.Timer;

@Autonomous(name="Super Auto Blue", group="Blue")
public class TheoreticalSuperAutoBlue extends AutoBase {
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
                        Pickup();
                        ThirdPosition();
                        Pickup();
                        ThirdPosition();
                        Pickup();
                        break;
                    case Reading:
                        ThirdPosition();
                        break;
                }


            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });

        //Pickup();
        //ThirdPosition();
        //Pickup();
        //ThirdPosition();

    }
    public void Pickup(){
        autoNav.AddTask(new MovementTask(400, -90, 0, 1f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.intake, RobotConfig.intakeSpeed));
        autoNav.AddTask(new MovementTask(1500, -10, 0, 1f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, RobotConfig.intakeSpeed));
        autoNav.AddTask(new MovementTask(1200, 0, 0, -1f));
    }

    public void Park() {

    }

    public void FirstPosition() {
        autoNav.AddTask(new MovementTask(500, 90, 1f, 0.5f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, RobotConfig.outtakeSpeed));
        autoNav.AddTask(new MovementTask(500,-90, 1f, 0.5f));

    }

    public void SecondPosition() {
        autoNav.AddTask(new MovementTask(500, 90, 1f, 0.5f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, RobotConfig.outtakeSpeed));
        autoNav.AddTask(new MovementTask(500,-90, 1f, 0.5f));

    }

    public void ThirdPosition() {
        autoNav.AddTask(new MovementTask(1000, 90, 1f, 1f));
        autoNav.AddTask(new MovementTask(300, 90, 0, 1f));
        autoNav.AddTask(new MovementTask(500, 0, 0, 1f));

        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(1000));

        autoNav.AddTask(new MovementTask(500, 0, 0, -1f));
        autoNav.AddTask(new MovementTask(300, 90, 0, -1f));
        autoNav.AddTask(new MovementTask(1000, 90, 1f, -1f));

        //autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, RobotConfig.outtakeSpeed));
        //autoNav.AddTask(new MovementTask(500,-90, 1f, 0.5f));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Blue;
    }
}
