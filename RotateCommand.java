
public class RotateCommand extends AnimationCommand {

	int start, stop;
	int angleInDegrees;
	public RotateCommand(int start, int stop, double angleInDegrees)
	{
		this.start = start;
		this.stop = stop;
	}
	
	
	@Override
	public void runCommand(int time) 
	{
		// TODO Auto-generated method stub
		if (time < start)
		{
			return;
		}
		if (time >= stop)
		{
			element.rotate(angleInDegrees);
			return;
		}
		double t = (double)(time - start) / (double)(stop - start);
		element.rotate(angleInDegrees*t);
	}

}
