package org.firstinspires.ftc.teamcode.subsystems.ColorSensor;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.hardware.rev.RevColorSensorV3;

import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class pickupDetection implements DiInterfaces.IInitializable , DiInterfaces.IDisposable, DiInterfaces.ITickable{
    @DiContainer.Inject(id="freightSensor")
    public RevColorSensorV3 freightColorSensor;

    @DiContainer.Inject(id="LEDLights")
    public RevBlinkinLedDriver leds;

    public ColorSensorCalibration colorSensor1Calibration;
    public freightType freightPresent = freightType.Block;
    public RevBlinkinLedDriver.BlinkinPattern pattern;

    public freightType currentFreightCarried(){
        return colorSensor1Calibration.isFreightPresent(freightColorSensor.red(), freightColorSensor.green(), freightColorSensor.blue());
    }

    @Override
    public void Initialize() {

    }

    @Override
    public void Dispose() {

    }

    @Override
    public void Tick() {
        freightPresent = currentFreightCarried();
        if(freightPresent == freightType.Absent){
            pattern = RobotConfig.absentPattern;
        }
        if(freightPresent == freightType.Block){
            pattern = RobotConfig.blockPattern;
        }
        if(freightPresent == freightType.Ball){
            pattern = RobotConfig.ballPattern;
        }
        if(freightPresent == freightType.Duck){
            pattern = RobotConfig.duckPattern;
        }
        leds.setPattern(pattern);
    }
}
