package org.firstinspires.ftc.teamcode.subsystems.Distance;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class DistanceDisplay implements DiInterfaces.IInitializable , DiInterfaces.IDisposable, DiInterfaces.ITickable{

    @DiContainer.Inject(id="distanceSensor")
    public Rev2mDistanceSensor distanceSensor;

    @DiContainer.Inject()
    public Telemetry telemetry;

    @Override
    public void Initialize() {

    }

    @Override
    public void Tick() {
        telemetry.addData("Distance:", distanceSensor.getDistance(DistanceUnit.CM));
    }

    @Override
    public void Dispose() {

    }
}
