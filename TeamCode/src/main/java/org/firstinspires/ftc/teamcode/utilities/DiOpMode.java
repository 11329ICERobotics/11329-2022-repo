package org.firstinspires.ftc.teamcode.utilities;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;

import java.lang.reflect.InvocationTargetException;

public abstract class DiOpMode extends OpMode {
    public DiContainer Container;

    public abstract void Install() throws IllegalAccessException, InstantiationException, InvocationTargetException;

    @Override
    public void init() {
        try {
            Install();
        } catch (Exception e) {
            telemetry.log().add("Failed to Init, robot will die now");
            telemetry.log().add(e.toString());
        }

        Container.Initialize();
    }

    @Override
    public void loop() {
        Container.Tick();
    }

    @Override
    public void stop() {
        Container.Dispose();
    }
}
