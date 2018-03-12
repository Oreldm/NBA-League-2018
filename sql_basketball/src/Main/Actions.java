package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import Panels.Add_Player_Panel;
import Panels.Add_USER_Panel;
import Panels.Coach_Panel;
import Panels.Game_Panel_Search_Page;
import Panels.Games_Panel_After_Search;
import Panels.Management_Panel;
import Panels.One_Player_Panel;
import Panels.One_Team_Panel;
import Panels.Players_Panel;
import Panels.Remove_Player_Panel;
import Panels.Teams_Panel;
import Panels.Trade_Players_Panel;
import Panels.Update_Player_Panel;
import nba_objects.Player;
import nba_objects.Team;
import sql_package.JDBC;
import sql_package.SQL_FUNCTIONS;
import sql_package.SQL_TABLES;
import sql_package.SQL_TYPES;

public class Actions implements SQL_FUNCTIONS, SQL_TABLES, SQL_TYPES {
	public static JDBC jdbc = new JDBC();
	public static JFrame totalFrame;
	public static JPanel insidePanel;
	public static JPanel playersPanel;
	public static JPanel playersPanelCache;
	public static JPanel lastPanel;
	public static JPanel teamsPanel;
	public static boolean isFirstTime = true;

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

					// The next 4 lines are for caching the players
					ArrayList<String> result = jdbc.runDBFunction(GET_TABLE_TO_STRING, TEAMS_TABLE);
					teamsPanel = new Teams_Panel(result);
					
					result = jdbc.runDBFunctionTableTypeReturn(GET_PLAYERS, ALL, PLAYERS_TYPE);
					playersPanel = new Players_Panel(result);
					
					
					/**
					 * !!!CHANGE TO MAIN PAGE!!!
					 */
					totalFrame = new AppGUI();

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
					if(teamsPanel==null)
						teamsPanel = new Teams_Panel(result);
					insidePanel = teamsPanel;
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

