package simulator.validators;

/**
 * CommandValidator checks whether the given command is a defined command or not,
 * by comparing it against the defined set of commands
 *(PLACE X,Y,E , MOVE, LEFT, RIGHT or REPORT )
 */
public class CommandValidator {

    public boolean validateCommandType(String command)
    {
        boolean isValidCommand;

        if (command.split(",").length == 3 && command.split(",")[0].split(" ")[0].equals("PLACE"))
        {
            try
            {
                Integer.parseInt(command.split(",")[0].split(" ")[1]);
                Integer.parseInt(command.split(",")[1]);
                isValidCommand = true;
            }
            catch (NumberFormatException nFE)
            {
                System.out.println("\nWARNING: Coordinates should be integers !!!");
                isValidCommand = false;
            }
        }
        else if (command.equals("MOVE") || command.equals("LEFT") || command.equals("RIGHT") || command.equals("REPORT") || command.equals(""))
        {
            isValidCommand = true;
        }
        else
        {
            isValidCommand = false;
        }

        return isValidCommand;
    }
}
