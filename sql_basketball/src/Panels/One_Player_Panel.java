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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import Main.Actions;
import nba_objects.Player;
import nba_objects.Player_Stats;
import nba_objects.Team;
import utils.FilesUtils;
import utils.ImagesGui;
import utils.Paths_NBA;

public class One_Player_Panel extends JPanel implements Paths_NBA {
	private static int GAP = 15;
	private static int FIRST_POSITION = 70;

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

		playerPicture = ImagesGui.resize(playerPicture, 300, 300);
		imageIcon = new ImageIcon(playerPicture);

		JLabel lblPicture = new JLabel(imageIcon);
		lblPicture.setBounds(500, 52, 300, 300);
		this.add(lblPicture);
		// END - PICTURE

		// to add
		ArrayList<String> teamResult = Actions.jdbc.runDBFunctionTableTypeReturn("GET_TEAM", "" + tempPlayer.teamid,
				null);
		Team tempTeam=new Team("none,,none,none,none,none,none,none,none");
		try {
			tempTeam = new Team(teamResult.get(1));
		}catch(Exception e) {
			tempTeam=new Team("none,,,none,none,none,none,none,none");
		}
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
		lblStats.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		lblStats.setForeground(Color.red);
		lblStats.setBounds(240, FIRST_POSITION, 46, 14);
		this.add(lblStats);
		
		ArrayList<String> statsString = Actions.jdbc.runDBFunctionTableTypeReturn("GET_PLAYER_STATS", ""+tempPlayer.playerid, "PLAYER_STATS_TABLE");
		Player_Stats stats = new Player_Stats(statsString.get(0));
		System.out.println("STATS STRING IS "+stats.totalPoints);
		
		JLabel lblStatsMinutes = new JLabel("Minutes "+stats.totalMinutes);
		lblStatsMinutes.setBounds(240, FIRST_POSITION+GAP+5, 200, 14);
		this.add(lblStatsMinutes);
		
		JLabel lblStatsMinutesPerGame = new JLabel("Minutes PerGame: "+stats.minutesPerGame);
		lblStatsMinutesPerGame.setBounds(240, FIRST_POSITION+3+GAP*2, 200, 14);
		this.add(lblStatsMinutesPerGame);

		JLabel totalPoints = new JLabel("Points: "+stats.totalPoints);
		totalPoints.setBounds(240, FIRST_POSITION+3+GAP*3, 200, 14);
		this.add(totalPoints);
		
		JLabel pointsPerGame = new JLabel("Points PerGame: "+stats.pointsPerGame);
		pointsPerGame.setBounds(240, FIRST_POSITION+3+GAP*4, 200, 14);
		this.add(pointsPerGame);
		
		JLabel from1PointPrecent = new JLabel("Precent From Line: "+stats.from1PointPrecent+"%");
		from1PointPrecent.setBounds(240, FIRST_POSITION+3+GAP*5, 200, 14);
		this.add(from1PointPrecent);
		
		JLabel from2PointPrecent = new JLabel("Precent from 2: "+stats.from2PointPrecent+"%");
		from2PointPrecent.setBounds(240, FIRST_POSITION+3+GAP*6, 200, 14);
		this.add(from2PointPrecent);
		//from here
		JLabel from3PointPrecent = new JLabel("Precent from 3: "+stats.from3PointPrecent+"%");
		from3PointPrecent.setBounds(240, FIRST_POSITION+3+GAP*7, 200, 14);
		this.add(from3PointPrecent);
		
		JLabel totalRebounds = new JLabel("Total Rebounds: "+stats.totalRebounds);
		totalRebounds.setBounds(240, FIRST_POSITION+3+GAP*8, 200, 14);
		this.add(totalRebounds);
		
		JLabel reboundsPerGame = new JLabel("Rebounds PerGame: "+stats.reboundsPerGame);
		reboundsPerGame.setBounds(240, FIRST_POSITION+3+GAP*9, 200, 14);
		this.add(reboundsPerGame);
		
