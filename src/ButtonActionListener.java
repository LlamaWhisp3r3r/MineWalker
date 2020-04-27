import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MineFieldButton button = (MineFieldButton) arg0.getSource();
		if(button.hasActive()) {
			if(button.isMine()) {
				button.setColor(Color.black);
				button.activate();
			}else {
				Color buttonColor = button.getNearbyMineColor();
				button.setColor(buttonColor);
				button.activate();
			}
		}
	}

}
