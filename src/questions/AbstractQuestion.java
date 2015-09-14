package questions;

public abstract class AbstractQuestion {

	
	
	public AbstractQuestion(String question)
	{
	this.question=question;
	}
	public final boolean haveBeenUsed()
	{
		return this.used;
	
	}
	public final void reset()
	{
		this.used=false;
	}
	public final void setToUsed()
	{
		this.used=true;
	}
	public final String toString()
	{
		return this.question;
	}
	
	
	protected String question;
	protected boolean used;
}
