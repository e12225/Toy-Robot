package com.company;

import java.util.Scanner;

public class Core {

    //choices set
    String move = "MOVE";
    String left = "LEFT";
    String right = "RIGHT";
    String report = "REPORT";

    public static void main(String[] args) {

        System.out.print("Welcome to the Toy-Robot simulation !!!\n");
        System.out.print("Please enter the sequence of commands to move the robot within the table space\n");
        System.out.print("Refer the below shown structure to identify the valid bounds of the table space\n");
        System.out.print("(0,5)___________________(5,5)\n");
        System.out.print("    |                   |\n");
        System.out.print("    |                   |\n");
        System.out.print("    |                   |\n");
        System.out.print("    |___________________|\n");
        System.out.println("(0,0)                   (5,0)\n");
        System.out.print("Let's begin....\n");
        System.out.print("\nPlace the robot on the table space :\n");

        Scanner scanner = new Scanner(System.in);
        String firstCommand = scanner.nextLine();

        FirstCommandValidator validtor = new FirstCommandValidator();

        while ( !validtor.validateFirstCommand(firstCommand) )
        {
            //TODO: remove the while loop and put an if-else clause if required !
            System.out.print("Re-try placing the robot on the table space :\n");
            firstCommand = scanner.nextLine();
        }
    }
}
