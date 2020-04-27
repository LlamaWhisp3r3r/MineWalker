import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MineFieldButton button = (MineFieldButton) arg0.getSource();
		if(button.isMine()) {
			button.setColor(Color.black);
		}else {
			Color buttonColor = button.getNearbyMineColor();
			button.setColor(buttonColor);
		}
	}

}
