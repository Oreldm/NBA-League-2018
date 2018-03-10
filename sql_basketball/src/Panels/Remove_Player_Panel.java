package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Main.Actions;

public class Remove_Player_Panel extends JPanel{
//	private String GUEST = "Guest";
//	private String ADMIN = "Administrator";
	private static JLabel jlStatus = new JLabel("check");
	private JTextField jtfUsername;
	public Remove_Player_Panel() {
		final JPanel panel = new JPanel();
		final JPanel panel2 = new JPanel();
		final JScrollPane scroll = new JScrollPane(panel);
		final JButton jbDeletePlayer = new JButton("Delete Player");
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		//panel.setLayout(new GridLayout(0, 2, 2, 2));
		JLabel playerId = new JLabel("Player ID:");
		jtfUsername = new JTextField();
		jtfUsername.setPreferredSize(new Dimension(100, 24));
		panel.add(playerId);
		panel.add(jtfUsername);
		setLayout(new BorderLayout());
		panel2.add(jbDeletePlayer, BorderLayout.CENTER);
		panel.add(jlStatus);
		jbDeletePlayer.addActionListener(Actions.deletePlayers());
		add(panel2, BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public String getLabelText() {
		return jtfUsername.getText();
	}
	public void setStatus(String txt) {
		jlStatus.setText(txt);
	}
}
