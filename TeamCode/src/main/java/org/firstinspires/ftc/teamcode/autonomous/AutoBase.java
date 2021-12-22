package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.ftccommon.SoundPlayer;

import org.firstinspires.ftc.teamcode.utilities.OpModeBase;
import org.firstinspires.ftc.teamcode.commands.autonav.AutoNav;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

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
