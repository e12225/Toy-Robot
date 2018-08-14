package simulator.processor;

import simulator.validators.CoordinateValidator;
import simulator.validators.FaceValidator;

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
        else
        {
            CoordinateValidator cval = new CoordinateValidator();
            FaceValidator fval = new FaceValidator();

            boolean isCVal = cval.validateCoordinates(Integer.parseInt(nextCommand.split(",")[0].split(" ")[1]), Integer.parseInt(nextCommand.split(",")[1]));
            boolean isFVal = fval.validateFace(nextCommand.split(",")[2]);

            if (isCVal && isFVal)
            {
                valueHolder.setX(Integer.parseInt(nextCommand.split(",")[0].split(" ")[1]));
                valueHolder.setY(Integer.parseInt(nextCommand.split(",")[1]));
                valueHolder.setFace(nextCommand.split(",")[2]);

                isSuccess = true;
            }
        }

        return isSuccess;
    }

    public ValueHolder getValueHolder() {
        return valueHolder;
    }
}
