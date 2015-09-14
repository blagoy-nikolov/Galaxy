package questions;

public final class MediumQuestion extends AbstractQuestion {

	public MediumQuestion(String question, char answer) {
		super(question);
		this.answer=answer;
		
	}
	public final boolean isTrue(char answer)
	{
		return this.answer==Character.toUpperCase(answer);
	}
	
	
	private char answer;

}
