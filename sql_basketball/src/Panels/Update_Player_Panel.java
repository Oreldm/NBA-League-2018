package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Main.Actions;

public class Update_Player_Panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JTextField jtfSearch = new JTextField();
	private final JLabel jlStatus = new JLabel();
	private JPanel panel2 = new JPanel();
	private JTextField jtfShirtNumbers = new JTextField();
	private JTextField jtfSalary = new JTextField();
	private JTextField jtfTeamId = new JTextField();
	
	public Update_Player_Panel() {
		
		JPanel panel = new JPanel();
		//JPanel panel2 = new JPanel();
		final JButton jbSearch = new JButton("Search");
		final JLabel jlSearch = new JLabel("Enter Player ID:");
		final JScrollPane scroll = new JScrollPane(panel);
		jtfSearch.setPreferredSize(new Dimension(100,24));
		panel.add(jlSearch);
		panel.add(jtfSearch);
		panel.add(jbSearch);
		panel.add(jlStatus);
		jbSearch.addActionListener(Actions.searchPlayer());
		//createSubPanel();
		
		setLayout(new BorderLayout());
		add(scroll, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
	}
	
	
	public void createSubPanel(JPanel panel) {
		//final JPanel panel = new JPanel();
		
		final JButton jbUpdatePlayer = new JButton("Update Player");
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		panel.setLayout(new GridLayout(0, 2, 1, 1));

//		JLabel firstName = new JLabel("First Name:");
//		JLabel lastName = new JLabel("Last Name:");
		JLabel shirtNumbers = new JLabel("Shirt Number:");
//		JLabel position = new JLabel("Position:");
//		JLabel height = new JLabel("Height:");
//		JLabel birthday = new JLabel("Birthday:");
//		JLabel region = new JLabel("Region:");
//		JLabel hireDate = new JLabel("Hire date:");
		JLabel salary = new JLabel("Salary:");
		JLabel teamId = new JLabel("Team ID:");


		panel.add(shirtNumbers);
		panel.add(jtfShirtNumbers);


		panel.add(salary);
		panel.add(jtfSalary);

		panel.add(teamId);
		panel.add(jtfTeamId);
		
		jbUpdatePlayer.addActionListener(Actions.updatePlayer());
		
		
		add(jbUpdatePlayer, BorderLayout.SOUTH);
		updateUI();

		
	}
	public void setStatus(String txt) {
		jlStatus.setText(txt);
	}
	
	public String getPlayerToSearch() {
		return jtfSearch.getText();
	}
	public void setEditableFalse() {
		jtfSearch.setEditable(false);
	}
	
	public JPanel getSubPanel(){
		return panel2;
	}
	
	public String getData() {
		String field1, field2, field3;
		field1=(jtfShirtNumbers.getText().equals("")) ? "NULL" : jtfShirtNumbers.getText();
		field2=(jtfSalary.getText().equals("")) ? "NULL" : jtfSalary.getText();
		field3=(jtfTeamId.getText().equals("")) ? "NULL" : jtfTeamId.getText();
		return jtfSearch.getText()+", "+field1+", "+field2+", "+field3;
	}

//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.add(new Update_Player_Panel());
//		frame.pack();
//		frame.setSize(300, 500);
//		frame.setLocationRelativeTo(null); // Center the frame
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setAlwaysOnTop(true);
//		frame.setResizable(false);
//		frame.setVisible(true);
//	}
}
