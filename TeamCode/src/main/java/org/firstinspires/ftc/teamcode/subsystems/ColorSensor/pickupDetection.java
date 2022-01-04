package org.firstinspires.ftc.teamcode.subsystems.ColorSensor;

import com.qualcomm.hardware.rev.RevColorSensorV3;

import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class pickupDetection implements DiInterfaces.IInitializable , DiInterfaces.IDisposable{
    @DiContainer.Inject(id="colorSensor")
    public RevColorSensorV3 freightColorSensor;

    public ColorSensorCalibration colorSensor1Calibration;
    public static freightType freightPresent = freightType.Absent;

    public freightType currentFreightCarried(){
        freightPresent = colorSensor1Calibration.isFreightPresent(freightColorSensor.red(), freightColorSensor.green(), freightColorSensor.blue());
        return freightPresent;
    }

    @Override
    public void Initialize() {

    }

    @Override
    public void Dispose() {

    }
}
