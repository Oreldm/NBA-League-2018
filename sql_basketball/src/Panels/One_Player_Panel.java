package Panels;

import java.awt.Color;
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
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import Main.Actions;
import nba_objects.Player;
import nba_objects.Team;
import utils.FilesUtils;
import utils.ImagesGui;

public class One_Player_Panel extends JPanel {

	public One_Player_Panel(ArrayList<String> result) throws IOException, HeadlessException, SQLException {
		this.setLayout(null);

		JLabel lblTeamname = new JLabel("Player_Name");
		lblTeamname.setBounds(232, 25, 63, 39);
		this.add(lblTeamname);

		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(405, 52, 212, 170);
		this.add(lblPicture);

		JLabel lblNewLabel = new JLabel("Team:");
		lblNewLabel.setBounds(38, 74, 46, 14);
		this.add(lblNewLabel);

		JLabel lblNumber = new JLabel("Number: #");
		lblNumber.setBounds(38, 91, 89, 14);
		this.add(lblNumber);

		JLabel lblRole = new JLabel("Role: ");
		lblRole.setBounds(38, 105, 89, 14);
		this.add(lblRole);

		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(38, 169, 72, 14);
		this.add(lblHeight);

		JLabel lblNewLabel_1 = new JLabel("Weight: ");
		lblNewLabel_1.setBounds(38, 182, 46, 14);
		this.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Birthday: ");
		lblNewLabel_2.setBounds(38, 155, 131, 14);
		this.add(lblNewLabel_2);

		JLabel lblRegion = new JLabel("Region: ");
		lblRegion.setBounds(38, 194, 89, 14);
		this.add(lblRegion);

		JLabel label = new JLabel("");
		label.setBounds(38, 208, 46, 14);
		this.add(label);

		JLabel lblSalary = new JLabel("Salary: ");
		lblSalary.setBounds(38, 116, 89, 19);
		this.add(lblSalary);

		JLabel lblNewLabel_3 = new JLabel("Hire Date:");
		lblNewLabel_3.setBounds(38, 130, 116, 19);
		this.add(lblNewLabel_3);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new MatteBorder(25, 25, 25, 25, (Color) new Color(0, 0, 0)));
		verticalBox.setBackground(Color.MAGENTA);
		verticalBox.setFont(new Font("Calibri", Font.PLAIN, 12));
		verticalBox.setForeground(Color.BLACK);
		verticalBox.setBounds(164, 65, 1, 185);
		this.add(verticalBox);

		JLabel lblStats = new JLabel("STATS");
		lblStats.setBounds(197, 74, 46, 14);
		this.add(lblStats);

	}

}
