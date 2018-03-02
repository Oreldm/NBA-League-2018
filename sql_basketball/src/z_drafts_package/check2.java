//package z_drafts_package;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.HeadlessException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.swing.BorderFactory;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextField;
//
//public class check2 extends JFrame {
//
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	public check2(Statement statement) throws HeadlessException, SQLException {
//        final JPanel panel = new JPanel();
//        panel.setBorder(BorderFactory.createLineBorder(Color.red));
//        panel.setPreferredSize(new Dimension(800, 600));
//
//        final JScrollPane scroll = new JScrollPane(panel);
//        final JTextField jtfSearch = new JTextField(10);
//        panel.add(jtfSearch);
//    		ResultSet  emps = statement.executeQuery(Queries.getPlayers());
//    		JLabel temp;
//    		panel.setLayout(new GridLayout(31, 1));
//    		while (emps.next())
//    		{
//    			String  firstName = emps.getString(1);
//    			String  lastName = emps.getString(2);
//    			System.out.println("name= "+firstName + ", last= " + lastName);
//    			temp = new JLabel(firstName + " " + lastName);
//    			//temp.setFont(temp.getFont().deriveFont(18.0f));
//    			temp.setBorder(BorderFactory.createLineBorder(Color.gray));
//    			panel.add(temp);
//    		}
//    		//*connection.close();
////    		} catch (SQLException e) {
////    			// TODO Auto-generated catch block
////    			e.printStackTrace();
////    		} catch (ClassNotFoundException e) {
////    			// TODO Auto-generated catch block
////    			e.printStackTrace();
////    		}
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
//        setSize(300, 300);
//        setVisible(true);
//    }
//}