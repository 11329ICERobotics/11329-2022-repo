package org.firstinspires.ftc.teamcode.commands.manipulators;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.manipulators.DuckSpinner;
import org.firstinspires.ftc.teamcode.utilities.RobotConfig;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class TeleopDuckSpinner implements DiInterfaces.ITickable {
    @DiContainer.Inject()
    public DuckSpinner duckSpinner;

    @DiContainer.Inject(id="gamepad1")
    public Gamepad gamepad1;

    @DiContainer.Inject(id="gamepad2")
    public Gamepad gamepad2;

    @DiContainer.Inject()
    public RobotSide side;

    @Override
    public void Tick() {
        double spinnerSpeed = ((side == RobotSide.RED) ? -RobotConfig.spinnerSpeed : RobotConfig.spinnerSpeed);
        duckSpinner.Spin((gamepad1.circle ? spinnerSpeed : 0) + (gamepad1.cross ? -spinnerSpeed : 0));
    }
}