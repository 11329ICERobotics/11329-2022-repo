package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.ftccommon.SoundPlayer;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.subsystems.Vision.BarcodePipeline;
import org.firstinspires.ftc.teamcode.subsystems.Vision.ComputerVision;
import org.firstinspires.ftc.teamcode.utilities.OpModeBase;
import org.firstinspires.ftc.teamcode.commands.autonav.AutoNav;
import org.firstinspires.ftc.teamcode.utilities.RobotSide;

import java.lang.reflect.InvocationTargetException;

public abstract class AutoBase extends OpModeBase {
    // PLS IMPLEMENT A PROPER PARSER SO THAT WAY YESN'T PAIN
    public abstract void Run();

    public AutoNav autoNav;

    public int audioClipID;

    @Override
    public void InstallLower() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Container.Bind(AutoNav.class).AsSingle();

        audioClipID = hardwareMap.appContext.getResources().getIdentifier("funny", "raw", hardwareMap.appContext.getPackageName());
        //SoundPlayer.getInstance().setMasterVolume(1);
        SoundPlayer.getInstance().preload(hardwareMap.appContext, audioClipID);

        //if (GetSide() == RobotSide.Red) Container.BindInstance(hardwareMap.get(WebcamName.class, "redCamera"));
        //else Container.BindInstance(hardwareMap.get(WebcamName.class, "blueCamera"));
        //Container.BindInstance(hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName())).WithId("cameraMonitorViewId");

        //Container.Bind(BarcodePipeline.class).AsSingle();

        //Container.Bind(ComputerVision.class).AsSingle();

        autoNav = (AutoNav) Container.Resolve(AutoNav.class);

        //autoNav = (AutoNav) Container.Instantiate(AutoNav.class);

        //Run();
    }

    @Override
    public void start() {
        //audioClipID = hardwareMap.appContext.getResources().getIdentifier("funny", "raw", hardwareMap.appContext.getPackageName());
        //SoundPlayer.getInstance().setMasterVolume(1);
        SoundPlayer.getInstance().startPlaying(hardwareMap.appContext, audioClipID);

        Run();
    }
}
