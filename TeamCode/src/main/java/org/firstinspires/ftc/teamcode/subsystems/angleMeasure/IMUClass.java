package org.firstinspires.ftc.teamcode.subsystems.angleMeasure;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class IMUClass implements DiInterfaces.IInitializable, DiInterfaces.IDisposable, DiInterfaces.ITickable {
    @DiContainer.Inject()
    Telemetry telemetry;
    // State used for updating telemetry
    Orientation angles;
    Acceleration gravity;

    // The IMU sensor object
    @DiContainer.Inject(id="IMU")
    BNO055IMU imu;

    @Override
    public void Initialize() {

    }

    @Override
    public void Tick() {
        telemetry.addData("Angle:", imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES));
    }

    @Override
    public void Dispose() {

    }
}
