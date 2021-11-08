

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class MainWindowPanel extends JPanel {
	
	private final Action showAnimation = new ShowAnimationAction();
	private Toolkit t;
	private BufferedImage coin;
	private Game game;
	private JLabel moneyLabel;
	private JLabel messageBar;
	private CharacterSheet characterSheet;
	private BracketPanel bracket;
	private JTabbedPane tabbedPane;
	
	public MainWindowPanel(Game game) {
		game.setPanel(this);
		this.game = game;
		characterSheet = new CharacterSheet(game);
		t=Toolkit.getDefaultToolkit(); 
		setBackground(new Color(71, 160, 71));
		setLayout(null);
		
		JButton showAnimationButton = new JButton("Show Animation");
		showAnimationButton.setBounds(500, 5, 146, 23);
		showAnimationButton.setAction(showAnimation);
		add(showAnimationButton);
		
		JButton playMatchButton = new JButton("Play Match");
		playMatchButton.setBounds(220, 5, 146, 23);
		playMatchButton.setAction(new PlayMatchAction());
		add(playMatchButton);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 20, 1285, 748);
		add(tabbedPane);
		
		bracket = new BracketPanel(characterSheet);
		tabbedPane.addTab("Bracket", null, bracket, null);
		tabbedPane.addTab("Character Sheet", null, characterSheet, null);
		
		messageBar = new JLabel("Welcome!");
		messageBar.setFont(characterSheet.getFont());
		messageBar.setBounds(10, 770, 1020, 34);
		moneyLabel = new JLabel("Money");
		moneyLabel.setFont(characterSheet.getFont());
		moneyLabel.setBounds(840, 5, 62, 42);
		add(moneyLabel);
		add(messageBar);
		getCoinImage();
		
	}
	
	public void showMessage(String message)
	{
		messageBar.setText(message);
		update();
	}
	
	private void getCoinImage()
	{
		this.coin = GoblinTools.getImageFromFilename("Coin.png");
		
	}

	private class ShowAnimationAction extends AbstractAction {
		public ShowAnimationAction() {
			putValue(NAME, "Show Animation");
			putValue(SHORT_DESCRIPTION, "Some Animation Description");
		}
		public void actionPerformed(ActionEvent e) {
			AnimationJFrame ajf = new AnimationJFrame("AnimationFileSample.ani");
			System.out.println("AnimationPanel");
			
		}
	}
	private class PlayMatchAction extends AbstractAction 
	{
		public PlayMatchAction() 
		{
			putValue(NAME, "Play Match");
			putValue(SHORT_DESCRIPTION, "Play the next match, in order");
		}
		public void actionPerformed(ActionEvent e) 
		{
			game.playMatch();
		}
	}
	
	private void update()
	{
		moneyLabel.setText("" + game.getMoney());
		t.sync();
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(coin, 800,5,this);
		update();
		
		
		
    }
	
	public void putGoblinInPosition(int goblin, int position)
	{
		bracket.putGoblinInPosition(goblin, position);
	}
	public void switchToCharacterSheet()
	{
		tabbedPane.setSelectedIndex(1);
	}
}
