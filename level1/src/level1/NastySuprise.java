package level1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class NastySuprise implements ActionListener {
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
		button1.addActionListener(this);
		button2.addActionListener(this);
		
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
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(button1.equals(e.getSource())){
	showPictureFromTheInternet("http://blogs-images.forbes.com/kristintablang/files/2016/02/Uber-Puppies.jpg");
	System.out.println("1");
	}else if(button2.equals(e.getSource())){
		System.out.println("2");
		for (int i = 0; i < 10; i++) {
	showPictureFromTheInternet("https://media.giphy.com/media/7WlEkydlQEi0o/giphy-facebook_s.jpg");
		}
	}
		
}
}