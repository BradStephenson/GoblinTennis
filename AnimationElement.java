package GoblinTennis;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationElement 
{
	ArrayList<AnimationCommand> commandList;
	ArrayList<BufferedImage> imageList;
	BufferedImage image;
	AnimationJPanel panel;
	private boolean visible = true;
	private int x, y;
	public AnimationElement(AnimationJPanel p)
	{
		commandList = new ArrayList<AnimationCommand>();
		imageList = new ArrayList<BufferedImage>();
		panel = p;
		
		x = 0;
		y = 0;
	}
	
	public void addCommand(AnimationCommand c)
	{
		commandList.add(c);
		c.setElement(this);
	}
	public void addImage(BufferedImage i)
	{
		imageList.add(i);
	}
	public void setImage(BufferedImage i)
	{
		image = i;
	}
	public void runCommands(int time)
	{
		for (AnimationCommand c : commandList)
		{
			c.runCommand(time);
		}
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public void draw(Graphics g, int time)
	{
		if(visible)
		{
			g.drawImage(image, x,y,panel);
			System.out.println(x + " " + time);
		}
	}
	
	
	
	
	
	
	
	// -- Command Methods --
	public void makeVisible()
	{
		visible = true;
	}
	public void makeInvisible()
	{
		visible = false;
	}
	public void setVisibility(boolean visibility)
	{
		this.visible = visibility;
	}
	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public void setLocationX(int x)
	{
		this.x = x;
	}
	public void setLocationY(int y)
	{
		this.y = y;
	}
		
}
