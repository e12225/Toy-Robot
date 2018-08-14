package simulator.processor;

/**
 * Turner is responsible for turning the robot by 90 degrees to it's left side or right side,
 * depending on the command given
 */

public class Turner {

    boolean success = false;

    public String turn(String nextCmd, String face)
    {
      switch (nextCmd)
      {
          case "LEFT":
              switch (face)
              {
                  case "NORTH":
                      face = "WEST";
                      this.setSuccess(true);
                      break;

                  case "EAST":
                      face = "NORTH";
                      this.setSuccess(true);
                      break;

                  case "SOUTH":
                      face = "EAST";
                      this.setSuccess(true);
                      break;

                  case "WEST":
                      face = "SOUTH";
                      this.setSuccess(true);
                      break;

                  default:
                      System.out.println("\nWARNING: Current face is not valid !");
                      this.setSuccess(false);
                      break;
              }
              break;

          case "RIGHT":
              switch (face)
              {
                  case "NORTH":
                      face = "EAST";
                      this.setSuccess(true);
                      break;

                  case "EAST":
                      face = "SOUTH";
                      this.setSuccess(true);
                      break;

                  case "SOUTH":
                      face = "WEST";
                      this.setSuccess(true);
                      break;

                  case "WEST":
                      face = "NORTH";
                      this.setSuccess(true);
                      break;

                  default:
                      System.out.println("\nWARNING: Current face is not valid !");
                      this.setSuccess(false);
                      break;
              }
              break;
      }
      return face;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
