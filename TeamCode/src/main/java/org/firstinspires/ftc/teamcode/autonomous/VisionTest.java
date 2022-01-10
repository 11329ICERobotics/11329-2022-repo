package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ReadBarcodeTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

@Autonomous(name="Vision Testing (DO NOT RUN)", group="Testing")
public class VisionTest extends AutoBase {

    @Override
    public void Run() {
        autoNav.AddTask(new ReadBarcodeTask());

        telemetry.log().add("what did we see?");
        telemetry.log().add(autoNav.computerVision.GetBarcodeStatus().toString());
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Blue;
    }
}
