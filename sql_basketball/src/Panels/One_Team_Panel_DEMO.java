package Panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;

public class One_Team_Panel_DEMO {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					One_Team_Panel_DEMO window = new One_Team_Panel_DEMO();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public One_Team_Panel_DEMO() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCoachname = new JLabel("Coach_Name");
		lblCoachname.setBounds(30, 24, 255, 31);
		panel.add(lblCoachname);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setBounds(30, 84, 169, 36);
		panel.add(lblBirthday);
		
		JLabel lblRegion = new JLabel("Region:");
		lblRegion.setBounds(30, 148, 169, 36);
		panel.add(lblRegion);
		
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setBounds(263, 84, 169, 36);
		panel.add(lblSalary);
		
		JLabel lblHireDate = new JLabel("Hire Date: ");
		lblHireDate.setBounds(263, 148, 169, 36);
		panel.add(lblHireDate);
		
		JButton btnBackToTeam = new JButton("Back To Team");
		btnBackToTeam.setBounds(471, 28, 119, 36);
		panel.add(btnBackToTeam);
	}
}
