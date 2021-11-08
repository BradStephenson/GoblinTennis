

public class SetVisibilityCommand extends AnimationCommand {
	
	private int start;
	private boolean visibility;
	
	public SetVisibilityCommand(int start, boolean visibility)
	{
		this.start = start;
		this.visibility = visibility;
	}
	@Override
	public void runCommand(int time) 
	{
		// TODO Auto-generated method stub
		if (time == start)
		{
			element.setVisibility(visibility);
		}
	}

}
