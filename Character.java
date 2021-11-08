import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Character 
{
	private String name, blurb;
	private int skill;
	private int tempSkillModifier = 0;
	private ImageIcon head;
	private double vulToItch = .2;
	private double vulToHoney = .2;
	private double vulToPoison = .2;
	private double vulToBribe = .2;
	private Random rand;
	private CharacterSheet characterSheet;
	CharacterButtonAction buttonAction;
	
	
	public Character()
	{
		this.name = "larry";
		this.skill = 10;
		this.blurb = "Larry is one of the stooges.";
		
	}
	public Character(String name, String blurb, int skill, ImageIcon head, CharacterSheet characterSheet)
	{
		this.name = name;
		this.blurb = blurb;
		this.skill = skill;
		this.head = head;
		this.characterSheet = characterSheet;
		this.rand = characterSheet.getRand();
		buttonAction = new CharacterButtonAction(this, characterSheet);
		
		rand = new Random(System.currentTimeMillis());
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getBlurb()
	{
		return this.blurb;
	}
	
	public void setSkillMod(int mod)
	{
		this.tempSkillModifier = mod;
	}
	
	public int getSkill()
	{
		int temp = this.tempSkillModifier;
		this.tempSkillModifier = 0;
		return (skill + temp);
	}
	public JButton getButton()
	{
		JButton button = new JButton();
		button.setIcon(head);
		button.setBounds(0, 0, 62, 62);
		button.setToolTipText(this.blurb);
		button.setAction(buttonAction);
		button.setIcon(head);
		return button;
	}
	public ImageIcon getImage()
	{
		return head;
	}
	public ImageIcon getBigHead()
	{
		Image i = head.getImage();

		Image newimg = i.getScaledInstance(310, 310,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		
		ImageIcon ii = new ImageIcon(newimg);
		
		return ii;
	}
	public void bribe()
	{
		if (rand.nextDouble() < this.vulToBribe)
		{
			tempSkillModifier = 0 - skill;
		}
	}
	public void poison()
	{
		if (rand.nextDouble() < this.vulToPoison)
		{
			tempSkillModifier = -15;
		}
	}
	public void honey()
	{
		if (rand.nextDouble() < this.vulToHoney)
		{
			tempSkillModifier = -5;
		}
	}
	public void itch()
	{
		if (rand.nextDouble() < this.vulToItch)
		{
			tempSkillModifier = -10;
		}
	}
	
	public void setVulToItch(double d)
	{
		this.vulToItch = d;
	}
	public void setVulToPoison(double d)
	{
		this.vulToPoison = d;
	}
	public void setVulToHoney(double d)
	{
		this.vulToHoney = d;
	}
	public void setVulToBribe(double d)
	{
		this.vulToBribe = d;
	}
	private class CharacterButtonAction extends AbstractAction {
		Character character;
		CharacterSheet characterSheet;
		public CharacterButtonAction(Character character, CharacterSheet characterSheet) {
			this.character = character;
			this.characterSheet = characterSheet;
			//putValue(NAME, character.getName());
			putValue(SHORT_DESCRIPTION, character.getBlurb());
		}
		public void actionPerformed(ActionEvent e) {
			characterSheet.changeActiveCharacter(character);
			//System.out.println(character.getName() + " is clicked");
			characterSheet.showMessage(character.name);
			characterSheet.switchToCharacterSheet();
		}
	}
}
