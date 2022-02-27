package org.firstinspires.ftc.teamcode.teleop;
/*
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ReadWriteFile;


import org.firstinspires.ftc.robotcore.internal.system.AppUtil;
import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.subsystems.ColorSensor.ColorSensorCalibration;


import java.io.File;

@TeleOp(name = "Calibration")
public class Calibration extends LinearOpMode {

    RevColorSensorV3 freightSensor;

    ColorSensorCalibration colorSensor1Calibration;

    boolean pushingA = false;
    boolean pushingB = false;

    @Override
    public void runOpMode() {

        freightSensor = hardwareMap.get(RevColorSensorV3.class, "freightSensor");

        colorSensor1Calibration = new ColorSensorCalibration();




        while (opModeIsActive()) {
            if(gamepad1.dpad_up){
                colorSensor1Calibration.setPresentDuckRGB(freightSensor.red(), freightSensor.green(), freightSensor.blue());

            }
            if (gamepad1.a) {
                    colorSensor1Calibration.setPresentBallRGB(freightSensor.red(), freightSensor.green(), freightSensor.blue());
            }

            if (gamepad1.b) {
                if (!pushingB) {
                    writeFile(RobotConfig.colorSensor1ConfigFileName, colorSensor1Calibration.serialize());
                    }
                pushingB = true;
            } else pushingB = false;

            if (gamepad1.x) {
                colorSensor1Calibration.setAbsentRGB(freightSensor.red(), freightSensor.green(), freightSensor.blue());
                }

            if (gamepad1.y) {
                colorSensor1Calibration.setPresentBlockRGB(freightSensor.red(), freightSensor.green(), freightSensor.blue());
                }

        }
    }

    void writeFile(String filename, String data) {
        File file = AppUtil.getInstance().getSettingsFile(filename);
        ReadWriteFile.writeFile(file, data);
        telemetry.log().add("saved: " + filename);
    }

}*/