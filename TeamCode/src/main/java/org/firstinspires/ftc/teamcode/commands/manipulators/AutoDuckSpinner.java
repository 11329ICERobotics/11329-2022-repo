package org.firstinspires.ftc.teamcode.commands.manipulators;

import org.firstinspires.ftc.teamcode.subsystems.manipulators.DuckSpinner;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;

public class AutoDuckSpinner {
    @DiContainer.Inject()
    public DuckSpinner duckSpinner;

    @DiContainer.Inject()
    public RobotSide side;
}
