package simulator.validators;

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
            System.out.println("\nThe facing direction should be NORTH, SOUTH, EAST, or WEST");
            return false;
        }
    }
}
