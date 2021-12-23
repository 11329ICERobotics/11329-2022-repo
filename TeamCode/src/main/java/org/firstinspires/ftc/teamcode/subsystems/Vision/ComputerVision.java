package org.firstinspires.ftc.teamcode.subsystems.Vision;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.firstinspires.ftc.teamcode.utilities.di.DiInterfaces;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;

public class ComputerVision implements DiInterfaces.IInitializable, DiInterfaces.ITickable, DiInterfaces.IDisposable {
    @DiContainer.Inject
    public WebcamName webcamName;

    @DiContainer.Inject
    public BarcodePipeline barcodePipeline;

    @DiContainer.Inject(id="cameraMonitorViewId")
    public int cameraMonitorViewId;

    OpenCvWebcam webcam;

    boolean webcamReady = false;

    boolean readBarcode = true;
    BarcodePipeline.Position position = BarcodePipeline.Position.Reading;

    @Override
    public void Initialize() {
        webcam = OpenCvCameraFactory.getInstance().createWebcam(webcamName, cameraMonitorViewId);

        webcam.setPipeline(barcodePipeline);

        webcam.setMillisecondsPermissionTimeout(4000);
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(640, 480, OpenCvCameraRotation.UPRIGHT);

                webcamReady = true;
            }

            @Override
            public void onError(int errorCode) {

            }
        });
    }

    @Override
    public void Tick() {
        if (readBarcode) position = barcodePipeline.position;
    }

    @Override
    public void Dispose() {
        webcam.stopStreaming();
    }

    public boolean IsCameraReady() {
        return webcamReady;
    }

    public BarcodePipeline.Position GetBarcodeStatus() {
        return position;
    }

    public void Read(boolean enable) {
        readBarcode = enable;
    }
}
