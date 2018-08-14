Toy-Robot Application Exercising Guide
--------------------------------------

1.) Compile and run the application.

2.) You'll see a welcome panel, including details about the boundaries of the table space. 
	Enter a PLACE command to start the simulation.
	
	The format is "PLACE X,Y,F" ; X = X coordinate, Y = Y coordinate, F = Facing direction of the robot.
	
	Ex: PLACE 1,1,NORTH
	
3.) There onwards, enter a sequence of valid commands to simulate the motion of the Robot.
    Below is an example sequence of commands.
	
	Ex: PLACE 1,1,NORTH
		MOVE
		MOVE
		RIGHT
		MOVE
		LEFT
		REPORT
	
	After entering the REPORT command, the following output will be shown.
	
	Robot's location on the table space :
	X Coordinate     : 2
	Y Coordinate     : 3
	Facing direction : NORTH
	
	here onwards also, you can continue the simulation as you prefer.
	
4.) If an invalid command is given, it'll show a warning message like below.
	
	Ex: TEST
	
	WARNING: Please enter a valid command. You can chose one of the followings !!!
	PLACE X,Y,F
	F = > NORTH/SOUTH/EAST/WEST
	MOVE
	LEFT/RIGHT
	REPORT
	
5.) If the given coordinates of the PLACE command are out of the table space, it'll show a warning message like below.
	
	Ex: PLACE 1,7,SOUTH

	WARNING: Both X and Y coordinates should be between 0 and 4 !!!
	
6.)If a MOVE command causes the robot to fall off the table space, it'll show a warning message like below.

	Ex: PLACE 1,1,NORTH
		MOVE
		MOVE
		MOVE
		REPORT

		Robot's location on the table space :
		X Coordinate     : 1
		Y Coordinate     : 4
		Facing direction : NORTH

		MOVE

		WARNING: This move causes the robot to fall off the table. Please try a different move !!!

	
7.) If characters ( except numbers ) are entered as coordinates in the PLACE command, it'll show a warning message like below.
	
	Ex: PLACE a,3,EAST

	WARNING: Coordinates should be integers !!!
	
8.) If an incorrect value is entered as the Face in the PLACE command, it'll show a warning message like below.

	Ex: PLACE 1,1,TEST

	WARNING: The facing direction should be NORTH, SOUTH, EAST, or WEST !!!
	
9.) If you enter an invalid command, even after entering a valid PLACE command, it'll show a warning message like below.

    Ex: PLACE 2,3,EAST 
	    TEST COMMAND

	WARNING: Please enter a valid command. You can chose one of the followings !!!
	PLACE X,Y,F
	F = > NORTH/SOUTH/EAST/WEST
	MOVE
	LEFT/RIGHT
	REPORT	
	
	
	
	
	
	
	
	
	