import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;

public class CharacterSheet extends JPanel {
	private Random rand;
	private ArrayList<Character> characters;
	private Character activeCharacter;
	private Toolkit t;
	private Game game;
	private JLabel bigHead;
	private Graphics g;
	private Font font;
	
	
	private JButton itchButton, poisonButton, bribeButton, honeyButton;
	public CharacterSheet(ArrayList<Character> characters)
	{
		this.characters = characters;
	}
	public CharacterSheet(Game game)
	{
		
		font = GoblinTools.getFont();
		setBackground(new Color(160, 70, 71));
		setLayout(null);
		t=Toolkit.getDefaultToolkit();
		JList list = new JList();
		add(list);
		characters = new ArrayList<Character>();
		makeCharacters();
		putGoblinsOnSheet();
		activeCharacter = characters.get(1);
		this.game = game;
		rand = game.getRand();
		bigHead = new JLabel(activeCharacter.getBigHead());
		bigHead.setBounds(30, 30, 310, 310);
		add(bigHead);
		JLabel skillLabel = new JLabel("Skill");
		skillLabel.setFont(font);
		skillLabel.setBounds(400, 80, 190, 40);
		add(skillLabel);
		game.setCharacters(characters);
		setupActionButtons();
	}
	
	public void changeActiveCharacter(Character goblin)
	{
		activeCharacter = goblin;
		bigHead.setIcon(activeCharacter.getBigHead());
		repaint();
		t.sync();
	}
	public JButton getGoblinButton(int which)
	{
		return characters.get(which - 1).getButton();
	}
	private void makeCharacters()
	{
		String name;
		name = "Bob";
		characters.add(new Character(name, name + " is a Boblin", 10, getHead("goblin head shot 001.png", name), this));
		name = "Larry";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 002.png", name), this));
		name = "Moe";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 003.png", name), this));
		name = "Curly";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 004.png", name), this));
		name = "Shemp";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 005.png", name), this));
		name = "Reginald";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 006.png", name), this));
		name = "Orlando";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 007.png", name), this));
		name = "Othman";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 008.png", name), this));
		name = "Randy";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 009.png", name), this));
		name = "Gob";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 010.png", name), this));
		name = "Dufus";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 011.png", name), this));
		name = "Rufus";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 012.png", name), this));
		name = "Stufus";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 013.png", name), this));
		name = "Moops";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 014.png", name), this));
		name = "Gob Gob Gob";
		characters.add(new Character(name, name + " is a Goblin", 10, getHead("goblin head shot 015.png", name), this));
		name = "Rob";
		characters.add(new Character(name, name + " is a Roblin", 10, getHead("goblin head shot 016.png", name), this));
		
	}
	public void setupActionButtons()
	{
		this.itchButton = new JButton("Itch");
		this.itchButton.setBounds(100, 400, 100, 40);
		this.itchButton.setAction(new ItchyAnimation());
		add(this.itchButton);
		
		this.poisonButton = new JButton("Poison");
		this.poisonButton.setBounds(250, 400, 100, 40);
		this.poisonButton.setAction(new PoisonAnimation());
		add(this.poisonButton);
		
		this.honeyButton = new JButton("Sabotage");
		this.honeyButton.setBounds(400, 400, 100, 40);
		this.honeyButton.setAction(new HoneyAnimation());
		add(this.honeyButton);
		
		this.bribeButton = new JButton("Bribe");
		this.bribeButton.setBounds(550, 400, 100, 40);
		this.bribeButton.setAction(new BribeAnimation());
		add(this.bribeButton);
	}
	private ImageIcon getHead(String fileName, String name)
	{
		ImageIcon icon = new ImageIcon("Goblin Heads/" + fileName, name);
		
		
		//ImageIcon imageIcon = new ImageIcon("./img/imageName.png"); // load the image to a imageIcon
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(62, 62,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon = new ImageIcon(newimg);
		return icon;
	}
	
	private void putGoblinsOnSheet()
	{
		for (int i = 1; i <= 16; i++)
		{
			JButton jb = getGoblinButton(i);
			jb.setVisible(true);
			jb.setLocation(78*i - 53, 633);
			add(jb);
		}
	}
	public Font getFont()
	{
		return this.font;
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(activeCharacter.getBigHead(), 40, 50, this);
		
		
		t.sync();
    }
	public void showMessage(String s)
	{
		game.showMessage(s);
	}
	public void switchToCharacterSheet()
	{
		game.switchToCharacterSheet();
	}
	public String getHobby()
	{
		return "Fighting low level adventuing parties";
	}
	public String getBribeHobby()
	{
		return "Playing Goblin Poker";
	}
	public Random getRand()
	{
		return rand;
	}
	
	private class HoneyAnimation extends AbstractAction {
		public HoneyAnimation() {
			putValue(NAME, "Sabotage");
			putValue(SHORT_DESCRIPTION, "Sabotage a player's raquet with honey");
		}
		public void actionPerformed(ActionEvent e) {
			AnimationJFrame ajf = new AnimationJFrame("AnimationFileSample.ani");
			activeCharacter.honey();
		}
	}
	private class ItchyAnimation extends AbstractAction {
		public ItchyAnimation() {
			putValue(NAME, "Itching Powder");
			putValue(SHORT_DESCRIPTION, "Make a player dance!");
		}
		public void actionPerformed(ActionEvent e) {
			AnimationJFrame ajf = new AnimationJFrame("Itchy.ani");
			activeCharacter.itch();
		}
	}
	private class BribeAnimation extends AbstractAction {
		public BribeAnimation() {
			putValue(NAME, "Bribe");
			putValue(SHORT_DESCRIPTION, "Bribe a player to throw a match");
		}
		public void actionPerformed(ActionEvent e) {
			AnimationJFrame ajf = new AnimationJFrame("Bribe.ani");
			activeCharacter.bribe();
		}
	}
	private class PoisonAnimation extends AbstractAction {
		public PoisonAnimation() {
			putValue(NAME, "Poison!");
			putValue(SHORT_DESCRIPTION, "Poison a player!");
		}
		public void actionPerformed(ActionEvent e) {
			AnimationJFrame ajf = new AnimationJFrame("Poison.ani");
			activeCharacter.poison();
		}
	}
}
