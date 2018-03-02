package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utils.ImagesGui;


public class AppGUI extends JFrame implements ImagesGui {
	private static final long serialVersionUID = 1L;

	private JLabel jlHeadLine = new JLabel(HEADLINE_ICON);

	public AppGUI() {
		JPanel jpMenu = new JPanel();
		JPanel headline = new JPanel();
		headline.setLayout(new GridLayout(2, 1));
		jpMenu.setLayout(new GridLayout(1, 3));
		
		JButton jbTeams = new JButton("Teams", TEAMS_ICON);
		jbTeams.setVerticalTextPosition(SwingConstants.BOTTOM);
		jbTeams.setHorizontalTextPosition(SwingConstants.CENTER);
		
		jpMenu.add(jbTeams);

		JButton jbPlayers = new JButton("Players", PLAYERS_ICON);
		jbPlayers.setVerticalTextPosition(SwingConstants.BOTTOM);
		jbPlayers.setHorizontalTextPosition(SwingConstants.CENTER);
		jpMenu.add(jbPlayers);

		JButton jbGames = new JButton("Games", GAMES_ICON);
		jbGames.setVerticalTextPosition(SwingConstants.BOTTOM);
		jbGames.setHorizontalTextPosition(SwingConstants.CENTER);
		jpMenu.add(jbGames);
		
		headline.add(jlHeadLine, BorderLayout.NORTH);
		headline.add(jpMenu, BorderLayout.SOUTH);
		headline.setBorder(BorderFactory.createLineBorder(Color.black, 3));

		add(headline, BorderLayout.NORTH);

		jbTeams.addActionListener(Actions.changeToTeamsPannel(this));
		jbPlayers.addActionListener(Actions.changeToPlayersPannel(this));
		jbGames.addActionListener(Actions.changeToGamesPannel(this, 1610612754, 1610612756));

		// frame commands
		pack();
		setSize(755, 700);
		setIconImage(BASKETBALL_ICON.getImage());
		setTitle("Basketball League DB");
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
	}

}
