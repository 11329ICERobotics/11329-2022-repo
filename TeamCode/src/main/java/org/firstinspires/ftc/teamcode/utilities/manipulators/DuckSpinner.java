package org.firstinspires.ftc.teamcode.utilities.manipulators;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;
import org.firstinspires.ftc.teamcode.utilities.RobotConfig;

public class DuckSpinner implements DiInterfaces.IInitializable, DiInterfaces.ITickable, DiInterfaces.IDisposable {
    @DiContainer.Inject(id="spinnerMotor")
    public DcMotor spinnerMotor;

    @DiContainer.Inject(id="gamepad1")
    public Gamepad gamepad1;

    @DiContainer.Inject(id="gamepad2")
    public Gamepad gamepad2;

    @Override
    public void Initialize() {
        spinnerMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        spinnerMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void Tick() {
        spinnerMotor.setPower(((gamepad1.circle || gamepad2.circle) ? -RobotConfig.spinnerSpeed : 0));
    }

    @Override
    public void Dispose() {
        spinnerMotor.setPower(0);
    }
}