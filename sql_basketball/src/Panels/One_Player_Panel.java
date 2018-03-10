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
import utils.Paths_NBA;

public class One_Player_Panel extends JPanel implements Paths_NBA {

	public One_Player_Panel(ArrayList<String> result) throws IOException, HeadlessException, SQLException {
		Player tempPlayer = new Player(result.get(1), 1);

		this.setLayout(null);

		JLabel lblTeamname = new JLabel(tempPlayer.firstName + " " + tempPlayer.lastName);
		lblTeamname.setFont(new Font(lblTeamname.getName(), Font.BOLD, 26));
		lblTeamname.setBounds(290, 25, 500, 39);
		this.add(lblTeamname);

		// PICTURE
		BufferedImage playerPicture = null;
		ImageIcon imageIcon;
		URL url;
		if (FilesUtils.isDirectoryExists(PLAYERS_IMAGES_CACHE)
				&& FilesUtils.isFileDirectoryExists(new File(PLAYERS_IMAGES_CACHE + "\\" + tempPlayer.playerid))) {
			playerPicture = ImageIO.read(new File(PLAYERS_IMAGES_CACHE + "\\" + tempPlayer.playerid));
		} else {
			playerPicture = ImageIO.read(new File(PLAYERS_IMAGES_CACHE + "\\unknown.png"));
		}

		playerPicture = ImagesGui.resize(playerPicture, 200, 200);
		imageIcon = new ImageIcon(playerPicture);

		JLabel lblPicture = new JLabel(imageIcon);
		lblPicture.setBounds(500, 52, 212, 170);
		this.add(lblPicture);
		// END - PICTURE

		// to add
		ArrayList<String> teamResult = Actions.jdbc.runDBFunctionTableTypeReturn("GET_TEAM", "" + tempPlayer.teamid,
				null);
		Team tempTeam = new Team(teamResult.get(1));
		JLabel lblNewLabel = new JLabel("Team: " + tempTeam.name + " " + tempTeam.nickname);
		lblNewLabel.setBounds(38, 74, 300, 14);
		this.add(lblNewLabel);

		JLabel lblNumber = new JLabel("Number: #" + tempPlayer.shirtNumber);
		lblNumber.setBounds(38, 91, 89, 14);
		this.add(lblNumber);

		JLabel lblRole = new JLabel("Role: " + tempPlayer.position);
		lblRole.setBounds(38, 105, 89, 14);
		this.add(lblRole);

		JLabel lblHeight = new JLabel("Height: " + tempPlayer.height);
		lblHeight.setBounds(38, 169, 150, 14);
		this.add(lblHeight);

		JLabel lblNewLabel_1 = new JLabel("Weight: " + tempPlayer.weight);
		lblNewLabel_1.setBounds(38, 182, 150, 14);
		this.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Birthday: " + tempPlayer.birthday);
		lblNewLabel_2.setBounds(38, 155, 131, 200);
		this.add(lblNewLabel_2);

		JLabel lblRegion = new JLabel("Region: " + tempPlayer.region);
		lblRegion.setBounds(38, 194, 89, 14);
		this.add(lblRegion);

		JLabel label = new JLabel("");
		label.setBounds(38, 208, 46, 14);
		this.add(label);

		JLabel lblSalary = new JLabel("Salary: " + tempPlayer.salary);
		lblSalary.setBounds(38, 116, 89, 19);
		this.add(lblSalary);

		JLabel lblNewLabel_3 = new JLabel("Hire Date: " + tempPlayer.hireDate);
		lblNewLabel_3.setBounds(38, 130, 180, 20);
		this.add(lblNewLabel_3);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new MatteBorder(60, 25, 25, 25, (Color) new Color(0, 0, 0)));
		verticalBox.setBackground(Color.MAGENTA);
		verticalBox.setFont(new Font("Calibri", Font.PLAIN, 12));
		verticalBox.setForeground(Color.BLACK);
		verticalBox.setBounds(230, 65, 1, 185);
		this.add(verticalBox);

		JLabel lblStats = new JLabel("STATS");
		lblStats.setBounds(297, 74, 46, 14);
		this.add(lblStats);

	}

}
