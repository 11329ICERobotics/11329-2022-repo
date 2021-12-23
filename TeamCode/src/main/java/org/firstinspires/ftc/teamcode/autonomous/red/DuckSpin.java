package org.firstinspires.ftc.teamcode.autonomous.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.autonomous.AutoBase;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ArmTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.CustomTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.CustomTimedTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.DuckSpinTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.MovementTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.WaitTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

@Autonomous(name="Duck Spin Red", group="Red")
public class DuckSpin extends AutoBase {
    @Override
    public void Run() {
        autoNav.AddTask(new ArmTask(1000, null));
        autoNav.AddTask(new MovementTask(5000, 260, -0.5f, 0.25f));
        autoNav.AddTask(new MovementTask(1500, 180, 0, 0.25f));
        autoNav.AddTask(new DuckSpinTask(true));
        autoNav.AddTask(new MovementTask(RobotConfig.msForOneDuckSpin, 180, 0, 0.0f));
        autoNav.AddTask(new DuckSpinTask(false));
        autoNav.AddTask(new MovementTask(1250, 0, 0, 0.5f));
        autoNav.AddTask(new MovementTask(250, 270, 0, 0.5f));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Red;
    }
}
