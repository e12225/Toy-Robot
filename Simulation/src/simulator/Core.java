package simulator;

import simulator.validators.CommandValidator;
import simulator.processor.NextCommandProcessor;
import simulator.validators.PlaceCommandValidator;

import java.util.Scanner;

public class Core {

    public static void main(String[] args) {

        System.out.print("Welcome to the Toy-Robot simulation !!!\n");
        System.out.print("Please enter the sequence of commands to move the robot within the table space\n");
        System.out.print("Refer the below shown structure to identify the valid bounds of the table space\n");
        System.out.print("(0,4)___________________(4,4)\n");
        System.out.print("    |                   |\n");
        System.out.print("    |                   |\n");
        System.out.print("    |                   |\n");
        System.out.print("    |___________________|\n");
        System.out.println("(0,0)                   (4,0)\n");
        System.out.print("Let's begin....");
        System.out.println("\nPlace the robot on the table space :\n");

        Scanner scanner = new Scanner(System.in);

        /**
         * Capturing the first command (i.e, the PLACE X,Y,F command)
         */
        String firstCommand = scanner.nextLine();
        PlaceCommandValidator placeCommandValidator = new PlaceCommandValidator();

        while ( !placeCommandValidator.validatePlaceCommand(firstCommand) )
        {
            System.out.print("Re-try placing the robot on the table space :\n");
            firstCommand = scanner.nextLine();
        }

        Integer current_X = placeCommandValidator.getValueHolder().getX();
        Integer current_Y = placeCommandValidator.getValueHolder().getY();
        String current_Face = placeCommandValidator.getValueHolder().getFace();

        /**
         * Capturing next commands onwards. There, is the user enter a new line
         * as the command, it is ignored and the program waits( within a while loop )
         * until it meets a non-new-line command
         */
        String command = scanner.nextLine();
        while (command.equals(""))
        {
            command = scanner.nextLine();
        }

        CommandValidator commandValidator = new CommandValidator();
        NextCommandProcessor nextCommandProcessor = new NextCommandProcessor();

        while (true)
        {
            if (!commandValidator.validateCommandType(command))
            {
                System.out.println("\nWARNING: Please enter a valid command. You can chose one of the followings !!!");
                System.out.println("PLACE X,Y,F\nF = > NORTH/SOUTH/EAST/WEST\nMOVE\nLEFT/RIGHT\nREPORT\n");
            }

            while (command.equals(""))
            {
                command = scanner.nextLine();
            }

            nextCommandProcessor.processNextCommand(command, current_X, current_Y, current_Face);

            current_X = nextCommandProcessor.getValueHolder().getX();
            current_Y = nextCommandProcessor.getValueHolder().getY();
            current_Face = nextCommandProcessor.getValueHolder().getFace();

            command = scanner.nextLine();
        }
    }
}
