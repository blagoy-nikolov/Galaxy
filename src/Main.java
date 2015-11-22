import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

import coordinates.AbstractCoordinate;
import coordinates.PlayerOne;
import coordinates.PlayerTwo;
import coordinates.TemporaryChar;
import questions.Database;
/**
 * Main method for the game.
 * */
public final class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to the Galaxy 2.1 game!");
		try{
			showMenu();
		}
		/** 
		 * This is supposed to catch any InputMismatch exceptions
		 * and when a player tries to move out of the matrix
		 * or tries to move on the other player's position.
		 * */


		catch(ArrayIndexOutOfBoundsException | InputMismatchException exception) {
			clearConsole();
			System.out.println("Fatal error. Game exits!");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.exit(0);
			}
			System.exit(0);

		}


	}
	

	public final static void showMenu()
	{	
		System.out.println("[1] Instructions");
		System.out.println("[2] Play");
		System.out.println("[3] Exit");
		System.out.println("Please choose an option: ");
		int userChoise;
		do {
			userChoise=Global.sc.nextInt();
			if(userChoise==1)
			{
				showInstructions();
			}
			else if (userChoise==2) {
				play();
			}
			else if (userChoise==3)
			{
				System.exit(0); 
			}
			if(userChoise!=1&&userChoise!=2&&userChoise!=3)
				System.out.println("Invalid number. Enter again: ");
		} while(userChoise!=1&&userChoise!=2&&userChoise!=3);

	}

	public final static void showInstructions()
	{
		clearConsole();
		System.out.println(GameConstants.instructions);
		System.out.println("Do you want me to create file with instructions? (y/n)");
		char userChoise=Global.sc.next(".").charAt(0);
		if(Character.toUpperCase(userChoise)=='Y')
		{
			try {
				PrintWriter out = new PrintWriter("Instructions.txt");
				out.println(GameConstants.instructions);
				out.close();
				clearConsole();
				System.out.println("File created!");
				showMenu();
			} catch (FileNotFoundException e) {
				System.out.println("File not found.");
				showMenu();
			}
		}
		clearConsole();
		showMenu();



	}

	public final static void play()
	{
		/**
		 * Resets the Database for a new game in case a game has already been played.
		 * */
		Database.resetForNewGame();


		clearConsole();
		int playerOnePoints = 0, playerTwoPoints = 0, matrixSize=0, userChoise=0;
		String playerOneName, playerTwoName;
		char controller;


		System.out.println("LET THE GAME BEGIN!");
		System.out.println("Please type players' names: ");

		/**
		 * Asks for player's names and Galaxy size.
		 * */
		do
		{
			System.out.println("Player One: ");
			playerOneName=Global.sc.next("\\w+");
			System.out.println("Player Two: ");
			playerTwoName=Global.sc.next("\\w+");
			if ((!checkNames(playerOneName, playerTwoName)))
			{
				System.out.println("Error. Please enter names with no marks and spaces, different first letter or less length.: ");
			}
		} while(!checkNames(playerOneName, playerTwoName));
		clearConsole();
		System.out.println("Please choose galaxy size: ");
		System.out.println("[1] Small");
		System.out.println("[2] Large");
		userChoise=Global.sc.nextInt();
		while(userChoise!=1&&userChoise!=2)
		{
			System.out.println("Wrong number. Please enter again: ");
			userChoise=Global.sc.nextInt();
		}
		if (userChoise==1) {
			matrixSize=GameConstants.smallMatrixSize;
		}
		else 
		{
			matrixSize=GameConstants.largeMatrixSize;
		}

		/**
		 * Creates the Galaxy and player's coordinates.
		 * */
		Galaxy galaxy = new Galaxy(matrixSize);
		PlayerOne playerOneCol=new PlayerOne();
		PlayerOne playerOneRow=new PlayerOne();
		PlayerTwo playerTwoRow=new PlayerTwo(matrixSize);
		PlayerTwo playerTwoCol=new PlayerTwo(matrixSize);
		/**
		 * Creates TemporaryChar which will hold a potential symbol ('8'/'+'/'*') of a question.
		 * */
		TemporaryChar temp = new TemporaryChar();
		galaxy.putStars(matrixSize);
		galaxy.putPlayers(playerOneName, playerTwoName, matrixSize);


		//GAME BEGINS



		do
		{
			//First player


			clearConsole();
			displayPlayerInfo(playerOneName, playerOnePoints, playerTwoName, playerTwoPoints);
			galaxy.printMatrix(matrixSize);
			System.out.print(playerOneName);
			System.out.print(", please make a move: ");

			controller=Global.sc.next(".").charAt(0);

			movePlayer(galaxy,temp, controller, playerOneRow, playerOneCol);

			//Throws exception if player has tried to move on the other player's position.
			if (playerOneRow.coordinate == playerTwoRow.coordinate&&playerOneCol.coordinate ==playerTwoCol.coordinate)
			{
				throw new ArrayIndexOutOfBoundsException();	
			}
			playerOnePoints+=pointsToAdd(temp);
			clearConsole();
			displayPlayerInfo(playerOneName, playerOnePoints, playerTwoName, playerTwoPoints);
			galaxy.printMatrix(matrixSize);

			//Checks if there are any stars.
			if(!galaxy.checkForRemainingStars(matrixSize)) break;





			//Second player


			clearConsole();
			displayPlayerInfo(playerOneName, playerOnePoints, playerTwoName, playerTwoPoints);
			galaxy.printMatrix(matrixSize);
			System.out.print(playerTwoName);
			System.out.print(", please make a move: ");

			controller=Global.sc.next(".").charAt(0);

			movePlayer(galaxy,temp, controller, playerTwoRow, playerTwoCol);

			if (playerOneRow.coordinate == playerTwoRow.coordinate&&playerOneCol.coordinate ==playerTwoCol.coordinate)
			{
				throw new ArrayIndexOutOfBoundsException();	
			}
			playerTwoPoints+=pointsToAdd(temp);
			clearConsole();
			displayPlayerInfo(playerOneName, playerOnePoints, playerTwoName, playerTwoPoints);
			galaxy.printMatrix(matrixSize);
		} while (galaxy.checkForRemainingStars(matrixSize));




		if (playerOnePoints > playerTwoPoints)
		{
			System.out.print(playerOneName);
			System.out.println(" wins!");
		}
		else if (playerOnePoints < playerTwoPoints)
		{
			System.out.print(playerTwoName);
			System.out.println(" wins!");
		}
		else System.out.println("It's a draw!");

		pressAnyKeyToContinue();
		showMenu();


	}


	/**
	 * Checks if player's names are with proper length,
	 * using only alphabetical symbols
	 * and not starting with same letters.
	 * */
	public final static boolean checkNames(String playerOneName, String playerTwoName)
	{
		if(playerOneName.length()>15||playerOneName.length()<2||playerTwoName.length()<2||playerTwoName.length()>15) return false;
		if(!playerOneName.matches("[a-zA-Z]+")||!playerTwoName.matches("[a-zA-Z]+")) return false;
		if(playerOneName.substring(0,1).equals(playerTwoName.substring(0,1))) return false;
		return true;
	}

	/**
	 * Moves player to another position.
	 * */
	public final static void movePlayer(Galaxy galaxy,TemporaryChar temp, char controller,AbstractCoordinate playerRow,AbstractCoordinate playerCol)
	{
		temp.symbol = ' ';
		if (Character.toUpperCase(controller) == 'W')
		{
			temp.symbol = galaxy.getMatrix()[playerRow.coordinate - 1][playerCol.coordinate];
			galaxy.getMatrix()[playerRow.coordinate - 1][playerCol.coordinate] = galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate];
			galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate] = '.';
			playerRow.coordinate--;
		}
		else if (Character.toUpperCase(controller) == 'A')
		{
			temp.symbol = galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate - 1];
			galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate - 1] = galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate];
			galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate] = '.';
			playerCol.coordinate--;
		}
		else if (Character.toUpperCase(controller) == 'S')
		{
			temp.symbol = galaxy.getMatrix()[playerRow.coordinate + 1][playerCol.coordinate];
			galaxy.getMatrix()[playerRow.coordinate + 1][playerCol.coordinate] = galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate];
			galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate] = '.';
			playerRow.coordinate++;
		}
		else if (Character.toUpperCase(controller) == 'D')
		{
			temp.symbol =galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate + 1];
			galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate + 1] = galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate];
			galaxy.getMatrix()[playerRow.coordinate][playerCol.coordinate] = '.';
			playerCol.coordinate++;
		}


	}

	public final static void displayPlayerInfo(String playerOneName,int playerOnePoints, String playerTwoName, int playerTwoPoints)
	{
		System.out.print("          ");
		System.out.print(playerOneName);
		System.out.print(": ");
		System.out.print(playerOnePoints);
		System.out.print("                       ");
		System.out.print(playerTwoName);
		System.out.print(": ");
		System.out.print(playerTwoPoints);
		System.out.println();
		System.out.println();

	}


	/**
	 * Chooses a random question (which hasn't been asked) 
	 * Returns the points for the exact type of question or 0.
	 * */

	public final static int pointsToAdd(TemporaryChar temp)
	{
		int randomIndex;
		char charAnswer;
		int intAnswer;
		if (temp.symbol == GameConstants.easyQuestionsSymbol)
		{
			randomIndex=Global.rand.nextInt(Database.EASYQUESTIONS.length);
			while (Database.EASYQUESTIONS[randomIndex].haveBeenUsed() == true)
			{
				randomIndex = Global.rand.nextInt(Database.EASYQUESTIONS.length);
			}
			System.out.println(Database.EASYQUESTIONS[randomIndex].toString());
			Database.EASYQUESTIONS[randomIndex].setToUsed();
			charAnswer=Global.sc.next(".").charAt(0);
			if (Database.EASYQUESTIONS[randomIndex].isTrue(charAnswer))
			{
				return GameConstants.easyQuestionsPoints;
			}
		}

		if (temp.symbol == GameConstants.mediumQuestionsSymbol)
		{
			randomIndex=Global.rand.nextInt(Database.MEDIUMQUESTIONS.length);
			while (Database.MEDIUMQUESTIONS[randomIndex].haveBeenUsed() == true)
			{
				randomIndex = Global.rand.nextInt(Database.MEDIUMQUESTIONS.length);
			}
			System.out.println(Database.MEDIUMQUESTIONS[randomIndex].toString());
			Database.MEDIUMQUESTIONS[randomIndex].setToUsed();
			charAnswer=Global.sc.next(".").charAt(0);
			if (Database.MEDIUMQUESTIONS[randomIndex].isTrue(charAnswer))
			{
				return GameConstants.mediumQuestionsPoints;
			}
		}


		if (temp.symbol == GameConstants.hardQuestionsSymbol)
		{

			randomIndex=Global.rand.nextInt(Database.HARDQUESTIONS.length);
			while (Database.HARDQUESTIONS[randomIndex].haveBeenUsed() == true)
			{
				randomIndex = Global.rand.nextInt(Database.HARDQUESTIONS.length);
			}
			System.out.println("Please enter an integer: ");
			System.out.println(Database.HARDQUESTIONS[randomIndex].toString());
			Database.HARDQUESTIONS[randomIndex].setToUsed();
			intAnswer=Global.sc.nextInt();
			if (Database.HARDQUESTIONS[randomIndex].isTrue(intAnswer))
			{
				return GameConstants.hardQuestionsPoints;
			}
			/**
			 * If the answer is wrong checks if it is at least 10% close to the real answer. 
			 * */
			else 
			{
				if (Database.HARDQUESTIONS[randomIndex].isCloseToAnswer(intAnswer))
				{
					return GameConstants.hardQuestionsNotFullPoints;
				}
			}
		}
		return 0;





	}


	public final static void clearConsole()
	{
		for (int i = 0; i < 50; ++i) System.out.println();
	} 
	public final static void pressAnyKeyToContinue()
	{ 
		System.out.println("Press any key to continue...");
		try
		{
			System.in.read();
		}  
		catch(Exception e)
		{}  
	}



}

