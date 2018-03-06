package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Main.Actions;

public class Add_Player_Panel extends JPanel {
	public Add_Player_Panel() {
		final JPanel panel = new JPanel();
		final JScrollPane scroll = new JScrollPane(panel);
		final JButton jbAddPlayer = new JButton("Add Player");
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		panel.setLayout(new GridLayout(12, 2, 1, 1));
		
		JLabel playerId = new JLabel("Player ID:");
		JLabel firstName = new JLabel("First Name:");
		JLabel lastName = new JLabel("Last Name:");
		JLabel shirtNumbers = new JLabel("Shirt Number:");
		JLabel position = new JLabel("Position:");
		JLabel height = new JLabel("Height:");
		JLabel birthday = new JLabel("Birthday:");
		JLabel region = new JLabel("Region:");
		JLabel hireDate = new JLabel("Hire date:");
		JLabel salary = new JLabel("Salary:");
		JLabel teamId = new JLabel("Team ID:");
		
		JTextField jtfPlayerId = new JTextField();
		JTextField jtfFirstName = new JTextField();
		JTextField jtfLastName = new JTextField();
		JTextField jtfShirtNumbers = new JTextField();
		JTextField jtfPosition = new JTextField();
		JTextField jtfHeight = new JTextField();
		JTextField jtfBirthday = new JTextField();
		JTextField jtfRegion = new JTextField();
		JTextField jtfHireDate = new JTextField();
		JTextField jtfSalary = new JTextField();
		JTextField jtfTeamId = new JTextField();

		panel.add(playerId);
		panel.add(jtfPlayerId);
		
		panel.add(firstName);
		panel.add(jtfFirstName);
		
		panel.add(lastName);
		panel.add(jtfLastName);
		
		panel.add(shirtNumbers);
		panel.add(jtfShirtNumbers);
		
		panel.add(position);
		panel.add(jtfPosition);
		
		panel.add(height);
		panel.add(jtfHeight);
		
		panel.add(birthday);
		panel.add(jtfBirthday);
		
		panel.add(region);
		panel.add(jtfRegion);
		
		panel.add(hireDate);
		panel.add(jtfHireDate);
		
		panel.add(salary);
		panel.add(jtfSalary);
		
		panel.add(teamId);
		panel.add(jtfTeamId);
		
		setLayout(new BorderLayout());
		add(jbAddPlayer, BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new Add_Player_Panel());
		frame.pack();
		frame.setSize(300, 500);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
