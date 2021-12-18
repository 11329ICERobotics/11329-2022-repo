package org.firstinspires.ftc.teamcode.autonomous.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.autonomous.AutoBase;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.DuckSpinTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.MovementTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

@Autonomous(name="Duck Spin Red", group="Red")
public class DuckSpin extends AutoBase {
    @Override
    public void Run() {
        autoNav.AddTask(new MovementTask(1200, 245, -0.85f, 0.5f));
        autoNav.AddTask(new DuckSpinTask(RobotConfig.msForOneDuckSpin));
        autoNav.AddTask(new MovementTask(1100, 0, 0, 0.5f));
        autoNav.AddTask(new MovementTask(500, 270, 0, 0.5f));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Red;
    }
}
