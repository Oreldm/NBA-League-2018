package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Remove_Player_Panel extends JPanel{
	private String GUEST = "Guest";
	private String ADMIN = "Administrator";
	
	public Remove_Player_Panel() {
		final JPanel panel = new JPanel();
		final JScrollPane scroll = new JScrollPane(panel);
		final JButton jbDeletePlayer = new JButton("Delete Player");
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		panel.setLayout(new GridLayout(1, 2, 2, 2));
		JLabel playerId = new JLabel("Player ID:");
		JTextField jtfUsername = new JTextField();
		panel.add(playerId);
		panel.add(jtfUsername);
		setLayout(new BorderLayout());
		add(jbDeletePlayer, BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new Remove_Player_Panel());
		frame.pack();
		frame.setSize(300, 100);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
