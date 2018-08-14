package simulator.validators;

public class CoordinateValidator {

    /**
     * Since the table space is 5x5 space, maximum values of X and Y
     * coordinates are 5. In case of the enlargement of the table space,
     * we can simple change the values of max_X and max_Y variables.
     */
    int max_X = 5;
    int max_Y = 5;

    public boolean validateCoordinates(int x, int y)
    {
        if ( (x <= max_X && x >= 0) && (y <= max_Y && y >= 0) )
        {
            return true;
        }
        else
        {
            System.out.println("Both X and Y coordinates should be between 0 and " + max_Y);
            return false;
        }
    }
}
