package Main;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class LoginGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	static Container pane;
	static JFrame frmMain;

	private JTextField jtfUsername = new JTextField("Administrator");
	private JPasswordField jtfPassword = new JPasswordField("Admin11");
	private JTextField jtfStatus = new JTextField();
	private static JButton jbtConnect = new JButton("Connect");
	public LoginGUI() throws ClassNotFoundException {
		jtfStatus.setEditable(false);

		// panel building
		JPanel loginPannel = buildLoginPannel(); // text fields
		JPanel buttonPannel = buildButtonPannel(); // buttons
		// Add the panels to the frame
		add(loginPannel, BorderLayout.CENTER);
		add(buttonPannel, BorderLayout.SOUTH);
		
		jbtConnect.addActionListener(Actions.connectToDatabase((JFrame)this));
		this.setVisible(true);
	}
	
	public JTextField getStatusField(){
		return this.jtfStatus;
	}
	
	public JTextField getJtfUsername(){
		return this.jtfUsername;
	}
	
	public JTextField getJtfPassword(){
		return this.jtfPassword;
	}

	private JPanel buildLoginPannel() {
		final String USERNAME_STR ="Username:"; 
		final String PASSWORD_STR ="Password:"; 
		final String STATUS_STR ="Status:";
		final String LOGIN_STR ="Login:"; 
		
		JPanel loginPannnel = new JPanel(new GridLayout(3, 2));
		
		//username
		loginPannnel.add(new JLabel(USERNAME_STR));
		loginPannnel.add(jtfUsername);
		
		//password
		loginPannnel.add(new JLabel(PASSWORD_STR));
		loginPannnel.add(jtfPassword);
		
		//status
		loginPannnel.add(new JLabel(STATUS_STR));
		loginPannnel.add(jtfStatus);
		
		//border
		loginPannnel.setBorder(new TitledBorder(LOGIN_STR));

		return loginPannnel;
	}

	private JPanel buildButtonPannel() {
		JPanel buttonPannel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPannel.add(jbtConnect);

		return buttonPannel;
	}

	
	
}
