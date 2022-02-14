package org.firstinspires.ftc.teamcode.subsystems.ColorSensor;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.subsystems.ColorSensor.ColorSensorCalibration;
import org.firstinspires.ftc.teamcode.subsystems.ColorSensor.freightType;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;

public class pickupDetection implements DiInterfaces.IInitializable , DiInterfaces.IDisposable, DiInterfaces.ITickable{
    @DiContainer.Inject(id="freightSensor")
    public RevColorSensorV3 freightColorSensor;

    @DiContainer.Inject(id="gamepad1")
    public Gamepad gamepad1;

    @DiContainer.Inject
    public Telemetry telemetry;
    @DiContainer.Inject(id="LEDLights")
    public RevBlinkinLedDriver leds;

    public ColorSensorCalibration colorSensor1Calibration = new ColorSensorCalibration();
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

    public int PrintSensorOutputRed() { return freightColorSensor.red();}
    public int PrintSensorOutputGreen() { return freightColorSensor.green();}
    public int PrintSensorOutputBlue() { return freightColorSensor.blue();}
    @Override
    public void Tick() {
        //telemetry.log().add("Colors be sensing");

        freightPresent = currentFreightCarried();

        telemetry.addData("Present Freight:", freightPresent);


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
