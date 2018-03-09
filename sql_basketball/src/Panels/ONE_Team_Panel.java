package Panels;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class One_Team_Panel extends JPanel {
	
	public One_Team_Panel(ArrayList<String> result) {
		this.setLayout(null);
		
		JLabel lblTeamname = new JLabel("Team_Name");
		lblTeamname.setBounds(30, 32, 112, 39);
		this.add(lblTeamname);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(30, 103, 131, 108);
		this.add(lblPicture);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(219, 32, 197, 218);
		this.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblStats = new JLabel("Stats");
		lblStats.setBounds(454, 44, 46, 14);
		this.add(lblStats);
		
		JLabel lblTotalPoints = new JLabel("Total Points:");
		lblTotalPoints.setBounds(454, 69, 112, 14);
		this.add(lblTotalPoints);
		
		JLabel lblAssists = new JLabel("Assists:");
		lblAssists.setBounds(454, 93, 63, 14);
		this.add(lblAssists);
		
		JLabel lblDefensiveRebounds = new JLabel("Defensive rebounds:");
		lblDefensiveRebounds.setBounds(454, 118, 112, 14);
		this.add(lblDefensiveRebounds);
		
	}

}
