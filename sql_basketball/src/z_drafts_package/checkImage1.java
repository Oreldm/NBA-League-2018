package z_drafts_package;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;

public class checkImage1 extends JFrame {
	
	public checkImage1() {
		 try {
             String path = "https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png";
             System.out.println("Get Image from " + path);
             URL url = new URL(path);
             BufferedImage image = ImageIO.read(url);
             System.out.println("Load image into frame...");
             JLabel label = new JLabel(new ImageIcon(image));
             JFrame f = new JFrame();
             f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             f.getContentPane().add(label);
             f.pack();
             f.setLocation(200, 200);
             f.setVisible(true);
         } catch (Exception exp) {
             exp.printStackTrace();
         }
	
	}
	
	
	public static void main(String[] args) {
//		checkImage1 frame = new checkImage1();
//		frame.pack();
//		frame.setSize(300, 180);
//		ImageIcon img = new ImageIcon("basketball_icon.png");
//		frame.setIconImage(img.getImage());
//		frame.setTitle("Login To OracleDB");
//		frame.setLocationRelativeTo(null); // Center the frame
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setAlwaysOnTop(true);
//		frame.setResizable(false);
//		frame.setVisible(true);  
		 try {
             String path = "https://s-media-cache-ak0.pinimg.com/originals/ed/b3/51/edb351de37b70cffc500b6214d831020.png";
             System.out.println("Get Image from " + path);
             URL url = new URL(path);
             BufferedImage image = ImageIO.read(url);
             System.out.println("Load image into frame...");
             JLabel label = new JLabel(new ImageIcon(image));
             JFrame f = new JFrame();
             f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             f.getContentPane().add(label);
             f.pack();
             f.setLocation(200, 200);
             f.setVisible(true);
         } catch (Exception exp) {
             exp.printStackTrace();
         }
	}
}
