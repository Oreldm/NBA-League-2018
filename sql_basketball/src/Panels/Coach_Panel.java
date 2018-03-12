package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Main.Actions;
import nba_objects.Coach;
import nba_objects.Team;
import utils.FilesUtils;
import utils.ImagesGui;
import utils.Paths_NBA;

public class Coach_Panel extends JPanel implements Paths_NBA {
	private static final long serialVersionUID = 1L;
	
	public Coach_Panel(ArrayList<String> result) throws HeadlessException, SQLException, IOException {
		Coach coach=new Coach(result);
		
		this.setLayout(null);
		
		JLabel lblCoachname = new JLabel(coach.firstName+ " "+coach.lastName);
		lblCoachname.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 34));
		lblCoachname.setForeground(Color.RED);
		lblCoachname.setBounds(30, 24, 500, 50);
		this.add(lblCoachname);
		
		JLabel lblBirthday = new JLabel("Birthday: "+coach.birthday);
		lblBirthday.setBounds(30, 84, 169, 36);
		this.add(lblBirthday);
		
		JLabel lblRegion = new JLabel("Region: "+coach.region);
		lblRegion.setBounds(30, 148, 169, 36);
		this.add(lblRegion);
		
		JLabel lblSalary = new JLabel("Salary: "+coach.salary);
		lblSalary.setBounds(263, 84, 169, 36);
		this.add(lblSalary);
		
		JLabel lblHireDate = new JLabel("Hire Date: "+coach.hireDate);
		lblHireDate.setBounds(263, 148, 169, 36);
		this.add(lblHireDate);
		
		JButton btnBackToTeam = new JButton("Back To Team");
		btnBackToTeam.addActionListener(Actions.changeToLastPanel());
		btnBackToTeam.setBounds(471, 28, 119, 36);
		this.add(btnBackToTeam);
	}

}
