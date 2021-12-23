package org.firstinspires.ftc.teamcode.commands.autonav;

import org.firstinspires.ftc.teamcode.subsystems.Vision.ComputerVision;

public abstract class Task {
    public abstract void Begin();
    public abstract boolean Execute();
    public abstract void Stop();
    public abstract ETA GetETA();
    public AutoNav autoNav;
    public ComputerVision computerVision;

    public class ETA {
        public double startTime;
        public double currentTime = 0;
        public double endTime = 0;
        public boolean hasEstimate = false;

        public ETA(double startTime, double currentTime, double endTime) {
            this.startTime = startTime;
            this.currentTime = currentTime;
            this.endTime = endTime;
            hasEstimate = true;
        }
        public ETA() {
            this.currentTime = 0;
            this.endTime = 0;
            hasEstimate = false;
        }

        public String FormatETA() {
            if (!hasEstimate) return "Unknown";

            double totalTime = endTime - startTime;
            double percent = -((endTime - currentTime) - totalTime) / totalTime;

            return (currentTime - startTime) + "/" + totalTime + " (" + percent + "%)";
        }
    }
}
