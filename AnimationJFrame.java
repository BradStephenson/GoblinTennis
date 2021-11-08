package GoblinTennis;

import javax.swing.JFrame;

public class AnimationJFrame extends JFrame 
{

	private AnimationJPanel animPan;
	
	public AnimationJFrame()
	{
		animPan = new AnimationJPanel();
		this.setContentPane(animPan);
		this.setSize(400,400);  
		this.setVisible(true);
	}
	
	
	
}
