package coordinates;

public final class PlayerTwo extends AbstractCoordinate {
	/**
	 * Needs constructor to set coordinates to bottom right corner.
	 * */
	public PlayerTwo(int matrixSize)
	{
		this.coordinate=matrixSize-1;
	}
}
