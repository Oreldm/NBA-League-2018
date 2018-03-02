//package z_drafts_package;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.HeadlessException;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.sql.Blob;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextField;
//import javax.swing.SwingUtilities;
//
//public class check3 extends JFrame {
//
//    public check3() throws HeadlessException, SQLException {
//        final JPanel panel = new JPanel();
//        final JTextField jtSearchPlayer = new JTextField(20);
//        panel.setBorder(BorderFactory.createLineBorder(Color.red));
//        panel.setPreferredSize(new Dimension(800, 600));
//
//        final JScrollPane scroll = new JScrollPane(panel);
//
//        //***
//        try {
//    		Class.forName("oracle.jdbc.OracleDriver");
//    		String  url = "jdbc:oracle:thin:@oraclenba.c9jdzgmhpebu.eu-west-1.rds.amazonaws.com:1521:orcl";
//    		String  user = "Administrator";
//    		String  password = "Administrator";
//    		Connection connection = DriverManager.getConnection(url,user,password);
//    		Statement  statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
//    		
//    		System.out.println("connected");
//    		jtSearchPlayer.addKeyListener(new KeyListener() {
//				
//				@Override
//				public void keyTyped(KeyEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void keyReleased(KeyEvent e) {
//					// TODO Auto-generated method stub
//					try {
//						panel.removeAll();
//						panel.updateUI();
//						System.out.println(jtSearchPlayer.getText());
//					//ResultSet  emps = statement.executeQuery(Queries.getPlayer(jtSearchPlayer.getText()));
//					ResultSet  emps = statement.executeQuery(Queries.getPlayer(jtSearchPlayer.getText()));
//					
//					System.out.println("ASdasdasdasdasdasd");
//		    		JLabel temp;
//		    		panel.setLayout(new GridLayout(31, 1));
//		    		while (emps.next())
//		    		{
//		    			String  first_name = emps.getString(1);
//		    			String  last_name = emps.getString(2);
////		    			int  shirtNumber = emps.getInt(3);
////		    			char pos = emps.getString(3).charAt(0);
////		    			double height = emps.getDouble(4);
////		    			double weight = emps.getDouble(5);
////		    			Date birthday = emps.getDate(6);
////		    			String region = emps.getString(7);
////		    			double salary = emps.getDouble(8);
////		    			String picture = emps.getString(9);
////		    			String teamName = emps.getString(11);
//		    			System.out.println("Name: " +first_name + " last: " +last_name);
//		    			temp = new JLabel("Name: " +first_name + " last: " +last_name);
//		    			//temp.setFont(temp.getFont().deriveFont(18.0f));
//		    			temp.setBorder(BorderFactory.createLineBorder(Color.gray));
//		    			panel.add(temp);
//		    		}
//					} catch (SQLException e1) {
//		    			// TODO Auto-generated catch block
//		    			e1.printStackTrace();
//		    		}
//				}
//				
//				@Override
//				public void keyPressed(KeyEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//    		
//    		
//    		//connection.close();
//    		} catch (SQLException e) {
//    			// TODO Auto-generated catch block
//    			e.printStackTrace();
//    		} catch (ClassNotFoundException e) {
//    			// TODO Auto-generated catch block
//    			e.printStackTrace();
//    		}
//    		System.out.println("here");
//    		
//        
//       
//        
//        //***
//        
//        
//      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//        add(scroll, BorderLayout.CENTER);
//        add(jtSearchPlayer, BorderLayout.NORTH);
//        setSize(300, 300);
//        setVisible(true);
//    }
//
//    public static void main(final String[] args) throws Exception {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//					new check3().setVisible(true);
//				} catch (HeadlessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//            }
//        });	
//   }
//}