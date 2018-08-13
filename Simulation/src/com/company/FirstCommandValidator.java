package com.company;

public class FirstCommandValidator {

    /**
     * validateFirstCommand() method is used to check whether the PLACE command i.e, the first command
     * is passed according to the correct format, 'PLACE X,Y,F'
     * @param fCommand
     * @return
     */
    public boolean validateFirstCommand(String fCommand)
    {
        //input set
        String place = "PLACE";
        int x_Coordinate = 0;
        int y_Coordinate = 0;
        String face = null;

        boolean isValid = false;

        if ( fCommand.split(",").length == 3 && fCommand.split(",")[0].split(" ")[0].equals(place) )
        {
            try
            {
                x_Coordinate = Integer.parseInt(fCommand.split(",")[0].split(" ")[1]);
                y_Coordinate = Integer.parseInt(fCommand.split(",")[1]);
                isValid = true;
            }
            catch(NumberFormatException nFE)
            {
                System.out.println("\nCoordinates should be integers !");
                isValid = false;
            }

            return isValid;
        }
        else
        {
            return isValid;
        }
    }
}
