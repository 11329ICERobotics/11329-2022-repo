package org.firstinspires.ftc.teamcode.autonomous.blue;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.autonomous.AutoBase;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.DuckSpinTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.MovementTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

@Autonomous(name="Duck Spin Blue", group="Blue")
public class DuckSpin extends AutoBase {
    @Override
    public void Run() {
        autoNav.AddTask(new MovementTask(1000, 180, 0, 0.5f));
        autoNav.AddTask(new DuckSpinTask(RobotConfig.msForOneDuckSpin));
        autoNav.AddTask(new MovementTask(1000, 90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(500, 180, 0, 0.5f));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Blue;
    }
}
