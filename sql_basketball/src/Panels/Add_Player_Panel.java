package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Main.Actions;

public class Add_Player_Panel extends JPanel {
	private	JTextField jtfPlayerId = new JTextField();
	private JTextField jtfFirstName = new JTextField();
	private JTextField jtfLastName = new JTextField();
	private JTextField jtfShirtNumbers = new JTextField();
	private static String []arr = {"G", "F", "C"};
	private JComboBox<String> jtfPosition = new JComboBox<>(arr);
	private JTextField jtfHeight = new JTextField();
	private JTextField jtfWeight = new JTextField();
	private JTextField jtfBirthday = new JTextField();
	private JTextField jtfRegion = new JTextField();
	private JTextField jtfHireDate = new JTextField();
	private JTextField jtfSalary = new JTextField();
	private JTextField jtfTeamId = new JTextField();
	private JTextField jtfImage = new JTextField();
	
	private JLabel jlStatus = new JLabel();
	
	public Add_Player_Panel() {
		final JPanel panel = new JPanel();
		final JScrollPane scroll = new JScrollPane(panel);
		final JButton jbAddPlayer = new JButton("Add Player");
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		panel.setLayout(new GridLayout(14, 2, 1, 1));
		
		JLabel playerId = new JLabel("Player ID:");
		JLabel firstName = new JLabel("First Name:");
		JLabel lastName = new JLabel("Last Name:");
		JLabel shirtNumbers = new JLabel("Shirt Number:");
		JLabel position = new JLabel("Position:");
		JLabel height = new JLabel("Height:");
		JLabel weight = new JLabel("Weight:");
		JLabel birthday = new JLabel("Birthday: (DD/MM/YYYY)");
		JLabel region = new JLabel("Region:");
		JLabel hireDate = new JLabel("Hire date: (DD/MM/YYYY)");
		JLabel salary = new JLabel("Salary:");
		JLabel teamId = new JLabel("Team ID:");
		JLabel image = new JLabel("Image:");
		

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
		
		panel.add(weight);
		panel.add(jtfWeight);
		
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
		
		panel.add(image);
		panel.add(jtfImage);
		panel.add(jlStatus);
		
		jbAddPlayer.addActionListener(Actions.AddPlayer());
		
		setLayout(new BorderLayout());
		add(jbAddPlayer, BorderLayout.SOUTH);
		
		add(scroll, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
	}
	
	public String getData() {
		System.out.println("HERERHEHR123123");
		String lastField;
		if (jtfImage.getText().equals(""))
			lastField="NULL";
		else
			lastField="'"+jtfImage.getText()+"'";
		return jtfPlayerId.getText()+", '"+jtfFirstName.getText()+"', '"+jtfLastName.getText()+"', "+
				jtfShirtNumbers.getText()+", '"+jtfPosition.getSelectedItem()+"', "+jtfHeight.getText()+", "+
				jtfWeight.getText()+", '"+jtfBirthday.getText()+"', '"+jtfRegion.getText()+"', '"+
				jtfHireDate.getText()+"', "+jtfSalary.getText()+", "+jtfTeamId.getText()+", "+
				lastField;
	}
	
	
	public void setStatus(String txt) {
		jlStatus.setText(txt);
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
