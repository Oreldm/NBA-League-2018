package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Main.Actions;
import nba_objects.Team;

public class Game_Panel_Search_Page extends JPanel {
	public final JComboBox<String> firstTeamBox = new JComboBox<>();
	public final JComboBox<String> secondTeamBox = new JComboBox<>();
	private ArrayList<Integer> allTeamsId = new ArrayList<>();
	private ArrayList<String> allTeams = new ArrayList<>();
	private final DefaultListModel<String> model1 = new DefaultListModel<>();
	private final DefaultListModel<String> model2 = new DefaultListModel<>();
	private JButton jbSearch = new JButton("Search");
	
	private static final long serialVersionUID = 1L;

	public Game_Panel_Search_Page() {
		final JPanel panel = new JPanel();
		JScrollPane scroll = new JScrollPane(panel);
		final JPanel panel3 = new JPanel();
		final JLabel jlHomeTeam = new JLabel("Home Team");
		final JLabel jlVisitTeam = new JLabel("Visit Team");
		getTeams();
		
		firstTeamBox.addActionListener(Actions.getGames(allTeamsId));
		secondTeamBox.addActionListener(Actions.getGames(allTeamsId));
//		jbSearch.addActionListener();
		
		panel.setLayout(new FlowLayout());
		panel.add(jlHomeTeam);
		panel.add(firstTeamBox);
		panel.add(jlVisitTeam);
		panel.add(secondTeamBox);
		panel3.add(jbSearch);
		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
		add(panel3, BorderLayout.SOUTH);
		setSize(300, 300);
		setVisible(true);
	}
	
	public int getSelectedItemFromFirst(){
		return firstTeamBox.getSelectedIndex();
	}
	public int getSelectedItemFromSecond(){
		return secondTeamBox.getSelectedIndex();
	}
	public DefaultListModel<String> getModel1() {
		return model1;
	}
	
	public DefaultListModel<String> getModel2() {
		return model2;
	}
	
	public ArrayList<Integer> getAllTeamsId() {
		return allTeamsId;
	}
	public JButton getJBSearch() {
		return jbSearch;
	}
	
	public void getTeams() {
		allTeams = Actions.jdbc.runDBFunction("GET_TABLE_TO_STRING", "Teams");
		int i=1;
		while (i < allTeams.size()) {
			Team tempTeam = new Team(allTeams.get(i));
			System.out.println("Team #"+i+": " + tempTeam);
			allTeamsId.add(tempTeam.id);
			firstTeamBox.addItem(tempTeam.name);
			secondTeamBox.addItem(tempTeam.name);
//			System.out.println("i="+i+", teamid= "+allTeamsId.get(1) + "teamname=" +tempTeam.name);
			i++;
		}
	}
	
//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.add(new Trade_Players_Panel());
//		frame.pack();
//		frame.setSize(300, 180);
//		frame.setLocationRelativeTo(null); // Center the frame
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setAlwaysOnTop(true);
//		frame.setResizable(false);
//		frame.setVisible(true);
//	}
}
