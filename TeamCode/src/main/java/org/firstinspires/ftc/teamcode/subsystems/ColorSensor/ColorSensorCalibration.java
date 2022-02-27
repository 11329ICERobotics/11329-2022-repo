package org.firstinspires.ftc.teamcode.subsystems.ColorSensor;


public class ColorSensorCalibration {
    double minValue;
    public static int absentRed = 80;
    public static int absentGreen = 130;
    public static int absentBlue = 80;





    public static int presentBallCloseSolidRed = 1300;
    public static int presentBallCloseSolidGreen = 2550;
    public static int presentBallCloseSolidBlue = 2120;

    public static int presentBallFarSolidRed = 800;
    public static int presentBallFarSolidGreen = 1470;
    public static int presentBallFarSolidBlue = 1050;

    public static int presentBallMidSolidRed =1300;
    public static int presentBallMidSolidGreen = 2550;
    public static int presentBallMidSolidBlue = 1720;


    public static int presentBallFarHoleRed = 210;
    public static int presentBallFarHoleGreen = 258;
    public static int presentBallFarHoleBlue = 86;

    public static int presentBallMidHoleRed = 475;
    public static int presentBallMidHoleGreen = 600;
    public static int presentBallMidHoleBlue = 179;

    public static int presentBallCloseHoleRed = 1550;
    public static int presentBallCloseHoleGreen = 3010;
    public static int presentBallCloseHoleBlue = 2120;










    public static int presentBlockCloseSolidRed = 5200;
    public static int presentBlockCloseSolidGreen = 7000;
    public static int presentBlockCloseSolidBlue = 1550;

    public static int presentBlockFarSolidRed = 340;
    public static int presentBlockFarSolidGreen = 440;
    public static int presentBlockFarSolidBlue = 142;


    public static int presentBlockFarHoleRed = 210;
    public static int presentBlockFarHoleGreen = 258;
    public static int presentBlockFarHoleBlue = 86;

    public static int presentBlockMidHoleRed = 475;
    public static int presentBlockMidHoleGreen = 600;
    public static int presentBlockMidHoleBlue = 179;


    public static int presentDuckRed = 370;
    public static int presentDuckGreen = 573;
    public static int presentDuckBlue = 178;

    public ColorSensorCalibration() {

    }

   /* public String serialize() {
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
    }*/

    public freightType isFreightPresent(int red, int green, int blue) {
        double absentXDerivative = absentRed - red;
        double absentYDerivative = absentGreen - green;
        double absentZDerivative = absentBlue - blue;
        double absentDistance = Math.sqrt((double)(absentXDerivative * absentXDerivative + absentYDerivative * absentYDerivative + absentZDerivative * absentZDerivative));


        double presentBlockCloseSolidDistance = Math.sqrt((double)(Math.pow(presentBlockCloseSolidRed-red, 2) + Math.pow(presentBlockCloseSolidGreen-green, 2)  + Math.pow(presentBlockCloseSolidBlue-blue, 2) ));
        double presentBlockFarSolidDistance = Math.sqrt((double)(Math.pow(presentBlockFarSolidRed-red, 2) + Math.pow(presentBlockFarSolidGreen-green, 2)  + Math.pow(presentBlockFarSolidBlue-blue, 2) ));

        double presentBlockMidHoleDistance = Math.sqrt((double)(Math.pow(presentBlockMidHoleRed-red, 2) + Math.pow(presentBlockMidHoleGreen-green, 2)  + Math.pow(presentBlockMidHoleBlue-blue, 2) ));
        double presentBlockFarHoleDistance = Math.sqrt((double)(Math.pow(presentBlockFarHoleRed-red, 2) + Math.pow(presentBlockFarHoleGreen-green, 2)  + Math.pow(presentBlockFarHoleBlue-blue, 2) ));

        double presentBallCloseSolidDistance = Math.sqrt((double)(Math.pow(presentBallCloseSolidRed-red, 2) + Math.pow(presentBallCloseSolidGreen-green, 2)  + Math.pow(presentBallCloseSolidBlue-blue, 2) ));
        double presentBallFarSolidDistance = Math.sqrt((double)(Math.pow(presentBallFarSolidRed-red, 2) + Math.pow(presentBallFarSolidGreen-green, 2)  + Math.pow(presentBallFarSolidBlue-blue, 2) ));
        double presentBallMidSolidDistance = Math.sqrt((double)(Math.pow(presentBallMidSolidRed-red, 2) + Math.pow(presentBallMidSolidGreen-green, 2)  + Math.pow(presentBallMidSolidBlue-blue, 2) ));

        double presentBallMidHoleDistance = Math.sqrt((double)(Math.pow(presentBallMidHoleRed-red, 2) + Math.pow(presentBallMidHoleGreen-green, 2)  + Math.pow(presentBallMidHoleBlue-blue, 2) ));
        double presentBallFarHoleDistance = Math.sqrt((double)(Math.pow(presentBallFarHoleRed-red, 2) + Math.pow(presentBallFarHoleGreen-green, 2)  + Math.pow(presentBallFarHoleBlue-blue, 2) ));
        double presentBallCloseHoleDistance = Math.sqrt((double)(Math.pow(presentBallCloseHoleRed-red, 2) + Math.pow(presentBallCloseHoleGreen-green, 2)  + Math.pow(presentBallCloseHoleBlue-blue, 2) ));

        double presentDuckXDerivative = presentDuckRed - red;
        double presentDuckYDerivative = presentDuckGreen - green;
        double presentDuckZDerivative = presentDuckBlue - blue;
        double presentDuckDistance = Math.sqrt((double)(presentDuckXDerivative * presentDuckXDerivative + presentDuckYDerivative * presentDuckYDerivative + presentDuckZDerivative * presentDuckZDerivative));
        minValue = presentDuckDistance;
        double[] allDistances = new double[12];
        allDistances[0] = presentBlockFarSolidDistance;
        allDistances[1] = presentBlockCloseSolidDistance;
        allDistances[2] = presentBlockMidHoleDistance;
        allDistances[3] = presentBlockFarHoleDistance;
        allDistances[4] = presentBallCloseHoleDistance;
        allDistances[5] = presentBallFarHoleDistance;
        allDistances[6] = presentBallMidHoleDistance;
        allDistances[7] = presentBallCloseSolidDistance;
        allDistances[8] = presentBallMidSolidDistance;
        allDistances[9] = presentBallFarSolidDistance;
        allDistances[10] = presentDuckDistance;
        allDistances[11] = presentDuckDistance;

        double whichFreight = minimum(allDistances);
        if(whichFreight == presentBlockCloseSolidDistance || whichFreight == presentBlockFarSolidDistance || whichFreight == presentBlockMidHoleDistance || whichFreight == presentBlockFarHoleDistance){ return freightType.Block;}
        else if(whichFreight == presentBallCloseSolidDistance || whichFreight == presentBallFarSolidDistance || whichFreight == presentBallMidSolidDistance || whichFreight == presentBlockFarHoleDistance || whichFreight == presentBallMidHoleDistance || whichFreight == presentBallCloseSolidDistance){ return freightType.Ball;}
        else if(whichFreight == presentDuckDistance){ return freightType.Duck;}
        else { return freightType.Absent;}
    }
    public  double minimum(double[] numbers){
        for(int i = 0; i< numbers.length; i++){
            if(numbers[i]< minValue){
                    minValue = numbers[i];
                }
            }
        return minValue;

    }
}
