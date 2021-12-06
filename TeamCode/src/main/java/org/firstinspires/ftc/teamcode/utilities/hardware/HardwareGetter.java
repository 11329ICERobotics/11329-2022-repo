package org.firstinspires.ftc.teamcode.utilities.hardware;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareGetter {
    public CRServo servo1;
    public CRServo servo2;

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public DcMotor armMotor;
    public DcMotor wristMotor;

    public DcMotor spinnerMotor;

    public HardwareGetter(HardwareMap hardwareMap) {
        servo1 = hardwareMap.get(CRServo.class, "servo1");
        servo2 = hardwareMap.get(CRServo.class, "servo2");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        wristMotor = hardwareMap.get(DcMotor.class, "wristMotor");

        spinnerMotor = hardwareMap.get(DcMotor.class, "spinnerMotor");
    }
}
