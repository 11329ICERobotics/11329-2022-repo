package org.firstinspires.ftc.teamcode.commands.manipulators;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.manipulators.DuckSpinner;
import org.firstinspires.ftc.teamcode.RobotConfig;
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
    public Telemetry telemetry;

    @Override
    public void Tick() {
        boolean spin = gamepad1.circle;

        telemetry.addData("TeleopDuckSpinner Status", "Spinning?: " + spin);

        duckSpinner.Spin(spin);
    }
}