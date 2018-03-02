package Main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import utils.ImagesGui;

public class Program implements ImagesGui {
	public static void main(String[] args) throws ClassNotFoundException {
		LoginGUI frame = new LoginGUI();
		setFrameProperites(frame);
	}

	private static void setFrameProperites(LoginGUI frame) {
		final String loginTitle = "Login To OracleDB";

		frame.pack();
		frame.setSize(300, 180);
		frame.setIconImage(BASKETBALL_ICON.getImage());
		frame.setTitle(loginTitle);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// TODO: (not only here)
				// DELETE CACHE
				// CLOSE CONNECTION
			}
		});
	}  
}
