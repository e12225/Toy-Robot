package simulator.processor;

import simulator.validators.CoordinateValidator;
import simulator.validators.FaceValidator;

/**
 * NextCommandProcessor receives the current values of X,Y and F along with the next entered command
 * and perform MOVE, LEFT/RIGHT, REPORT or PLACE functions accordingly. After each performance, it updates the
 * X,Y and F values of robot
 */

public class NextCommandProcessor {

    boolean isSuccess = false;
    ValueHolder valueHolder = new ValueHolder();

    public boolean processNextCommand(String nextCommand, Integer current_X, Integer current_Y, String current_Face)
    {
        Mover mover = new Mover();
        Turner turner = new Turner();

        if (nextCommand.equals("MOVE"))
        {
            valueHolder = mover.move(current_X, current_Y, current_Face);
            if ( mover.isSuccess() )
            {
                isSuccess = true;
            }
        }
        else if (nextCommand.equals("LEFT") || nextCommand.equals("RIGHT"))
        {
            valueHolder.setFace(turner.turn(nextCommand, current_Face));
            valueHolder.setX(current_X);
            valueHolder.setY(current_Y);

            if ( turner.isSuccess() )
            {
                isSuccess = true;
            }
        }
        else if (nextCommand.equals("REPORT"))
        {
            System.out.println("\nRobot's location on the table space :");
            System.out.println("X Coordinate     : " + current_X);
            System.out.println("Y Coordinate     : " + current_Y);
            System.out.println("Facing direction : " + current_Face + "\n");

            isSuccess = true;

        }
        else if ((nextCommand.split(",").length == 3) && (nextCommand.split(",")[0].split(" ")[0].equals("PLACE")))
        {
            CoordinateValidator cval = new CoordinateValidator();
            FaceValidator fval = new FaceValidator();

            boolean isCVal = false;
            boolean isFVal = false;
            try
            {
                isCVal = cval.validateCoordinates(Integer.parseInt(nextCommand.split(",")[0].split(" ")[1]), Integer.parseInt(nextCommand.split(",")[1]));
                isFVal = fval.validateFace(nextCommand.split(",")[2]);
            }
            catch (NumberFormatException nFE)
            {
                valueHolder.setX(current_X);
                valueHolder.setY(current_Y);
                valueHolder.setFace(current_Face);

                isSuccess = false;
            }

            if (isCVal && isFVal)
            {
                valueHolder.setX(Integer.parseInt(nextCommand.split(",")[0].split(" ")[1]));
                valueHolder.setY(Integer.parseInt(nextCommand.split(",")[1]));
                valueHolder.setFace(nextCommand.split(",")[2]);

                isSuccess = true;
            }
        }
        else
        {
            valueHolder.setX(current_X);
            valueHolder.setY(current_Y);
            valueHolder.setFace(current_Face);

            isSuccess = false;
        }

        return isSuccess;
    }

    public ValueHolder getValueHolder() {
        return valueHolder;
    }
}
