package org.firstinspires.ftc.teamcode.subsystems.manipulators;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class DuckSpinner implements DiInterfaces.IInitializable, DiInterfaces.IDisposable {
    @DiContainer.Inject(id="spinnerMotor")
    public DcMotor spinnerMotor;

    @Override
    public void Initialize() {
        spinnerMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        spinnerMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void Dispose() {
        spinnerMotor.setPower(0);
    }

    public void Spin(double power) {
        spinnerMotor.setPower(power);
    }
}