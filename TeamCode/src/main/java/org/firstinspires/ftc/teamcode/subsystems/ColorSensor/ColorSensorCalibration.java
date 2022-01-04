package org.firstinspires.ftc.teamcode.subsystems.ColorSensor;

public class ColorSensorCalibration {
    public int absentRed = 0;
    public int absentGreen = 0;
    public int absentBlue = 0;

    public int presentBlockRed = 0;
    public int presentBlockGreen = 0;
    public int presentBlockBlue = 0;

    public int presentBallRed = 0;
    public int presentBallGreen = 0;
    public int presentBallBlue = 0;

    public int presentDuckRed = 0;
    public int presentDuckGreen = 0;
    public int presentDuckBlue = 0;

    public ColorSensorCalibration() {

    }

    public String serialize() {
        String csv = "";
        csv += "absentRed:" + absentRed + ",";
        csv += "absentGreen:" + absentGreen + ",";
        csv += "absentBlue:" + absentBlue + ",";
        csv += "presentBallRed:" + presentBallRed + ",";
        csv += "presentBallGreen:" + presentBallGreen + ",";
        csv += "presentBallBlue:" + presentBallBlue + ",";
        csv += "presentDuckRed:" + presentDuckRed + ",";
        csv += "presentDuckGreen:" + presentDuckGreen + ",";
        csv += "presentDuckBlue:" + presentDuckBlue + ",";
        csv += "presentBlockRed:" + presentBlockRed + ",";
        csv += "presentBlockGreen:" + presentBlockGreen + ",";
        csv += "presentBlockBlue:" + presentBlockBlue;
        return csv;
    }

    public void deserialize(String calibration) {
        String[] elements = calibration.split(",");

        for (int i = 0; i < 6; i++) {
            String[] element = elements[i].split(":");

            switch (element[0]) {
                case "absentRed":
                    absentRed = Integer.parseInt(element[1]);
                    break;
                case "absentGreen":
                    absentGreen = Integer.parseInt(element[1]);
                    break;
                case "absentBlue":
                    absentBlue = Integer.parseInt(element[1]);
                    break;
                case "presentBlockRed":
                    presentBlockRed = Integer.parseInt(element[1]);
                    break;
                case "presentBlockGreen":
                    presentBlockGreen = Integer.parseInt(element[1]);
                    break;
                case "presentBlockBlue":
                    presentBlockBlue = Integer.parseInt(element[1]);
                    break;
                case "presentBallRed":
                    presentBallRed = Integer.parseInt(element[1]);
                    break;
                case "presentBallGreen":
                    presentBallGreen = Integer.parseInt(element[1]);
                    break;
                case "presentBallBlue":
                    presentBallBlue = Integer.parseInt(element[1]);
                    break;
                case "presentDuckRed":
                    presentDuckRed = Integer.parseInt(element[1]);
                    break;
                case "presentDuckGreen":
                    presentDuckGreen = Integer.parseInt(element[1]);
                    break;
                case "presentDuckBlue":
                    presentDuckBlue = Integer.parseInt(element[1]);
                    break;
            }
        }
    }

    public void setAbsentRGB(int red, int green, int blue) {
        absentRed = red;
        absentGreen = green;
        absentBlue = blue;
    }

    public void setPresentBlockRGB(int red, int green, int blue) {
        presentBlockRed = red;
        presentBlockGreen = green;
        presentBlockBlue = blue;
    }

    public void setPresentBallRGB(int red, int green, int blue) {
        presentBallRed = red;
        presentBallGreen = green;
        presentBallBlue = blue;
    }

    public void setPresentDuckRGB(int red, int green, int blue) {
        presentDuckRed = red;
        presentDuckGreen = green;
        presentDuckBlue = blue;
    }

    public boolean isFreightPresent(int red, int green, int blue) {
        double absentXDerivative = absentRed - red;
        double absentYDerivative = absentGreen - green;
        double absentZDerivative = absentBlue - blue;
        double absentDistance = Math.sqrt((double)(absentXDerivative * absentXDerivative + absentYDerivative * absentYDerivative + absentZDerivative * absentZDerivative));

        double presentBlockXDerivative = presentBlockRed - red;
        double presentBlockYDerivative = presentBlockGreen - green;
        double presentBlockZDerivative = presentBlockBlue - blue;
        double presentBlockDistance = Math.sqrt((double)(presentBlockXDerivative * presentBlockXDerivative + presentBlockYDerivative * presentBlockYDerivative + presentBlockZDerivative * presentBlockZDerivative));

        return presentBlockDistance < absentDistance;

    }
}