	public static ActionListener gamePanelSearch() {
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ArrayList<String> result = jdbc.runDBFunction(GET_TABLE_TO_STRING, TEAMS_TABLE);
				try {
					if (insidePanel != null)
						totalFrame.remove(insidePanel);
					//insidePanel = new Game_Panel_Search_Page(result);
					insidePanel = new Game_Panel_Search_Page();
					totalFrame.add(insidePanel, BorderLayout.CENTER);
					SwingUtilities.updateComponentTreeUI(totalFrame);	
				} catch (HeadlessException e1) {
					e1.printStackTrace();
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				} catch (IOException e1) {
//					e1.printStackTrace();
				}
			}
		};
		return action;
	}
	
	public static ActionListener changeToGamesPannel(JFrame frame, int homeTeam, int visitTeam) {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> result = jdbc.runDBFunctionTableTypeReturn(GET_GAMES, homeTeam, visitTeam,
						GAMES_TYPE);
				if(result.size()==0)
					return;
				totalFrame = frame;
				System.out.println(result);
				try {
					if (insidePanel != null)
						frame.remove(insidePanel);
					System.out.println("Result is! : " + result);
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
	
	public static ActionListener changeToCoachPannel(ArrayList<String> result) {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					lastPanel=insidePanel;
					if (insidePanel != null)
						totalFrame.remove(insidePanel);
					insidePanel = new Coach_Panel(result);
					totalFrame.add(insidePanel, BorderLayout.CENTER);
					SwingUtilities.updateComponentTreeUI(totalFrame);
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
	
	public static ActionListener changeToLastPanel() {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					if (insidePanel != null)
						totalFrame.remove(insidePanel);
					insidePanel = lastPanel;
					totalFrame.add(insidePanel, BorderLayout.CENTER);
					SwingUtilities.updateComponentTreeUI(totalFrame);
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} 
			}
		};
		return action;
	}

	public static ActionListener changeToPlayersPannel() {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// using it because of massive data
				String searchString;
				try {
					searchString = ((Players_Panel) insidePanel).getTextFromSearch();
				} catch (Exception e1) {
					searchString = ((Players_Panel) playersPanel).getTextFromSearch();
				}
				if (searchString.equals("Enter name for search:")) {
					searchString = "";
				}

				ArrayList<String> result;
				try {
					if (searchString.equals("") && !isFirstTime) {
						totalFrame.remove(insidePanel);
						insidePanel = playersPanelCache;
					} else {
						result = jdbc.runDBFunctionTableTypeReturn(GET_PLAYERS, searchString, PLAYERS_TYPE);
						if (insidePanel != null) {
							totalFrame.remove(insidePanel);
						}
						if (isFirstTime) {
							playersPanelCache = playersPanel;
							insidePanel = playersPanel;
							isFirstTime = false;
						} else {
							insidePanel = new Players_Panel(result);
							playersPanel = insidePanel;
						}
					}
					totalFrame.add(insidePanel, BorderLayout.CENTER);
					insidePanel.revalidate();
					SwingUtilities.updateComponentTreeUI(totalFrame);
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

	public static MouseListener clickLabelChangeColor(Component c) {
		MouseListener action = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Component c = e.getComponent();
				c.setBackground(Color.GRAY);
				((JComponent) c).setOpaque(true);
			}

			public void mouseReleased(MouseEvent e) {
				Component c = e.getComponent();
				c.setBackground(null);
				((JComponent) c).setOpaque(true);
			}

			public void mouseClicked(MouseEvent e) {
				System.out.println("TEST IS " + ((JLabel) e.getComponent()).getText());
				System.out.println("TEST IS " + ((JLabel) e.getComponent()).getName());
				if (e.getComponent().getName().contains("player_label")) {
					String playerId = ((JLabel) e.getComponent()).getName().split("\\$")[1];
					ArrayList<String> result = jdbc.runDBFunctionTableTypeReturn("GET_PLAYER_BY_ID", playerId, null);
					if (insidePanel != null) {
						totalFrame.remove(insidePanel);
					}
					try {
						insidePanel = new One_Player_Panel(result);
					} catch (Exception e1) {
						e1.printStackTrace();
						System.out.println("HERE123123123424");
						System.out.println(result);
					}
					System.out.println(result);
					totalFrame.add(insidePanel);
					SwingUtilities.updateComponentTreeUI(totalFrame);
					
				}else if (e.getComponent().getName().contains("Mgmt_label")) {
					System.out.println("mgmt_label");
					String choice = ((JLabel) e.getComponent()).getName().substring(10);
					System.out.println(choice);
					System.out.println(((JLabel) e.getComponent()).getName());
					if (insidePanel != null) {
						totalFrame.remove(insidePanel);
					}
					switch (choice) {
					case "1":
						insidePanel = new Add_USER_Panel();
						break;
					case "2":
						insidePanel = new Add_Player_Panel();
						break;
					case "3":
						insidePanel = new Remove_Player_Panel();
						break;
					case "4":
						insidePanel = new Update_Player_Panel();
						break;
					case "5":
						insidePanel = new Trade_Players_Panel();
						break;
					case "6":
						insidePanel = new Add_USER_Panel();
						break;
					default:
						break;
					}

					totalFrame.add(insidePanel);
					SwingUtilities.updateComponentTreeUI(totalFrame);
				} else if (((JLabel) e.getComponent()).getName().contains("TEAM")) {
					// Team Label
					String teamId = ((JLabel) e.getComponent()).getName().split("\\$")[1];
					ArrayList<String> result = jdbc.runDBFunctionTableTypeReturn("GET_TEAM", teamId, null);
					if (insidePanel != null) {
						totalFrame.remove(insidePanel);
					}
					try {
						insidePanel = new One_Team_Panel(result);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					System.out.println(result);
					totalFrame.add(insidePanel);
					SwingUtilities.updateComponentTreeUI(totalFrame);
				}
			}
		};
		return action;
	}

	public static FocusListener textDisappeardOnclick(JTextField textField) {
		FocusListener action = new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				textField.setText("Enter name for search:");
			}

			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");

			}
		};
		return action;
	}

	public static ActionListener changeToManagementPanel(JFrame frame) {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (insidePanel != null)
					frame.remove(insidePanel);
				insidePanel = new Management_Panel();
				frame.add(insidePanel, BorderLayout.CENTER);
				SwingUtilities.updateComponentTreeUI(frame);
			}
		};
		return action;
	}

	public static ActionListener deletePlayers() {
		// TODO Auto-generated method stub
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// using it because of massive data
				String playerId;
				int errorCode;
				try {
					playerId = ((Remove_Player_Panel) insidePanel).getLabelText();
				} catch (Exception e1) {
					playerId = ((Remove_Player_Panel) playersPanel).getLabelText();
				}
				System.out.println("CHECK=" + playerId);
				errorCode=jdbc.runDBProcedure("DELETE_PLAYER", playerId);
				System.out.println("----");
				switch (errorCode) {
				case 0: 	((Remove_Player_Panel) insidePanel).setStatus("Success!");
							break;
				case 20002: ((Remove_Player_Panel) insidePanel).setStatus("Player not found");
							break;
				case 6550: if(JDBC.errorString.contains("PLS-00904:")){
								JDBC.errorString="";
								((Remove_Player_Panel) insidePanel).setStatus("You dont have the privileges!");
							}else
								((Remove_Player_Panel) insidePanel).setStatus("OOPS... Something Wrong!");
							break;
				default: 	((Remove_Player_Panel) insidePanel).setStatus("Awkward error");
							break;
				
				
				}
				//System.out.println("Success");
			}
		};
		return action;
	}

	public static ActionListener AddPlayer() {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int errorCode;
				String playerData;
				try {
					playerData = ((Add_Player_Panel) insidePanel).getData();
				} catch (Exception e1) {
					playerData = ((Add_Player_Panel) playersPanel).getData();
				}
				playerData=playerData.replace(", ,", ", NULL,");
				playerData=playerData.replace(", ,", ", NULL,");
				System.out.println(playerData);
				errorCode=jdbc.runDBProcedure("ADD_PLAYER", playerData);
				switch (errorCode) {
				case 0: 	((Add_Player_Panel) insidePanel).setStatus("Success!");
							break;
				case 20002: ((Add_Player_Panel) insidePanel).setStatus("You have tried to insert a duplicate playerID");
							break;
				case 6550: 
						if(JDBC.errorString.contains("PLS-00904:")){
							JDBC.errorString="";
							((Add_Player_Panel) insidePanel).setStatus("You dont have the privileges!");
						}else
							((Add_Player_Panel) insidePanel).setStatus("OOPS... Something Wrong!");
  							break;
				default: 	((Add_Player_Panel) insidePanel).setStatus("Awkward error");
							break;
				
				
				}
			}
			
		};
		return action;
	}

	public static ActionListener searchPlayer() {
		
		ActionListener action = new ActionListener() {
			private boolean firstTime=true;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> result = new ArrayList<>();
				String playerToSearch;
				try {
					playerToSearch = ((Update_Player_Panel) insidePanel).getPlayerToSearch();
				} catch (Exception e1) {
					playerToSearch = ((Update_Player_Panel) playersPanel).getPlayerToSearch();
				}
				result=jdbc.runDBFunction("CHECK_PLAYER_ID", playerToSearch);
				System.out.println(result.get(0));
				if (result.get(0).equals("0"))
						((Update_Player_Panel) insidePanel).setStatus("Player not found!");
				else {
					((Update_Player_Panel) insidePanel).setStatus("Player found!");
					((Update_Player_Panel) insidePanel).setEditableFalse();
					if (firstTime){
						((Update_Player_Panel) insidePanel).createSubPanel(((Update_Player_Panel) insidePanel).getSubPanel());
						firstTime=false;
					}
				}
						
			}
			
		};
		return action;
	}

	public static ActionListener updatePlayer() {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int errorCode;
				String playerData;
				try {
					playerData = ((Update_Player_Panel) insidePanel).getData();
				} catch (Exception e1) {
					playerData = ((Update_Player_Panel) playersPanel).getData();
				}
				System.out.println(playerData);
				errorCode=jdbc.runDBProcedure("UPDATE_PLAYER", playerData);
				switch (errorCode) {
				case 0:		((Update_Player_Panel) insidePanel).setStatus("Success!");
							//System.out.println("Success!");
				 			break;
				case 20001: ((Update_Player_Panel) insidePanel).setStatus("illegal input");
							//System.out.println("illegal input");;
							break;
				case 20002: ((Update_Player_Panel) insidePanel).setStatus("team not exists");
							//System.out.println("team not exists");
							break;
				case 6550: 	if(JDBC.errorString.contains("PLS-00904:")){
								JDBC.errorString="";
								((Update_Player_Panel) insidePanel).setStatus("You dont have the privileges!");
//								System.out.println("You dont have the privileges!");
							}else
								((Update_Player_Panel) insidePanel).setStatus("OOPS... Something Wrong!");
								//System.out.println("OOPS... Something Wrong!");
							break;
				default: 	((Update_Player_Panel) insidePanel).setStatus("Awkward error");
							//System.out.println("Awkward error");
							break;
				}
			}
		};
		return action;
	}

	public static ActionListener getPlayers(ArrayList<Integer> allTeamsId) {
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectedFirstItem = ((Trade_Players_Panel) insidePanel).getSelectedItemFromFirst();
				int selectedSecondItem = ((Trade_Players_Panel) insidePanel).getSelectedItemFromSecond();
				System.out.println("fist=" + selectedFirstItem + "id="+allTeamsId.get(selectedFirstItem));
				System.out.println("second=" + selectedSecondItem +"id="+allTeamsId.get(selectedSecondItem));
				ArrayList<String> playersNameForFirstBox = Actions.jdbc.runDBFunctionTableTypeReturn("GET_PLAYER_BYTEAMID", ""+allTeamsId.get(selectedFirstItem), PLAYERS_TYPE);
				ArrayList<String> playersNameForSecondBox = Actions.jdbc.runDBFunctionTableTypeReturn("GET_PLAYER_BYTEAMID", ""+allTeamsId.get(selectedSecondItem), PLAYERS_TYPE);
				System.out.println("-----");
				System.out.println(playersNameForFirstBox);
				System.out.println("-----");
				System.out.println(playersNameForSecondBox);
				((Trade_Players_Panel) insidePanel).getModel1().removeAllElements();
				((Trade_Players_Panel) insidePanel).getModel2().removeAllElements();
				int i=0;
				while (i < playersNameForFirstBox.size()) {
					Player tempPlayer = new Player(playersNameForFirstBox.get(i),0);
					((Trade_Players_Panel) insidePanel).getModel1().addElement(tempPlayer.firstName + " " + tempPlayer.lastName);;
					i++;
				}
				i=0;
				while (i < playersNameForSecondBox.size()) {
					Player tempPlayer = new Player(playersNameForSecondBox.get(i),0);
					((Trade_Players_Panel) insidePanel).getModel2().addElement(tempPlayer.firstName + " " + tempPlayer.lastName);;
					i++;
				}
			}
		};
		return action;
	}

	public static ActionListener makeTrade() {
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int errorCode;
				String playerOne=((Trade_Players_Panel) insidePanel).getSelectedPlayerFromTeamOne();
				String playerTwo=((Trade_Players_Panel) insidePanel).getSelectedPlayerFromTeamTwo();
				System.out.println("Player1: "+playerOne + " PlayerTwo: " + playerTwo);
				errorCode=jdbc.runDBProcedure("TRADE_PLAYERS", "'"+playerOne + "', '"+ playerTwo+"'");
				switch (errorCode) {
				case 0:		((Trade_Players_Panel) insidePanel).getTradeStatus().setText("Success! Please refresh the UI");
	 						break;
				case 6550: 	if(JDBC.errorString.contains("PLS-00904:")){
								JDBC.errorString="";
								((Trade_Players_Panel) insidePanel).getTradeStatus().setText("You dont have the privileges!");
							}else
								((Trade_Players_Panel) insidePanel).getTradeStatus().setText("OOPS... Something Wrong!");
							break;
				case 20001:
				default:	((Trade_Players_Panel) insidePanel).getTradeStatus().setText("Please select players!");
							break;
				}
//				((Trade_Players_Panel) insidePanel).getTeams();
//				Actions.getPlayers(((Trade_Players_Panel) insidePanel).getAllTeamsId());
//				((Trade_Players_Panel) insidePanel).getPanel2().updateUI();
			}
			
		};
		return action;
	}

	private static ActionListener gamesSearchListener;
	public static ActionListener getGames(ArrayList<Integer> allTeamsId) {
			ActionListener action = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int selectedFirstItem = ((Game_Panel_Search_Page) insidePanel).getSelectedItemFromFirst();
					int selectedSecondItem = ((Game_Panel_Search_Page) insidePanel).getSelectedItemFromSecond();
					System.out.println("first=" + selectedFirstItem + " id="+allTeamsId.get(selectedFirstItem));
					System.out.println("second=" + selectedSecondItem +" id="+allTeamsId.get(selectedSecondItem));
					if(gamesSearchListener!=null)
						((Game_Panel_Search_Page) insidePanel).getJBSearch().removeActionListener(gamesSearchListener);
					gamesSearchListener = changeToGamesPannel(totalFrame, allTeamsId.get(selectedFirstItem), allTeamsId.get(selectedSecondItem));
					((Game_Panel_Search_Page) insidePanel).getJBSearch().addActionListener(gamesSearchListener);
				}
			};
			return action;
	}

}
