package org.firstinspires.ftc.teamcode.autonomous.blue;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.autonomous.AutoBase;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ArmTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.CappingTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.CustomTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.DuckSpinTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.MovementTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ReadBarcodeTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.ReleaseIntakeTask;
import org.firstinspires.ftc.teamcode.commands.autonav.tasks.WaitTask;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

@Autonomous(name="Capper TEST (DO NOT RUN)", group="Red")
public class DuckSpinStorageBlueTwo extends AutoBase {
    @Override
    public void Run() {
        autoNav.AddTask(new CappingTask(0.679, 39090, -0.1, 1000));
    }



    @Override
    public RobotSide GetSide() {
        return RobotSide.Red;
    }
}
