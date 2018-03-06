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
//		final JPanel panel = new JPanel();
//		final String premissions[] = {GUEST, ADMIN};
//		final JScrollPane scroll = new JScrollPane(panel);
//		final JButton jbInsertUser = new JButton("Insert User");
//		panel.setBorder(BorderFactory.createLineBorder(Color.red));
//		panel.setLayout(new GridLayout(3, 2, 2, 2));
//		JLabel username = new JLabel("Username:");
//		JTextField jtfUsername = new JTextField();
//		JLabel password = new JLabel("Password:");
//		JTextField jtfPassword = new JTextField();
//		JLabel premission = new JLabel("Premission:");
//		JComboBox<String> jCPremission = new JComboBox<>(premissions);
//		panel.add(username);
//		panel.add(jtfUsername);
//		panel.add(password);
//		panel.add(jtfPassword);
//		panel.add(premission);
//		panel.add(jCPremission);
//		setLayout(new BorderLayout());
//		add(jbInsertUser, BorderLayout.SOUTH);
//		add(scroll, BorderLayout.CENTER);
//		setSize(300, 300);
//		setVisible(true);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new Remove_Player_Panel());
		frame.pack();
		frame.setSize(300, 180);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
