

import javax.swing.JFrame;

public class MainWindow extends JFrame 
{

	private ButtonPanel buttonPanel;
	
	public MainWindow() 
	{
		buttonPanel = new ButtonPanel();
		buttonPanel.setOpaque(true);
		this.setContentPane(buttonPanel);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		this.setSize(1100,800);  
        //Display the window.
		///this.pack();
		this.setVisible(true);
	}
	
}
