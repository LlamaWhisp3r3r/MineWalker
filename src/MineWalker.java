import javax.swing.JFrame;

public class MineWalker {

	public static void main(String[] args) {
		
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().add(new MineWalkerPanel());
		mainFrame.pack();
		mainFrame.setVisible(true);
		

	}

}
