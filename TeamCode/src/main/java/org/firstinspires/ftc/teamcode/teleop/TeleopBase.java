package org.firstinspires.ftc.teamcode.teleop;

import org.firstinspires.ftc.teamcode.commands.manipulators.TeleopCapper;
import org.firstinspires.ftc.teamcode.subsystems.ColorSensor.pickupDetection;
import org.firstinspires.ftc.teamcode.utilities.OpModeBase;
import org.firstinspires.ftc.teamcode.commands.drivetrain.TeleopDrive;
import org.firstinspires.ftc.teamcode.commands.manipulators.TeleopArm;
import org.firstinspires.ftc.teamcode.commands.manipulators.TeleopDuckSpinner;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

import java.lang.reflect.InvocationTargetException;

public abstract class TeleopBase extends OpModeBase {

    @Override
    public void InstallLower() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Container.BindInstance(gamepad1).WithId("gamepad1");
        Container.BindInstance(gamepad2).WithId("gamepad2");

        Container.Bind(TeleopDrive.class).AsSingle();
        Container.Bind(TeleopArm.class).AsSingle();
        Container.Bind(TeleopDuckSpinner.class).AsSingle();
        //Container.Bind(TeleopCapper.class).AsSingle();
    }
}
