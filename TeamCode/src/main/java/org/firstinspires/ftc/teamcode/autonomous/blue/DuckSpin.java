package org.firstinspires.ftc.teamcode.autonomous.blue;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.autonomous.AutoBase;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ArmTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.CustomTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.DuckSpinTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.MovementTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ReleaseIntakeTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.WaitTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

//@Autonomous(name="Duck Spin Blue", group="Blue")
public class DuckSpin extends AutoBase {
    @Override
    public void Run() {
        autoNav.AddTask(new ReleaseIntakeTask(RobotConfig.msForReleaseIntake));

        autoNav.AddTask(new ArmTask(1000, null));
        autoNav.AddTask(new MovementTask(3100, -35, 0, -0.25f));
        autoNav.AddTask(new MovementTask(1200, -90, 0, 0.25f));
        autoNav.AddTask(new DuckSpinTask(true));
        autoNav.AddTask(new MovementTask(RobotConfig.msForOneDuckSpin, -90, 0, 0.01f));
        autoNav.AddTask(new DuckSpinTask(false));
        autoNav.AddTask(new MovementTask(2200, 100, 0, 0.25f));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Blue;
    }
}
