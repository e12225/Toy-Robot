package simulator.validators;

import simulator.processor.ValueHolder;

/**
 * PlaceCommandValidator is used to check whether the PLACE command i.e, the first command
 * is passed according to the correct format, 'PLACE X,Y,F'. There, it is checked whether X and Y are passed
 * as integers and whether F is one of the valid directions(NORTH, EAST, SOUTH, WEST) or not
 */

public class PlaceCommandValidator {

    boolean isValid = false;
    ValueHolder valueHolder = new ValueHolder();

    public boolean validatePlaceCommand(String fCommand)
    {
        FaceValidator faceValidator = new FaceValidator();
        CoordinateValidator coordinateValidator = new CoordinateValidator();

        if ( fCommand.split(",").length == 3 && fCommand.split(",")[0].split(" ")[0].equals("PLACE") )
        {
            try
            {
                int x_Coordinate = Integer.parseInt(fCommand.split(",")[0].split(" ")[1]);
                int y_Coordinate = Integer.parseInt(fCommand.split(",")[1]);
                String face = fCommand.split(",")[2];

                if ( faceValidator.validateFace(face) && coordinateValidator.validateCoordinates(x_Coordinate, y_Coordinate) )
                {
                    isValid = true;

                    this.valueHolder.setX(x_Coordinate);
                    this.valueHolder.setY(y_Coordinate);
                    this.valueHolder.setFace(face);
                }
                else
                {
                    isValid = false;
                }
            }
            catch(NumberFormatException nFE)
            {
                System.out.println("\nWARNING: Coordinates should be integers !!!\n");
                isValid = false;
            }

            return isValid;
        }
        else
        {
            return isValid;
        }
    }

    public ValueHolder getValueHolder() {
        return valueHolder;
    }
}
