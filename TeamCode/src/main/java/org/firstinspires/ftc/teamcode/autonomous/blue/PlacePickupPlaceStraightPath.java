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
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.toDistanceTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

//LAST ON XPosition was commented (Done, not tuned)
@Autonomous(name="Place, Pickup Another,Straight Blue ", group="Blue")
public class PlacePickupPlaceStraightPath extends AutoBase {
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
                        autoNav.AddTask(new MovementTask(300, 0, 0, 1f));
                        FirstPosition();
                        Pickup();
                        FinalThirdPosition();
                        Park();
                        //dropNewFreightAndPark();
                        break;
                    case Two:
                        autoNav.AddTask(new MovementTask(300, 0, 0, 1f));
                        SecondPosition();
                        Pickup();
                        FinalThirdPosition();
                        Park();
                        //dropNewFreightAndPark();
                        break;
                    case Three:
                        autoNav.AddTask(new MovementTask(550, 0, 0, 0.75f));
                        ThirdPosition();
                        SpecialPickup();
                        FinalThirdPosition();
                        SpecialPark();
                        //dropNewFreightAndPark();
                        break;
                    case Reading:
                        autoNav.AddTask(new MovementTask(300, 0, 0, 1f));
                        ThirdPosition();
                        Pickup();
                        FinalThirdPosition();
                        Park();
                        //dropNewFreightAndPark();
                        break;
                }

                //Park();
            }

            @Override
            public boolean execute() {
                return true;
            }

            @Override
            public void stop() {
            }
        });
    }
    public void SpecialPark(){
        autoNav.AddTask(new ArmTask(1000, null));

        autoNav.AddTask(new MovementTask(1000,-1, 1f));
        autoNav.AddTask(new MovementTask(450, -90, 0, 0.8f));
        autoNav.AddTask(new MovementTask(2500, 0, 0, 0.8f));
        //autoNav.AddTask(new MovementTask(1500, 0, 0, 1f));
    }
    public void Park() {
        telemetry.log().add("started PARK");
        autoNav.AddTask(new ArmTask(1000, null));
        /*autoNav.AddTask(new MovementTask(350,1, -1f));
        autoNav.AddTask(new MovementTask(1500, 180, 0, 1f));
        autoNav.AddTask(new MovementTask(500, 90, 0, 1f));
        autoNav.AddTask(new MovementTask(100, 90, 0, 1f));
        autoNav.AddTask(new MovementTask(700, 180, 0, 1f));*/
        //autoNav.AddTask(new MovementTask(500, 0, -1, 1f));
        //autoNav.AddTask(new MovementTask(1000, 0, 0, 0.5f));

        autoNav.AddTask(new MovementTask(1000,-1, 1f));
        autoNav.AddTask(new MovementTask(2500, 0, 0, 0.8f));
        //autoNav.AddTask(new MovementTask(1500, 0, 0, 1f));

    }
    public void FirstPosition() {
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, RobotConfig.intakeSpeed));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        //autoNav.AddTask(new MovementTask(150, 0, 0, 1f));
        autoNav.AddTask(new MovementTask(5700, -90, 0, 0.25f));

        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));


        autoNav.AddTask(new MovementTask(800, 90, 0, 1f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));
        autoNav.AddTask(new MovementTask(1200,-1, 1f));
        autoNav.AddTask(new MovementTask(1000, -90, 0, 1f));
        autoNav.AddTask(new MovementTask(350, 0, 0, 1f));
    }
    public void SecondPosition() {
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, RobotConfig.intakeSpeed));
        autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(5700, -90, 0, 0.25f));
        autoNav.AddTask(new MovementTask(250, 0, 0, 0.5f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));

        autoNav.AddTask(new MovementTask(300, 180, 0, 1f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));
        autoNav.AddTask(new MovementTask(800, 90, 0, 1f));
        autoNav.AddTask(new MovementTask(1200,-1, 1f));
        autoNav.AddTask(new MovementTask(1000, -90, 0, 1f));
    }

    public void ThirdPosition() {
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, RobotConfig.intakeSpeed));


        //autoNav.AddTask(new MovementTask(3150, 90, 0, 0.25f));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(5700, -90, 0, 0.25f));

        //autoNav.AddTask(new MovementTask(250, 0, 0, 1f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(1000));

        //autoNav.AddTask(new MovementTask(300, -180, 0, 1f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));
        autoNav.AddTask(new MovementTask(800, 90, 0, 1f));
        autoNav.AddTask(new MovementTask(1200,-1, 1f));
        autoNav.AddTask(new MovementTask(1000, -90, 0, 1f));
    }
    public void FinalThirdPosition() {
        telemetry.log().add("started FINAL THIRD");
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, RobotConfig.intakeSpeed));
        //autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(950, 0, 0, 0.5f));
        //autoNav.AddTask(new MovementTas/k(50, 0, 10, 0.5f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(1500));
        //autoNav.AddTask(new MovementTask(50, 0, 10, 0.5f));

        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));
        //autoNav.AddTask(new MovementTask(600, 180, 0, 1f));
        //autoNav.AddTask(new MovementTask(2850, -90, 0, 0.5f));    }
    }
    public void Pickup() {
        telemetry.log().add("started PICKUP");
        autoNav.AddTask(new ArmTask(1200, null));


        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.intake, RobotConfig.intakeSpeed));
        //autoNav.AddTask(new toDistanceTask(50, 1f));
        autoNav.AddTask(new MovementTask(1300, -10, 0, 0.8f));
        autoNav.AddTask(new ArmTask(1200, RobotConfig.intakeSpeed));
        //autoNav.AddTask(new WaitTask(2500));
        autoNav.AddTask(new toDistanceTask(100, 0.7f));

        autoNav.AddTask(new MovementTask(550, -170, 0, 1f));

        //Get ready to place again

        autoNav.AddTask(new ArmTask(1200, null));
        autoNav.AddTask(new MovementTask(1300, 90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(925,-1, -1f));
    }
    public void SpecialPickup() {
        telemetry.log().add("started PICKUP");
        autoNav.AddTask(new ArmTask(1200, null));


        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.intake, RobotConfig.intakeSpeed));
        //autoNav.AddTask(new toDistanceTask(50, 1f));
        autoNav.AddTask(new MovementTask(1400, -10, 0, 0.8f));
        autoNav.AddTask(new ArmTask(1200, RobotConfig.intakeSpeed));
        //autoNav.AddTask(new WaitTask(2500));
        autoNav.AddTask(new toDistanceTask(100, 0.7f));

        autoNav.AddTask(new MovementTask(550, -170, 0, 1f));

        //Get ready to place again

        autoNav.AddTask(new ArmTask(1200, null));
        autoNav.AddTask(new MovementTask(1300, 90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(925,-1, -1f));
    }
    public void PickupFar() {
        telemetry.log().add("started PICKUP");
        autoNav.AddTask(new ArmTask(1200, null));
        autoNav.AddTask(new MovementTask(850,1, 1f));
        autoNav.AddTask(new MovementTask(800, -90, 0, 1f));
        //autoNav.AddTask(new MovementTask(800, -90, 0, 1f));

        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.intake, RobotConfig.intakeSpeed));
        //autoNav.AddTask(new toDistanceTask(50, 1f));
        autoNav.AddTask(new MovementTask(1200, -10, 0, 1f));
        autoNav.AddTask(new ArmTask(1200, RobotConfig.intakeSpeed));
        autoNav.AddTask(new toDistanceTask(100, 0.5f));
        autoNav.AddTask(new MovementTask(550, -170, 0, 1f));

        //Get ready to place again

        autoNav.AddTask(new ArmTask(1200, null));
        autoNav.AddTask(new MovementTask(1300, 90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(900,-1, -1f));
    }



    @Override
    public RobotSide GetSide() {
        return RobotSide.Jank;
    }
}
