/**
 * Holds game constants.
 * */

public final class GameConstants {
	private GameConstants(){};
	public final static int easyQuestionsPoints=5;
	public final static int mediumQuestionsPoints=7;
	public final static int hardQuestionsPoints=15;
	public final static int hardQuestionsNotFullPoints=5;

	public final static int smallMatrixSize=8;
	public final static int largeMatrixSize=12;

	public final static char easyQuestionsSymbol='*';
	public final static char mediumQuestionsSymbol='+';
	public final static char hardQuestionsSymbol='8';
	
	public static final String instructions="This is a two player game.\nYou must use the controller (A-left, S-down, D-right, W-up) \nto catch as many stars as you can.\n "
	+ "Depending on the type of the star,\nthere are questions with different difficulty\n"
	+ "'*' - easy (5 points)\n"
	+ "'+' - medium (7 points)\n"
	+ "'8' - hard (15 or 5 points)\n"
	+ "Developed by: Blagoy Nikolov\n\n";

}
