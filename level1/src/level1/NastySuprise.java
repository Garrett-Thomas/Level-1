package level1;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class NastySuprise {
	JFrame frame;
	JPanel panel;
	JButton button1;
	JButton button2;
	public static void main(String[] args) {
		NastySuprise trick = new NastySuprise();
		trick.anOriginalMethodName();
	}
	private void anOriginalMethodName(){
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(400, 400);
		panel = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		button1.setText("Trick");
		button2.setText("Treat");
		//button1.setBounds(0, 100, 100, 100);
	}



private void showPictureFromTheInternet(String imageUrl) {
		try {
			URL url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			JLabel imageLabel = new JLabel(icon);
			JFrame frame = new JFrame();
			frame.add(imageLabel);
			frame.setVisible(true);
			frame.pack();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
}
}