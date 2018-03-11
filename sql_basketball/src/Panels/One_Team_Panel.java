package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import Main.Actions;
import Main.AppGUI;
import Main.LoginGUI;
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
	
	public static JScrollPane scrollPane;
	static JPanel playersPanel;
	static Team tempTeam;
	
	public One_Team_Panel(ArrayList<String> result) throws IOException, HeadlessException, SQLException {
		tempTeam = new Team(result.get(1));
		playersPanel = getPlayersSortedByPointsUp(tempTeam) ;
		paintScreen();
	}
	
	public void paintScreen() throws IOException {
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

		scrollPane = new JScrollPane();
		scrollPane.setBounds(345, 52, 197, 258);
		this.add(scrollPane);

		
		scrollPane.setViewportView(playersPanel);
		

		JLabel lblStats = new JLabel("Stats");
		lblStats.setBounds(560, 44, 46, 14);
		this.add(lblStats);

		JLabel lblTotalPoints = new JLabel("Total Points:");
		lblTotalPoints.setBounds(560, 69, 112, 14);
		this.add(lblTotalPoints);

		JLabel lblAssists = new JLabel("Assists:");
		lblAssists.setBounds(560, 93, 63, 14);
		this.add(lblAssists);

		JLabel lblDefensiveRebounds = new JLabel("Defensive rebounds:");
		lblDefensiveRebounds.setBounds(560, 118, 170, 14);
		this.add(lblDefensiveRebounds);

		
		
		JButton byNumber = new JButton("By Number");
		byNumber.setBounds(220, 118, 120, 30);
		byNumber.addActionListener(changePanel(this,2));
		this.add(byNumber);
		
		JButton byPoints = new JButton("By Points");
		byPoints.setBounds(220, 158, 120, 30);
		byPoints.addActionListener(changePanel(this,i=i^1));
		this.add(byPoints);
	}
	
	public static JPanel getPlayersSortedByNumbers(Team team) {
		ArrayList<String> players = Actions.jdbc.runDBFunctionTableTypeReturn(GET_PLAYER_BYTEAMID_BY_NUMBER_SORT, ""+team.id, PLAYERS_TYPE);
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
		return playersPanel;
	}
	
	public static JPanel getPlayersSortedByPointsDown(Team team) {
		JPanel playersPanel = new JPanel();
		ArrayList<String> playersByPoints = Actions.jdbc.runDBFunction("PLAYER_BYTEAMID_POINTS_DOWN", team.id+"','1");
		playersPanel.setLayout(new GridLayout(playersByPoints.size(), 0));
		for(int i=1;i<playersByPoints.size();i++) {
			String playerId = playersByPoints.get(i).split(",")[1];
			String points = playersByPoints.get(i).split(",")[2];
			ArrayList<String> player = Actions.jdbc.runDBFunctionTableTypeReturn("GET_PLAYER_BY_ID", playerId, null);
			Player tempPlayer= new Player(player.get(1),1);
			System.out.println(tempPlayer.firstName);
			JLabel tempLabel = new JLabel(tempPlayer.toString() +" POINTS : " +points);
			playersPanel.add(tempLabel);
		}
		return playersPanel;
	}
	
	public static JPanel getPlayersSortedByPointsUp(Team team) {
		JPanel playersPanel = new JPanel();
		ArrayList<String> playersByPoints = Actions.jdbc.runDBFunction("PLAYER_BYTEAMID_POINTS_DOWN", team.id+"','0");
		playersPanel.setLayout(new GridLayout(playersByPoints.size(), 0));
		for(int i=1;i<playersByPoints.size();i++) {
			String playerId = playersByPoints.get(i).split(",")[1];
			String points = playersByPoints.get(i).split(",")[2];
			ArrayList<String> player = Actions.jdbc.runDBFunctionTableTypeReturn("GET_PLAYER_BY_ID", playerId, null);
			Player tempPlayer= new Player(player.get(1),1);
			System.out.println(tempPlayer.firstName);
			JLabel tempLabel = new JLabel(tempPlayer.toString() +" POINTS : " +points);
			playersPanel.add(tempLabel);
		}
		return playersPanel;
	}
	
	private static int i=0; //if 0->by number  ,  1->points down ,  2->points up
	
	
	public ActionListener changePanel(One_Team_Panel panel, int number) {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				scrollPane.remove(panel);
				switch(number) {
					case 2:
						playersPanel=getPlayersSortedByNumbers(tempTeam);
							break;
					case 1:
						playersPanel=getPlayersSortedByPointsDown(tempTeam);
						break;
					case 0:
						playersPanel=getPlayersSortedByPointsUp(tempTeam);
						break;
				}
				try {
					panel.paintScreen();
					if (Actions.insidePanel != null) {
						Actions.totalFrame.remove(Actions.totalFrame);
					}
					Actions.insidePanel =panel;
					Actions.totalFrame.add(Actions.insidePanel);
					SwingUtilities.updateComponentTreeUI(Actions.totalFrame);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};

		return action;
	}

}
