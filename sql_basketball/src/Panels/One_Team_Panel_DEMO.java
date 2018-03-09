package Panels;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

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
		
		JLabel lblTeamname = new JLabel("Team_Name");
		lblTeamname.setBounds(30, 32, 112, 39);
		panel.add(lblTeamname);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(30, 103, 131, 108);
		panel.add(lblPicture);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(219, 32, 197, 218);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblStats = new JLabel("Stats");
		lblStats.setBounds(454, 44, 46, 14);
		panel.add(lblStats);
		
		JLabel lblTotalPoints = new JLabel("Total Points:");
		lblTotalPoints.setBounds(454, 69, 112, 14);
		panel.add(lblTotalPoints);
		
		JLabel lblAssists = new JLabel("Assists:");
		lblAssists.setBounds(454, 93, 63, 14);
		panel.add(lblAssists);
		
		JLabel lblDefensiveRebounds = new JLabel("Defensive rebounds:");
		lblDefensiveRebounds.setBounds(454, 118, 112, 14);
		panel.add(lblDefensiveRebounds);
	}
}
