package org.firstinspires.ftc.teamcode.subsystems.manipulators;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class DuckSpinner implements DiInterfaces.IInitializable, DiInterfaces.IDisposable {
    @DiContainer.Inject(id="spinnerMotor")
    public DcMotorEx spinnerMotor;

    @DiContainer.Inject
    public RobotSide side;

    @Override
    public void Initialize() {
        spinnerMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        spinnerMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void Dispose() {
        spinnerMotor.setPower(0);
    }
    public void Spin(boolean run) {
        if (run) {
            if (side == RobotSide.Red) spinnerMotor.setPower(RobotConfig.spinnerSpeed);
            else if (side == RobotSide.Blue) spinnerMotor.setPower(-RobotConfig.spinnerSpeed);
        } else {
            spinnerMotor.setPower(0);
        }
    }

    public void Release(boolean run) {
        if (run) {
            spinnerMotor.setPower(-RobotConfig.spinnerSpeed);
        } else {
            spinnerMotor.setPower(0);
        }
    }

    public void Stop() {
        Spin(false);
    }
}