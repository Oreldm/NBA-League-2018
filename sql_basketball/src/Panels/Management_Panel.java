package Panels;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import Main.Actions;
import utils.ImagesGui;
import utils.Paths_NBA;

public class Management_Panel extends JPanel implements Paths_NBA, ImagesGui {
	private static final long serialVersionUID = 1L;
	
	public Management_Panel() {
		final JPanel panel = new JPanel();
		JLabel label;
		final JScrollPane scroll = new JScrollPane(panel);
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		//panel.setPreferredSize(new Dimension(300, 500));
		panel.setLayout(new GridLayout(6, 1));
		ArrayList<String> text = new ArrayList<>(Arrays.asList( "Add or Remove user from the system",
																"Add player",
																"Remove player",
																"Update Player",
																"Trade players",
																"Insert Score"));
		ArrayList<ImageIcon> pictures = new ArrayList<>(Arrays.asList(USER_ICON, ADD_ICON, REMOVE_ICON, UPDATE_ICON, TRADE_ICON, INSERT_ICON));
		int i=0;
		for (String theText: text) {
			label = new JLabel(theText, pictures.get(i++),0);
			label.setName("Mgmt_label" + i);
			label.addMouseListener(Actions.clickLabelChangeColor(this));
			label.setHorizontalAlignment(SwingConstants.LEFT);
			label.setAlignmentX(LEFT_ALIGNMENT);
			panel.add(label);		
		}
		
		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
	}
	
//	public static void main(String[] args) {
//		JFrame f = new JFrame();
//		f.add(new Management_Panel());
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.pack();
//        f.setLocation(200, 200);
//        f.setVisible(true);
//	}

}