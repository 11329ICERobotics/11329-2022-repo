package org.firstinspires.ftc.teamcode.commands.autonav.tasks;

import org.firstinspires.ftc.teamcode.commands.autonav.Task;

public class ReadBarcodeTask extends Task {
    long millis = 500;

    long endTime = 0;

    boolean hasWebcamInited = false;

    public ReadBarcodeTask() {

    }

    @Override
    public void Begin() {
        computerVision.Read(true);
    }

    @Override
    public boolean Execute() {
        if (computerVision.IsCameraReady() && !hasWebcamInited) {
            endTime = System.currentTimeMillis() + millis;
            hasWebcamInited = true;
        }

        return (endTime < System.currentTimeMillis()) && hasWebcamInited;
    }

    @Override
    public void Stop() {
        computerVision.Read(false);
    }

    @Override
    public ETA GetETA() {
        return new ETA(endTime - millis, System.currentTimeMillis(), endTime);
    }
}
