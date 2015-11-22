package questions;

public final class EasyQuestion extends AbstractQuestion {

	public EasyQuestion(String question, char answer) {
		super(question);
		this.answer=answer;
	}
	public final boolean isTrue(char answer)
	{
		return this.answer==Character.toUpperCase(answer);
	}




	private char answer;
}

