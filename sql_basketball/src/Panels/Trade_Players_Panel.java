package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class Trade_Players_Panel extends JPanel {
	public final JComboBox<String> firstTeamBox = new JComboBox<>();
	public final JComboBox<String> secondTeamBox = new JComboBox<>();
	private final JLabel tradeStatus = new JLabel();
	private ArrayList<Integer> allTeamsId = new ArrayList<>();
	private ArrayList<String> allTeams = new ArrayList<>();
	private final DefaultListModel<String> model1 = new DefaultListModel<>();
	private final DefaultListModel<String> model2 = new DefaultListModel<>();
	private final JList<String> jlPlayers1 = new JList<>(model1);
	private final JList<String> jlPlayers2 = new JList<>(model2);
	private JButton jbTrade = new JButton("Trade");
	private JPanel panel2 = new JPanel();
	private JScrollPane scroll = new JScrollPane(panel2);
	
	private static final long serialVersionUID = 1L;

	public Trade_Players_Panel() {
		final JPanel panel = new JPanel();
//		final JPanel panel2 = new JPanel();
		final JPanel panel3 = new JPanel();
//		final String teams[] = getTeamsName();
//		final String teams[] = {"a","b","c","d","e","f"};
//		ArrayList<String> allTeams = Actions.jdbc.runDBFunction("GET_TABLE_TO_STRING", "Teams");
//		int i=1;
//		while (i < allTeams.size()) {
//			Team tempTeam = new Team(allTeams.get(i));
//			System.out.println("Team #"+i+": " + tempTeam);
//			allTeamsId.add(tempTeam.id);
//			firstTeamBox.addItem(tempTeam.name);
//			secondTeamBox.addItem(tempTeam.name);
////			System.out.println("i="+i+", teamid= "+allTeamsId.get(1) + "teamname=" +tempTeam.name);
//			i++;
//		}
		
		//up
		getTeams();
		//
		
		firstTeamBox.addActionListener(Actions.getPlayers(allTeamsId));
		secondTeamBox.addActionListener(Actions.getPlayers(allTeamsId));
		jbTrade.addActionListener(Actions.makeTrade());
		
//		final JScrollPane scroll = new JScrollPane(panel2);
		panel.setLayout(new GridLayout(1,2,2,2));
		panel2.setLayout(new GridLayout(1,2,2,2));
		panel.add(firstTeamBox);
		panel.add(secondTeamBox);
		panel2.add(jlPlayers1);
		panel2.add(jlPlayers2);
		panel3.add(jbTrade);
		panel3.add(tradeStatus);
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		//add(scroll, BorderLayout.NORTH);
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
	
	public String getSelectedPlayerFromTeamOne() {
		return jlPlayers1.getSelectedValue();
	}
	public String getSelectedPlayerFromTeamTwo() {
		return jlPlayers2.getSelectedValue();
	}
	public JLabel getTradeStatus() {
		return tradeStatus;
	}
	public JPanel getPanel2() {
		return panel2;
	}
	public JScrollPane getScroll() {
		return scroll;
	}
	public ArrayList<Integer> getAllTeamsId() {
		return allTeamsId;
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
