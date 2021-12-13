package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.OpModeBase;
import org.firstinspires.ftc.teamcode.commands.drivetrain.AutoDrive;
import org.firstinspires.ftc.teamcode.commands.manipulators.AutoArm;
import org.firstinspires.ftc.teamcode.commands.manipulators.AutoDuckSpinner;

import java.lang.reflect.InvocationTargetException;

public abstract class AutoBase extends OpModeBase {
    // PLS IMPLEMENT A PROPER PARSER SO THAT WAY YESN'T PAIN
    //public abstract void Run();

    public AutoDrive autoDrive;
    public AutoArm autoArm;
    public AutoDuckSpinner autoDuckSpinner;

    @Override
    public void InstallLower() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        autoDrive = (AutoDrive) Container.Instantiate(AutoDrive.class);
        autoArm = (AutoArm) Container.Instantiate(AutoArm.class);
        autoDuckSpinner = (AutoDuckSpinner) Container.Instantiate(AutoDuckSpinner.class);
    }
}
