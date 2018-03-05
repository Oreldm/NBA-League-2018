package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Main.Actions;

public class Add_Player_Panel extends JPanel {
	public Add_Player_Panel() {
		final JPanel panel = new JPanel();
		JLabel label;
		final JScrollPane scroll = new JScrollPane(panel);
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		//panel.setPreferredSize(new Dimension(300, 500));
		panel.setLayout(new GridLayout(6, 1));
		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);

	}
}
