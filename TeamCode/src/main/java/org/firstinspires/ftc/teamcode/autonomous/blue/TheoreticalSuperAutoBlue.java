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

        Pickup();
        ThirdPosition();
        Pickup();
        ThirdPosition();

    }
    public void Pickup(){
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.intake, RobotConfig.intakeSpeed));

    }

    public void Park() {

    }

    public void FirstPosition() {

    }

    public void SecondPosition() {

    }

    public void ThirdPosition() {
        autoNav.AddTask(new MovementTask(500, 90, 1f, 0.5f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, RobotConfig.outtakeSpeed));
        autoNav.AddTask(new MovementTask(500,-90, 1f, 0.5f));

    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Blue;
    }
}
