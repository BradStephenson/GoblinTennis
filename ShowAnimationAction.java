import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
public class ShowAnimationAction extends AbstractAction {
		public ShowAnimationAction() {
			putValue(NAME, "Show Animation");
			putValue(SHORT_DESCRIPTION, "Some Animation Description");
		}
		public void actionPerformed(ActionEvent e) {
			AnimationJFrame ajf = new AnimationJFrame();
			System.out.println("AnimationPanel");
		}
	}