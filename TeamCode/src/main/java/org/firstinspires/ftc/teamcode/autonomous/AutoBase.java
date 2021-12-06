package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.AutoNav;
import org.firstinspires.ftc.teamcode.HardwareInterface;

import java.util.concurrent.Callable;

public abstract class AutoBase extends OpMode {
    public abstract void Run();

    HardwareInterface hardwareInterface;
    AutoNav autoNav;

    boolean opmodeActive = true;

    public Callable<Boolean> opModeActiveCallable = new Callable<Boolean>() {
        public Boolean call() {
            return opmodeActive;
        }
    };

    @Override
    public void init() {
        hardwareInterface = new HardwareInterface(hardwareMap);
        autoNav = new AutoNav(opModeActiveCallable, telemetry, hardwareInterface);
    }

    @Override
    public void start() {
        Run();
    }

    @Override
    public void loop() {}

    @Override
    public void stop() {
        opmodeActive = false;
    }
}
