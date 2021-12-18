package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name="poggers")
public class Test extends OpMode {

    @Override
    public void init() {
        String audioClip = "funny";//(int) (Math.floor(Math.random() * funnies.length) + 1)];
        SoundPlayer.getInstance().setMasterVolume(1);
        SoundPlayer.getInstance().preload(hardwareMap.appContext, hardwareMap.appContext.getResources().getIdentifier(audioClip, "raw", hardwareMap.appContext.getPackageName()));

    }
    @Override
    public void start() {
        String audioClip = "funny";//(int) (Math.floor(Math.random() * funnies.length) + 1)];
        SoundPlayer.getInstance().setMasterVolume(1);
        SoundPlayer.getInstance().startPlaying(hardwareMap.appContext, hardwareMap.appContext.getResources().getIdentifier(audioClip, "raw", hardwareMap.appContext.getPackageName()));

    }

    @Override
    public void loop() {

    }
}
