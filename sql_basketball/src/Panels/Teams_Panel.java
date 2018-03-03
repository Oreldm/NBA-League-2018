package Panels;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import Main.Actions;
import nba_objects.Team;
import utils.FilesUtils;
import utils.ImagesGui;
import utils.Paths_NBA;

public class Teams_Panel extends JPanel implements Paths_NBA {
	private static final long serialVersionUID = 1L;
	
	public Teams_Panel(ArrayList<String> result) throws HeadlessException, SQLException, IOException {
		final JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		panel.setPreferredSize(new Dimension(500, 800));

		final JScrollPane scroll = new JScrollPane(panel);
		JLabel temp;
		panel.setLayout(new GridLayout(15, 2));
		System.out.println(result.get(0));
		int i = 1;
		while (i < result.size()) {
			Team tempTeam = new Team(result.get(i));
			BufferedImage logo = null;

			if (FilesUtils.isDirectoryExists(TEAMS_IMAGES_CACHE)
					&& FilesUtils.isFileDirectoryExists(new File(TEAMS_IMAGES_CACHE + "\\" + tempTeam.logoFileName))) {
				logo = ImageIO.read(new File(TEAMS_IMAGES_CACHE + "\\" + tempTeam.logoFileName));
			} else {
				if (!FilesUtils.isDirectoryExists(TEAMS_IMAGES_CACHE)) {
					new File(TEAMS_IMAGES_CACHE).mkdir();
				}
				URL url = new URL(TEAMS_IMAGES_URL + tempTeam.logoFileName);
				logo = ImageIO.read(url);
				ImageIO.write(logo, "gif", new File(TEAMS_IMAGES_CACHE + "\\" + tempTeam.logoFileName));
			}

			logo = ImagesGui.resize(logo, 50, 50);
			ImageIcon imageIcon = new ImageIcon(logo);

			temp = new JLabel(tempTeam.name + " " + tempTeam.nickname, imageIcon,0);
			temp.setHorizontalAlignment(SwingConstants.LEFT);
			temp.setBorder(BorderFactory.createLineBorder(Color.gray));
			temp.setAlignmentX(LEFT_ALIGNMENT);
			temp.addMouseListener(Actions.clickLabelChangeColor(this));
			//temp.addMouseListener(Actions.changeTo1TeamPanel(new JFrame(), tempTeam));
			
			panel.add(temp);
			i++;
		}

		setLayout(new BorderLayout());
		add(scroll, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
	}

}