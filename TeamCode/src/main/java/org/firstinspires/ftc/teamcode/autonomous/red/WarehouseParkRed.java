package org.firstinspires.ftc.teamcode.autonomous.red;

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

@Autonomous(name="Warehouse Park Red", group="Red")
public class WarehouseParkRed extends AutoBase {
    @Override
    public void Run() {
        autoNav.AddTask(new MovementTask(500, 0, 0, 0.02f));
        autoNav.AddTask(new ReleaseIntakeTask(RobotConfig.msForReleaseIntake));
        autoNav.AddTask(new ArmTask(1000, null));
        autoNav.AddTask(new MovementTask(1900, 10, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1850, -90, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1000, 0, 0, 0.5f));
        autoNav.AddTask(new MovementTask(1250,1, 0.5f));
        autoNav.AddTask(new MovementTask(1250, -90, 0, 0.5f));
    }

    @Override
    public RobotSide GetSide() {
        return RobotSide.Red;
    }
}
