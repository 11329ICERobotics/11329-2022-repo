package org.firstinspires.ftc.teamcode.commands.manipulators;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.manipulators.Arm;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class TeleopArm implements DiInterfaces.ITickable {
    @DiContainer.Inject()
    public Arm arm;

    @DiContainer.Inject(id="gamepad1")
    public Gamepad gamepad1;

    @DiContainer.Inject(id="gamepad2")
    public Gamepad gamepad2;

    @Override
    public void Tick() {
        arm.Run(gamepad2.right_stick_y, (gamepad2.left_trigger - gamepad2.right_trigger));
    }
}