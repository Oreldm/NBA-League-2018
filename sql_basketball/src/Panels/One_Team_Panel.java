package Panels;

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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Main.Actions;
import nba_objects.Player;
import nba_objects.Team;
import sql_package.SQL_FUNCTIONS;
import sql_package.SQL_TYPES;
import utils.FilesUtils;
import utils.ImagesGui;
import utils.Paths_NBA;

public class One_Team_Panel extends JPanel implements Paths_NBA, SQL_FUNCTIONS, SQL_TYPES {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("static-access")
	public One_Team_Panel(ArrayList<String> result) throws IOException, HeadlessException, SQLException {
		Team tempTeam = new Team(result.get(1));
		System.out.println(tempTeam);

		this.setLayout(null);

		JLabel lblTeamname = new JLabel(tempTeam.name + " \n" + tempTeam.nickname);
		lblTeamname.setFont(new Font("regulatFont", Font.BOLD, 24));
		lblTeamname.setBounds(10, 12, 300, 39);

		this.add(lblTeamname);

		BufferedImage logo = null;
		if (FilesUtils.isDirectoryExists(TEAMS_IMAGES_CACHE)
				&& FilesUtils.isFileDirectoryExists(new File(TEAMS_IMAGES_CACHE + "\\" + tempTeam.logoFileName))) {
			logo = ImageIO.read(new File(TEAMS_IMAGES_CACHE + "\\" + tempTeam.logoFileName));
		} else {
			if (!FilesUtils.isDirectoryExists(TEAMS_IMAGES_CACHE)) {
				new File(TEAMS_IMAGES_CACHE).mkdir();
			}
			URL url = new URL(TEAMS_IMAGES_URL + tempTeam.logoFileName);
			logo = ImageIO.read(url);
			ImageIO.write(logo, "gif", new File(TEAMS_IMAGES_CACHE + "\\" + tempTeam.logoFileName));
		}
		logo = ImagesGui.resize(logo, 200, 200);
		ImageIcon imageIcon = new ImageIcon(logo);

		JLabel lblPicture = new JLabel(imageIcon);
		lblPicture.setBounds(10, 73, 210, 208);
		lblPicture.setAlignmentX(lblPicture.LEFT_ALIGNMENT);
		lblPicture.setAlignmentY(lblPicture.TOP_ALIGNMENT);
		this.add(lblPicture);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 52, 197, 258);
		this.add(scrollPane);

		ArrayList<String> players = Actions.jdbc.runDBFunctionTableTypeReturn(GET_PLAYER_BYTEAMID, ""+tempTeam.id, PLAYERS_TYPE);
//		Players_Panel playersPanel = new Players_Panel(players);
		JPanel playersPanel = new JPanel();
		playersPanel.setLayout(new GridLayout(players.size(), 0));
		for(String str : players) {
			try {
				Player tempPlayer = new Player(str,0);
				JLabel tempLabel = new JLabel(tempPlayer.toString());
				playersPanel.add(tempLabel);
			}catch(Exception e) {
				//not a player
			}
		}
		
		scrollPane.setViewportView(playersPanel);
		

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
