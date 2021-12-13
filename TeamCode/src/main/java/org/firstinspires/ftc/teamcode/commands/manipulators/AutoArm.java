package org.firstinspires.ftc.teamcode.commands.manipulators;

import org.firstinspires.ftc.teamcode.subsystems.manipulators.Arm;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;

public class AutoArm {
    @DiContainer.Inject()
    public Arm arm;
}
