package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.autonav.tasks.CustomTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ReadBarcodeTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.toDistanceTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

@Autonomous(name="distance Testing (DO NOT RUN)", group="Testing")
public class distanceTest extends AutoBase {

    @Override
    public void Run() {
        autoNav.AddTask(new toDistanceTask(100, 0.1));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Blue;
    }
}
