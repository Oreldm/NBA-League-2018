package Panels;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import nba_objects.Game;
import utils.Paths_NBA;

public class Games_Panel_After_Search extends JPanel implements Paths_NBA {
	private static final long serialVersionUID = 1L;

	public Games_Panel_After_Search(ArrayList<String> result) throws HeadlessException, SQLException, IOException {
		final JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		panel.setPreferredSize(new Dimension(800, 600));

		final JScrollPane scroll = new JScrollPane(panel);
		JLabel temp;
		panel.setLayout(new GridLayout(15, 2));
		System.out.println(result.get(0));
		int i = 0;
		while (i < result.size()) {
			Game tempGame = new Game(result.get(i));


			temp = new JLabel(tempGame.toString(),SwingConstants.LEFT);
			temp.setBorder(BorderFactory.createLineBorder(Color.gray));
			temp.setAlignmentX(LEFT_ALIGNMENT);
			temp.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					// you can open a new frame here as
					// i have assumed you have declared "frame" as instance variable
					panel.removeAll();
					System.out.println("hello");
					setSize(300, 300);
					setVisible(true);
				}
			});
			panel.add(temp);
			i++;
		}

		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
	}

}