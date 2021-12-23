package org.firstinspires.ftc.teamcode.subsystems.Vision;

import org.firstinspires.ftc.teamcode.utilities.RobotSide;
import org.firstinspires.ftc.teamcode.utilities.di.DiContainer;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class BarcodePipeline extends OpenCvPipeline {
    public enum Position {
        Reading,
        One,
        Two,
        Three
    }

    public Position position = Position.Reading;

    @DiContainer.Inject
    public RobotSide side;

    @Override
    public Mat processFrame(Mat input) {
        // Imgproc

        return input;
    }
}