		JLabel fouls = new JLabel("Total Fouls: "+stats.fouls);
		fouls.setBounds(240, FIRST_POSITION+3+GAP*10, 200, 14);
		this.add(fouls);
		
		JLabel foulsPerGame = new JLabel("Fouls PerGame: "+stats.foulsPerGame);
		foulsPerGame.setBounds(240, FIRST_POSITION+3+GAP*11, 200, 14);
		this.add(foulsPerGame);
		
		JLabel lossBall = new JLabel("Loss Balls: "+stats.lossBall);
		lossBall.setBounds(240, FIRST_POSITION+3+GAP*12, 200, 14);
		this.add(lossBall);
		
		JLabel lossBallPerGame = new JLabel("LossBalls PerGame: "+stats.lossBallPerGame);
		lossBallPerGame.setBounds(240, FIRST_POSITION+3+GAP*13, 200, 14);
		this.add(lossBallPerGame);
		
		JLabel assists = new JLabel("Assists: "+stats.assists);
		assists.setBounds(240, FIRST_POSITION+3+GAP*14, 200, 14);
		this.add(assists);
		
		JLabel assistsPerGame = new JLabel("Assists PerGame: "+stats.assistsPerGame);
		assistsPerGame.setBounds(240, FIRST_POSITION+3+GAP*15, 200, 14);
		this.add(assistsPerGame);
		
		JLabel totalBlocks = new JLabel("Blocks: "+stats.totalBlocks);
		totalBlocks.setBounds(410, FIRST_POSITION+3+GAP, 200, 14);
		this.add(totalBlocks);
		
		JLabel blocksPerGame = new JLabel("Blocks PerGame: "+stats.blocksPerGame);
		blocksPerGame.setBounds(410, FIRST_POSITION+3+GAP*2, 200, 14);
		this.add(blocksPerGame);
		
		JLabel st = new JLabel("PLACE IN LEAGUE: " );
		st.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		st.setForeground(Color.red);
		st.setBounds(410, FIRST_POSITION+3+GAP*4, 200, 14);
		this.add(st);
		
		JLabel pointPlaceInLeague = new JLabel("Points: #"+stats.pointPlaceInLeague);
		pointPlaceInLeague.setBounds(410, FIRST_POSITION+3+GAP*5, 200, 14);
		this.add(pointPlaceInLeague);
		
		JLabel reboundsPlaceInLeague = new JLabel("Rebounds: #"+stats.reboundsPlaceInLeague);
		reboundsPlaceInLeague.setBounds(410, FIRST_POSITION+3+GAP*6, 200, 14);
		this.add(reboundsPlaceInLeague);
		
		JLabel assistsPlaceInLeague = new JLabel("Assists: #"+stats.assistsPlaceInLeague);
		assistsPlaceInLeague.setBounds(410, FIRST_POSITION+3+GAP*7, 200, 14);
		this.add(assistsPlaceInLeague);
		
		JLabel blocksPlacecInLeague = new JLabel("Blocks: #"+stats.blocksPlacecInLeague);
		blocksPlacecInLeague.setBounds(410, FIRST_POSITION+3+GAP*8, 200, 14);
		this.add(blocksPlacecInLeague);
		
		JLabel from1PointPlaceInLeague = new JLabel("ShootsFromTheLine: #"+stats.from1PointPlaceInLeague);
		from1PointPlaceInLeague.setBounds(410, FIRST_POSITION+3+GAP*9, 200, 14);
		this.add(from1PointPlaceInLeague);
		
		JLabel from2PointPlaceInLeague = new JLabel("ShootFrom2: #"+stats.from2PointPlaceInLeague);
		from2PointPlaceInLeague.setBounds(410, FIRST_POSITION+3+GAP*10, 200, 14);
		this.add(from2PointPlaceInLeague);
		
		JLabel from3PointPlaceInLeague = new JLabel("ShootFrom3: #"+stats.from3PointPlaceInLeague);
		from3PointPlaceInLeague.setBounds(410, FIRST_POSITION+3+GAP*11, 200, 14);
		this.add(from3PointPlaceInLeague);
		
	}
	
}
