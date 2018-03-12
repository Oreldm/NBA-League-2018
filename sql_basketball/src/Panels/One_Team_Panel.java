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
	private static int GAP=15;
	private static int firstStatsPixel=10;
	
	public One_Team_Panel(ArrayList<String> result) throws IOException, HeadlessException, SQLException {
		tempTeam = new Team(result.get(1));
		playersPanel = getPlayersSortedByNumbers(tempTeam) ;
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
			try {
				logo = ImageIO.read(url);
				
				ImageIO.write(logo, "gif", new File(TEAMS_IMAGES_CACHE + "\\" + tempTeam.logoFileName));
				}catch(Exception e) {
					url = new URL("https://yt3.ggpht.com/-p7dRfvM60F8/AAAAAAAAAAI/AAAAAAAAAAA/fzDL1FonNCU/s900-c-k-no-mo-rj-c0xffffff/photo.jpg");
					logo= ImageIO.read(url);
					
				}
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
		lblStats.setBounds(560, firstStatsPixel, 46, 14);
		this.add(lblStats);
		
		ArrayList<String> stats = Actions.jdbc.runDBFunctionTableTypeReturn("GET_TEAM_STATS", ""+tempTeam.id, "TEAM_STATS_TABLE");
		System.out.println(stats.get(0));
		String[] statsArr =stats.get(0).split(",");

		JLabel lblTotalPoints = new JLabel("Total Points: "+getStrFromArr(statsArr,0));
		lblTotalPoints.setBounds(560, firstStatsPixel+GAP*2, 170, 14);
		this.add(lblTotalPoints);

		JLabel lblPointPerGame = new JLabel("Points Per Game: "+getStrFromArr(statsArr,1));
		lblPointPerGame.setBounds(560, firstStatsPixel+GAP*3, 170, 14);
		this.add(lblPointPerGame);

		JLabel lbl1PointPrecent = new JLabel("1-Point precent: "+getStrFromArr(statsArr,2)+"%");
		lbl1PointPrecent.setBounds(560, firstStatsPixel+GAP*4, 170, 14);
		this.add(lbl1PointPrecent);
		
		JLabel lbl2PointPrecent = new JLabel("2-Point precent: "+getStrFromArr(statsArr,3)+"%");
		lbl2PointPrecent.setBounds(560, firstStatsPixel+GAP*5, 170, 14);
		this.add(lbl2PointPrecent);
		
		JLabel lbl3PointPrecent = new JLabel("3-Point precent: "+getStrFromArr(statsArr,4)+"%");
		lbl3PointPrecent.setBounds(560, firstStatsPixel+GAP*6, 170, 14);
		this.add(lbl3PointPrecent);
		
		JLabel lblAssists = new JLabel("Assists: "+getStrFromArr(statsArr,5));
		lblAssists.setBounds(560, firstStatsPixel+GAP*7, 170, 14);
		this.add(lblAssists);
		
		JLabel lblAssistsPerGame = new JLabel("Assists per game: "+getStrFromArr(statsArr,6));
		lblAssistsPerGame.setBounds(560, firstStatsPixel+GAP*8, 170, 14);
		this.add(lblAssistsPerGame);
		
		JLabel lblDefensiveRebounds = new JLabel("Rebounds: "+getStrFromArr(statsArr,7));
		lblDefensiveRebounds.setBounds(560, firstStatsPixel+GAP*9, 170, 14);
		this.add(lblDefensiveRebounds);
		
		JLabel lblDefensiveReboundsPerGame = new JLabel("Rebounds per Game: "+getStrFromArr(statsArr,8));
		lblDefensiveReboundsPerGame.setBounds(560, firstStatsPixel+GAP*10, 170, 14);
		this.add(lblDefensiveReboundsPerGame);
		
		JLabel lblTotalFouls = new JLabel("Total Fouls: "+getStrFromArr(statsArr,9));
		lblTotalFouls.setBounds(560, firstStatsPixel+GAP*11, 170, 14);
		this.add(lblTotalFouls);
		
		JLabel lblFoulsPerGame = new JLabel("Fouls per game: "+getStrFromArr(statsArr,10));
		lblFoulsPerGame.setBounds(560, firstStatsPixel+GAP*12, 170, 14);
		this.add(lblFoulsPerGame);
		
		JLabel lblLossBall = new JLabel("Loss Ball: "+getStrFromArr(statsArr,11));
		lblLossBall.setBounds(560, firstStatsPixel+GAP*13, 170, 14);
		this.add(lblLossBall);

		JLabel lblLossBallPerGame = new JLabel("Loss Ball per game: "+getStrFromArr(statsArr,12));
		lblLossBallPerGame.setBounds(560, firstStatsPixel+GAP*14, 170, 14);
		this.add(lblLossBallPerGame);
		
		
		JButton byNumber = new JButton("By Number");
		byNumber.setBounds(220, 118, 120, 30);
		byNumber.addActionListener(changePanel(this,2));
		this.add(byNumber);
		
		JButton byPoints = new JButton("By Points");
		byPoints.setBounds(220, 158, 120, 30);
		byPoints.addActionListener(changePanel(this,i=i^1));
		this.add(byPoints);
	}
	
	public String getStrFromArr(String[]arr,int index) {
		try {
			return arr[index];
		}catch(Exception e) {
			return "not available";
		}
	}
	
	public static JPanel getPlayersSortedByNumbers(Team team) {
		ArrayList<String> players = Actions.jdbc.runDBFunctionTableTypeReturn(GET_PLAYER_BYTEAMID_BY_NUMBER_SORT, ""+team.id, PLAYERS_TYPE);
		JPanel playersPanel = new JPanel();
		int size = (players.size()==0) ? 1 : players.size();
		playersPanel.setLayout(new GridLayout(size, 0));
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
			JLabel tempLabel = new JLabel(tempPlayer.toString() +" [POINTS : " +points+"]");
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
			JLabel tempLabel = new JLabel(tempPlayer.toString() +" POINTS : [" +points+"]");
			playersPanel.add(tempLabel);
		}
		return playersPanel;
	}
	
	private static int i=0; //1->points down ,  0->points up
	
	public ActionListener changePanel(One_Team_Panel panel, int number) {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				scrollPane.remove(panel);
				switch(number) {
				//if 2->by number  ,  1->points down ,  0->points up
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
					Actions.insidePanel=panel;
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
