package org.firstinspires.ftc.teamcode.autonomous.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.autonomous.AutoBase;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ArmTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.CustomTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.MovementTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ReadBarcodeTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ReleaseIntakeTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.WaitTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

@Autonomous(name="SlowSuperArmUpBlue", group="Blue")
public class TheoreticalSuperAutoBlueSlowArmUpAtLast extends AutoBase {
    public float speed = 0.5f;
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
                        Pickup();
                        SecondThirdPosition();
                        PickupSecond();
                        break;
                    case Two:
                        SecondPosition();
                        Pickup();
                        SecondThirdPosition();
                        PickupSecond();

                        break;
                    case Three:
                        ThirdPosition();
                        Pickup();
                        SecondThirdPosition();
                        PickupSecond();

                        //ThirdPosition();
                        //Pickup();
                        break;
                    case Reading:
                        ThirdPosition();
                        Pickup();
                        SecondThirdPosition();
                        PickupSecond();
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
    public void PickupSecond(){
        autoNav.AddTask(new ArmTask(1000, RobotConfig.intakeSpeed));
        autoNav.AddTask(new MovementTask((long) (200/speed), -90, 0, speed));
        //autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.intake, RobotConfig.intakeSpeed));
        autoNav.AddTask(new MovementTask((long) (1500/speed), -10, 0, speed));

  }
    public void Pickup(){
        autoNav.AddTask(new MovementTask((long) (200/speed), -90, 0, speed));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.intake, RobotConfig.intakeSpeed));
        autoNav.AddTask(new MovementTask((long) (1300/speed), -10, 0, speed));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, RobotConfig.intakeSpeed));
        autoNav.AddTask(new MovementTask((long) (200/speed), 90, 0, -speed));

        autoNav.AddTask(new MovementTask((long) (1300/speed), 0, 0, -speed));
    }

    public void Park() {

    }

    public void FirstPosition() {
        autoNav.AddTask(new ArmTask(null, RobotConfig.intakeSpeed));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, null));

        autoNav.AddTask(new MovementTask((long) (900), 90, 1f, 1f));

        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask((long) (500/speed), 90, 0, speed));
        autoNav.AddTask(new MovementTask((long) (150/speed), 0, 0, speed));

        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, 0.0));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(1000));

        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));

        autoNav.AddTask(new MovementTask((long) (150/speed), 0, 0, -speed));
        autoNav.AddTask(new MovementTask((long) (500/speed), 90, 0, -speed));
        autoNav.AddTask(new MovementTask((long) (900), 90, 1f, -1f));

    }

    public void SecondPosition() {
        autoNav.AddTask(new ArmTask(null, RobotConfig.intakeSpeed));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, null));


        autoNav.AddTask(new MovementTask((long) (900), 90, 1f, 1f));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask((long) (500/speed), 90, 0, speed));
        autoNav.AddTask(new MovementTask((long) (225/speed), 0, 0, speed));

        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, 0.0));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(1000));

        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));

        autoNav.AddTask(new MovementTask((long) (225/speed), 0, 0, -speed));
        autoNav.AddTask(new MovementTask((long) (500/speed), 90, 0, -speed));
        autoNav.AddTask(new MovementTask((long) (900), 90, 1f, -1f));

    }

    public void ThirdPosition() {
        autoNav.AddTask(new ArmTask(null, RobotConfig.intakeSpeed));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, null));


        autoNav.AddTask(new MovementTask((long) (900), 90, 1f, 1f));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask((long) (400/speed), 90, 0, speed));
        autoNav.AddTask(new MovementTask((long) (430/speed), 0, 0, speed));

        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));

        autoNav.AddTask(new MovementTask((long) (430/speed), 0, 0, -speed));
        autoNav.AddTask(new MovementTask((long) (375/speed), 90, 0, -speed));
        autoNav.AddTask(new MovementTask((long) (900), 90, 1f, -1f));

        //autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, RobotConfig.outtakeSpeed));
        //autoNav.AddTask(new MovementTask(500,-90, 1f, 0.5f));
    }

    public void SecondThirdPosition() {
        autoNav.AddTask(new ArmTask(null, RobotConfig.intakeSpeed));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, null));


        autoNav.AddTask(new MovementTask((long) (900), 90, 1f, 1f));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask((long) (375/speed), 90, 0, speed));
        autoNav.AddTask(new MovementTask((long) (450/speed), 0, 0, speed));

        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(1000));

        autoNav.AddTask(new MovementTask((long) (450/speed), 0, 0, -speed));
        autoNav.AddTask(new MovementTask((long) (375/speed), 90, 0, -speed));
        autoNav.AddTask(new MovementTask((long) (900), 90, 1f, -1f));

        //autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, RobotConfig.outtakeSpeed));
        //autoNav.AddTask(new MovementTask(500,-90, 1f, 0.5f));
    }
    @Override
    public RobotSide GetSide() {
        return RobotSide.Blue;
    }
}
