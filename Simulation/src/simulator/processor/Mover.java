package simulator.processor;

public class Mover {

    boolean success = false;

    public ValueHolder move(Integer x, Integer y, String face)
    {
        ValueHolder valueHolder = new ValueHolder();
        int max = 4;
        int min = 0;

        switch (face)
        {
            case "NORTH":
                if ((y+1) > max)
                {
                    System.out.println("\nWARNING: This move causes the robot to fall off the table. Please try a different move !!!\n");
                }
                else
                {
                    y = y + 1;
                    this.setSuccess(true);
                }
                break;

            case "EAST":
                if ((x+1) > max)
                {
                    System.out.println("\nWARNING: This move causes the robot to fall off the table. Please try a different move !!!\n");
                }
                else
                {
                    x = x + 1;
                    this.setSuccess(true);
                }
                break;

            case "SOUTH":
                if ((y-1) < min)
                {
                    System.out.println("\nWARNING: This move causes the robot to fall off the table. Please try a different move !!!\n");
                }
                else
                {
                    y = y - 1;
                    this.setSuccess(true);
                }
                break;

            case "WEST":
                if ((x-1) < min)
                {
                    System.out.println("\nWARNING: This move causes the robot to fall off the table. Please try a different move !!!\n");
                }
                else
                {
                    x = x - 1;
                    this.setSuccess(true);
                }
                break;

            default:
                System.out.println("\nWARNING: Please enter a valid MOVE command !");
                System.out.println("PLACE X,Y,F\nLEFT/RIGHT");
                this.setSuccess(false);
                break;
        }

        valueHolder.setX(x);
        valueHolder.setY(y);
        valueHolder.setFace(face);

        return valueHolder;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
