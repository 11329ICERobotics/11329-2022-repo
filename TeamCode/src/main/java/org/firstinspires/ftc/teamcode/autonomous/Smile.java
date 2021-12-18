package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.DuckSpinTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.MovementTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

@Autonomous(name="Smile", group="funny")
public class Smile extends AutoBase {
    @Override
    public void Run() {

    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Blue;
    }
}