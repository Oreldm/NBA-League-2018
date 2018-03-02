package z_drafts_package;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Main.AppGUI;

public class myCode {
//	public static ActionListener connectToDatabase(JFrame loginGui) {
//		ActionListener connectToDB = new ActionListener() {
//
//			private JTextField jtfUsername = new JTextField("Administrator");
//			private JPasswordField jtfPassword = new JPasswordField("Admin11");
//			private JTextField jtfStatus = new JTextField();
//
//			private final String CONNECTION_SUCCESS = "Connected!";
//			private final String CONNECTION_FAILED = "Failed to connect";
//			private final String DATABASE_DRIVER_ERROR = "Failed to connect due to driver error!";
//
//			@SuppressWarnings("deprecation")
//			@Override
//			public void actionPerformed(ActionEvent e) {
//					try {
//						Class.forName(SQL_DRIVER_NAME);
//					} catch (ClassNotFoundException e1) {
//						e1.printStackTrace();
//					}
//					String user = jtfUsername.getText();
//					String password = jtfPassword.getText();
//					jdbc.loadDriverAndConnnect(URL, user, password);

					// THIS IS HOW YOU RUN PL SQL IN JAVA

//					CallableStatement stproc_stmt = connection.prepareCall("{? = call SUMFORTEAMS(?)}");
//					stproc_stmt.registerOutParameter(1, OracleTypes.NUMBER);
//					stproc_stmt.setInt(2, 1610612744);
//					stproc_stmt.executeUpdate();
//					System.out.println(stproc_stmt.getObject(1));
					// THIS IS HOW YOU RUN PL SQL IN JAVA
					/*
					 * stproc_stmt = connection.prepareCall("{call PROCEDURE1(?)}");
					 * stproc_stmt.registerOutParameter(1, OracleTypes.NUMBER);
					 * stproc_stmt.execute(); System.out.println(stproc_stmt.getInt(1));
					 */
					// more pl sql
//					OracleCallableStatement cs = (OracleCallableStatement) connection
//							.prepareCall("{?=call getPlayers(?)}");
//					cs.registerOutParameter(1, OracleTypes.ARRAY, "T_TABLE");
//					cs.registerOutParameter(2, OracleTypes.INTEGER, 1610612765);
//					cs.execute();
//					ARRAY array_to_pass = cs.getARRAY(1);
//					Datum[] elements = array_to_pass.getOracleArray();
//					for (int i = 0; i < elements.length; i++) {
//						Object[] element = ((STRUCT) elements[i]).getAttributes();
//						String value = (String) element[0];
//						log("array(" + i + ").val=" + value);
//					}

//					stproc_stmt = connection.prepareCall("{? = call getPlayers(?)}");
//					stproc_stmt.registerOutParameter(1,Types.ARRAY, "T_TABLE");
//					stproc_stmt.setInt(2, 1610612765);
//					stproc_stmt.executeUpdate();
//					System.out.println(stproc_stmt.getObject(1).toString());
//					ARRAY array_to_pass = (ARRAY) stproc_stmt.getObject(1);
//					Datum[] elements = array_to_pass.getOracleArray();
//					for (int i = 0; i < elements.length; i++) {
//						Object[] element = ((STRUCT) elements[i]).getAttributes();
//						BigDecimal value = (BigDecimal) element[0];
//						System.out.println(element[1]);
////						log("array(" + i + ").val=" + value);
//					}
					
//					jtfStatus.setForeground(Color.green);
//					jtfStatus.setText(CONNECTION_SUCCESS);
//
//					new AppGUI(); // MOVING TO THE FIRST APP PAGE!!!!!!!!!!!!!!!!!!!!!!
//					loginGui.dispose(); // closing loginGui
//				
//			}
//
//			public void printErrorOnGui(String error, Exception e) {
//				jtfStatus.setForeground(Color.red);
//				jtfStatus.setText(DATABASE_DRIVER_ERROR);
//				e.printStackTrace();
//			}
//		};

//		return connectToDB;
//	}
	
	
	// private static void log(String s) throws SQLException {
	// PreparedStatement ps = connection
	// .prepareStatement("begin dbms_output.put_line(:x); end;");
	// ps.setString(1, s);
	// ps.execute();
	// ps.close();
	// }
	
}
