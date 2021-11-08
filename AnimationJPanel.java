

import java.awt.*;  
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class AnimationJPanel extends JPanel  implements Runnable
{
	
	
	private ArrayList<AnimationElement> elements;
	
	
	
	private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;

    private Thread animator;
    private int x, y, time;
	
	
	
	
	Toolkit t; 
	private BufferedImage image;
	public AnimationJPanel() {
		elements = new ArrayList<AnimationElement>();
		testElements();
		setLayout(null);
		t=Toolkit.getDefaultToolkit(); 
		
		try 
		{                
	        image = ImageIO.read(new File("C:\\JavaGame\\JavaGameProject\\src\\GoblinTennis/bracket.png"));
	    } 
		catch (IOException ex) {
	          System.out.println("image didn't load");
	    }
		
		
		x = INITIAL_X;
        y = INITIAL_Y;
        time = 0;
        
        System.out.println(System.getProperty("user.dir"));
	}
	
	
	
	
	
	
	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (AnimationElement e : elements)
        {
        	e.draw(g, time);
        }
		
		
		
		
		t.sync();
    }
	
	
	
	
	
	
	
	
	public void testElements()
	{
		BufferedImage i;
		try 
		{                
	        i = ImageIO.read(new File("Lower arm.png"));
	    } 
		catch (IOException ex) {
	          System.out.println("arm didn't load");
	          return;
	    }
		
		AnimationElement e = new AnimationElement(this);
		e.setImage(i);
		e.addCommand(new MoveToCommand(0, 0, 300, 100));
		e.addCommand(new MoveToCommand(0, 100, 100, 100));
		e.addCommand(new SetVisibilityCommand(0, true));
		elements.add(e);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }


   

    

    private void cycle() {
    	
    	for (AnimationElement e : elements)
    	{
    		e.runCommands(time);
    	}

        x += 1;
        y += 1;
        time += 1;

        if (y > B_HEIGHT) {

            y = INITIAL_Y;
            x = INITIAL_X;
        }
    }

    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                
                String msg = String.format("Thread interrupted: %s", e.getMessage());
                
                JOptionPane.showMessageDialog(this, msg, "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}

