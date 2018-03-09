package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Trade_Players_Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Trade_Players_Panel() {
		final JPanel panel = new JPanel();
//		final String teams[] = getTeamsName();
		final String teams[] = {"a","b","c","d","e","f"};
		final String players1[] = {"1","2","3","4"};
		final String players2[] = {"11","12","13","14"};
		final JList jlPlayers1 = new JList(players1);
		final JList jlPlayers2 = new JList(players2);
		final JScrollPane scroll = new JScrollPane(panel);
		panel.setLayout(new GridLayout(2,2,2,2));
		JComboBox<String> firstTeam = new JComboBox<>(teams);
		JComboBox<String> secondTeam = new JComboBox<>(teams);
		panel.add(firstTeam);
		panel.add(jlPlayers1);
		panel.add(secondTeam);
		panel.add(jlPlayers2);
		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);

	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new Trade_Players_Panel());
		frame.pack();
		frame.setSize(300, 180);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
