

public class MoveToCommand extends AnimationCommand {
	int start, stop, toX, toY, fromX, fromY;

	public MoveToCommand(int start, int stop, int toX, int toY)
	{
		this.start = start;
		this.stop = stop;
		this.toX = toX;
		this.toY = toY;
		fromX = 0;
		fromY = 0;
	}
	
	
	
	@Override
	public void runCommand(int time) {
		// TODO Auto-generated method stub
		if (time < start)
		{
			return;
		}
		if (time > stop)
		{
			return;
		}
		if(time == stop)
		{
			element.setLocation(toX, toY);
			return;
		}
		if (time == start)
		{
			fromX = element.getX();
			fromY = element.getY();
		}
		
		int dx, dy;
		double t = (double)(time - start) / (double)(stop - start);
		dx = (int)((toX - fromX) * t);
		dy = (int)((toY - fromY) * t);
		element.setLocation(fromX + dx, fromY + dy);

	}

}
