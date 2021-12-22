package org.firstinspires.ftc.teamcode.autonomous.red;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.autonomous.AutoBase;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.CustomTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.DuckSpinTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.MovementTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.WaitTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

@Autonomous(name="Duck Spin With Top Goal Place Red", group="Red")
public class DuckSpinWithTopGoalPlace extends AutoBase {
    @Override
    public void Run() {
        autoNav.AddTask(new CustomTask() {
            @Override
            public void begin() {
                //autoNav.arm.RunArmPower(0.5);
                autoNav.arm.RunIntake(-1);
            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });
        autoNav.AddTask(new WaitTask(1600));
        autoNav.AddTask(new CustomTask() {
            @Override
            public void begin() {
                //autoNav.arm.RunArmPower(0);
                autoNav.arm.RunIntake(0);
            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });

        autoNav.AddTask(new MovementTask(2000, -90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1100, 0, 0, 0.25f));

        autoNav.AddTask(new CustomTask() {
            @Override
            public void begin() {
                autoNav.arm.RunIntake(RobotConfig.outtakeSpeed);
            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });
        autoNav.AddTask(new WaitTask(1500));
        autoNav.AddTask(new CustomTask() {
            @Override
            public void begin() {
                autoNav.arm.RunIntake(0);
            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });

        autoNav.AddTask(new MovementTask(1100, 180, 0, 0.25f));

        autoNav.AddTask(new CustomTask() {
            @Override
            public void begin() {
                //autoNav.arm.RunArmPower(-0.5);
            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });
        autoNav.AddTask(new WaitTask(900));
        autoNav.AddTask(new CustomTask() {
            @Override
            public void begin() {
                //autoNav.arm.RunArmPower(0);
            }

            @Override
            public boolean execute() { return true; }

            @Override
            public void stop() { }
        });

        autoNav.AddTask(new MovementTask(2250, 90, 0, 0.5f));

        //Duck Code
        autoNav.AddTask(new MovementTask(3400, 260, -0.5f, 0.25f));
        autoNav.AddTask(new MovementTask(900, 180, 0, 0.25f));
        autoNav.AddTask(new DuckSpinTask(true));
        autoNav.AddTask(new MovementTask(RobotConfig.msForOneDuckSpin, 180, 0, 0.0f));
        autoNav.AddTask(new DuckSpinTask(false));
        autoNav.AddTask(new MovementTask(900, 0, 0, 0.5f));
        autoNav.AddTask(new MovementTask(500, 270, 0, 0.5f));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Red;
    }
}
