package org.firstinspires.ftc.teamcode.autonomous.blue;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.autonomous.AutoBase;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.CustomTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.DuckSpinTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.MovementTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.WaitTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

@Autonomous(name="Duck Spin Blue", group="Blue")
public class DuckSpin extends AutoBase {
    @Override
    public void Run() {
        autoNav.AddTask(new CustomTask() {
            @Override
            public void begin() {
                autoNav.arm.RunArmPower(0.5);
            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });
        autoNav.AddTask(new WaitTask(750));
        autoNav.AddTask(new CustomTask() {
            @Override
            public void begin() {
                autoNav.arm.RunArmPower(0);
            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });
        autoNav.AddTask(new MovementTask(1700, 260, -0.5f, 0.25f));
        autoNav.AddTask(new MovementTask(1000, 180, 0, 0.25f));
        autoNav.AddTask(new DuckSpinTask(true));
        autoNav.AddTask(new MovementTask(RobotConfig.msForOneDuckSpin, 180, 0, 0.02f));
        autoNav.AddTask(new DuckSpinTask(false));
        autoNav.AddTask(new MovementTask(1000, 0, 0, 0.25f));
        autoNav.AddTask(new MovementTask(1700, 260, -0.5f, 0.25f));
        autoNav.AddTask(new MovementTask(1000, 0, 0, 0.5f));
        autoNav.AddTask(new MovementTask(500, 180, 0, 0.5f));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Blue;
    }
}
