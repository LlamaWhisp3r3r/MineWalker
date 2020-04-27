import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MineFieldButton button = (MineFieldButton) arg0.getSource();
		button.setColor();
	}

}
