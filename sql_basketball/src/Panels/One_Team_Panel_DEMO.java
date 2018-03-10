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
		
		JLabel lblTeamname = new JLabel("Player_Name");
		lblTeamname.setBounds(232, 25, 63, 39);
		panel.add(lblTeamname);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(405, 52, 212, 170);
		panel.add(lblPicture);
		
		JLabel lblNewLabel = new JLabel("Team:");
		lblNewLabel.setBounds(38, 74, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNumber = new JLabel("Number: #");
		lblNumber.setBounds(38, 91, 89, 14);
		panel.add(lblNumber);
		
		JLabel lblRole = new JLabel("Role: ");
		lblRole.setBounds(38, 105, 89, 14);
		panel.add(lblRole);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(38, 169, 72, 14);
		panel.add(lblHeight);
		
		JLabel lblNewLabel_1 = new JLabel("Weight: ");
		lblNewLabel_1.setBounds(38, 182, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Birthday: ");
		lblNewLabel_2.setBounds(38, 155, 131, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblRegion = new JLabel("Region: ");
		lblRegion.setBounds(38, 194, 89, 14);
		panel.add(lblRegion);
		
		JLabel label = new JLabel("");
		label.setBounds(38, 208, 46, 14);
		panel.add(label);
		
		JLabel lblSalary = new JLabel("Salary: ");
		lblSalary.setBounds(38, 116, 89, 19);
		panel.add(lblSalary);
		
		JLabel lblNewLabel_3 = new JLabel("Hire Date:");
		lblNewLabel_3.setBounds(38, 130, 116, 19);
		panel.add(lblNewLabel_3);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new MatteBorder(25, 25, 25, 25, (Color) new Color(0, 0, 0)));
		verticalBox.setBackground(Color.MAGENTA);
		verticalBox.setFont(new Font("Calibri", Font.PLAIN, 12));
		verticalBox.setForeground(Color.BLACK);
		verticalBox.setBounds(164, 65, 1, 185);
		panel.add(verticalBox);
		
		JLabel lblStats = new JLabel("STATS");
		lblStats.setBounds(197, 74, 46, 14);
		panel.add(lblStats);
	}
}
