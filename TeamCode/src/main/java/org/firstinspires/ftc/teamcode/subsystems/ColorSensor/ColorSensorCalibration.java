package org.firstinspires.ftc.teamcode.subsystems.ColorSensor;


public class ColorSensorCalibration {
    public static int absentRed = 128;
    public static int absentGreen = 186;
    public static int absentBlue = 114;

    public static int presentBlockRed = 638;
    public static int presentBlockGreen = 780;
    public static int presentBlockBlue = 206;

    public static int presentBallRed = 8570;
    public static int presentBallGreen = 15120;
    public static int presentBallBlue = 11160;

    public static int presentDuckRed = 370;
    public static int presentDuckGreen = 573;
    public static int presentDuckBlue = 178;

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

    public freightType isFreightPresent(int red, int green, int blue) {
        double absentXDerivative = absentRed - red;
        double absentYDerivative = absentGreen - green;
        double absentZDerivative = absentBlue - blue;
        double absentDistance = Math.sqrt((double)(absentXDerivative * absentXDerivative + absentYDerivative * absentYDerivative + absentZDerivative * absentZDerivative));

        double presentBlockXDerivative = presentBlockRed - red;
        double presentBlockYDerivative = presentBlockGreen - green;
        double presentBlockZDerivative = presentBlockBlue - blue;
        double presentBlockDistance = Math.sqrt((double)(presentBlockXDerivative * presentBlockXDerivative + presentBlockYDerivative * presentBlockYDerivative + presentBlockZDerivative * presentBlockZDerivative));

        double presentBallXDerivative = presentBallRed - red;
        double presentBallYDerivative = presentBallGreen - green;
        double presentBallZDerivative = presentBallBlue - blue;
        double presentBallDistance = Math.sqrt((double)(presentBallXDerivative * presentBallXDerivative + presentBallYDerivative * presentBallYDerivative + presentBallZDerivative * presentBallZDerivative));

        double presentDuckXDerivative = presentDuckRed - red;
        double presentDuckYDerivative = presentBallGreen - green;
        double presentDuckZDerivative = presentBallBlue - blue;
        double presentDuckDistance = Math.sqrt((double)(presentDuckXDerivative * presentDuckXDerivative + presentDuckYDerivative * presentDuckYDerivative + presentDuckZDerivative * presentDuckZDerivative));

        double whichFreight = Math.min(Math.min(presentBlockDistance, absentDistance), Math.min(presentBallDistance, presentDuckDistance));
        if(whichFreight == presentBlockDistance){ return freightType.Block;}
        else if(whichFreight == presentBallDistance){ return freightType.Ball;}
        else if(whichFreight == presentDuckDistance){ return freightType.Duck;}
        else { return freightType.Absent;}
    }
}
