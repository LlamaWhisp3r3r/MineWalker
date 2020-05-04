import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
	
	private MineFieldPanel mfp;
	private MineWalkerPanel mwp;

	
	public ButtonActionListener(MineFieldPanel mfp, MineWalkerPanel mwp) {
		this.mfp = mfp;
		this.mwp = mwp;
	}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MineFieldButton button = (MineFieldButton) arg0.getSource();
			if(button.hasActive()) {
				if(button.isMine()) {
					button.setColor(Color.black);
					mfp.lives--;
				}else {
					Color buttonColor = button.getNearbyMineColor();
					button.setColor(buttonColor);
					button.activate();
					mwp.score--;
				}
			}
			
			mwp.updateScorePanel();
		}
}
