import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BracketPanel extends JPanel 
{
	BufferedImage bracketImage;
	CharacterSheet characterSheet;
	private int whichMatch = 1;
	public BracketPanel(CharacterSheet characterSheet)
	{
		setLayout(null);
		this.characterSheet = characterSheet;
		bracketImage = GoblinTools.getImageFromFilename("bracket_with_portraits.png");
		for (int i = 1; i <= 16; i++)
		{
			putGoblinInPosition(i, i);
		}
	}
	public void paintComponent(Graphics g) 
	{
        super.paintComponent(g);
		g.drawImage(bracketImage, 0,0, this);
	}

	public void putGoblinInPosition(int goblin, int position)
	{
		JButton jb = characterSheet.getGoblinButton(goblin);
		jb.setVisible(true);
		add(jb);
		
		if (position == 1)
			jb.setLocation(127, 117);
		if (position == 2)
			jb.setLocation(127, 187);
		if (position == 3)
			jb.setLocation(127, 257);
		if (position == 4)
			jb.setLocation(127, 327);
		if (position == 5)
			jb.setLocation(127, 397);
		if (position == 6)
			jb.setLocation(127, 467);
		if (position == 7)
			jb.setLocation(127, 537);
		if (position == 8)
			jb.setLocation(127, 607);
		if (position == 9)
			jb.setLocation(1092, 117);
		if (position == 10)
			jb.setLocation(1092, 187);
		if (position == 11)
			jb.setLocation(1092, 257);
		if (position == 12)
			jb.setLocation(1092, 327);
		if (position == 13)
			jb.setLocation(1092, 397);
		if (position == 14)
			jb.setLocation(1092, 467);
		if (position == 15)
			jb.setLocation(1092, 537);
		if (position == 16)
			jb.setLocation(1092, 607);
		if (position == 17)
			jb.setLocation(358, 218);
		if (position == 18)
			jb.setLocation(358, 358);
		if (position == 19)
			jb.setLocation(358, 498);
		if (position == 20)
			jb.setLocation(358, 638);
		if (position == 21)
			jb.setLocation(861, 218);
		if (position == 22)
			jb.setLocation(861, 358);
		if (position == 23)
			jb.setLocation(861, 498);
		if (position == 24)
			jb.setLocation(861, 638);
		if (position == 25)
			jb.setLocation(484, 288);
		if (position == 26)
			jb.setLocation(484, 568);
		if (position == 27)
			jb.setLocation(735, 288);
		if (position == 28)
			jb.setLocation(735, 568);
		if (position == 29)
			jb.setLocation(609, 361);
		if (position == 30)
			jb.setLocation(609, 495);
		if (position == 31)
			jb.setLocation(609, 138);
		
		repaint();
	}
}
