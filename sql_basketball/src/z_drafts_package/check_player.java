//package z_drafts_package;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.HeadlessException;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.imageio.ImageIO;
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextField;
//
//public class check_player extends JFrame{
//
//	public check_player(Statement statement, int playerid) throws HeadlessException, SQLException, IOException  {
//		final JPanel panel = new JPanel();
//		panel.setBorder(BorderFactory.createLineBorder(Color.red));
//		panel.setPreferredSize(new Dimension(800, 600));
//
//		ResultSet  emps = statement.executeQuery(Queries.getPlayerRev(playerid));
//		JLabel temp;
//		//panel.setLayout(new GridLayout(31, 1));
//		while (emps.next())
//		{
//			String  firstName = emps.getString(1);
//			String  lastName = emps.getString(2);
//			double shirt_number = emps.getDouble(3);
//			char pos = emps.getString(4).charAt(0);
//			double height = emps.getDouble(5);
//			double weight = emps.getDouble(6);
//			Date birthday = emps.getDate(7);
//			String pic = emps.getString(10);
//			System.out.println("name= "+firstName + ", last= " + lastName);
//			temp = new JLabel(firstName + " " + lastName);
//			//temp.setFont(temp.getFont().deriveFont(18.0f));
//			temp.setBorder(BorderFactory.createLineBorder(Color.gray));
//			panel.add(temp, BorderLayout.CENTER);
//			URL url = new URL(pic);
//		    BufferedImage image = ImageIO.read(url);
//		    JLabel label = new JLabel(new ImageIcon(image));
//		    panel.add(label, BorderLayout.WEST);
//		    getContentPane().add(label);
//		}
//		panel.updateUI();
//		//*connection.close();
//		//	    		} catch (SQLException e) {
//		//	    			// TODO Auto-generated catch block
//		//	    			e.printStackTrace();
//		//	    		} catch (ClassNotFoundException e) {
//		//	    			// TODO Auto-generated catch block
//		//	    			e.printStackTrace();
//		//	    		}
//		System.out.println("here");
//
//
//
//
//		//***
//
//
//		//  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new BorderLayout());
//		setSize(300, 300);
//		setVisible(true);
//	}
//
//	public static void main(String[]args) {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			String  url = "jdbc:oracle:thin:@oraclenba.c9jdzgmhpebu.eu-west-1.rds.amazonaws.com:1521:orcl";
//			String  user = "Administrator";
//			String  password = "Administrator";
//			Connection connection = DriverManager.getConnection(url,user,password);
//			Statement  statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
//			check_player checkkkk = new check_player(statement, 201956);
//			checkkkk.setVisible(true);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (HeadlessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
