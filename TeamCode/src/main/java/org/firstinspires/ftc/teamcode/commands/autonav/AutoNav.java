package org.firstinspires.ftc.teamcode.commands.autonav;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Vision.ComputerVision;
import org.firstinspires.ftc.teamcode.subsystems.drivetrain.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.manipulators.Arm;
import org.firstinspires.ftc.teamcode.subsystems.manipulators.DuckSpinner;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

import java.util.ArrayList;
import java.util.List;

public class AutoNav implements DiInterfaces.IInitializable, DiInterfaces.ITickable, DiInterfaces.IDisposable {
    @DiContainer.Inject()
    public RobotSide side;

    @DiContainer.Inject()
    public Telemetry telemetry;

    @DiContainer.Inject()
    public Drivetrain drivetrain;

    @DiContainer.Inject()
    public Arm arm;

    @DiContainer.Inject()
    public DuckSpinner duckSpinner;

    //@DiContainer.Inject()
    public ComputerVision computerVision;

    //@DiContainer.Inject(id="leftDistance")
    //public Rev2mDistanceSensor leftDistance;

    @DiContainer.Inject(id="rightDistance")
    public Rev2mDistanceSensor rightDistance;

    @DiContainer.Inject(id="frontDistance")
    public Rev2mDistanceSensor frontDistance;

    @DiContainer.Inject(id="backDistance")
    public Rev2mDistanceSensor backDistance;

    private List<Task> tasks = new ArrayList<>();

    private boolean hasInitTask = false;
    private String currentTaskName = "Unknown";

    @Override
    public void Initialize() {
        //leftDistance.initialize();
        rightDistance.initialize();
        frontDistance.initialize();
        backDistance.initialize();
    }

    @Override
    public void Tick() {
        if (tasks.size() < 1) {
            telemetry.addData("Auto Status:", "Waiting for more tasks...");
            return;
        } else if (!hasInitTask) {
            tasks.get(0).Begin();
            currentTaskName = tasks.get(0).getClass().getName();
            hasInitTask = true;
        }

        telemetry.addData("Auto Status:", "Running " + currentTaskName + "\n ETA: " + tasks.get(0).GetETA().FormatETA());

        if (tasks.get(0).Execute()) {
            tasks.get(0).Stop();
            tasks.remove(0);
            hasInitTask = false;
            currentTaskName = "Unknown";
        }
    }

    @Override
    public void Dispose() {
        drivetrain.Stop();
        arm.Stop();
        duckSpinner.Stop();
    }

    public void AddTask(Task task) {
        task.autoNav = this;
        task.computerVision = computerVision;
        tasks.add(task);
    }
}
