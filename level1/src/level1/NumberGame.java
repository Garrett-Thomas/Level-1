package level1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGame implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton button;
	JButton button2;
	JButton button3;
	JTextField text;
	double currentNum;
	public static void main(String[] args) {
		NumberGame game = new NumberGame();
		game.anOriginalMethodName();
		JOptionPane.showMessageDialog(null, "Pick a number between 1-100");
	}
	private void anOriginalMethodName(){
		frame = new JFrame();
		panel = new JPanel();
		button = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		text = new JTextField();
		frame.add(panel);
		panel.add(button);
		panel.add(text);
		panel.add(button2);
		panel.add(button3);
		text.setPreferredSize(new Dimension(150, 20));
		text.setEditable(false);
		button.setText("Higher");
		button2.setText("Lower");
		button3.setText("Correct");
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(button.equals(e.getSource())){
			currentNum = 100 * .75;
			text.setText("Is it " + currentNum);
			if(button3.equals(e.getSource())){
				text.setText("Youre number was " + currentNum);
			}
		}
	}
}
