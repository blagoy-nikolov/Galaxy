/**
 * The Galaxy class represents the matrix/game field. 
 *  
 *  
 *  */




public final class Galaxy {


	/**
	 * Creates the matrix and initialize with dots.
	 * */
	public Galaxy(int matrixSize)
	{
		this.matrix=new char[matrixSize][matrixSize];
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				this.matrix[i][j]='.';
			}
		}

	}
	public final char[][] getMatrix()
	{
		return this.matrix;
	}

	/**
	 * Puts stars on random positions.
	 * */
	public final void putStars(int matrixSize)
	{
		for (int i = 0; i < matrixSize; i++)
		{
			if (i % 2 == 0)
			{
				this.matrix[i][Global.rand.nextInt(matrixSize)] = GameConstants.easyQuestionsSymbol;
			}
			if (i % 3 == 0)
			{
				this.matrix[i][Global.rand.nextInt(matrixSize)] = GameConstants.mediumQuestionsSymbol;
			}
			if (i % 4 == 0)
			{
				this.matrix[i][Global.rand.nextInt(matrixSize)] = GameConstants.hardQuestionsSymbol;
			}
		}





	}

	/**
	 * Puts the players' indexes on the corners.
	 * */
	public final void putPlayers(String playerOneName, String playerTwoName,int matrixSize)
	{
		this.matrix[0][0]=playerOneName.charAt(0);
		this.matrix[matrixSize-1][matrixSize-1]=playerTwoName.charAt(0);
	}
	public final void printMatrix(int matrixSize)
	{
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				System.out.print(this.matrix[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
	/**
	 * Checks if the game is over.
	 * */
	public final boolean checkForRemainingStars(int matrixSize)
	{
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				if(this.matrix[i][j]==GameConstants.easyQuestionsSymbol||this.matrix[i][j]==GameConstants.mediumQuestionsSymbol||this.matrix[i][j]==GameConstants.hardQuestionsSymbol) return true;
			}
		}
		return false;
	}


	private char matrix[][];
}
