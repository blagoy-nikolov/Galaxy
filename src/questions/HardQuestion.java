package questions;

public final class HardQuestion extends AbstractQuestion {

	public HardQuestion(String question, int answer) {
		super(question);
		this.answer=answer;
	}
   public final boolean isTrue(int answer)
    {
    	return this.answer==answer;
    }
   public final boolean isCloseToAnswer(int answer)
   {
	   int tenPercent=this.answer/10;
	   return answer>this.answer-tenPercent&&answer<this.answer+tenPercent;
	   
	   
   }
	
	
	private int answer;
}
