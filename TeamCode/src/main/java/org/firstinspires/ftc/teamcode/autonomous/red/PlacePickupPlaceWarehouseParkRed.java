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
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.toDistanceTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;
//LAST ON XPosition was commented (Done, not tuned)
@Autonomous(name="Place, Pickup Another, and Warehouse Park Red", group="Red")
public class PlacePickupPlaceWarehouseParkRed extends AutoBase {
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
                        removeElementOne();
                        FirstPosition();
                        Pickup();
                        FinalThirdPosition();
                        //dropNewFreightAndPark();
                        break;
                    case Two:
                        removeElement();
                        SecondPosition();
                        Pickup();
                        FinalThirdPosition();
                        //dropNewFreightAndPark();
                        break;
                    case Three:
                        removeElement();
                        ThirdPosition();
                        Pickup();
                        FinalThirdPosition();
                        //dropNewFreightAndPark();
                        break;
                }

                Park();
            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });



    }
    public void removeElement(){
        autoNav.AddTask(new ArmTask(1000, null));
        //autoNav.AddTask(new MovementTask(1500,-90, 0, -0.5f));
        autoNav.AddTask(new MovementTask(2500, -90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1300, 90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1900,1, -0.5f));
    }
    public void removeElementOne(){
        autoNav.AddTask(new ArmTask(1000, null));
        //autoNav.AddTask(new MovementTask(1500,-90, 0, -0.5f));
        autoNav.AddTask(new MovementTask(300, 0, 0, 0.75f));

        autoNav.AddTask(new MovementTask(2500, -90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1300, 90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(300, 0, 0, -0.75f));

        autoNav.AddTask(new MovementTask(0,1, -1f));
    }


    public void Park() {
        telemetry.log().add("started PARK");
        autoNav.AddTask(new ArmTask(1000, null));
        autoNav.AddTask(new MovementTask(1125,1, 0.8f));
        //autoNav.AddTask(new MovementTask(1500,-90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(2000, 0, 0, 1f));
        /*autoNav.AddTask(new MovementTask(1300, 90, 0, 0.5f));

        // Park

        autoNav.AddTask(new MovementTask(2000, 10, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1850, -90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1000, 0, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1250,1, 0.5f));
        autoNav.AddTask(new MovementTask(1250, -90, 0, 0.5f));*/
    }
    public void PosOnePark() {
        telemetry.log().add("started PARK");
        autoNav.AddTask(new ArmTask(1000, null));
        autoNav.AddTask(new MovementTask(0,1, 0.8f));
        autoNav.AddTask(new MovementTask(1500,90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(2000, 0, 0, 0.75f));
        /*autoNav.AddTask(new MovementTask(1300, 90, 0, 0.5f));

        // Park

        autoNav.AddTask(new MovementTask(2000, 10, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1850, -90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1000, 0, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1250,1, 0.5f));
        autoNav.AddTask(new MovementTask(1250, -90, 0, 0.5f));*/
    }
    public void Pickup() {
        telemetry.log().add("started PICKUP");
        autoNav.AddTask(new ArmTask(1200, null));
        autoNav.AddTask(new MovementTask(1900,1, 0.5f));
        autoNav.AddTask(new MovementTask(1500, 90, 0, 0.5f));

        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.intake, RobotConfig.intakeSpeed));
        //autoNav.AddTask(new toDistanceTask(50, 1f));
        autoNav.AddTask(new MovementTask(1400, 10, 0, 1f));
        autoNav.AddTask(new ArmTask(1200, RobotConfig.intakeSpeed));
        autoNav.AddTask(new toDistanceTask(100, 0.5f));
        autoNav.AddTask(new MovementTask(550, 170, 0, 1f));

        //Get ready to place again

        autoNav.AddTask(new ArmTask(1200, null));
        autoNav.AddTask(new MovementTask(1200, -90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1500,1, -0.6f));
    }

    public void FirstPosition() {
        telemetry.log().add("started FIRST");
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, RobotConfig.intakeSpeed));
        //autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(275, 0, 0, 0.5f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontThird, 0.0));
        autoNav.AddTask(new MovementTask(600, 180, 0, 0.5f)); //0050
        //autoNav.AddTask(new MovementTask(2850, -90, 0, 0.5f));
    }

    public void SecondPosition() {
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, RobotConfig.intakeSpeed));
        //autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(475, 0, 0, 0.5f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontSecond, 0.0));
        autoNav.AddTask(new MovementTask(325, 180, 0, 0.55f));
        //autoNav.AddTask(new MovementTask(2850, -90, 0, 0.5f));
    }

    public void ThirdPosition() {
        telemetry.log().add("started THIRD");
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, RobotConfig.intakeSpeed));
        //autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(800, 0, 0, 0.5f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));
        autoNav.AddTask(new MovementTask(600, 180, 0, 0.5f));
        //autoNav.AddTask(new MovementTask(2850, -90, 0, 0.5f));
    }
    public void FinalThirdPosition() {
        telemetry.log().add("started FINAL THIRD");
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, RobotConfig.intakeSpeed));
        //autoNav.AddTask(new WaitTask(500));
        autoNav.AddTask(new ArmTask(null, 0.0));
        autoNav.AddTask(new MovementTask(900, 0, 0, 0.5f));
        //autoNav.AddTask(new MovementTask(50, 0, 10, 0.5f));
        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, -RobotConfig.outtakeSpeed));
        autoNav.AddTask(new WaitTask(2000));
        //autoNav.AddTask(new MovementTask(50, 0, 10, 0.5f));

        autoNav.AddTask(new ArmTask(RobotConfig.ArmPresets.frontFirst, 0.0));
        autoNav.AddTask(new MovementTask(500, 180, 0, 1f));
        //autoNav.AddTask(new MovementTask(2850, -90, 0, 0.5f));    }
    }
    @Override
    public RobotSide GetSide() {
        return RobotSide.Red;
    }
}
