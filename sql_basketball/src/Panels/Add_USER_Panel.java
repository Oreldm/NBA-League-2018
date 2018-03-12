package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Main.Actions;

public class Add_USER_Panel extends JPanel{
	private String GUEST = "Guest";
	private String ADMIN = "Administrator";
	
	public Add_USER_Panel() {
		final JPanel panel = new JPanel();
		final String premissions[] = {GUEST, ADMIN};
		final JScrollPane scroll = new JScrollPane(panel);
		final JButton jbInsertUser = new JButton("Insert User");
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		panel.setLayout(new GridLayout(3, 2, 2, 2));
		JLabel username = new JLabel("Username:");
		JTextField jtfUsername = new JTextField();
		JLabel password = new JLabel("Password:");
		JTextField jtfPassword = new JTextField();
		JLabel premission = new JLabel("Premission:");
		JComboBox<String> jCPremission = new JComboBox<>(premissions);
		panel.add(username);
		panel.add(jtfUsername);
		panel.add(password);
		panel.add(jtfPassword);
		panel.add(premission);
		panel.add(jCPremission);
		setLayout(new BorderLayout());
		jbInsertUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Actions.jdbc.runDBProcedure("PLAYERSPACKAGE.ADD_USER", "'"+jtfUsername.getText()+"',"+"'"+jtfPassword.getText()+"',"
			+"'"+premissions[jCPremission.getSelectedIndex()]+"'");
			}
		});
		add(jbInsertUser, BorderLayout.SOUTH);
		add(scroll, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
	}
}
