package Panels;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Main.Actions;
import nba_objects.Player;
import utils.FilesUtils;
import utils.ImagesGui;
import utils.Paths_NBA;

public class Players_Panel extends JPanel implements Paths_NBA {
	private static final long serialVersionUID = 1L;
	private JTextField searchPlayer;

	public Players_Panel(ArrayList<String> result)
			throws HeadlessException, SQLException, IOException {
		final JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		int playersNumber = Integer.parseInt(Actions.jdbc.runDBFunction("NUM_PLAYERS", null).get(0));
		//panel.setPreferredSize(new Dimension(500, playersNumber));
		
		searchPlayer = new JTextField("Enter name for search:");
		final JScrollPane scroll = new JScrollPane(panel);
		JLabel temp;
		GridLayout gl = new GridLayout(0, 4 , 2, 2); //0 =default
		panel.setLayout(gl);
		
		System.out.println(result);

		int i = 0;
		while (i < result.size()) {
			Player tempPlayer = new Player(result.get(i),0);
			BufferedImage playerPicture = null;

			ImageIcon imageIcon;
			URL url;
			try {
				if (FilesUtils.isDirectoryExists(PLAYERS_IMAGES_CACHE) && FilesUtils
						.isFileDirectoryExists(new File(PLAYERS_IMAGES_CACHE + "\\" + tempPlayer.playerid))) {
					playerPicture = ImageIO.read(new File(PLAYERS_IMAGES_CACHE + "\\" + tempPlayer.playerid));
				} else {
					if (tempPlayer.firstName.contains(" ") || tempPlayer.lastName.contains(" ")
							|| tempPlayer.firstName.contains(".") || tempPlayer.lastName.contains(".")) {
						throw new Exception();
					}

					if (!FilesUtils.isDirectoryExists(PLAYERS_IMAGES_CACHE)) {
						new File(PLAYERS_IMAGES_CACHE).mkdir();
					}

					url = new URL(tempPlayer.picture);
					playerPicture = ImageIO.read(url);
					ImageIO.write(playerPicture, "png", new File(PLAYERS_IMAGES_CACHE + "\\" + tempPlayer.playerid));
				}

				playerPicture = ImagesGui.resize(playerPicture, 120, 120);
				imageIcon = new ImageIcon(playerPicture);
			} catch (Exception e) {
				if (FilesUtils.isDirectoryExists(PLAYERS_IMAGES_CACHE)
						&& FilesUtils.isFileDirectoryExists(new File(PLAYERS_IMAGES_CACHE + "\\unknown.png"))) {
					playerPicture = ImageIO.read(new File(PLAYERS_IMAGES_CACHE + "\\unknown.png"));
				} else {
					if (!FilesUtils.isDirectoryExists(PLAYERS_IMAGES_CACHE)) {
						new File(PLAYERS_IMAGES_CACHE).mkdir();
					}
					url = new URL("https://image.ibb.co/ivS6fx/Male_silhouette.png");
					playerPicture = ImageIO.read(url);
					ImageIO.write(playerPicture, "png", new File(PLAYERS_IMAGES_CACHE + "\\unknown.png"));
				}

				playerPicture = ImagesGui.resize(playerPicture, 120, 120);
				imageIcon = new ImageIcon(playerPicture);
			}

			temp = new JLabel(tempPlayer.firstName + " " + tempPlayer.lastName, imageIcon, SwingConstants.CENTER);
			temp.setFont(temp.getFont().deriveFont(18.0f));
			temp.setHorizontalTextPosition(JLabel.CENTER);
			temp.setVerticalTextPosition(JLabel.BOTTOM);
			temp.setBorder(BorderFactory.createLineBorder(Color.gray));
			temp.setAlignmentX(LEFT_ALIGNMENT);
			temp.setAlignmentY(TOP_ALIGNMENT);
			temp.setName("player_label$"+tempPlayer.playerid);
			temp.addMouseListener(Actions.clickLabelChangeColor(this));
//			temp.addMouseListener(new MouseAdapter() {
//				public void mouseClicked(MouseEvent e) {
//					// you can open a new frame here as
//					// i have assumed you have declared "frame" as instance variable
//					panel.removeAll();
//					System.out.println("hello");
//					System.out.println("world");
//					System.out.println("PLAYERS NUM = " +playersNumber);
//					setSize(300, 300);
//					setVisible(true);
//				}
//			});
			panel.add(temp);
			i++;
		}
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		
		searchPlayer.addFocusListener(Actions.textDisappeardOnclick(searchPlayer));
		searchPlayer.addActionListener(Actions.changeToPlayersPannel());
		add(searchPlayer, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		setSize(300, 300);
		setVisible(true);
	}
	
	public String getTextFromSearch(){
		return searchPlayer.getText();
	}
}