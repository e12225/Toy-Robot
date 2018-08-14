package simulator.validators;

/**
 * FaceValidator checks whether the given value for F in the PLACE command is a correct direction or not
 */
public class FaceValidator {

    String north = "NORTH";
    String south = "SOUTH";
    String east = "EAST";
    String west = "WEST";

    public boolean validateFace(String face)
    {
        if ( face.equals(north) || face.equals(south) || face.equals(east) || face.equals(west) )
        {
            return true;
        }
        else
        {
            System.out.println("\nWARNING: The facing direction should be NORTH, SOUTH, EAST, or WEST !!!\n");
            return false;
        }
    }
}
