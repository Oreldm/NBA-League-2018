package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Panels.Games_Panel_After_Search;
import Panels.Players_Panel;
import Panels.Teams_Panel;
import sql_package.JDBC;
import sql_package.SQL_FUNCTIONS;
import sql_package.SQL_TABLES;
import sql_package.SQL_TYPES;

public class Actions implements SQL_FUNCTIONS, SQL_TABLES, SQL_TYPES {
	public static JDBC jdbc = new JDBC();
	public static JFrame totalFrame;
	public static JPanel insidePanel;
	public static JPanel playersPanel; // used for cache

	public static ActionListener connectToDatabase(JFrame loginGui) {
		ActionListener connectToDB = new ActionListener() {

			private final String CONNECTION_FAILED = "Failed to connect";
			private final String DATABASE_DRIVER_ERROR = "Driver Error";

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String user = ((LoginGUI) loginGui).getJtfUsername().getText();
					String password = ((LoginGUI) loginGui).getJtfPassword().getText();
					jdbc.loadDriverAndConnnect(user, password);
					
					//The next 2 lines are for caching the players
					ArrayList<String> result = jdbc.runDBFunctionTableTypeReturn(GET_PLAYERS, ALL, PLAYERS_TYPE);
					playersPanel = new Players_Panel(result);

					/**
					 * !!!CHANGE TO MAIN PAGE!!!
					 */
					new AppGUI();

					loginGui.dispose(); // closing loginGui
				} catch (SQLException e1) {
					printErrorOnGui(CONNECTION_FAILED, e1);
				} catch (ClassNotFoundException e1) {
					printErrorOnGui(DATABASE_DRIVER_ERROR, e1);
				} catch (HeadlessException e1) {
					printErrorOnGui(CONNECTION_FAILED, e1);
				} catch (IOException e1) {
					printErrorOnGui(DATABASE_DRIVER_ERROR, e1);
				}
			}

			public void printErrorOnGui(String error, Exception e) {
				// error print on status
				((LoginGUI) loginGui).getStatusField().setForeground(Color.red);
				((LoginGUI) loginGui).getStatusField().setText(error);
				SwingUtilities.updateComponentTreeUI(loginGui);
			}
		};

		return connectToDB;
	}

	public static ActionListener changeToTeamsPannel(JFrame frame) {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> result = jdbc.runDBFunction(GET_TABLE_TO_STRING, TEAMS_TABLE);
				totalFrame = frame;
				try {
					if (insidePanel != null)
						frame.remove(insidePanel);
					insidePanel = new Teams_Panel(result);
					frame.add(insidePanel, BorderLayout.CENTER);
					SwingUtilities.updateComponentTreeUI(frame);
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		return action;
	}
	
	public static ActionListener changeToGamesPannel(JFrame frame, int homeTeam, int visitTeam) {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> result = jdbc.runDBFunctionTableTypeReturn(GET_GAMES,homeTeam,visitTeam,GAMES_TYPE);
				totalFrame = frame;
				try {
					if (insidePanel != null)
						frame.remove(insidePanel);
					System.out.println("Result is! : " +result);
					insidePanel = new Games_Panel_After_Search(result);
					frame.add(insidePanel, BorderLayout.CENTER);
					SwingUtilities.updateComponentTreeUI(frame);
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		return action;
	}

	public static ActionListener changeToPlayersPannel(JFrame frame) {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// using it because of massive data
				ArrayList<String> result = jdbc.runDBFunctionTableTypeReturn(GET_PLAYERS, ALL, PLAYERS_TYPE);
				totalFrame = frame;
				try {
					if (insidePanel != null)
						frame.remove(insidePanel);
					if (playersPanel != null)
						insidePanel = playersPanel;
					else {
						insidePanel = new Players_Panel(result);
						playersPanel = insidePanel;
					}
					frame.add(insidePanel, BorderLayout.CENTER);
					insidePanel.revalidate();
					SwingUtilities.updateComponentTreeUI(frame);
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		return action;
	}

}
