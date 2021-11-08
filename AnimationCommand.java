

public abstract class AnimationCommand 
{
	AnimationElement element;
	public void setElement(AnimationElement e)
	{
		element = e;
	}
	public abstract void runCommand(int time);
}
