package simulator.validators;

public class CoordinateValidator {

    /**
     * Since the table space is 5x5 space, maximum values of X and Y
     * coordinates are 5. In case of the enlargement of the table space,
     * we can simple change the values of max and min variables.
     *
     * Also, we can specify min & max values for X and Y separately as well.
     */

    int max = 4;
    int min = 0;

    public boolean validateCoordinates(Integer x, Integer y)
    {
        if ( (x <= max && x >= min) && (y <= max && y >= min) )
        {
            return true;
        }
        else
        {
            System.out.println("\nBoth X and Y coordinates should be between " + min + "and " + max);
            return false;
        }
    }
}
