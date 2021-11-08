

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class ButtonPanel extends JPanel {
	private final Action showAnimation = new ShowAnimationAction();
	public ButtonPanel() {
		setBackground(new Color(51, 102, 51));
		setLayout(null);
		
		JButton showAnimationButton = new JButton("Show Animation");
		showAnimationButton.setBounds(10, 266, 109, 23);
		showAnimationButton.setAction(showAnimation);
		add(showAnimationButton);
	}

	private class ShowAnimationAction extends AbstractAction {
		public ShowAnimationAction() {
			putValue(NAME, "Show Animation");
			putValue(SHORT_DESCRIPTION, "Some Animation Description");
		}
		public void actionPerformed(ActionEvent e) {
			AnimationJFrame ajf = new AnimationJFrame();
			System.out.println("AnimationPanel");
		}
	}
}
