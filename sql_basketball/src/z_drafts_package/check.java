//package z_drafts_package;
//
//import java.awt.*;
//import java.sql.Blob;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import javax.swing.*;
//
//public class check extends JFrame {
//
//	public check(Statement statement) throws HeadlessException, SQLException {
//		final JPanel panel = new JPanel();
//		panel.setBorder(BorderFactory.createLineBorder(Color.red));
//		panel.setPreferredSize(new Dimension(800, 600));
//
//		final JScrollPane scroll = new JScrollPane(panel);
//
//		// ***
//		// try {
//		// Class.forName("oracle.jdbc.OracleDriver");
//		// String url =
//		// "jdbc:oracle:thin:@oraclenba.c9jdzgmhpebu.eu-west-1.rds.amazonaws.com:1521:orcl";
//		// String user = "Administrator";
//		// String password = "Administrator";
//		// Connection connection = DriverManager.getConnection(url,user,password);
//		//
//		// Statement statement =
//		// connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE ,
//		// ResultSet.CONCUR_UPDATABLE);
//		// ResultSet emps = statement.executeQuery("Select TEAM_NAME, TEAM_NICKNAME,
//		// LOGO from TEAMS");
//		ResultSet emps = statement.executeQuery(Queries.getPlayers());
//		JLabel temp;
//		panel.setLayout(new GridLayout(31, 1));
//		while (emps.next()) {
//			String name = emps.getString(1);
//			String nickname = emps.getString(2);
////			Blob logo = emps.getBlob(3);
////			if (logo != null) {
////				ImageIcon img = new ImageIcon(logo.getBytes(1, (int) logo.length()), "description");
////				JLabel check = new JLabel(img);
////				panel.add(check);
////			}
//			System.out.println("name= " + name + ", nickname= " + nickname);
//			temp = new JLabel(name + " " + nickname);
//			// temp.setFont(temp.getFont().deriveFont(18.0f));
//			temp.setBorder(BorderFactory.createLineBorder(Color.gray));
//			panel.add(temp);
//		}
//		// *connection.close();
//		// } catch (SQLException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// } catch (ClassNotFoundException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//		System.out.println("here");
//
//		// ***
//
//		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new BorderLayout());
//		add(scroll, BorderLayout.CENTER);
//		setSize(300, 300);
//		setVisible(true);
//	}
//
//	// public static void main(final String[] args) throws Exception {
//	// SwingUtilities.invokeLater(new Runnable() {
//	// @Override
//	// public void run() {
//	// new check().setVisible(true);
//	// }
//	// });
//	// }
//}